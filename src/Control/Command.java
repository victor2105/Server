package Control;

import java.util.ArrayList;
import java.util.LinkedList;

import org.json.JSONArray;

import Model.Table;

public abstract class Command {
	
	public abstract String execute(Table noms, JSONArray parametres);


}
