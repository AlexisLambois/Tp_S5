public class PileHanoi implements Pile<DisqueHanoi>{
	
	private int nbElem = 0;
	private DisqueHanoi[] tab = new DisqueHanoi[MAX_ELEMENTS];
	private String nom;
	private Affichage algoAffichage = new AffichageSimple();

	public PileHanoi(String s){
		this.nom = s;
	}
	
	public PileHanoi(String s , Affichage a){
		this.nom = s;
		this.algoAffichage = a;
	}

	public boolean vide(){
		return nbElem == 0;
	}

	public boolean pleine (){
		return nbElem == MAX_ELEMENTS;
	}

	public boolean peutEmpiler (DisqueHanoi x){
		if(nbElem == 0) return true;
		if(nbElem == MAX_ELEMENTS) return false;
		return sommet().diametre() > x.diametre();
	}

	public DisqueHanoi sommet(){
		if(!vide()){
			return tab[nbElem-1];
		}else{
			return null;
		}
	}

	public DisqueHanoi depile(){
		if(!vide()){
			DisqueHanoi tmp = tab[nbElem-1];
			nbElem--;
			return tmp;
		}else{
			return null;
		}
	}

	public void empile(DisqueHanoi x){
		if(peutEmpiler(x) && !pleine()){
			tab[nbElem] = x;
			nbElem++;
		}
	}

	public void vider(){
		nbElem = 0;
		this.tab = new DisqueHanoi[MAX_ELEMENTS];
	}

	public int nbElements(){
		return nbElem;
	}

	public void deplacerUnElementVers(Pile p){
		if(!vide()){
			System.out.println("Je deplace un disque de "+ nom +" vers "+ p.getNom());
			if(!p.vide()){
				p.empile(depile());
			}else{
				if(p.peutEmpiler(sommet())) p.empile(depile());
			}
		}
	}
	
	public void deplacerDesDisques(int n,Pile dest,Pile interm){
		if(n>0){
			this.deplacerDesDisques(n-1, interm, dest);
			this.deplacerUnElementVers(dest);
			((PileHanoi)interm).deplacerDesDisques(n-1, dest, this);
		}
		
	}

	public String getNom(){
	    return nom;
	}

	public String toString(){
		return nom + " : " + algoAffichage.affichage_tableau(this.tab, nbElem) ;
	}
}
