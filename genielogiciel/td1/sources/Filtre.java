import java.util.ArrayList;

public class Filtre{
	
	ArrayList<Integer> valeur = new ArrayList<Integer>();

	public Filtre(int nb){
		valeur.add(nb);
	}

	public void filtrer(int x){
		
		int i = 0;
		boolean b = false;

		while( !b && i < valeur.size() ){
			
			if( x % valeur.get(i) == 0 ){
				b = true;
			}

			i++;
		}
		
		if(!b && !valeur.contains(x)){ valeur.add(x); }
	}

	public String toString(){
		String rep="";
		for (int i = 0; i < valeur.size(); i++) {
			rep += valeur.get(i)+" ";
		}
		return rep;
	}
}
