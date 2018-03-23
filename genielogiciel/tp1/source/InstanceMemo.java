/**
 * Ici commence la documentation de la classe InstanceMemo
 */
public class InstanceMemo{
    
	static int numero = 0;

    public InstanceMemo(){
    	numero++;
    }
    
    public static int nombreInstances(){
    	return numero;
    }

    public static void afficherInstances(){
    	for(int i = numero-10; i <= numero ; i++){
    		if(i>=0){
    			System.out.println("Je suis l'instance numero "+i);
    		}
    	}
    }
}
