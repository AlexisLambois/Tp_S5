import java.util.*;
public abstract class Cargaison{

    int distance;
    int limite;
    int quantity;
    ArrayList<Good> contient;

    public Cargaison(int distance,int limite){
	this.contient=new ArrayList<>();
	this.quantity=0;
	this.distance=distance;
	this.limite=limite;
    }

    public abstract void add(Good g);

    public abstract int cost();
}
