package etatCarte;

public class Attente extends EtatCarte {
	
	@Override
	public void detruire() {
		this.carte.etat=new Mort();
	}

}
