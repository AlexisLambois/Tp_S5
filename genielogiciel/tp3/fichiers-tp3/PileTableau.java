class PileTableau<E> implements Pile<E>{
	
	private E[] elements ;  // les éléments contenus dans la pile
	private int nbElem = 0 ; // le nombre d’éléments dans la pile
	private String nom ;     // nom de la pile : information supplémentaire propre à PileTableau

	public PileTableau(){
	}

	public PileTableau(String nom){
		this.nom = nom;
	}

	public boolean vide(){
		return nbElem ==0;
	}

	public boolean pleine(){
		return nbElem ==MAX_ELEMENTS;
	}

	public boolean peutEmpiler(E x){
		return this.pleine();
	}

	public E sommet(){
		return elements[nbElem-1];
	}

	public E depile(){
		if(!this.vide()){
			E temp = this.sommet();
			nbElem--;
			elements[nbElem] = null;
			return temp;
		}
		return null;
	}

	public void empile(E x){
		if(elements==null){this.elements = (E[]) new Object[MAX_ELEMENTS];}
		if(!this.peutEmpiler(x)){
			elements[nbElem] = x;
			nbElem++;
		}
	}

	public void vider(){
		this.nbElem =0;
		this.elements = (E[]) new Object[MAX_ELEMENTS];
	}

	public int nbElements(){
		return this.nbElem;
	}
	
	public String getNom(){
		return this.nom;
	}

	public void deplacerUnElementVers(Pile<E> p){
		if(!this.vide()){
			p.empile(this.depile());
			System.out.println("Deplace de "+this.nom+" a "+p.getNom());
		}
	}

	public String toString(){
		String res ="";
		for(int i=nbElem-1; i >= 0 ; i--){
			res+=elements[i]+" ";
		}
		return res;
	}
}
