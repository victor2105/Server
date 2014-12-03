import Control.MyControl;
import Server.ServerUDP;


public class MainServerUDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerUDP serverUDP = new ServerUDP(5000);
		
		MyControl myControl = new MyControl();
		serverUDP.setControl(myControl);
		
		serverUDP.execute();
	}

}
