package Control;

import Model.Table;
import Server.ServerControl;



public class MyControl extends ServerControl{

	Table noms;
	
	@Override
	public String execulte(String req) {
		// TODO Auto-generated method stub
		String res = "bye";
		
		System.out.println(req);
		
		
		return res;
	}
	
}
