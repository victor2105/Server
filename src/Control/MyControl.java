package Control;

import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Model.Table;
import Server.ServerControl;



public class MyControl extends ServerControl{
	
	Enregistrer enr;
	Table noms;
//	JSONParser parser = nez JSONParser();
	

	public MyControl() {
		// TODO Auto-generated constructor stub
		enr = new Enregistrer();
	}
	
	@Override
	public String execute(String req) {
		try {
			JSONObject obj=new JSONObject(req);
			
			JSONArray parametres = obj.getJSONArray("parametres");
			
			if(obj.getString("type").equals("enregistrer")) enr.execute(noms, parametres);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return req;
	}
}
