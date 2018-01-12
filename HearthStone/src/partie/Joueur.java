package partie;

import java.util.ArrayList;

import pioche.Pioche;
import plateau.Plateau;
import heros.Heros;
import carte.Carte;
import carte.Serviteur;

public class Joueur {
	private ArrayList<Carte> main;
	private Heros heros;
	private Pioche pioche;
	private Plateau plateau;
	private boolean estJ1;
	
	/**
	 * Constructeur de classe.
	 * Les attributs de la classe sont initialis�s durant une partie
	 */
	public Joueur() {
		super();
	}
	
	public void setOrdreJeu(boolean estJ1){
		this.estJ1=estJ1;
	}
	
	private ArrayList<Serviteur> getMyServiteurs(){
		if (estJ1)return this.plateau.getServiteursJ1();
		else return this.plateau.getServiteursJ2();	
	}
	
	private ArrayList<Serviteur> getServiteursEnnemies(){
		if (!estJ1)return this.plateau.getServiteursJ1();
		else return this.plateau.getServiteursJ2();
	}
	
	public void piocher(){
		this.main.add(this.pioche.piocher(String this.heros.getType()));
	}
	
	/**
	 * Appel� par Jeu afin de permettre au joueur de jouer.
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
	
	private void invoquerServiteur(Serviteur s1){
		
	}
}
