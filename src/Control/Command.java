package Control;

import java.util.LinkedList;

import Model.Table;

public abstract class Command {
	
	//public abstract String execute(Table noms, JSONArray parametres);
	public abstract String execute(Table noms, LinkedList<String> parametres);

}
