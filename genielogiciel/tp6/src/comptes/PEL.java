package comptes;
public class PEL extends CompteEpargne{

    protected int cpt=0;

    public PEL(int numero){
	super(numero,0.05);
    }

    public void retirer(double somme){
	if(super.getAnciennete()>=40){
	    super.retirer(somme);
	}
    }

    public void ajouter(double somme){
	cpt+=somme;
	super.ajouter(somme);
    }

    public void operationsMensuelles()throws DepassementDecouvertExc, VersementsInsuffisantsExc {
	super.anciennete++;
	if(cpt<=50){
	    super.operationsMensuelles();
	}else{
	    throw new VersementsInsuffisantsExc(super.getNumero());
	}
	cpt=0;
    }
}
