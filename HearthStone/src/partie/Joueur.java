package partie;

import pioche.Pioche;
import heros.Heros;
import carte.Carte;

public class Joueur {
	private Carte[] main;
	private Heros heros;
	private Pioche pioche;
	
	public void piocher(){
		// TODO
	}
	
	/**
	 * Appelé par Jeu afin de permettre au joueur de jouer.
	 * @param mana maximal du joueur pour ce tour
	 * @return le joueur perdant. Null si il n'y en a pas.
	 */
	public Joueur jouer(int mana) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public boolean aPerdu() {
		return this.heros.estMort();
	};
}
