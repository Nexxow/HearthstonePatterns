package carte;

import plateau.Plateau;

public class CarteGuerrierMaitriseDuBlocage extends Sort {
	
	public CarteGuerrierMaitriseDuBlocage() {
		this.nom = "Maitrise du blocage";
		this.coutMana = 3;
		this.description = "Vous gagnez 5 points d'armure et piochez une carte";
	}

	@Override
	public void activer(boolean isJ1, Plateau plateau) {
		plateau.getJoueur(isJ1).getHeros().attaqueArmure(-5);
	}
}
