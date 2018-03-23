public abstract class Cargaison_terre extends Cargaison{

    public Cargaison_terre(int distance,int limite){
	super(distance,limite);
    }

    public void add(Good g){
	if(g.getWeight()+this.quantity < this.limite){
	    this.contient.add(g);
	    this.quantity+=g.getWeight();
	}else{
	    throw new IllegalStateException("Ajout impossible");
	}
    }
}
