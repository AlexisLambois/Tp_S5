package dictionnaire;/** L'interface Couple permet de caractériser tout objet qui contient des paires
 * de valeurs, la première du type X, la seconde du type Y */
public interface Couple<K,V> {
	K premier() ;                   
	V second() ;
	void defPremier(K x) ;       
	void defSecond(V y) ;
	boolean equals(Object o) ;
}
