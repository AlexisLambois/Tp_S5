import java.util.*;
public class anagramme{
    public static boolean estAnagramme(String s1,String s2){

	if(s1.length()!=s2.length()){return false;}
	HashMap<Character,Integer> hs1 = new HashMap<>();
	HashMap<Character,Integer> hs2 = new HashMap<>();
	
	for(int i = 0 ; i < s1.length() ; i++){
	    char c1 = s1.charAt(i);
	    char c2 = s2.charAt(i);
	    if(hs1.containsKey(c1)){
		int temp = hs1.remove(c1);
		hs1.put(c1,temp+1);
	    }else{
		hs1.put(c1,1);
	    }
	    if(hs2.containsKey(c2)){
		int temp = hs2.remove(c2);
		hs2.put(c2,temp+1);
	    }else{
		hs2.put(c2,1);
	    }
	}

	Set cles = hs1.keySet();
	Iterator it = cles.iterator();
	while(it.hasNext() ){
	    Object cle = it.next();
	    if( hs1.get(cle) != hs2.get(cle) ){
		return false;
	    }
	}
	return true;
    }
    
    public static void main(String args[]){

	System.out.println(args[0].toLowerCase()+" et "+args[1].toLowerCase()+" sont anagrammes : " + estAnagramme(args[0].toLowerCase(),args[1].toLowerCase()));

    }
}
