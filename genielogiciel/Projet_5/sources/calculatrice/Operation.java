package calculatrice;

public enum Operation {
	
    PLUS("+"),
    MOINS("-"),
    FOIS("*"),
    DIV("/"),
    PUISS("^");
	
	private final String code_operation;
	
	Operation(String code){
		this.code_operation = code;
	}
	
	public double eval(double x,double y){
		if( this == PLUS ){
			return x+y;
		}
		if( this == MOINS ){
			return x-y;
		}
		if( this == FOIS ){
			return x*y;
		}
		if( this == DIV && y != 0 ){
			return x/y;
		}
		if( this == PUISS){
			return Math.pow(x, y);
		}
		return -1;
	}
	
	public String toString(){
		return code_operation;
	}
}
