package dictionnaire;
public class CoupleObj<K,V> implements Couple<K,V>{
	K cle;
	V valeur;

	public CoupleObj(K k, V v){
		this.cle = k;
		this.valeur = v;
	}

	public CoupleObj(){

	}

	public K premier(){
		return this.cle;
	}

	public V second(){
		return this.valeur;
	}

	public void defPremier(K cle){
		this.cle = cle;
	}

	public void defSecond(V valeur){
		this.valeur = valeur;
	}

	public boolean equals(Object o){
		CoupleObj<K,V> temp = (CoupleObj<K,V>)o;
		return this.cle == temp.cle && this.valeur == temp.valeur;
	}

	public String toString(){
		return "{"+this.cle+"->"+this.valeur+"}";
	}
}
