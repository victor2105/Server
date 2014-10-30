import java.util.ArrayList;

import ExceptionMessages.NameNotFoundException;
import ExceptionMessages.UnavailableNameException;


public class Table {
	private ArrayList<Nom> lines;
	
	Table(){
		lines = new ArrayList<Nom>();
	}
	
	public void add(Nom newNom) throws UnavailableNameException {
		// TODO Auto-generated method stub
		boolean estLa = false;
		for(int i=0;i<lines.size()&&!estLa;i++){
			Nom nom = (Nom) lines.get(i);
			if(nom.equals(newNom)){
				estLa = true;
			}
		}
		
		if(!estLa){
			lines.add(newNom);
		}else{
			throw new UnavailableNameException();
		}
	}
	
	public Table getNom(String nom) throws NameNotFoundException, UnavailableNameException{
		Table table = new Table();
		
		for (Nom nom2 : lines) {			
			if(nom2.equals(nom)){				
				table.add(nom2);				
				return table;		
			}
		}
		
		throw new NameNotFoundException();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String table = "[";
		
		if(lines.size()>0){
			table = table + "\n	" + lines.get(0).toString() + "";
			
			for(int i=1;i<lines.size();i++){
				table = table + ",\n	" + lines.get(0).toString();
			}
			
		}
		table = table + "\n]";
		
		return table;
	}
	
}
