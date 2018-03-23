package employesAvecHeritage;

public class EmployeNormal extends EmployeAvecHSup{
	public EmployeNormal(String nom){
		super(nom);
		this.majoration=1.25;
	}
}
