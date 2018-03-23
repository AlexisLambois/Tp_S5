/**
 * Algorithme "objet" du crible d’Ératosthène.
 */
public class Eratosthene {
    /**
     * Principe : on crée un générateur de nombres de 2 à N,
     * puis on le fait travailler.
     */
    public static void main (String [] argv) {
        Generateur g = new Generateur(1000) ;
        g.travailler() ;
        System.out.println(g.toString()) ;
    }
}