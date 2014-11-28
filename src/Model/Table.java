package Model;
import java.util.ArrayList;

import ExceptionMessages.NameNotFoundException;
import ExceptionMessages.UnavailableNameException;


public class Table {
	private ArrayList<Nom> lines;
	
	public Table(){
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
	
	private Nom getNomPrivate(String nom) throws NameNotFoundException{
		
		for (Nom nom2 : lines) {			
			if(nom2.equals(nom)){
				return nom2;
			}
		}
		
		throw new NameNotFoundException();
	}
	
	public Nom getNom(String nom) throws NameNotFoundException, UnavailableNameException{
		Nom table = getNomPrivate(nom);
		return table;		
	}
	
	public Table getNom(ArrayList<String> noms) throws NameNotFoundException, UnavailableNameException{
		Table table = new Table();
		
		for (String n : noms) {
			table.add(getNomPrivate(n));
		}
		
		return table;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String table = "[";
		
		if(lines.size()>0){
			table = table + "\n	" + lines.get(0).toString() + "";
			
			for(int i=1;i<lines.size();i++){
				table = table + ",\n	" + lines.get(i).toString();
			}
			
		}
		table = table + "\n]";
		
		return table;
	}
	
}
