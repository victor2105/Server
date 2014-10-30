
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Server server = new Server(50000);
		//server.execulte();
		
		Table table = new Table();
		
		try{
			Nom v = new Nom("Victor");
			v.addSurNom("Henrique");
			v.addSurNom("dos");
			v.addSurNom("Santos");
			
			Nom v2 = new Nom("Victor");
			
			table.add(v);
			
			
			System.out.println(table);
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
