package partie;

import java.util.ArrayList;
import java.util.Scanner;

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
	private int mana;
	private boolean estJ1;
	
	/**
	 * Constructeur de classe.
	 * Les attributs de la classe sont initialis�s durant une partie
	 */
	public Joueur() {
		super();
	}
	
	public void afficherMain(){
		
		int cpt = 0;
		
		for (Carte carte : main){
			System.out.println(carte.toString() + " id : " + cpt + "/b");
			cpt ++;
		}
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
		this.main.add(this.pioche.piocher(this.heros.getType()));
	}
	
	/**
	 * Appelé par Jeu afin de permettre au joueur de jouer.
	 * 
	 * @param mana maximal du joueur pour ce tour
	 * @return le joueur perdant. Null si il n'y en a pas.
	 */
	public Joueur jouer() {
		//TODO demande au joueur de selectionner des cartes et des actions.
		
		boolean finTour = false;
		
		while (finTour == false){
			System.out.println("Selectionnez une action parmis celles-ci : Jouer, Attaquer, Terminer tour");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			switch(input){
				case "Jouer": 
					System.out.println("Selectionnez une carte parmis la liste avec le numéro lui correspondant");
					this.afficherMain();
					
			}
			
		}
		
		
		
		return null;
	}

	public boolean aPerdu() {
		return this.heros.estMort();
	};
	private void invoquerCarte(int index){
		if (this.main.get(index) instanceof Serviteur) {
			this.invoquerServiteur(index);			
		}else {
			this.utiliserSort(index);
		}
		int coutMana = this.main.get(index).getCoutMana();
		this.mana -= coutMana;
		this.main.remove(index);
	}
	
	
	private void utiliserSort(int index) {
		// TODO Auto-generated method stub
		
	}

	private void invoquerServiteur(int index){
		Serviteur s1 = (Serviteur) this.main.get(index);
		this.plateau.invoquerServiteur(s1, this.estJ1);
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

}
