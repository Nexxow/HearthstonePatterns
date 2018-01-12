package carte;

import java.util.ArrayList;

import plateau.Plateau;

public class CarteMageExplosionDesArcanes extends Sort {
	
	public CarteMageExplosionDesArcanes() {
		this.nom = "Explosion des arcanes";
		this.coutMana = 2;
		this.description = "Inflige 1 point de degats a tous les serviteurs adverses";
	}

	@Override
	public void activer(boolean isJ1, Plateau plateau) {
		ArrayList<Serviteur> array = plateau.getServiteurJoueur(!isJ1);
		for (int i = 0; i < array.size(); i++) {
			plateau.sortAttaqueMonstre(1, i, isJ1);		
		}
		
	}
}
