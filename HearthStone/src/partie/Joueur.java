package partie;

import java.util.ArrayList;

import pioche.Pioche;
import heros.Heros;
import carte.Carte;

public class Joueur {
	private ArrayList<Carte> main;
	private Heros heros;
	private Pioche pioche;
	
	/**
	 * Constructeur de classe.
	 * Les attributs de la classe sont initialisés durant une partie
	 */
	public Joueur() {
		super();
	}
	
	
	public void piocher(){
		//this.main.add(this.pioche.fabriquerCarte("")); // en attente d'une création aléatoire de carte
	}
	
	/**
	 * Appelé par Jeu afin de permettre au joueur de jouer.
	 * 
	 * @param mana maximal du joueur pour ce tour
	 * @return le joueur perdant. Null si il n'y en a pas.
	 */
	public Joueur jouer(int mana) {
		//TODO demande au joueur de selectionner des cartes et des actions.
		return null;		
	}

	public boolean aPerdu() {
		return this.heros.estMort();
	};
}
