import java.util.*;
public class tri{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	StringTokenizer st = new StringTokenizer(sc.nextLine());
	ArrayList<String> list = new ArrayList<>();
	while(st.hasMoreTokens()){
	    list.add(st.nextToken());
	}
	Collections.sort(list);
	System.out.println(list);
    }
}
