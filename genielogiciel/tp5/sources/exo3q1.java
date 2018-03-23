import java.util.*;
public class exo3q1{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	StringTokenizer st = new StringTokenizer(sc.nextLine());
	ArrayList<Character> list = new ArrayList<>();
	Stack<Character> sta = new Stack<>();
	while(st.hasMoreTokens()){
	    String chaine = st.nextToken().toUpperCase();
	    for(int i=0; i < chaine.length() ; i++){
		list.add(chaine.charAt(i));
		sta.push(chaine.charAt(i));
	    }
	}
	for(char c : list){
	    System.out.print(c);
	}
	System.out.print("\n");

	boolean b = true;
	int i = 0;
	    
	while(!sta.empty()){
	    char c = sta.pop();
	    if(b && c!=list.get(i) ){
		b=false;
	    }
	    i++;
	    System.out.print(c);
	}
	System.out.println("\nEst palindrome : " + b);
    }
}
