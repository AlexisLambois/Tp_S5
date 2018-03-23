
public class AffichageSimple implements Affichage{

	public String affichage_tableau(Disque[] d, int n) {
		String res = "";
		for (int i = 0; i < n; i++) {
			res+=d[i]+" ";
		}
		return res;
	}

}
