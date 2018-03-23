import java.util.ArrayList;
import java.util.Scanner;

public class NoeudArbre{

	private String contenu;

	private NoeudArbre gauche,droite;

	public NoeudArbre(){
		this.contenu = null;
		this.gauche = null;
		this.droite = null;
	}

	public NoeudArbre(String contenu){
		this.contenu = contenu;
		this.gauche = null;
		this.droite = null;
	}

	public NoeudArbre(String contenu, NoeudArbre gauche, NoeudArbre droite){
		this.contenu = contenu;
		this.gauche = gauche;
		this.droite = droite;
	}

	public void rechercherAnimal(){

		System.out.println(this.contenu);

		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		if( str.equals("non") ){
			if ( this.gauche != null ){
				this.gauche.rechercherAnimal();
			}else{
				apprendre();
				return;
			}
		}

		if( str.equals("oui") ){ 
			if( this.droite != null ) {
				this.droite.rechercherAnimal();
			}else{
				System.out.println("Vous pensiez a : "+this.contenu+" ! ");
				return;
			}
		}

	}

	public void apprendre(){

		String old_contenu = this.contenu;
		String rep = "";
		String oui_non = "";
		Scanner sc = new Scanner(System.in);

		System.out.println("Tu pensais a quoi ?");
		rep = sc.nextLine();

		System.out.println("Je connais aps ! Pose ta question qui diff avec " + this.contenu);
		this.contenu = sc.nextLine();

		System.out.println("Quelle rep pour " + rep + " ? ");
		oui_non = sc.nextLine();

		if( oui_non.equals("non") ){
			this.gauche = new NoeudArbre(rep);
			this.droite = new NoeudArbre(old_contenu);
		}

		if( oui_non.equals("oui") ){
			this.droite = new NoeudArbre(rep);
			this.gauche = new NoeudArbre(old_contenu);
		}
	}

	public static NoeudArbre init(ArrayList<NoeudArbre> liste){

		for (int i = 0; i < liste.size()-1; i++) {
			if( liste.get(i).contenu.contains("?") ){
				liste.get(i).gauche = liste.get(i+1);
			}else{
				for (int j =i; j >= 0; j--) {
					if( liste.get(j).droite == null && liste.get(j).contenu.contains("?") ){
						liste.get(j).droite = liste.get(i+1);
					}
				}
			}
		}
		
		return liste.get(0);
	}

	public String definir( String animal ){

		String rep ="";
		String temp ="";

		rep+=this.contenu;

		if( this.gauche != null ){
			temp = " -> non : "+this.gauche.definir(animal);
			if( temp.contains(animal) ){
				rep+=temp;
			}
		}

		if( this.droite != null ){
			temp = " -> oui : "+this.droite.definir(animal);
			if( temp.contains(animal) ){
				rep+=temp;
			}
		}

		return rep;

	}


	public String toString(){

		String rep = " "+this.contenu+"\n";

		if( this.gauche != null ){
			rep+= this.gauche.toString();
		}

		if( this.droite != null ){
			rep+= this.droite.toString();
		}

		return rep;
	}

	public static void main(String[] args) {

		NoeudArbre test;
		int ind = 0;
		String obj_to_def = "";

		if( args[0].equals("--definir") ){
			ind = 2;
		}

		if( args.length == ind ){
			test = new NoeudArbre("Es-ce un mammifère ?",new NoeudArbre("un crocodile"),new NoeudArbre("un chien"));
		}else{
			ArrayList<NoeudArbre> liste = new ArrayList<>();

			for (int i = ind; i < args.length; i++) {
				liste.add(new NoeudArbre(args[i]));
			}
			
			test = init(liste);
			
			System.out.println(test.toString());
		}

		if( args[0].equals("--definir") ){

			System.out.println(test.definir(args[1]));

		}else{

			Scanner sc = new Scanner(System.in);
			String rep = "";

			do{
				test.rechercherAnimal();
				System.out.println("\n================================================\n");
				System.out.println("Voulez vous rejouez ?");
				rep = sc.nextLine();
				System.out.println("\n================================================\n");

			}while (rep.equals("oui"));

			System.out.println(test.toString());
		}
	}
}
