package heros;

import java.util.ArrayList;
import java.util.Scanner;

import carte.Carte;
import carte.Serviteur;
import plateau.Plateau;

public class PouvoirBouleDeFeu implements Pouvoir {

	@Override
	public void utiliserPouvoir(boolean isJ1, Plateau plateau) {
		int indexEnnemi=-1;
		Scanner sc = new Scanner(System.in);

		ArrayList<Carte> cartesEnnemies;
		System.out.println("Quel ennemi ? Entrez son id.");
		
		ArrayList<Serviteur> serviteursTaunt = plateau.getEffetTaunt(isJ1);
		
		if (serviteursTaunt != null){
			cartesEnnemies = new ArrayList<Carte>(serviteursTaunt);
		}
		else{
			ArrayList<Serviteur> servEnnemis = plateau.getServiteurJoueur(!isJ1);
			cartesEnnemies = new ArrayList<Carte>(servEnnemis);
		}
		
	
		plateau.getJoueur(isJ1).afficherListeCartes(cartesEnnemies);
		indexEnnemi = sc.nextInt();
		
		if (indexEnnemi==-1) plateau.attaquerJoueur(2, isJ1);
		else plateau.sortAttaqueMonstre(2, indexEnnemi, isJ1);
		
		
	}


}
