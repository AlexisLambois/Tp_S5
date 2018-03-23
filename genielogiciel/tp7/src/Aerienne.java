public class Aerienne extends Cargaison_aerien{

    public Aerienne(int distance){
	super(distance);
    }

    public int cost(){
	return (10*this.distance)+(4*this.quantity);
    }
}
