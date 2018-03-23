/** L'interface Dictionnaire décrit les objets capables de stocker un ensemble d'associations
 *  (clef, valeur), chaque clef n'étant présente qu'une seule fois. À noter : cette interface
 *  utilise deux types génériques K et V pour le type des clefs et les valeurs respectivement.
 */
package dictionnaire;
public interface Dictionnaire<K,V> {
    boolean estVide() ;
    boolean contient(Couple <K,V> assoc) ;
    boolean contientClef(K c) ;
    boolean contientValeur(V v) ;
    int nbElements() ;
    Couple<K,V> assocPour(K c) ;
    V valeurPour(K c) ;
    void ajouter(Couple<K,V> assoc) ;
    void ajouter(K c, V v) ;
    void enlever(Couple<K,V> assoc) ;
    void enleverPour(K c) ;
}
