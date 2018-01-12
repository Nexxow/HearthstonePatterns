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
	private boolean isJ1;
	
	/**
	 * Constructeur de classe.
	 * Les attributs de la classe sont initialisÃ©s durant une partie
	 */
	public Joueur() {
		super();
	}
	
	public void afficherListeCartes(ArrayList<Carte> cartes){
		
		int cpt = 0;
		
		for (Carte carte : cartes){
			System.out.println(carte.toString() + " id : " + cpt + "/b");
			cpt ++;
		}
	}
	
	public void setOrdreJeu(boolean isJ1){
		this.isJ1=isJ1;
	}
	
	private ArrayList<Serviteur> getMyServiteurs(){
		return this.plateau.getServiteurJoueur(isJ1);
	}
	
	private ArrayList<Serviteur> getServiteursEnnemis(){
		return this.plateau.getServiteurJoueur(!isJ1);
	}
	
	public void piocher(){
		this.main.add(this.pioche.piocher(this.heros.getType()));
	}
	
	/**
	 * AppelÃ© par Jeu afin de permettre au joueur de jouer.
	 * 
	 * @param mana maximal du joueur pour ce tour
	 * @return le joueur perdant. Null si il n'y en a pas.
	 */
	public Joueur jouer() {
		
		boolean finTour = false;
		
		while (finTour == false){
			System.out.println("Selectionnez une action parmis celles-ci : 'Jouer' (sort ou carte), 'Attaquer', 'Pouvoir',"
					+ " 'Terminer tour'");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			switch(input){
				case "Jouer": 
					this.jouerInvocation(sc);
					
				case "Attaquer":
					this.attaquer(sc);
					
				case "Pouvoir":
					this.utiliserPouvoir();
					
				case "Terminer tour":
					finTour = true;
					
			}
			if (this.plateau.getJoueur(!isJ1).heros.estMort()){
				return this.plateau.getJoueur(!isJ1);
			}
		}
		
		return null;
	}
	
	public void attaquer(Scanner sc) {
		
		int herosEnnemiPv = this.plateau.getJoueur(!isJ1).heros.getPV();
		int herosEnnemiArmure = this.plateau.getJoueur(!isJ1).heros.getArmure();
		
		ArrayList<Carte> cartesEnnemies;
		System.out.println("Quel ennemi ? Entrez son id");
		
		ArrayList<Serviteur> serviteursTaunt = this.plateau.getEffetTaunt(isJ1);
		
		if (serviteursTaunt != null){
			cartesEnnemies = new ArrayList<Carte>(serviteursTaunt);
		}
		else{
			ArrayList<Serviteur> servEnnemis = this.getServiteursEnnemis();
			cartesEnnemies = new ArrayList<Carte>(servEnnemis);
			System.out.println("-1 pour attaquer le héros adverse, il possède " + herosEnnemiPv + " PV, et " + herosEnnemiArmure
					+ " armure");
			
		}
		
		
		this.afficherListeCartes(cartesEnnemies);
		int ennemi = sc.nextInt();
		
		System.out.println("Avec quel allie ? Entrez son id");
		ArrayList<Serviteur> servAllies = this.getMyServiteurs();
		ArrayList<Carte> cartesAllies = new ArrayList<Carte>(servAllies);
		this.afficherListeCartes(cartesAllies);
		int allie = sc.nextInt();

		if (ennemi != -1) {
			this.plateau.monstreAttaqueMonstre(allie, ennemi, isJ1);
		}
		else {
			this.plateau.attaquerJoueur(this.getMyServiteurs().get(allie).getAttaque() , isJ1);
		}
	}
	
	public void jouerInvocation(Scanner sc) {
		System.out.println("Selectionnez une carte parmis la liste avec le numero lui correspondant");
		this.afficherListeCartes(this.main);
		int inputInt = sc.nextInt();
		this.invoquerCarte(inputInt);
	}

	public boolean aPerdu() {
		return this.heros.estMort();
	}
	
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
		this.plateau.invoquerServiteur(s1, this.isJ1);
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
	
	private void utiliserPouvoir(){
		this.heros.utiliserPouvoir(isJ1, plateau);
	}

	public void attaquePV(int nb) {
		this.heros.attaquePV(nb);
		
	}

	public Heros getHeros() {	
		return this.heros;
	}

}
