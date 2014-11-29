package Control;

import java.util.LinkedList;
import java.util.List;

import ExceptionMessages.UnavailableNameException;
import Model.Nom;
import Model.Table;

public class Enregistrer extends Command{

	@Override
	public String execute(Table noms, List<String> parametres){
		
		/*
		
		String snom = "v", ssurnom="h";
		
		snom = (String) parametres.get(0);
		ssurnom = (String) parametres.get(1);
		
		Nom nom = new Nom(snom, ssurnom);

		try {
			noms.add(nom);
		} catch (UnavailableNameException e) {
			// TODO Auto-generated catch block
			System.out.println("hgf");
		}
		*/
		return noms.toString();
	}

}
