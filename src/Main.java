import Control.MyControl;
import Model.*;
import Server.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		Server server = new Server(50000);
		MyControl myControl = new MyControl();
		server.setControl(myControl);
		server.execulte();*/
		
		Table table = new Table();
		
		try{
			Nom v = new Nom("Victor");
			v.addSurNom("Henrique");
			v.addSurNom("dos");
			v.addSurNom("Santos");
			
			Nom v2 = new Nom("Victor");
			
			table.add(v);
			
			
			System.out.println(table.getNom("Victor"));
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
