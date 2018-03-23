package comptes ;
/** Exception a lever dans le cas d'un solde negatif 
 * depassant le decouvert autorise d'un compte courant */
public class DepassementDecouvertExc extends Exception
{
    public DepassementDecouvertExc(int num_compte)
    {
	super("Depassement du decouvert autorise sur le "
	      + "compte n° " + num_compte) ;
    }
}
