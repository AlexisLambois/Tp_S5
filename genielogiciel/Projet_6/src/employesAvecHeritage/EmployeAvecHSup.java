package employesAvecHeritage;

public class EmployeAvecHSup extends EmployeQuelconque {
	protected double temps_travail, taux_horaire, majoration ;
	
	public EmployeAvecHSup(String nom){
		super(nom);
		temps_travail = 35;
		taux_horaire=7.5;
	}
	
	
	public double salaireHebdo() {
		if (travail > temps_travail) 
			return temps_travail * taux_horaire 
					+ (travail - temps_travail) * taux_horaire * majoration ;
		return travail * taux_horaire ;
	}
}
