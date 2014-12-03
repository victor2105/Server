package Server;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class ServerUDP extends Server {

	DatagramSocket datagramSocket;
	
	public ServerUDP(int port) {
		super(port);
	}
	
	// Le controle va recevoir les requetes et il va formuler les bonnes reponses.
	
	public void execute(){
		try {
			datagramSocket = new DatagramSocket(portNumber);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] receiveData = new byte[10240];
		byte[] sendData = new byte[20480];
		System.out.println("Started : port : "+portNumber);
		while(true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			try {
				datagramSocket.receive(receivePacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String req = new String( receivePacket.getData());
			
			String res = control.execute(req);
			
			System.out.println("CLIENT: "+ req );
			
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			System.out.println("port : "+ port);
			
			sendData = res.getBytes();
			DatagramPacket sendPacket =
					new DatagramPacket(sendData, sendData.length, IPAddress, port);
			try {
				datagramSocket.send(sendPacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("SERVER : " + res);
		}
	}	
}
