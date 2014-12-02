package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Control.MyControl;

public class MultiServerThread extends Thread{
	private Socket socket = null;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String clientMessage;
	private MyControl control = new MyControl();
	
	public MultiServerThread(Socket socket) {
	super("MultiServerThread");
	this.socket = socket; 
	}
	
	public void run(){
	try{
		out = new ObjectOutputStream(socket.getOutputStream());
		out.flush();			
		in = new ObjectInputStream(socket.getInputStream());
		
			try{
				do{
				clientMessage = (String) in.readObject();
				System.out.println("Client: \'" + clientMessage + "\'");
				
				if(clientMessage.equals("bye")){
					sendMessage("bye");
				}else{
					sendMessage(control.execute(clientMessage));
				}
			}while(!clientMessage.equals("bye"));
			
			}catch(/*ClassNotFound*/Exception classNotFoundException){
				System.err.println("Data received in unknown format");
			}
		
		out.close(); in.close(); socket.close();
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	}
	
	private void sendMessage(String message){
		try{
			out.writeObject(message);
			out.flush();
			System.out.println("Server: \'" + message + "\'");
		}catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
}
