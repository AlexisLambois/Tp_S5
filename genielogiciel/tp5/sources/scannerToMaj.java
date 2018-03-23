import java.util.*;
public class scannerToMaj{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	StringTokenizer st = new StringTokenizer(sc.nextLine());
	int i = 0;
	while(st.hasMoreTokens()){
	    if( i%2==0 ){
		System.out.print(st.nextToken().toUpperCase());
	    }else{
		System.out.print(st.nextToken().toLowerCase());
	    }
	    i++;
	}
	System.out.print("\n");
    }
}
