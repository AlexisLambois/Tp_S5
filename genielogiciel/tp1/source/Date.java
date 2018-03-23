/**
 * Ici commence la documentation de la classe Date
 */

public class Date{
	
    /** Les attributs concernant le jour,moi et annee de la date voulu*/
    private int jour, mois, annee ;
    
    /** Attribut representant les mois d une annee*/
    public static final String [] NOM_DES_MOIS =
    { "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet",
      "Aout", "Septembre", "Octobre", "Novembre", "Decembre" } ;
    
    public static final String [] NOM_DES_MOIS_anglais =
    { "January", "February", "March", "April", "May", "June", "July",
      "August", "September", "October", "November", "December" } ;
    
    /** Constructeur pour creer une date*/
    public Date(int jour, int mois, int annee){
        this.jour = jour ;
        this.mois = mois ;
        this.annee = annee ;
    }
    
    /** Methode retournant un format de date*/
    public String toString(){
        return jour + " " + NOM_DES_MOIS[mois-1] + " " + annee ;
    }
    
    public String toStringAnglais(){
        return jour + " " + NOM_DES_MOIS_anglais[mois-1] + " " + annee ;
    }
    
    public static void main(String [] arg){
    	
		int jour = Clavier.readInt();
		int mois = Clavier.readInt();
		int anne = Clavier.readInt();
		Date d = new Date(jour,mois,anne);
	
		if(arg[0].length() > 0 && arg[0].equals("-francais")){
		    System.out.println(d.toString());
		}else{
		    System.out.println(d.toStringAnglais());
		}
    }
}
