import java.util.*;
public class exo3q3{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	StringTokenizer st = new StringTokenizer(sc.nextLine());
	ArrayList<String> list = new ArrayList<>();
	while(st.hasMoreTokens()){
	    String temp = st.nextToken();
	    String temp2 = "";
	    for(int i = temp.length()-1 ; i >= 0 ; i--){
		temp2+=temp.charAt(i);
	    }
	    list.add(temp2);
	}
	System.out.println(list);
    }
}
