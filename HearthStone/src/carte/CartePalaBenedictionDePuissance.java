package carte;

import java.util.ArrayList;
import java.util.Scanner;

import plateau.Plateau;

public class CartePalaBenedictionDePuissance extends Sort {

	public CartePalaBenedictionDePuissance() {
		this.nom = "Benediction de puissance";
		this.coutMana = 1;
		this.description = "Confere plus 3 attaque a un serviteur";
	}

	@Override
	public void activer(boolean isJ1, Plateau plateau) {
		int indexServiteur=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel allie cibler ? Entrez son id");
		ArrayList<Serviteur> servAllies = plateau.getJoueur(isJ1).getMyServiteurs();
		ArrayList<Carte> cartesAllies = new ArrayList<Carte>(servAllies);
		plateau.getJoueur(isJ1).afficherListeCartes(cartesAllies);
		int allie = sc.nextInt();
		plateau.boostAttaque(3, indexServiteur, isJ1);
		
	}
	
}
