package image;

import dictionnaire.correction.Dictionnaire;
import dictionnaire.correction.TabDict;

public abstract class Image extends ImageQuelconque{

    private Dictionnaire points ;
    
	public Image(int w, int h) {
		super(w, h);
	}
	public void initialiserPoints() {
		points = new TabDict() ;
	}
	
	
}
