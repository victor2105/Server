package Model;

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
	
<<<<<<< HEAD
	public Nom getNom(String nom) throws NameNotFoundException, UnavailableNameException{
		Nom table = getNomPrivate(nom);
		return table;		
=======
	/*************Que fait cette methode ?*****************/
	public Table getNom(String nom) throws NameNotFoundException, UnavailableNameException{
		Table table = new Table();
		
		table.add(getNomPrivate(nom));
		
		return table;
		
>>>>>>> 47d3e03c6858bfc01bb9066d06be4d9072186e9e
	}
	
	/*************Que fait cette methode ?*****************/
	public Table getNom(TreeSet<String> noms) throws NameNotFoundException, UnavailableNameException{
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
<<<<<<< HEAD
		
		if(lines.size()>0){
			table = table + "\n	" + lines.get(0).toString() + "";
			
			for(int i=1;i<lines.size();i++){
				table = table + ",\n	" + lines.get(i).toString();
			}
=======
>>>>>>> 47d3e03c6858bfc01bb9066d06be4d9072186e9e
			
		for(Nom nom : lines){
				table = table + "\n	" + nom.toString() + ",";
		}
			
		table = table + "\n]";
		
		return table;
	}
	
}
