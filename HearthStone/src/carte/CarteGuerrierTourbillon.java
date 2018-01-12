package carte;

import java.util.ArrayList;

import plateau.Plateau;

public class CarteGuerrierTourbillon extends Sort {

	public CarteGuerrierTourbillon() {
		this.nom = "Tourbillon";
		this.coutMana = 1;
		this.description = "Inflige 1 point de degats a tous les serviteurs";
	}

	@Override
	public void activer(boolean isJ1, Plateau plateau) {
		ArrayList<Serviteur> array = plateau.getServiteurJoueur(!isJ1);
		for (int i = 0; i < array.size(); i++) {
			plateau.sortAttaqueMonstre(1, i, isJ1);	
		}
		array = plateau.getServiteurJoueur(isJ1);
		for (int i = 0; i < array.size(); i++) {
			plateau.sortAttaqueMonstre(1, i, !isJ1);	
		}
		
	}
	
}
