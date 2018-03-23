package resto;

public class Plat {
	
	private int pno;
	private String type;
	private String libelle;
	private String description;
	
	public Plat(int pno,String type,String libelle,String description){
		this.pno=pno;
		this.type=type;
		this.libelle=libelle;
		this.description=description;
	}
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String toString() {return pno+";"+type+";"+libelle+";"+description;}
}