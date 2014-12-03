package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class Server {

	private ServerSocket serverSocket;
	private Socket socket = null;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;

	protected String clientMessage;

	// Le controle va recevoir les requetes et il va formuler les bonnes
	// reponses.
	protected ServerControl control;

	protected int portNumber;

	/**
	 * Server
	 */
	public Server() {
		this.portNumber = 5000;
		control = new ServerControl();
	}

	public Server(int portNumber) {

		this.portNumber = portNumber;
		control = new ServerControl();
	}

	public void setControl(ServerControl control) {
		this.control = control;
	}

	public int getPort() {
		return portNumber;
	}

	public void execute() {

		try {
			serverSocket = new ServerSocket(portNumber);

			System.out.println("Waiting for connection");
			socket = serverSocket.accept();

			System.out.println("Connection received by "
					+ socket.getInetAddress());

			objectOutputStream = new ObjectOutputStream(
					socket.getOutputStream());
			objectOutputStream.flush();
			objectInputStream = new ObjectInputStream(socket.getInputStream());

			do {
				try {
					clientMessage = (String) objectInputStream.readObject();
					System.out.println("Client: \'" + clientMessage + "\'");

					if (clientMessage.equals("bye")) {
						sendMessage("bye");
					} else {
						sendMessage(control.execute(clientMessage));
					}
				} catch (/* ClassNotFound */Exception classNotFoundException) {
					System.err.println("Data received in unknown format");
				}
			} while (!clientMessage.equals("bye"));

		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			// 5. closing connection
			try {
				objectInputStream.close();
				objectOutputStream.close();
				serverSocket.close();
			} catch (IOException ioException2) {
				ioException2.printStackTrace();
			}
		}

	}

	protected void sendMessage(String message) {
		try {
			objectOutputStream.writeObject(message);
			objectOutputStream.flush();
			System.out.println("Server: \'" + message + "\'");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

}
