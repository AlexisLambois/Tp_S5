/**
 * QuestionChaine : classe concrète qui définit les questions
 * dont les réponses sont des chaînes de caractères.
 *
 * @author S. Picault, d'après idée de P. Mathieu
 */

public class QuestionChaine extends Question 
{
    /** la chaîne attendue */
    protected String bonneReponse ;
    /** la chaîne donnée par le joueur */
    protected String reponseDuJoueur ;

    /** constructeur : ses paramètres sont l'énoncé de la question,
     * la chaîne correspondant à la réponse, et le nombre de points */
    public QuestionChaine(String q, String r, int p) { 
	super(q, p) ;
	bonneReponse = r ;
    }

    /** méthode permettant de lire la réponse du joueur */
    public void saisirReponseJoueur() {
	reponseDuJoueur = Clavier.readString() ;
    }

    /** méthode retournant vrai si la réponse du joueur est correcte
     * (la comparaison ne prend pas en compte la différence minuscule/
     * majuscule) */
    public boolean bonneReponseTrouvee() {
	return reponseDuJoueur.equalsIgnoreCase(bonneReponse) ;
    }

    /** renvoie la réponse correcte */
    public String donnerBonneReponse()  { return bonneReponse ; }  
} 
