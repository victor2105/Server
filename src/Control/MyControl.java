package Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import Model.Table;
import Server.ServerControl;



public class MyControl extends ServerControl{
	
	Enregistrer enr;
	Table noms;
	HashMap<String,Command> commands;
	private Scanner sc;
	

	public MyControl() {
		// TODO Auto-generated constructor stub
		enr = new Enregistrer();
		commands = new HashMap<>();
		commands.put("enregistrer",new Enregistrer());
		commands.put("ajouter",new Ajouter());
		commands.put("supprimer",new Supprimer());
		commands.put("modifier",new Modifier());
		commands.put("lister",new Lister());
		
		noms = new Table();
		
	}
	
	@Override
	public String execute(String req) {


		sc = new Scanner(req);
		String type = sc.next();
		
		ArrayList<String> parametres = new ArrayList<>();
		while(sc.hasNext()){
			parametres.add(sc.next());
		}
		
		System.out.println("cmd : "+type);
		String resp = req;
		
		Command cmd = commands.get(type);
		try {
			resp = cmd.execute(noms,parametres);
			System.out.println(resp);
		}catch(Exception e){
			System.out.println("Erro");
		}
		return resp;
	}
}
