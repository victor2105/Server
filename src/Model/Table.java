package Model;

import java.util.List;
import java.util.TreeSet;

import ExceptionMessages.NameNotFoundException;
import ExceptionMessages.UnavailableNameException;


public class Table {
	private TreeSet<Nom> lines;
	
	public Table(){
		lines = new TreeSet<Nom>();
	}
	
	public void add(Nom newNom) throws UnavailableNameException {
		boolean res = lines.add(newNom);
		if(!res)
			throw new UnavailableNameException();
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
	
	/**
	 * 
	 * @param List <String> noms
	 * @return Table des surnomes
	 * @throws NameNotFoundException
	 * @throws UnavailableNameException
	 */
	
	public Table getSurom(List<String> noms) throws NameNotFoundException, UnavailableNameException{
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
		boolean fist = true;
		for(Nom nom : lines){
				table = table + "\n	" + nom.toString();
				if(!fist) {
					table = table +  ",";
				}else{
					fist = false;
				}
		}
			
		table = table + "\n]";
		
		return table;
	}
	
}
