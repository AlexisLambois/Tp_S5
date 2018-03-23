package employesAvecHeritage;

public abstract class EmployeQuelconque {

	protected String nom;
	protected double travail;
	
	public EmployeQuelconque(String nom) {
		this.nom = nom ;
	}
	
	public String toString() { 
		return nom ;
	}
	
	public void setTravail(double x){
		this.travail=x;
	}
	
	public abstract double salaireHebdo();
}
