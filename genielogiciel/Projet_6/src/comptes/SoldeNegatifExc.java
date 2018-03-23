package comptes ;
/** Exception à lever dans le cas d'un solde négatif 
 * dépassant le découvert autorisé d'un compte courant */
public class SoldeNegatifExc extends Exception
{
    public SoldeNegatifExc(String message)
    {
	super(message) ;
    }
}
