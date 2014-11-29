import Control.MyControl;

import ExceptionMessages.UnavailableNameException;
import Model.*;
import Server.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Server server = new Server(5000);

		MyControl myCommand = new MyControl();
		server.setControl(myCommand);
		
		server.execute();
		
	}
}
