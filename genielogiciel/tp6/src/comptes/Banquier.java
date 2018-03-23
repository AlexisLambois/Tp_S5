package comptes;
public class Banquier{
    public static void main(String args[]){
	
	System.out.println("Depart !!!!!!!!!\n");
	
	Scanner sc = new Scanner(System.in);
	String rep;
	do{
	    do{
		System.out.println("Que voulez-vous faire ?\n");
		System.out.println("1) Creer un compte ?\n");
		System.out.println("2) Retirer d un compte ?\n");
		System.out.println("3) Ajouter a un compte ?\n");
		System.out.println("4) Passer N mois ?\n");
		System.out.println("5) AFFICHER TOUT LES COMPTES ?\N");
		System.out.println("6) Arrêter\n");
		rep=sc.nextLine();
	    }while(!rep.equals("6"));

	    if(rep.equals("1")){
		
		do{
		    System.out.println("Quel comptes voulez-vous créer ?\n");
		    System.out.println("1) Compte Courant ?\n");
		    System.out.println("2) PEL ?\n");
		    System.out.println("3) Livret A ?\n");
		    System.out.println("4) Passer le mois ?\n");
		    rep=sc.nextLine();
		}while(!rep.equals("4"));
		
	    }else if(rep.equals("2")){

	    }else if(rep.equals("3")){

	    }else if(rep.equals("4")){

	    }else if(rep.equals("5")){

	    }

	    
	}while();

    }
}
