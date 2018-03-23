package comptes ;
/** Exception a lever dans le cas ou les versements effectues 
 * depuis le mois precedent sur un PEL sont insuffisants */
public class VersementsInsuffisantsExc extends Exception
{
    public VersementsInsuffisantsExc(int num_compte)
    {
	super("Les versements du mois ecoule sur le PEL n° " 
	      + num_compte + " sont insuffisants") ;
    }
}
