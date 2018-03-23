/**
 * Quiz : classe qui contient un ensemble de questions
 * et les pose au joueur. On calcule ensuite son score et on
 * le compare au score maximal atteignable.
 *
 * @author S. Picault, d'après idée de P. Mathieu
 */
import java.util.*;

public class Quiz
{
    private Stack<Question> questions;
    
    private int nbQuestions;
    // total : le score total théorique, score : le score du joueur
    private int total, score;

    /** constructeur pour un nombre de questions donné */
    public Quiz() 
    {
        questions = new Stack<>();
	nbQuestions=0;
    }

    /** ajoute l'argument q à la liste des questions */
    public void ajouteQuestion(Question q){
	questions.push(q);
	nbQuestions++ ;
    }

    /** pose la question q au joueur : l'affiche, demande à la question q
     * de lire la réponse, de vérifier la réponse, et met à jour le score
     * du joueur en cas de succès. En cas d'échec, demande à la question q
     * la réponse correcte */
    public void poserQuestion(Question q) {
	boolean valide = true;
	do{
	    System.out.println(q);
	    System.out.print("Réponse : ");
	    try{
		q.saisirReponseJoueur();
		valide = true;
	    }catch(Exception e){
		valide = false;
	    }
	}while( !valide );
	if (q.bonneReponseTrouvee())
	    {
		System.out.println("Exact !\n");
		score += q.getValeur();
	    }
	else
	    System.out.println("Faux, la réponse était " +
			       q.donnerBonneReponse() + "\n");
	total += q.getValeur();
    }

    /** jouer, c'est poser toutes les questions */
    public void jouer()
    {
	// on pose toutes les questions
	for (int i=0; i<nbQuestions;i++)
	    poserQuestion(questions.pop()) ;
	// et on affiche le score
	System.out.println("FIN DU QUIZ... Vous avez obtenu "
			   + score + "/" + total);
    }

    /** exemple d'utilisation avec toutes les classes possibles */
    public static void main(String [] args) 
    {
	Quiz q = new Quiz();

	q.ajouteQuestion(new QuestionNumerique
			 ("Date de la Révolution française",1789,1));
	q.ajouteQuestion(new QuestionCaractere
			 ("Dans le code ASCII, quel caractère a le code 65",(char)65,2));
	q.ajouteQuestion(new QuestionChaine
			 ("Quelle est la couleur de la planète Mars",
			  "rouge", 2)) ;
	q.ajouteQuestion(new QuestionOuiNon
			 ("DOS est un système multi-tâches","non",2));
	q.ajouteQuestion(new QuestionNumeriqueOuverte
			 ("Donnez une année bissextile",
			  new VerificateurNumerique () {
			      public boolean verifier(int x)
			      { return (x % 400 == 0) || ((x % 4 == 0) && (x % 100 != 0)) ; }
			  }, "toute année divisible par 400, ou par 4 mais pas par 100", 2)) ;
	q.ajouteQuestion(new QuestionCaractereOuverte
			 ("Donnez une lettre après Z dans le code ASCII",
			  new VerificateurCaractere (){
			      public boolean verifier(char x) {
				  return Character.isLetter(x) && (x > 'Z') ;
			      }
			  }, "a, b... , z",1));
	q.ajouteQuestion(new QuestionNumeriqueOuverte
			 ("Donnez un nombre impair",
			  new VerificateurNumerique () {
			      public boolean verifier(int x)
			        { return x % 2 == 1 ; }
			  }, "1, 3, 5, 7...", 2));
	q.ajouteQuestion(new QuestionCaractereOuverte
			 ("Donnez une consonne",
			  new VerificateurCaractere () {
			      public boolean verifier(char x)
			      { return Character.isLetter(x) && ("AEIOUYaeiouy".indexOf(x) < 0) ; }
			  }, "Tout sauf a, e, i, o, u ou y", 1));
	q.ajouteQuestion(new QuestionOuiNon
			 ("En logique FAUX implique VRAI","oui",3));
	q.jouer();
    }
}
