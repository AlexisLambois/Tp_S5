import java.lang.*;
class Rationnel implements Comparable<Rationnel>{
	
	int p,q;

	public Rationnel(int p, int q){
		if(q!=0){
			this.p=p;
			this.q=q;
		}
	}

	public int compareTo(Rationnel r){
		if( this.calcul() < r.calcul() ){
			return -1;
		}else if( this.calcul() == r.calcul()){
			return 0;
		}
		return 1;
	}

	private double calcul(){
		return (double)this.p/this.q;
	}

}
