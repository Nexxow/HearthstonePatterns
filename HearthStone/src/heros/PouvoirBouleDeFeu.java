package heros;

import carte.Serviteur;
import plateau.Plateau;

public class PouvoirBouleDeFeu implements Pouvoir {

	@Override
	public void utiliserPouvoir(boolean isJ1, Plateau plateau) {
		int indexEnnemi=-1;
		// TODO demander au joueur
		if (indexEnnemi==-1) plateau.attaquerJoueur(2, isJ1);
		else plateau.sortAttaqueMonstre(2, indexEnnemi, isJ1);
		
		
	}


}
