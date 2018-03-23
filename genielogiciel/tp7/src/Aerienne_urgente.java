public class Aerienne_urgente extends Aerienne{

    public Aerienne_urgente(int distance){
	super(distance);
    }

    public int cost(){
	return 2*super.cost();
    }
}
