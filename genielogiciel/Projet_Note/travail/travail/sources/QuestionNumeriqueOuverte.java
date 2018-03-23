public class QuestionNumeriqueOuverte extends QuestionNumerique implements VerificateurNumerique{

    VerificateurNumerique algorithme;
    
    public QuestionNumeriqueOuverte(String enonce,VerificateurNumerique x,String rep,int valeur){
	super(enonce,rep,valeur);
	algorithme = x;
    }

    public boolean bonneReponseTrouvee() {
	return this.verifier(super.reponseDuJoueur);
    }
    
    public boolean verifier(int x){
	return this.algorithme.verifier(x);
    }
}


