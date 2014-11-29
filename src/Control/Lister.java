package Control;

import java.util.LinkedList;
import java.util.List;

import ExceptionMessages.NameNotFoundException;
import ExceptionMessages.UnavailableNameException;
import Model.Table;

public class Lister extends Command{

	@Override
	public String execute(Table noms, List<String> parametres) {
		// TODO Auto-generated method stub
		try {
			Table list = noms.getSurom(parametres);
			return list.toString();
		} catch (NameNotFoundException | UnavailableNameException e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
	}

	
}
