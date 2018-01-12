package heros;

import plateau.Plateau;

public class Heros {
	private int PV;
	private Pouvoir pouvoir;
	private int armure;
	private String type;
	
	public Heros(String type){
		this.PV = 30;
		this.armure = 0;
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public void utiliserPouvoir(boolean isJ1, Plateau plateau){
		this.pouvoir.utiliserPouvoir(isJ1, plateau);
	}

	public boolean estMort() {
		return this.PV<=0;
	}

	public void attaquePV(int nb) {
		this.PV-=nb;
		
	}

	public void attaqueArmure(int nb) {
		this.armure-=nb;
		
	}
	
}
