package comptes;
public class CompteCourant extends CompteGenerique{

    double montant_decouvert;

    public CompteCourant(int numero,double montant_decouvert){
	super(numero);
	this.montant_decouvert=montant_decouvert;
    }

    public void operationsMensuelles() throws DepassementDecouvertExc, VersementsInsuffisantsExc{
	super.anciennete++;
	if(montant<montant_decouvert){
	    throw new DepassementDecouvertExc(this.getNumero());
	}

	if(super.montant<0){
	    if(super.anciennete<60){
		super.retirer(super.montant*-1*0.1);
	    }else{
		super.retirer(super.montant*-1*0.06);
	    }
	}
    }

}
