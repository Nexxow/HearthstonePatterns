package pioche;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import carte.Carte;
import carte.CarteChefDeRaid;
import carte.CarteChevaucheurDeLoup;
import carte.CarteGuerrierAvocatCommisDoffice;
import carte.CarteGuerrierMaitriseDuBlocage;
import carte.CarteGuerrierTourbillon;
import carte.CarteMageExplosionDesArcanes;
import carte.CarteMageImageMiroir;
import carte.CarteMageMetamorphose;
import carte.CartePalaBenedictionDePuissance;
import carte.CartePalaChampionFrisselame;
import carte.CartePalaConsecration;
import carte.CarteSanglierBrocheroc;
import carte.CarteSoldatComteOr;
import carte.CarteYetiNoroit;
import carte.RecrueMainArgent;
import carte.Serviteur;
import decoratorCarte.EffetCharge;
import decoratorCarte.EffetChefDeRaid;
import decoratorCarte.EffetProvoc;
import decoratorCarte.EffetVolDeVie;

public class Pioche extends FactoryCarte {

	public Carte piocher(String type){
		
		ArrayList<String> listStringCartes = new ArrayList<>(Arrays.asList("Sanglier brocheroc", "Soldat du comte-de-l'or", "Chevaucheur de loup",
				"Chef de raid", "Yeti noroit" ));
		
		switch(type) {
			case "Mage": listStringCartes.add("Image miroir");
				listStringCartes.add("Explosion des arcanes");
				listStringCartes.add("Metamorphose");
				break;
			case "Paladin": listStringCartes.add("Champion frisselame");
				listStringCartes.add("Benediction de puissance");
				listStringCartes.add("Consecration");
				break;
			case "Guerrier": listStringCartes.add("Tourbillon");
				listStringCartes.add("Avocat commis d'office");
				listStringCartes.add("Maitrise du blocage");
				break;
		}
		
		Random randomizer = new Random();
		String random = listStringCartes.get(randomizer.nextInt(listStringCartes.size()));
		
		return this.fabriquerCarte(random);
		
	}
	
	@Override
	public Carte fabriquerCarte(String nom) {
		Carte carte = null;
		switch(nom) {
			case "Sanglier brocheroc": carte = new CarteSanglierBrocheroc();
				carte = new EffetCharge((Serviteur) carte);
				break;
			case "Soldat du comte-de-l'or": carte = new CarteSoldatComteOr();
				carte = new EffetProvoc((Serviteur) carte);
				break;
			case "Chevaucheur de loup": carte = new CarteChevaucheurDeLoup();
				carte = new EffetCharge((Serviteur) carte);
				break;
			case "Chef de raid": carte = new CarteChefDeRaid();
				carte = new EffetChefDeRaid((Serviteur) carte);
				break;
			case "Yeti noroit": carte = new CarteYetiNoroit();
				break;
			case "Image miroir": carte = new CarteMageImageMiroir();
				break;
			case "Explosion des arcanes": carte = new CarteMageExplosionDesArcanes();
				break;
			case "Metamorphose": carte = new CarteMageMetamorphose();
				break;
			case "Champion frisselame": carte = new CartePalaChampionFrisselame();
				carte = new EffetCharge((Serviteur) carte);
				carte = new EffetVolDeVie((Serviteur) carte);
				break;
			case "Benediction de puissance": carte = new CartePalaBenedictionDePuissance();
				break;
			case "Consecration": carte = new CartePalaConsecration();
				break;
			case "Tourbillon": carte = new CarteGuerrierTourbillon();
				break;
			case "Avocat commis d'office": carte = new CarteGuerrierAvocatCommisDoffice();
				carte = new EffetProvoc((Serviteur) carte);
				break;
			case "Maitrise du blocage": carte = new CarteGuerrierMaitriseDuBlocage();
				break;
			case "Recrue de la Main d'argent": carte = new RecrueMainArgent();
				break;
		}
		return carte;
		
	}

}
