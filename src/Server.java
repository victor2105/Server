import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

/**
 * 
 * @author victorhs
 * 
 */

public class Server {

	private ServerSocket serverSocket;
	private Socket socket = null;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;
	private String clientMessage;
	
	private int portNumber;
	
	/**
	 * Server
	 */
	public Server(){
		portNumber = 5000;
	}
	
	
	public Server(int portNumber)
	{
		this.portNumber = portNumber;
	}
	public void execulte(){
		
		try{
			//1. creating a server socket
			serverSocket = new ServerSocket(portNumber);
			//2. wait for connection
			System.out.println("Waiting for connection");
			socket = serverSocket.accept();
			
			System.out.println("Connection received by "+socket.getInetAddress());
			
			//3. get input and output stream
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.flush();			
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			sendMessage("Diga ai! Meu cliente");
			
			//4. communicate
			do{
				try{
					clientMessage = (String) objectInputStream.readObject();
					System.out.println("Client: \'" + clientMessage + "\'");
					if(clientMessage.equals("bye")){
						sendMessage("bye");
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
