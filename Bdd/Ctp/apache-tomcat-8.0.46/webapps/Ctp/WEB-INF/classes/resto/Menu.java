package resto;

import java.util.Date;

public class Menu {
	private int mno;
	private Plat entree,plat,dessert;
	private String email;
	private Date resa;

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public Plat getEntree() {
		return entree;
	}

	public void setEntree(Plat entree) {
		this.entree = entree;
	}

	public Plat getPlat() {
		return plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}

	public Plat getDessert() {
		return dessert;
	}

	public void setDessert(Plat dessert) {
		this.dessert = dessert;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getResa() {
		return resa;
	}

	public void setResa(Date resa) {
		this.resa = resa;
	}
	
	public String toString()
	{
	    return mno+";"+email+";"+resa+"\n"+entree+"\n"+plat+"\n"+dessert;
	}
}