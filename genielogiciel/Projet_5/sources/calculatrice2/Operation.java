package calculatrice2;

public enum Operation {

	PLUS("+",2),
	MOINS("-",2),
	FOIS("*",2),
	DIV("/",2),
	PUISS("^",2),
	SQRT("V",1),
	ABS("ABS",1),
	NOT("NOT",1),
	IF("IF",3);

	private final String code_operation;
	private final int arite;

	Operation(String code, int arite){
		this.code_operation = code;
		this.arite = arite;
	}

	public int getArite(){
		return arite;
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
