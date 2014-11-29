package Control;

import java.util.LinkedList;
import java.util.List;

import Model.Table;

public abstract class Command {
	
	//public abstract String execute(Table noms, JSONArray parametres);
	public abstract String execute(Table noms, List<String> parametres);

}
