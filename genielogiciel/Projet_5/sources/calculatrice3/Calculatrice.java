package calculatrice3;

import java.util.HashMap;
import java.util.Stack;

public class Calculatrice {
	
	Stack<Double> resultat;
	
	HashMap<String,Operation> operations;
	
	public Calculatrice(){
		this.resultat = new Stack<>();
		this.operations = new HashMap<>();
		for (Operation o: Operation.values()){
			this.operations.put(o.toString(), o);
		} 	
	}
	
	public double calculer(String s){
		
		String[] tab = s.split(" ");
		
		for (int i = 0; i < tab.length; i++) {
			try{
				double tmp = Double.parseDouble(tab[i]);
				resultat.push(tmp);
			}catch(Exception e){
				
				if( operations.containsKey(tab[i]) ){
					operations.get(tab[i]).execute(this.resultat);
				}
			}
		}
		
		return resultat.pop();
	}

}
