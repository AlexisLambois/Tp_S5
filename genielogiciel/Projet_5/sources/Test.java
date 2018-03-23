import calculatrice.* ;

public class Test {
    public static void main(String [] args) {
        if (args.length < 2) 
            System.err.println("Au moins deux nombres et un signe sur la ligne de commande !") ;
        else {
            // deux nombres passés sur la ligne de commande
            double x = new Double(args[0]) ;
            String signe = args[1];
            double y = new Double(args[2]) ;
            
            for (Operation o: Operation.values())
            	if( o.toString().equals(signe)){
            		System.out.println(x + " " + signe + " " + y + " = " + o.eval(x, y)) ;
            	}
        }
    }
}
