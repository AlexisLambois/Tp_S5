import java.util.*;
public class ex3q2{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	StringTokenizer st = new StringTokenizer(sc.nextLine());
	Stack<String> sta = new Stack<>();
	while(st.hasMoreTokens()){
	    sta.push(st.nextToken());
	}
	while(!sta.empty()){
	    System.out.print(sta.pop()+" ");
	}
	System.out.print("\n");
    }
}
