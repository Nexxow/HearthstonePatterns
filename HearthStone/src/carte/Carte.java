package carte;

import etatCarte.EtatCarte;
import etatCarte.NonInvoque;

public abstract class Carte {
	public EtatCarte etat = new NonInvoque();
	protected int coutMana;
	protected String nom;
	protected String description;
	

	public void jouer() { this.etat.jouer(); }
	
	public void invoquer() { this.etat.invoquer(); }

	public void detruire() { this.etat.detruire(); }

	public int getCoutMana() {
		return coutMana;
	}
	
	public String toString(){
		String str = "Carte " + this.nom + ", Coût en mana " + this.coutMana + ", Description : " + this.description;
		return str;
	}
	
}
