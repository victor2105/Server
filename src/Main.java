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
		

//		Test de la table
//		Table t = new Table();
//		Nom n1 = new Nom("Henrique Victor","Chat");
//		Nom n2 = new Nom("Salim Youssef","Bjr");
//		Nom n3 = new Nom("Germain Edouard","Slt");
//		Nom n4 = new Nom("Wang Yuqi","ree");
//		Nom n5 = new Nom("Germain Edouard","Allo");
//		
//		try {
//			t.add(n1);
//			t.add(n2);
//			t.add(n3);
//			t.add(n4);
//			t.add(n5);
//		} catch (UnavailableNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(t);
		
	}
}
