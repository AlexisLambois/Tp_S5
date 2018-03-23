package comptes ;
public interface Compte
{
    /** Retourne le numero identifiant le compte */
    int getNumero() ; 
    /** Retourne le nombre de mois ecoules depuis l'ouverture */
    int getAnciennete() ;
    /** Retourne le numero du compte et le montant */
    String toString() ;
    /** Effectue un ajout de la somme specifiee sur le compte */
    void ajouter(double somme) ;
    /** Tente d'effectuer un retrait de la somme specifiee sur le compte */    
    void retirer(double somme) ;
    /** Effectue les operations mensuelles de maintenance du compte. Cette methode est
     *  susceptible de declencher des exceptions si des anomalies sont detectees. */
    void operationsMensuelles() throws DepassementDecouvertExc, VersementsInsuffisantsExc ;
}