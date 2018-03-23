package image;

import dictionnaire.correction.TabDict;

public abstract class ImageQuelconque implements ImageGrise {


	protected int largeur, hauteur ;
    
    public ImageQuelconque(int w, int h) {
    	largeur = w ;
    	hauteur = h ;
    	this.initialiserPoints();
    }
    

    public boolean correct(int x, int y) {	
    	return ((x >= 0) && (x < largeur) && (y >= 0) && (y < hauteur)) ;
    }
    
    public boolean incompatible(ImageGrise img) {
    	return (largeur != img.largeur()) || (hauteur != img.hauteur()) ;
    }
    
    public int largeur() { return largeur ; }

    public int hauteur() { return hauteur ; }
    

    public abstract void initialiserPoints();
    
    public abstract NiveauGris pointEn(int x, int y);
	

	public abstract void definirPoint(int x, int y, NiveauGris gris);

	

	@Override
	public void allumer(int x, int y) {
		if (this.correct(x,y))
		    this.definirPoint(x, y, new NiveauGris(NiveauGris.NOIR)) ;
	}


	@Override
	public void eteindre(int x, int y) {
		if (this.correct(x,y))
		    this.definirPoint(x, y, new NiveauGris(NiveauGris.BLANC)) ;
	}


	@Override
	public void randomize() {
		for (int y=0; y<hauteur(); y++)
		    for (int x=0; x<largeur() ; x++) 
			this.definirPoint(x, y, this.pointEn(x,y).randomizeNB()) ;
	}


	@Override
	public int compterPoints(NiveauGris gris) {
		int nombre = 0 ;
		for (int y=0; y<hauteur; y++)
		    for (int x=0; x<largeur; x++) 
			if (this.pointEn(x,y).equals(gris))
			    nombre++ ;
		return nombre ;
	}


	public abstract ImageGrise inverser();

	public abstract ImageGrise eclaircir();

	public abstract ImageGrise assombrir();

	public abstract ImageGrise dupliquer();

	public abstract ImageGrise ajouter(ImageGrise img) throws ImagesIncompatiblesException;

	public abstract ImageGrise soustraire(ImageGrise img) throws ImagesIncompatiblesException;

	public abstract ImageGrise XOR(ImageGrise img) throws ImagesIncompatiblesException;
	
	public abstract ImageGrise intersection(ImageGrise img) throws ImagesIncompatiblesException;
	
	public abstract ImageGrise augmenterContraste();

	@Override
	public NiveauGris niveauMoyen() {
		int s = 0 ;
		for (int n=NiveauGris.BLANC; n<=NiveauGris.NOIR; n++) 
		    s += n * this.compterPoints(new NiveauGris(n)) ;
		return new NiveauGris((int)(((double) s) / (largeur * hauteur))) ;
	}


	
	
	 public String toString() {
			String s = largeur + "x" + hauteur ;
			for (int y=0; y<hauteur; y++) {
			    s += "\n" ;
			    for (int x=0; x<largeur; x++) 
				s += this.pointEn(x, y) ;	    
			}
			return s ;
	}
    
    
}
