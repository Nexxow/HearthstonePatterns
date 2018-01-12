package heros;

import carte.Carte;
import carte.Serviteur;
import pioche.Pioche;
import plateau.Plateau;

public class PouvoirRenfort implements Pouvoir {

	@Override
	public void utiliserPouvoir(boolean isJ1, Plateau plateau) {
		Pioche pioche = new Pioche();
		Serviteur s1 = (Serviteur) pioche.creerCarte("Recrue de la Main d'argent");
		plateau.invoquerServiteur(s1, isJ1);
	}

}
