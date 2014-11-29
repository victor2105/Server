package Control;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ExceptionMessages.NameNotFoundException;
import ExceptionMessages.ParametersNotValide;
import ExceptionMessages.UnavailableNameException;
import Model.Nom;
import Model.Table;

public class Ajouter extends Command{

	@Override
	public String execute(Table noms, List<String> parametres) {
		// TODO Auto-generated method stub
		ArrayList<String> l = (ArrayList) parametres;

		try {
			String nom = l.get(0);
			String surnom = l.get(1);
			if(nom.length() == 0)
				throw new ParametersNotValide();
			
			Nom n = noms.getNom(nom);
			n.addSurNom(surnom);
			
		} catch (NameNotFoundException | ParametersNotValide | UnavailableNameException e) {
			// TODO Auto-generated catch block
			return e.toString();
		} 
		
		return noms.toString();
	}
}
