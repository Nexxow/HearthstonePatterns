package heros;

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


	public void utiliserPouvoir(){
		this.pouvoir.utiliserPouvoir();
	}

	public boolean estMort() {
		return this.PV<0;
	}
	
}
