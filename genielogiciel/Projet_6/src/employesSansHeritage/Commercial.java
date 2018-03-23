package employesSansHeritage;

public class Commercial {
	
	private double salaire_fixe,chiffre_affaire ;
	private String nom ;
	
	public Commercial(String nom) {
		this.nom = nom;
		this.salaire_fixe=2000;
		this.chiffre_affaire=0;
	}
	
	public void setTravail(double chiffre_affaire) { 
		this.chiffre_affaire = chiffre_affaire ;
	}
	
	public double salaireHebdo() {
		return salaire_fixe+(chiffre_affaire/100);
	}
	
	public String toString() { 
		return nom ;
	}
}