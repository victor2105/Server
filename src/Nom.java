import java.util.ArrayList;


public class Nom {

	private String nom;
	private ArrayList <String> surNoms;
	
	public Nom(String nom){
		this.nom = nom;
		surNoms = new ArrayList<String>();
	}
	
	
	ArrayList<String> getSurNoms(){
		return surNoms;
	}
	
	void addSurNom(String surnom){
		boolean estTrouve = false;
		for(int i=0;i<this.surNoms.size()&&!estTrouve;i++){
			String sn = this.surNoms.get(i);
			if(sn.equals(surnom)){
				estTrouve = true;
			}
		}
		if(!estTrouve){
			this.surNoms.add(surnom);
		}		
	}
	
	
	public String getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String nomString = "{ \"nom\": \"" + this.nom + "\", \"surnoms\": [";
		
		if(surNoms.size()>0){
			nomString = nomString + " \"" + surNoms.get(0) + "\"";
			for(int i=1;i<surNoms.size();i++){
				nomString = nomString + ", \"" + surNoms.get(i) + "\"";
			}
		}
		
		
		nomString = nomString + " ] }";
		
		return nomString;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		return ((Nom) obj).getNom().equals(nom);
	}
	
	public boolean equals(String newNom) {
		// TODO Auto-generated method stub
		
		return nom.equals(newNom);
	}
	
}
