package image;

import java.util.Collections;
import java.util.Random;

import dictionnaire.correction.CoupleObj;
import dictionnaire.correction.Dictionnaire;
import dictionnaire.correction.TabDict;

public class ImageDict implements ImageGrise{

	TabDict<Point, NiveauGris> nivgris;
	int largeur;
	int hauteur;
	
	public ImageDict(int w, int h){
		this.largeur=w;
		this.hauteur=h;
		this.nivgris = new TabDict<>();
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				nivgris.ajouter(new Point(i,j),NiveauGris.randomize());
			}
		}
	}
	
	@Override
	public int largeur() {
		return largeur;
	}

	@Override
	public int hauteur() {
		return hauteur;
	}

	@Override
	public NiveauGris pointEn(int x, int y) {
		return nivgris.valeurPour(new Point(x,y));
	}

	@Override
	public void definirPoint(int x, int y, NiveauGris gris) {
		nivgris.enleverPour(new Point(x,y));
		nivgris.ajouter(new Point(x,y), gris);
	}

	@Override
	public void allumer(int x, int y) {
		nivgris.enleverPour(new Point(x,y));
		nivgris.ajouter(new Point(x,y), NiveauGris.NOIR);
	}

	@Override
	public void eteindre(int x, int y) {
		nivgris.enleverPour(new Point(x,y));
		nivgris.ajouter(new Point(x,y), NiveauGris.BLANC);
		
	}

	@Override
	public void randomize() {
		Random rdm = new Random();
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				if(rdm.nextInt(2) == 1){
					eteindre(i, j);
				}else{
					allumer(i, j);
				}
			}
		}
	}

	@Override
	public int compterPoints(NiveauGris gris) {
		int points=0;
		for (int i = 0; i < largeur; i++) {
			for (int j= 0; j < hauteur; j++) {
				if(nivgris.valeurPour(new Point(i,j)).equals(gris)){
					points++;
				}
			}
		}
		return points;
	}

	@Override
	public ImageGrise inverser() {
		ImageDict ig = new ImageDict(largeur, hauteur);
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				NiveauGris niv = ig.nivgris.valeurPour(new Point(i,j));
				ig.nivgris.enleverPour(new Point(i,j));
				ig.nivgris.ajouter(new Point(i,j), niv.inverser());
			}
		}
		return ig;
	}

	@Override
	public ImageGrise eclaircir() {
		ImageDict it = new ImageDict(largeur, hauteur);
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				NiveauGris niv = it.nivgris.valeurPour(new Point(i,j));
				it.nivgris.enleverPour(new Point(i,j));
				it.nivgris.ajouter(new Point(i,j), niv.eclaircir());
			}
		}
		return it;
	}

	@Override
	public ImageGrise assombrir() {
		ImageDict it = new ImageDict(largeur, hauteur);
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				NiveauGris niv = it.nivgris.valeurPour(new Point(i,j));
				it.nivgris.enleverPour(new Point(i,j));
				it.nivgris.ajouter(new Point(i,j), niv.assombrir());
			}
		}
		return it;
	}

	@Override
	public ImageGrise dupliquer() {
		ImageDict it = new ImageDict(largeur, hauteur);
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				it.nivgris.ajouter(new Point(i,j), nivgris.valeurPour(new Point(i,j)));
			}
		}
		return it;
	}

	@Override
	public ImageGrise ajouter(ImageGrise img) {
		ImageDict it = new ImageDict(largeur, hauteur);
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				NiveauGris niv = it.nivgris.valeurPour(new Point(i,j));
				it.nivgris.enleverPour(new Point(i,j));
				it.nivgris.ajouter(new Point(i,j), niv.ajouter(img.pointEn(i, j)));
			}
		}
		return it;
	}

	@Override
	public ImageGrise soustraire(ImageGrise img) {
		ImageDict it = new ImageDict(largeur, hauteur);
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				NiveauGris niv = it.nivgris.valeurPour(new Point(i,j));
				it.nivgris.enleverPour(new Point(i,j));
				it.nivgris.ajouter(new Point(i,j), niv.soustraire(img.pointEn(i, j)));
			}
		}
		return it;
	}

	@Override
	public ImageGrise XOR(ImageGrise img) {
		ImageDict it = new ImageDict(largeur, hauteur);
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				NiveauGris niv = it.nivgris.valeurPour(new Point(i,j));
				it.nivgris.enleverPour(new Point(i,j));
				it.nivgris.ajouter(new Point(i,j), niv.XOR(img.pointEn(i, j)));
			}
		}
		return it;
	}

	@Override
	public ImageGrise intersection(ImageGrise img) {
		ImageDict it = new ImageDict(largeur, hauteur);
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				if(!nivgris.valeurPour(new Point(i,j)).equals(img.pointEn(i, j))){
					it.nivgris.enleverPour(new Point(i,j));
					it.nivgris.ajouter(new Point(i,j), NiveauGris.BLANC);
				}else{
					it.nivgris.enleverPour(new Point(i,j));
					it.nivgris.valeurPour(new Point(i,j));
				}
			}
		}
		return it;
	}

	@Override
	public NiveauGris niveauMoyen() {
		int [] nivmoy = {compterPoints(NiveauGris.BLANC),compterPoints(NiveauGris.GRIS_CLAIR),compterPoints(NiveauGris.GRIS_FONCE),compterPoints(NiveauGris.GRIS_MOYEN),compterPoints(NiveauGris.NOIR)};
		NiveauGris [] ng = {NiveauGris.BLANC,NiveauGris.GRIS_CLAIR,NiveauGris.GRIS_FONCE,NiveauGris.GRIS_MOYEN,NiveauGris.NOIR};
		
		int max = 0;
		
		for (int i = 1; i < nivmoy.length; i++) {
			if(nivmoy[max] < nivmoy[i]){
				max = i;
			}
		}
		return ng[max];
		
	}

	@Override
	public ImageGrise augmenterContraste() {
		NiveauGris moy = niveauMoyen();
		ImageDict it = new ImageDict(largeur, hauteur);
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				if(moy.compareTo(nivgris.valeurPour(new Point(i,j))) > 0){
					it.nivgris.enleverPour(new Point(i,j));
					it.nivgris.ajouter(new Point(i,j), nivgris.valeurPour(new Point(i,j)).assombrir());
				}else{
					it.nivgris.enleverPour(new Point(i,j));
					it.nivgris.ajouter(new Point(i,j), nivgris.valeurPour(new Point(i,j)).eclaircir());
				}
			}
		}
		return it;
	}
	
}