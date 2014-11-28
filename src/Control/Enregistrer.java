package Control;

import java.util.ArrayList;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONException;

import ExceptionMessages.UnavailableNameException;
import Model.Nom;
import Model.Table;

public class Enregistrer extends Command{

	@Override
	public String execute(Table noms, JSONArray parametres){
		String snom = "v", ssurnom="h";
		try {
			snom = (String) parametres.get(0);
			ssurnom = (String) parametres.get(1);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Nom nom = new Nom(snom, ssurnom);

		try {
			noms.add(nom);
		} catch (UnavailableNameException e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
		
		return noms.toString();
	}

}
