package heros;

import plateau.Plateau;

public class PouvoirArmure implements Pouvoir {

	@Override
	public void utiliserPouvoir(boolean estJ1, Plateau plateau) {
			plateau.getJoueur(estJ1).getHeros().attaqueArmure(-2);
	}

}
