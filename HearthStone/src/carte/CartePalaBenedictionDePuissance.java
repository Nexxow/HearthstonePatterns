package carte;

import plateau.Plateau;

public class CartePalaBenedictionDePuissance extends Sort {

	public CartePalaBenedictionDePuissance() {
		this.nom = "Benediction de puissance";
		this.coutMana = 1;
		this.description = "Confere plus 3 attaque a un serviteur";
	}

	@Override
	public void activer(boolean isJ1, Plateau plateau) {
		int indexServiteur=0;
		// TODO choix serviteur
		plateau.boostAttaque(3, indexServiteur, isJ1);
		
	}
	
}
