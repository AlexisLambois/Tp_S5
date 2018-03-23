import java.lang.*;
class PileTableauComp implements Pile<Comparable>{
	
	private Comparable[] elements ;  // les éléments contenus dans la pile
	private int nbElem = 0 ; // le nombre d’éléments dans la pile
	private String nom ;     // nom de la pile : information supplémentaire propre à PileTableau

	public PileTableauComp(){
	}

	public PileTableauComp(String nom){
		this.nom = nom;
	}

	public boolean vide(){
		return nbElem ==0;
	}

	public boolean pleine(){
		return nbElem ==MAX_ELEMENTS;
	}

	public boolean peutEmpiler(Comparable x){
		return this.pleine();
	}

	public Comparable sommet(){
		return elements[nbElem-1];
	}

	public Comparable depile(){
		if(!this.vide()){
			Comparable temp = this.sommet();
			nbElem--;
			elements[nbElem] = null;
			return temp;
		}
		return null;
	}

	public void empile(Comparable x){
		if(elements==null){this.elements = (Comparable[]) new Object[MAX_ELEMENTS];}
		if(!this.peutEmpiler(x)){
			elements[nbElem] = x;
			nbElem++;
		}
	}

	public void vider(){
		this.nbElem =0;
		this.elements = (Comparable[]) new Object[MAX_ELEMENTS];
	}

	public int nbElements(){
		return this.nbElem;
	}
	
	public String getNom(){
		return this.nom;
	}

	public void deplacerUnElementVers(Pile<Comparable> p){
		if(!this.vide()){
			p.empile(this.depile());
			System.out.println("Deplace de "+this.nom+" a "+p.getNom());
		}
	}

	public void trier(){
		Comparable[] res = (Comparable[]) new Object[MAX_ELEMENTS];
		
	}

	public String toString(){
		String res ="";
		for(int i=nbElem-1; i >= 0 ; i--){
			res+=elements[i]+" ";
		}
		return res;
	}
}
