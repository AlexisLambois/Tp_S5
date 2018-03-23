/** @author Lambois Alexis */
public class Rationnel{
	
	int n,a,b;

	public Rationnel( int n ){
		this.n=n;
	}
	
	public Rationnel( int a, int b ){
		this(0,a,b);
	}
	
	public Rationnel( int n, int a, int b ){

		if( b != 0 ){
			
			int tempa = a;
			int tempb = b;
			int tempn = n;
			
			if( a >= b ){
				
				tempn = tempn + tempa/tempb;
				tempa = tempa%tempb;
				System.out.println(tempn+" "+tempa+" "+tempb);
			}
			
			if( tempa < 0 && tempb < 0 ){
				
				tempa = Math.abs(tempa);
				tempb = Math.abs(tempb);
				
			}
			
			if( ( tempa < 0 || tempb < 0 ) && tempa != 0 ){
				
				tempn--;
				tempa = Math.abs(tempb) - Math.abs(tempa);
				tempb = Math.abs(tempb);
				
			}
			System.out.println(tempn+" "+tempa+" "+tempb);
			this.a = tempa;
			this.b = tempb;
			this.n = tempn;
			
		}
	}
	
	/**
	*@return un boolean signifiant si l'objet est nul
	*/
	public boolean estNul(){
		return a==0 && n==0;
	}
	
	/**
	*@return le Rationnel inverse
	*/
	public Rationnel inverse(){

		if( a == 0 ){
			return new Rationnel(1,n);
		}

		if( n == 0 ){
			if( b%a == 0){
				return new Rationnel(b/a);
			}else{
				return new Rationnel((int)b/a,b%a,a);
			}
		}
		return (new Rationnel(1,n)).ajouter(new Rationnel(b,a));
	}
	
	/**
	*@param r Rationnel a additionner
	*@return le Rationnel representant la somme des deux
	*/
	public Rationnel ajouter(Rationnel r){
		int x,y;
		x = this.a*r.b+r.a*this.b;
		y = r.b * this.b;
		return new Rationnel(r.n+this.n+(int)b/x,y%x,x);		
	}
	
	/**
	*@param r Rationnel a multiplier
	*@return le Rationnel representant la multiplication des deux
	*/
	public Rationnel multiplier(Rationnel r){
		int resn = this.n*r.n;
		Rationnel r1 = new Rationnel(this.n*r.a,this.n*r.b);
		Rationnel r2 = new Rationnel(this.a*r.a,this.b*r.b);
		Rationnel r3 = new Rationnel(r.n*this.a,this.b*r.n);
		Rationnel res = r3.ajouter(r1.ajouter(r2));
		res.n = res.n + resn;
		return res;
	}
	
	/**
	*@return L'entier concernant l'attribut n
	*/
	public int donneEntier(){
		return this.n;		
	}
	
	/**
	*@return Le nombre a virgule concernant la fraction a/b
	*/
	public double donneDecimal(){
		return (double)this.a/this.b; 
	}
	
	/**
	*@param r Rationnel a comparer
	*@return L'entier representant le resultant de la comparaison
	*/
	public int compareTo(Rationnel r){
		
		if( this.n >= r.n ){
			return 1;
		}
		
		if( this.n <= r.n ){
			return -1;
		}

		if( this.a*r.b >= this.b*r.a ){
			return 1;
		}

		if( this.b*r.a <= this.a*r.b ){
			return -1;
		}
		
		return 0;
	}
	
	/**
	*@return Une chaine de caractere representant l'objet Rationnel
	*/
	public String toString(){
		
		if( a == 0 ){	
			return this.n +""; 
		}
		
		if( n == 0 ){
			return this.a+"/"+this.b;
		}
		
		return this.n+" + "+this.a+"/"+this.b;
	}
}
