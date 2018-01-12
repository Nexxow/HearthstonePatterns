package partie;

public class Jeu {
	private int tour;
	private Joueur j1;
	private Joueur j2;
	
	
	public Jeu(Joueur j1, Joueur j2) {
		j1.setOrdreJeu(true);
		this.j1 = j1;
		j2.setOrdreJeu(false);
		this.j2 = j2;
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
			String joueur;
			for (int i = 0; i <= 2; i++) {
				if (i==1){
					joueur = "j1";
					this.j1.setMana(mana);
				}
				else{
					joueur= "j2";
					this.j2.setMana(mana);
				}
				
				Joueur joueurPerdant = this.jouer(joueur, mana);
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
	private Joueur jouer(String joueur, int mana) {
		Joueur joueurPerdant;
		if (joueur=="j1"){
			this.piocher(this.j1);
			joueurPerdant = this.j1.jouer(mana);
		}else{
			this.piocher(this.j2);
			joueurPerdant = this.j2.jouer(mana);
		}
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
	private void piocher(Joueur joueur) {
		if ((this.tour==0)&&(joueur==this.j1)){
			joueur.piocher();
			joueur.piocher();
			joueur.piocher();
		}
		else if ((this.tour==0)&&(joueur==this.j2)){
			joueur.piocher();
			joueur.piocher();
			joueur.piocher();
			joueur.piocher();
		}
		else {
			joueur.piocher();
		}
		
	}
}
