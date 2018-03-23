package employesAvecHeritage;

public class Directeur extends EmployeQuelconque{
	
	protected static Directeur d;
	
	private Directeur(){
		super("d d");
	}
	
	private static Directeur getDirecteur(){
		if(d == null){
			d = new Directeur();
		}
		return d;
	}

	@Override
	public double salaireHebdo() {
		return travail+0.4*Commercial.chiffreaffairetotal;
	}
	
}
