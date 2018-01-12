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

		int herosEnnemiPv = plateau.getJoueur(!isJ1).getHeros().getPV();
		int herosEnnemiArmure = plateau.getJoueur(!isJ1).getHeros().getArmure();
		
		ArrayList<Carte> cartesEnnemies;
		System.out.println("Quel ennemi ? Entrez son id");
		
		ArrayList<Serviteur> serviteursTaunt = plateau.getEffetTaunt(isJ1);
		
		if (serviteursTaunt != null){
			cartesEnnemies = new ArrayList<Carte>(serviteursTaunt);
		}
		else{
			ArrayList<Serviteur> servEnnemis = plateau.getJoueur(isJ1).getServiteursEnnemis();
			cartesEnnemies = new ArrayList<Carte>(servEnnemis);
			System.out.println("-1 pour attaquer le héros adverse, il possède " + herosEnnemiPv + " PV, et " + herosEnnemiArmure
					+ " armure");
			
		}
	
		plateau.getJoueur(isJ1).afficherListeCartes(cartesEnnemies);
		indexEnnemi = sc.nextInt();
		
		if (indexEnnemi==-1) plateau.attaquerJoueur(1, isJ1);
		else plateau.sortAttaqueMonstre(1, indexEnnemi, isJ1);
		
		
	}


}
