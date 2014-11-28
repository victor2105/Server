import Control.MyControl;
import Model.*;
import Server.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Server server = new Server(50000);
		
		MyControl myControl = new MyControl();
		
		server.setControl(myControl);
		server.execulte();
	}
}
