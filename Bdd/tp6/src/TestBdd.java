
public class TestBdd {

	public static void main(String[] args) {
		BddTools bdd = new BddTools("da2i");
		System.out.println(bdd.nbLines("test"));
		System.out.println(bdd.describe("test"));
		System.out.println(bdd.getRequest("SELECT * FROM test"));
		bdd.fermer();
	}

}
