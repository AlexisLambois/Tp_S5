public class QuestionNumerique extends Question{

    protected String bonneReponse ;
    
    protected int reponseDuJoueur ;

    public QuestionNumerique(String q, int r, int p) { 
	super(q, p) ;
	bonneReponse = r+"" ;
    }

    public QuestionNumerique(String q, String r, int p) { 
	super(q, p) ;
	bonneReponse = r;
    }

    public void saisirReponseJoueur() {
	reponseDuJoueur = Clavier.readInt() ;
    }

    public boolean bonneReponseTrouvee() {
	return (reponseDuJoueur+"").equals(bonneReponse) ;
    }

    public String donnerBonneReponse()  { return bonneReponse; }
}
