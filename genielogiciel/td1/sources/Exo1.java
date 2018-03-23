import java.util.ArrayList;

public class Exo1 {
	
	ArrayList<Integer> tab = new ArrayList<>();
	final int taille = 25;
	
	public Exo1(){
	    for (int i = 2; i <= taille; i++) {
			tab.add(i);
	    }
	}

    public Exo1(int j){
	    for (int i = 2; i <= j; i++) {
			tab.add(i);
	    }
	}
	
	public String toString(){
		String rep="";
		for (int i = 0; i < tab.size(); i++) {
			rep += tab.get(i)+" ";
		}
		return rep;
	}

	public static void main(String [] args) {
		
		Exo1 ex;

	    if(args.length > 0){
			ex = new Exo1(Integer.parseInt(args[0]));
	    }else{
			ex = new Exo1();
	    }

	    System.out.println(ex.toString());

	    for (int i = 0; i < ex.tab.size(); i++) {
			for (int j = i+1; j < ex.tab.size(); j++) {
				if( ex.tab.get(j) % ex.tab.get(i) == 0 ){
					ex.tab.remove(j);
				}
			}
	    }

	    System.out.println(ex.toString());
	}

}
