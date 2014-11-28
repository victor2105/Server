package Control;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import Model.Table;
import Server.ServerControl;



public class MyControl extends ServerControl{
	
	Enregistrer enr;
	Table noms;
	HashMap<String,Command> commands;
	
	public MyControl() {
		// TODO Auto-generated constructor stub
		enr = new Enregistrer();
		commands = new HashMap<>();
		commands.put("enregistrer",new Enregistrer());
		commands.put("ajouter",new Ajouter());
		commands.put("supprimer",new Supprimer());
		commands.put("modifier",new Modifier());
		commands.put("lister",new Lister());
	}
	
	@Override
	public String execute(String req) {
		Scanner sc = new Scanner(req);
		String type = sc.next();
		LinkedList<String> parametres = new LinkedList<>();
		while(sc.hasNext()){
			parametres.add(sc.next());
		}
		
		Command cmd = commands.get(type);
		String resp = cmd.execute(noms,parametres);
		/*try {
			JSONObject obj=new JSONObject(req);
			
			JSONArray parametres = obj.getJSONArray("parametres");
			
			if(obj.getString("type").equals("enregistrer")) enr.execute(noms, parametres);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return req;*/
		return resp;
	}
}
