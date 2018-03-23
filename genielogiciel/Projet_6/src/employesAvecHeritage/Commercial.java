package employesAvecHeritage;

public class Commercial extends EmployeQuelconque{
	private double salaireFixe;
	
	protected static double chiffreaffairetotal = 0;
	
	public Commercial(String nom){
		super(nom);
	}

	public double salaireHebdo() {
       return salaireFixe+(super.travail/100);
       
    }
	
	public void setTravail(double heures){
		super.setTravail(heures);
		chiffreaffairetotal+=heures;
	}

}
