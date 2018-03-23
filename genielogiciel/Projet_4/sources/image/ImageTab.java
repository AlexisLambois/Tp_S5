package image;
import java.awt.Color;
import java.util.ArrayList;

public class ImageTab implements ImageGrise{
	
	NiveauGris[][] tab;
	private int largeur;
	private int hauteur;
	
	public ImageTab(int largeur,int hauteur){
		this.tab = new NiveauGris[largeur][hauteur];
		this.init();
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	
	private void init(){
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				this.tab[i][j] = NiveauGris.deCouleur(Color.LIGHT_GRAY);
			}
		}
	}

	public int largeur() {
		return this.largeur;
	}

	public int hauteur() {
		return this.hauteur;
	}

	public NiveauGris pointEn(int x, int y) {
		return this.tab[x][y];
	}

	public void definirPoint(int x, int y, NiveauGris gris) {
		this.tab[x][y] = gris;
	}

	public void allumer(int x, int y) {
		this.tab[x][y] = this.tab[x][y].deCouleur(Color.BLACK);
	}

	public void eteindre(int x, int y) {
		this.tab[x][y] = this.tab[x][y].deCouleur(Color.WHITE);
	}

	public void randomize() {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				this.tab[i][j] = this.tab[i][j].randomizeNB();
			}
		}
	}

	public int compterPoints(NiveauGris gris) {
		int cpt = 0;
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				if(this.tab[i][j].equals(gris)){
					cpt++;
				}
			}
		}
		return cpt;
	}

	public ImageGrise inverser() {
		ImageTab temp = (ImageTab) this.dupliquer();
		for (int i = 0; i < temp.largeur(); i++) {
			for (int j = 0; j < temp.hauteur(); j++) {
				 temp.tab[i][j] = temp.tab[i][j].inverser();
			}
		}
		return temp;
	}

	public ImageGrise eclaircir() {
		ImageTab temp = (ImageTab) this.dupliquer();
		for (int i = 0; i < temp.largeur(); i++) {
			for (int j = 0; j < temp.hauteur(); j++) {
				temp.tab[i][j] = temp.tab[i][j].eclaircir();
			}
		}
		return temp;
	}

	public ImageGrise assombrir() {
		ImageTab temp = (ImageTab) this.dupliquer();
		for (int i = 0; i < temp.largeur(); i++) {
			for (int j = 0; j < temp.hauteur(); j++) {
				 temp.tab[i][j] = temp.tab[i][j].assombrir();
			}
		}
		return temp;
	}

	public ImageGrise dupliquer() {
		ImageTab temp = new ImageTab(this.largeur,this.hauteur);
		for (int i = 0; i < temp.largeur(); i++) {
			for (int j = 0; j < temp.hauteur(); j++) {
				 temp.tab[i][j] = this.pointEn(i, j);
			}
		}
		return temp;
	}

	public ImageGrise ajouter(ImageGrise img) {
		if( img.largeur() != this.largeur || img.hauteur() != this.hauteur){
			return null;
		}
		ImageTab temp = new ImageTab(this.largeur,this.hauteur);
		for (int i = 0; i < temp.largeur(); i++) {
			for (int j = 0; j < temp.hauteur(); j++) {
				 temp.tab[i][j] = this.pointEn(i, j).ajouter(img.pointEn(i, j));
			}
		}
		return temp;
	}

	public ImageGrise soustraire(ImageGrise img) {
		if( img.largeur() != this.largeur || img.hauteur() != this.hauteur){
			return null;
		}
		ImageTab temp = new ImageTab(this.largeur,this.hauteur);
		for (int i = 0; i < temp.largeur(); i++) {
			for (int j = 0; j < temp.hauteur(); j++) {
				 temp.tab[i][j] = this.pointEn(i, j).soustraire(img.pointEn(i, j));
			}
		}
		return temp;
	}

	public ImageGrise XOR(ImageGrise img) {
		if( img.largeur() != this.largeur || img.hauteur() != this.hauteur){
			return null;
		}
		ImageTab temp = new ImageTab(this.largeur,this.hauteur);
		for (int i = 0; i < temp.largeur(); i++) {
			for (int j = 0; j < temp.hauteur(); j++) {
				 temp.tab[i][j] = this.pointEn(i, j).XOR(img.pointEn(i, j));
			}
		}
		return temp;
	}

	public ImageGrise intersection(ImageGrise img) {
		if( img.largeur() != this.largeur || img.hauteur() != this.hauteur){
			return null;
		}
		ImageTab temp = (ImageTab) this.dupliquer();
		for (int i = 0; i < temp.largeur(); i++) {
			for (int j = 0; j < temp.hauteur(); j++) {
				 if( !this.pointEn(i, j).equals(img.pointEn(i, j)) ){
					 temp.eteindre(i, j);
				 }
			}
		}
		return temp;
	}

	public NiveauGris niveauMoyen() {
		ArrayList<Integer> list = new ArrayList<>();
		NiveauGris[] list2 = new NiveauGris[]{NiveauGris.BLANC,NiveauGris.GRIS_CLAIR,NiveauGris.GRIS_MOYEN,NiveauGris.GRIS_FONCE,NiveauGris.NOIR};
		list.add(compterPoints(NiveauGris.BLANC));
		list.add(compterPoints(NiveauGris.GRIS_CLAIR));
		list.add(compterPoints(NiveauGris.GRIS_MOYEN));
		list.add(compterPoints(NiveauGris.GRIS_FONCE));
		list.add(compterPoints(NiveauGris.NOIR));
		int id_max = 0;
		
		for (int i = 1; i < list.size(); i++) {
			
			if( list.get(id_max) < list.get(i) ){
				id_max=i;
			}
		}
		
		return list2[id_max];
	}

	public ImageGrise augmenterContraste() {
		ImageTab temp = (ImageTab) this.dupliquer();
		NiveauGris moyenne = temp.niveauMoyen();
		
		for (int i = 0; i < temp.largeur(); i++) {
			for (int j = 0; j < temp.hauteur(); j++) {
				 if(moyenne.compareTo(temp.pointEn(i, j)) > 0){
					 temp.tab[i][j] = temp.tab[i][j].eclaircir();
				 }else{
					 temp.tab[i][j] = temp.tab[i][j].assombrir();
				 }
			}
		}
		return temp;
	}

}
