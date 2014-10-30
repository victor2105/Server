import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class Client {
	private Socket socket;
	private String serverName;
	private int serverPort;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	private String serverResponse;
	
	private Client(){
		serverName = "localhost";
		serverPort = 5000;
	}
	
	
	public void execulte(){
		try{
			socket = new Socket(serverName, serverPort);
			System.out.println("Connected with "+serverName+"in port:"+serverPort);
			
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.flush();
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			
			
			
		}catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	private void sendMessage(String message){
		try{
			objectOutputStream.writeObject(message);
			objectOutputStream.flush();
			System.out.println("client: "+message);

		}catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
}
