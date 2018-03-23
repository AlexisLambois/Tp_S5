package calculatrice3;

import java.util.Stack;

public enum Operation {
	
    PLUS("+",2),
    MOINS("-",2),
    FOIS("*",2),
    DIV("/",2),
    PUISS("^",2),
    SQRT("V",1),
    ABS("ABS",1),
    NOT("NOT",1),
    IF("IF",3),
	DROP(),
	DUP(),
	SWAP(),
	COUNT();
	
	private final String code_operation;
	private final int arite;
	
	Operation(){
		this.code_operation = name();
		arite = 0;
	}
	
	Operation(String code, int arite){
		this.code_operation = code;
		this.arite = arite;
	}
	
	public int getArite(){
		return arite;
	}
	
	public void execute(Stack<Double> pile){
		
		if( arite != 0){
			double[] temp = new double [ getArite() ];
			for (int j = 0; j < temp.length; j++) {
				temp[j] = pile.pop();
			}
			pile.push( eval(temp) );
		}else{
			if( this == DROP ){
				pile.pop();
			}else if( this == DUP ){
				pile.push(pile.peek());
			}else if( this == SWAP ){
				double a = pile.pop();
				double b = pile.pop();
				pile.push(a);
				pile.push(b);
			}else if( this == COUNT ){
				pile.push((double)pile.size());
			}
		}
	}
	
	public double eval(double [] operandes){
		if( this == PLUS ){
			return operandes[0]+operandes[1];
		}
		if( this == MOINS ){
			return operandes[0]-operandes[1];
		}
		if( this == FOIS ){
			return operandes[0]*operandes[1];
		}
		if( this == DIV && operandes[1] != 0 ){
			return operandes[0]/operandes[1];
		}
		if( this == PUISS){
			return Math.pow(operandes[0], operandes[1]);
		}
		if( this == SQRT){
			return Math.sqrt(operandes[0]);
		}
		if( this == ABS){
			return Math.abs(operandes[0]);
		}
		if( this == NOT){
			if(operandes[0]==0){
				return 1;
			}else{
				return 0;
			}
		}
		if( this == IF){
			if(operandes[0]!=0){
				return operandes[1];
			}else{
				return operandes[2];
			}
		}
		return -1;
	}
	
	public String toString(){
		return code_operation;
	}
}
