import java.util.*;
public class recensements{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	BitSet bs = new BitSet();
	StringTokenizer t = new StringTokenizer(sc.nextLine());
	
	while (t.hasMoreTokens()){
	    String chaine = t.nextToken();
	    for(int i = 0 ; i < chaine.length() ; i++){
		bs.set(chaine.charAt(i));
	    }
	}
	for (int i=0; i<bs.length(); i++)
	    if (bs.get(i)) System.out.print(((char) i) + " ");

	System.out.print("\n");
    }
}
