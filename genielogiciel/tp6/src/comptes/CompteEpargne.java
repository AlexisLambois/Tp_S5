package comptes;
public class CompteEpargne extends CompteGenerique{

    double taux;

    public CompteEpargne(int numero,double taux){
	super(numero);
	this.taux=taux;
    }

    public void retirer(double somme){
	if(somme<=this.montant){
	    super.retirer(somme);
	}
    }
    
    public void operationsMensuelles()throws DepassementDecouvertExc, VersementsInsuffisantsExc {
	double interet = taux*this.montant;
	System.out.println("Interet sont de : "+interet+"\n");
	super.ajouter(interet);
    }
}
