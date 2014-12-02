package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class MultiServer {
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = null;
		ServerControl control = new ServerControl();
		boolean listening = true;
		int port = 5000;
		try{
			serverSocket = new ServerSocket(port);
		}
		catch(IOException e){
			System.out.println("Could not listen on port: "+port);
			System.exit(-1);
		}
		while(listening){
			new MultiServerThread(serverSocket.accept()).start();
			
		}
		
	}
}
