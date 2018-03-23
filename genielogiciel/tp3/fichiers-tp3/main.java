class main{

	public static void main(String[] args){
		PileTableau<Integer> p = new PileTableau<Integer>();
		PileTableau<Integer> p1 = new PileTableau<Integer>("Truc");
		PileTableau<Integer> p2 = new PileTableau<Integer>("Truc2");
		p1.empile(20);
		p2.empile(21);
		p1.empile(22);
		p1.empile(23);
		p1.deplacerUnElementVers(p2);
		System.out.println(p2.toString());
	}
}
