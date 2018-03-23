public abstract class Question{

    int valeur;
    String enonce;
    
    public Question(String enonce, int valeur){
	this.valeur=valeur;
	this.enonce=enonce;
    }

    public abstract void saisirReponseJoueur();
    
    public abstract boolean bonneReponseTrouvee();

    public abstract String donnerBonneReponse();

    public String toString(){
	return "Question : ("+getValeur()+" point) : "+this.enonce;
    }

    public int getValeur(){
	return this.valeur;
    }

}
