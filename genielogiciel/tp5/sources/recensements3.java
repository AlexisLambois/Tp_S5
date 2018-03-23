import java.util.*;
public class recensements3{
    public static void main(String args[]){
	
	Scanner sc = new Scanner(System.in);
	String s  = sc.nextLine();
	HashMap<Character,Integer> hs = new HashMap<>();
	for(int i = 0 ; i < s.length() ; i++){
	    char c = s.charAt(i);
	    if(hs.containsKey(c)){
		int temp = hs.remove(c);
		hs.put(c,temp+1);
	    }else{
		hs.put(c,1);
	    }
	}
	Set cles = hs.keySet();
	Iterator it = cles.iterator();
	while(it.hasNext() ){
	    Object cle = it.next();
	    System.out.print(cle+":"+hs.get(cle)+"  ");
	}
    }
}
