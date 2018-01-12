package carte;

import java.util.ArrayList;

import plateau.Plateau;

public class CartePalaConsecration extends Sort {

	public CartePalaConsecration() {
		this.nom = "Consecration";
		this.coutMana = 4;
		this.description = "Inflige 2 points de degats a tous les adversaires";
	}

	@Override
	public void activer(boolean isJ1, Plateau plateau) {
		ArrayList<Serviteur> array = plateau.getServiteurJoueur(!isJ1);
		for (int i = 0; i < array.size(); i++) {
			plateau.sortAttaqueMonstre(2, i, isJ1);
			plateau.attaquerJoueur(2, isJ1);
			
		}
		
	}
}
