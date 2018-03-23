public class Routiere extends Cargaison_terre{

    public Routiere(int distance){
	super(distance,38000);
    }

    public int cost(){
	return 4*this.distance*this.quantity;
    }
}
