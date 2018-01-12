package heros;

public class Heros {
	private int PV;
	private Pouvoir pouvoir;
	private int armure;
	
	public void utiliserPouvoir(){
		this.pouvoir.utiliserPouvoir();
	}

	public boolean estMort() {
		return this.PV<0;
	}
}
