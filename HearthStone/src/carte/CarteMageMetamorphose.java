package carte;

import java.util.ArrayList;
import java.util.Scanner;

import pioche.Pioche;
import plateau.Plateau;

public class CarteMageMetamorphose extends Sort {
	
	public CarteMageMetamorphose() {
		this.nom = "Metamorphose";
		this.coutMana = 4;
		this.description = "Transforme un serviteur en mouton 1/1";
	}

	@Override
	public void activer(boolean isJ1, Plateau plateau) {
		Pioche pioche = new Pioche();
		Serviteur s1 = (Serviteur) pioche.creerCarte("Mouton");
		
		int indexEnnemi=-1;
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Carte> cartesEnnemies;
		System.out.println("Quel ennemi ? Entrez son id");
		
		ArrayList<Serviteur> serviteursTaunt = plateau.getEffetTaunt(isJ1);
		
		if (serviteursTaunt != null){
			cartesEnnemies = new ArrayList<Carte>(serviteursTaunt);
		}
		else{
			ArrayList<Serviteur> servEnnemis = plateau.getJoueur(isJ1).getServiteursEnnemis();
			cartesEnnemies = new ArrayList<Carte>(servEnnemis);			
		}
	
		plateau.getJoueur(isJ1).afficherListeCartes(cartesEnnemies);
		indexEnnemi = sc.nextInt();
		
		plateau.getServiteurJoueur(!isJ1).set(indexEnnemi, s1);
		
	}
}
