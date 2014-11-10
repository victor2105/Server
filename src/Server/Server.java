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
	private String clientMessage;
	
	
	// Il faut fare notre control
	private ServerControl control;
	
	private int portNumber;
	
	/**
	 * Server
	 */
	public Server(){
		portNumber = 5000;
		control = new ServerControl();
	}
	
	
	public Server(int portNumber)
	{
		this.portNumber = portNumber;
	}
	
	public void setControl(ServerControl control) {
		this.control = control;
	}
	
	public void execulte(){
		
		try{
			serverSocket = new ServerSocket(portNumber);
			
			System.out.println("Waiting for connection");
			socket = serverSocket.accept();
			
			System.out.println("Connection received by "+socket.getInetAddress());
			
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.flush();			
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			sendMessage("Diga ai! Meu cliente");
			
			do{
				try{
					clientMessage = (String) objectInputStream.readObject();
					System.out.println("Client: \'" + clientMessage + "\'");
					
					if(clientMessage.equals("bye")){
						sendMessage("bye");
					}else{
						sendMessage(control.execulte(clientMessage));
					}
					
				}catch(ClassNotFoundException classNotFoundException){
					System.err.println("Data received in unknown format");
				}
			}while(!clientMessage.equals("bye"));
			
		}catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			// 5. closing connection
			try{
				objectInputStream.close();
				objectOutputStream.close();
				serverSocket.close();
			}
			catch (IOException ioException2) {
				ioException2.printStackTrace();
			}
		}
		
	}
	
	private void sendMessage(String message){
		try{
			objectOutputStream.writeObject(message);
			objectOutputStream.flush();
			System.out.println("Server: \'" + message + "\'");
		}catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	
}
