package dictionnaire;
import java.util.Iterator;
/** ICI les commentaires sur le fonctionnement de la classe */
public class TabDict<K,V> implements  Dictionnaire<K,V>,Iterable<K>
{
	private static final int INIT_SIZE = 100 ;       // taille initiale du tableau
	private Couple<K,V> [] associations ;            // tableau contenant les associations
	private int nbAssoc ;	// nombre d'elements effectivement presents dans le dictionnaire

	/** Crée une instance de dictionnaire vide */
	public TabDict() {
		nbAssoc = 0 ;
		associations = (Couple<K,V>[]) new Couple[INIT_SIZE] ;
	}

	// redimensionnement automatique du tableau en une taille double
	private void resize() {
		Couple<K,V>[] tmp = (Couple<K,V>[]) new Couple[this.associations.length * 2];
		for(int i=0; i<associations.length; i++){
			if(associations[i] != null){
				tmp[i] = associations[i];
			}
		}
		this.associations = tmp;
	}

	// ajoute une association à la première position libre (après avoir 
	// redimensionné le tableau si nécessaire)
	private void add(Couple<K,V> assoc) {
		if(nbAssoc == associations.length)
			this.resize();
		for(int i=0; i<associations.length; i++){
			if(associations[i] == null){
				associations[i] = assoc;
				break;
			}
		}	    
		nbAssoc++;
	}

	// enlève l'association à l'indice spécifié
	void remove(int index) {
		if(index == nbAssoc -1)
			associations[index] = null;
		else{
			associations[index] = associations[nbAssoc-1];
			associations[nbAssoc-1] = null;
		}
		nbAssoc--;
	}

	// indice de l'association assoc ; -1 si elle est absente 
	private int indexOf(Couple<K,V> assoc) {
		for(int i=0; i<associations.length; i++){
			if(associations[i] != null && associations[i].equals(assoc)){
				return i;
			}
		}
		return -1;
	}

	// indice de l'association de clef c ; -1 si elle est absente
	private int indexOfClef(K c) {       
		for(int i=0; i<associations.length; i++){
			if(associations[i] != null && associations[i].premier().equals(c)){
				return i;
			}
		}
		return -1;
	}

	// méthode nécessaire pour l'itérateur :
	// retourne la clef située à l'indice i, null si i incorrect
	K clefPourIndex(int i) {
		if(associations[i] ==  null)
			return null;
		return associations[i].premier();
	}

	public String toString(){
		String res = "[\n";
		for(int i=0; i<associations.length; i++){
			if(associations[i] != null)
				res +=" "+associations[i]+"\n";
		}
		return res+"]\nSize : "+nbAssoc;
	}

	// IMPLÉMENTATION DE L'INTERFACE Dictionnaire
	/** Teste si le dictionnaire ne contient aucune association */
	public boolean estVide(){
		return nbAssoc == 0;
	}

	/** Teste si le dictionnaire contient l'association assoc */
	public boolean contient(Couple <K,V> assoc){
		return indexOf(assoc) != -1;
	}

	/** Teste si le dictionnaire possède une association de clef c */
	public boolean contientClef(K c){
		return indexOfClef(c) != -1;
	}

	/** Teste si le dictionnaire possède une association de valeur v */
	public boolean contientValeur(V v){
		for(int i=0; i<associations.length; i++){
			if(associations[i].second().equals(v)){
				return true;
			}
		}
		return false;
	}

	/** Retourne le nombre d'associations du dictionnaire */
	public int nbElements(){
		return nbAssoc;
	}

	/** Retourne l'association correspondant à la clef c spécifiée, null si absente */
	public Couple<K,V> assocPour(K c){
		int i = indexOfClef(c);
		if(i != -1){
			return associations[i];
		}else{
			return null;   
		}
	}

	/** Retourne la valeur associée à le clef c, null si absente */
	public V valeurPour(K c){
		int i = indexOfClef(c);
		if(i != -1){
			return associations[i].second();
		}else{
			return null;   
		}
	}
	/** Ajoute l'association assoc au dictionnaire (remplacement si clef présente) */
	public void ajouter(Couple<K,V> assoc){
		int i = indexOf(assoc);
		if(i != -1){
			associations[i] = assoc;
		}else{
			add(assoc);
		}
	}

	/** Définit ou modifie la valeur v associée à la clef c dans le dictionnaire */
	public void ajouter(K c, V v){
		int i = indexOfClef(c);
		if(i != -1){
			associations[i].defSecond(v);
		}else{
			Couple<K,V> assoc = new CoupleObj<>(c,v);
			add(assoc);
		}
	}

	/** Enlève l'association assoc du dictionnaire (si présente) */
	public void enlever(Couple<K,V> assoc){
		int i = indexOf(assoc);
		if(i != -1){
			remove(i);
		}
	}


	/** Enlève l'entrée de clef c (si présente) */
	public void enleverPour(K c){
		int i = indexOfClef(c);
		if(i != -1){
			remove(i);
		}
	}


	// IMPLÉMENTATION DE L'INTERFACE Iterable (2e partie du TP)
	/** Itérateur permettant de parcourir les clefs (et d'en supprimer) */
	public Iterator<K> iterator() {
		return new DictIterator<K>(this) ;
	}    
}

