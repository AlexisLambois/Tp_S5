package image ;

import dictionnaire.correction.* ;

/** La classe <code>ImageDoubleDict</code> représente une image en niveaux 
 *  de gris au moyen d'un dictionnaire dont les clefs sont les abscisses des
 *  points de l'image, et les valeurs sont elles-mêmes des dictionnaires 
 *  associant à chaque ordonnée le niveau de gris associé.
 *  La différence principale avec <code>ImageDict</code> est le temps d'accès
 *  aux données, de l'ordre de <code>largeur + hauteur</code> dans le pire cas,
 *  contre <code>largeur * hauteur</code> pour le pire cas dans <code>ImageDict</code>.
 *  <B> On remarquera que le code de toutes les méthodes de <code>ImageDict</code>
 *  et <code>ImageDoubleDict</code> est identique, à l'exception de <code>pointEn</code>
 *  et <code>definirPoint</code>.</B>
 *  Cette classe utilise <code>TabDict</code> pour gérer les dictionnaires.
 *  @see image.NiveauGris
 *  @see image.Point
 *  @see dictionnaire.correction.TabDict   
 */
public class ImageDoubleDict extends Image {
	private Dictionnaire points ;

	public ImageDoubleDict(int w, int h) {
		super(w, h);
		this.initialiserPoints() ;
	}


	public void initialiserPoints() {
		points = new TabDict() ;
	}

	public NiveauGris pointEn(int x, int y) {
		if (points.contientClef(x)){
			Dictionnaire d = (Dictionnaire) points.valeurPour(x) ;
			if (d.contientClef(y))
				return (NiveauGris) d.valeurPour(y) ;
		}
		return new NiveauGris(NiveauGris.BLANC) ;
	}

	public void definirPoint(int x, int y, NiveauGris gris) {
		if (this.correct(x,y)) {
			if (gris.equals(new NiveauGris(NiveauGris.BLANC))) {
				Dictionnaire d ;
				if (points.contientClef(x)) {
					d = (Dictionnaire) points.valeurPour(x) ;
					d.enleverPour(y) ;
					if (d.estVide())
						points.enleverPour(x) ;
				}
			} else {
				Dictionnaire d ;
				if (points.contientClef(x))
					d = (Dictionnaire) points.valeurPour(x) ;
				else {
					d = new TabDict() ;
					points.ajouter(x, d) ;
				}
				d.ajouter(y, gris) ;
			}
		}
	}

	public ImageGrise inverser() {
		ImageGrise result = new ImageDoubleDict(largeur, hauteur) ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				result.definirPoint(x, y, this.pointEn(x,y).inverser()) ;
		return result ;
	}

	public ImageGrise eclaircir() {
		ImageGrise result = new ImageDoubleDict(largeur, hauteur) ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				result.definirPoint(x, y, this.pointEn(x,y).eclaircir()) ;
		return result ;
	}

	public ImageGrise assombrir() {
		ImageGrise result = new ImageDoubleDict(largeur, hauteur) ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				result.definirPoint(x, y, this.pointEn(x,y).assombrir()) ;
		return result ;
	}

	public ImageGrise dupliquer() {
		ImageGrise result = new ImageDoubleDict(largeur, hauteur) ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				result.definirPoint(x, y, new NiveauGris(this.pointEn(x,y).code())) ;
		return result ;
	}

	public ImageGrise ajouter(ImageGrise img) throws ImagesIncompatiblesException {
		ImageGrise result = new ImageDoubleDict(largeur, hauteur) ;
		if (this.incompatible(img)) 
			throw new ImagesIncompatiblesException();
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				result.definirPoint(x, y, 
						this.pointEn(x,y).ajouter(img.pointEn(x,y))) ;
		return result ;
	}

	public ImageGrise soustraire(ImageGrise img) throws ImagesIncompatiblesException {
		ImageGrise result = new ImageDoubleDict(largeur, hauteur) ;
		if (this.incompatible(img)) 
			throw new ImagesIncompatiblesException();
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				result.definirPoint(x, y, 
						this.pointEn(x,y).soustraire(img.pointEn(x,y))) ;
		return result ;
	}

	public ImageGrise XOR(ImageGrise img) throws ImagesIncompatiblesException {
		ImageGrise result = new ImageDoubleDict(largeur, hauteur) ;
		if (this.incompatible(img)) 
			throw new ImagesIncompatiblesException();
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				result.definirPoint(x, y, 
						this.pointEn(x,y).XOR(img.pointEn(x,y))) ;
		return result ;
	}

	public ImageGrise intersection(ImageGrise img) throws ImagesIncompatiblesException {
		ImageGrise result = new ImageDoubleDict(largeur, hauteur) ;
		if (this.incompatible(img)) 
			throw new ImagesIncompatiblesException();
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) 
				if (this.pointEn(x,y).equals(img.pointEn(x,y)))
					result.definirPoint(x, y, this.pointEn(x,y)) ;
		return result ;
	}


	public ImageGrise augmenterContraste() {
		NiveauGris courant, moyen ;
		ImageGrise result = new ImageDoubleDict(largeur, hauteur) ;
		moyen = this.niveauMoyen() ;
		for (int y=0; y<hauteur; y++)
			for (int x=0; x<largeur; x++) {
				courant = this.pointEn(x, y) ;
				if (courant.compareTo(moyen) > 0)
					result.definirPoint(x, y, courant.assombrir()) ;
				else 
					result.definirPoint(x, y, courant.eclaircir()) ;		    
			}
		return result ;
	}
}
