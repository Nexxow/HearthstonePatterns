package partie;

import plateau.Plateau;

public class Jeu {
	private int tour;
	private Plateau plateau;
	
	public Jeu(Joueur j1, Joueur j2) {
		j1.setOrdreJeu(true);
		j2.setOrdreJeu(false);
		this.plateau=new Plateau(j1, j2);
		this.tour = 0;
	}

	/**
	 * m�thode lanc� pour faire fonctionner la partie
	 * elle s'arr�te � la fin du jeu
	 * @return 
	 */
	public Joueur lancerPartie(){
		while (true) {			
			int mana = getManaTour();
			boolean isJ1;
			for (int i = 0; i < 2; i++) {
				// choix du joueur
				if (i==0) isJ1 =true;
				else isJ1 =false;
				// tour de jeu
				this.plateau.getJoueur(isJ1).setMana(mana);
				Joueur joueurPerdant = this.jouer(isJ1);
				if (joueurPerdant!=null) return this.finDuJeu(joueurPerdant);
			}
			this.tour+=1;
		}
	}

	/**
	 * 	
	 * @param joueur le joueur en train de jouer
	 * @param mana max du joueur pour ce tour
	 * @return le joueur perdant. Null si il n'y en a pas.
	 */
	private Joueur jouer(boolean isJ1) {
		Joueur joueurPerdant;
		this.piocher(isJ1);
		joueurPerdant = this.plateau.getJoueur(isJ1).jouer();
		return joueurPerdant;
	}

	/**
	 * M�thode lanc� � la fin du jeu
	 * @param joueurPerdant
	 * @return
	 */
	private Joueur finDuJeu(Joueur joueurPerdant) {
		return joueurPerdant;		
	}

	/**
	 * 
	 * @return la mana max. pour ce tour.
	 */
	private int getManaTour() {
		int mana;
		if (this.tour<10) mana=this.tour;
		else mana=10;
		return mana;
	}

	/**
	 * organise la mani�re de piocher � chaque tour
	 * @param joueur qui pioche
	 */
	private void piocher(boolean isJ1) {
		if ((this.tour==0)&&(isJ1==true)){
			this.plateau.getJoueur(isJ1).piocher();
			this.plateau.getJoueur(isJ1).piocher();
			this.plateau.getJoueur(isJ1).piocher();
		}
		else if ((this.tour==0)&&(isJ1==false)){
			this.plateau.getJoueur(isJ1).piocher();
			this.plateau.getJoueur(isJ1).piocher();
			this.plateau.getJoueur(isJ1).piocher();
			this.plateau.getJoueur(isJ1).piocher();
		}
		else {
			this.plateau.getJoueur(isJ1).piocher();
		}
		
	}
}
