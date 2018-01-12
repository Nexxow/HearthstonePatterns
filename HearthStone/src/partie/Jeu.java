package partie;

import plateau.Plateau;

public class Jeu {
	private int tour;
	private Plateau plateau;
	private Joueur j1;
	private Joueur j2;
	
	
	public Jeu(Joueur j1, Joueur j2) {
		this.j1 = j1;
		this.j2 = j2;
		this.tour = 0;
		this.plateau=new Plateau();
	}

	/**
	 * méthode lancé pour le tour d'un joueur
	 * elle est lancé une fois par joueur à chaque tour
	 */
	public void tourDeJeu(int tour){
			int mana = getManaTour(tour);
			Joueur joueurPerdant = this.j1.jouer(mana);
			if (joueurPerdant!=null) this.finDuJeu(joueurPerdant);
			joueurPerdant = this.j2.jouer(mana);
			if (joueurPerdant!=null) this.finDuJeu(joueurPerdant);
			
		}
		
	}

	private int getManaTour(int tour2) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void tour0() {
		// TODO Auto-generated method stub
		
	}
}
