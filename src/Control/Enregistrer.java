package Control;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ExceptionMessages.UnavailableNameException;
import Model.Nom;
import Model.Table;

public class Enregistrer extends Command{

	@Override
	public String execute(Table noms, List<String> parametres){
		String res;
		ArrayList <String> p = (ArrayList) parametres;
		
		String snom = "v", ssurnom="h";
		
		snom = (String) parametres.get(0);
		ssurnom = (String) parametres.get(1);
		
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
