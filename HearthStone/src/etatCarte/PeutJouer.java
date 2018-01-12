package etatCarte;

public class PeutJouer extends EtatCarte {

	@Override
	public void jouer() {
		this.carte.etat=new Attente();

	}

	@Override
	public void detruire() {
		this.carte.etat=new Mort();

	}

}
