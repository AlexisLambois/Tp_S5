public class Fluvial extends Cargaison_terre{

    public Fluvial(int distance){
	super(distance,30000);
    }

    public int cost(){
	return this.distance*(int)Math.sqrt(this.quantity);
    }
}
