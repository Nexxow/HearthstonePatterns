package carte;

import etatCarte.EtatCarte;
import etatCarte.NonInvoque;

public abstract class Carte {
	public EtatCarte etat = new NonInvoque();
	

	public void jouer() { this.etat.jouer(); }
	
	public void invoquer() { this.etat.invoquer(); }

	public void detruire() { this.etat.detruire(); }
	
}
