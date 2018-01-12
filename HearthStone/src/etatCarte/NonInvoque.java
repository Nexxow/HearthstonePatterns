package etatCarte;

public class NonInvoque extends EtatCarte {

	@Override
	public void invoquer() {
		this.carte.etat=new Attente();
		
	}

}
