public abstract class Cargaison_aerien extends Cargaison{

    public Cargaison_aerien(int distance){
	super(distance,80000);
    }

    public void add(Good g){
	if(g.getVolume()+this.quantity < this.limite){
	    this.contient.add(g);
	    this.quantity+=g.getVolume();
	}else{
	    throw new IllegalStateException("Ajout impossible");
	}
    }
}
