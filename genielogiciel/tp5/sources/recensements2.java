import java.util.*;
public class recensements2{
    public static void main(String args[]){
	
	Scanner sc = new Scanner(System.in);
	HashSet<Character> e = new HashSet<Character>();
	String s  = sc.nextLine();
	
	for (int i=0; i<s.length(); i++)
	    e.add(s.charAt(i));
	Iterator<Character> it = e.iterator();
	while(it.hasNext())
	    System.out.print(it.next() + " ");
	System.out.print("\n");
    }
}
