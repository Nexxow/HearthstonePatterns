package pioche;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import carte.Carte;
import carte.CarteChefDeRaid;
import carte.CarteChevaucheurDeLoup;
import carte.CarteGuerrierAvocasCommisDoffice;
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
import carte.Serviteur;
import decoratorCarte.EffetCharge;
import decoratorCarte.EffetChefDeRaid;
import decoratorCarte.EffetProvoc;
import decoratorCarte.EffetVolDeVie;

public class Pioche extends FactoryCarte {

	public Carte piocher(String type){
		
		ArrayList<String> listStringCartes = new ArrayList<>(Arrays.asList("Sanglier brocheroc", "Soldat du comté-de-l'or", "Chevaucheur de loup",
				"Chef de raid", "Yéti noroit" ));
		
		switch(type) {
			case "Mage": listStringCartes.add("Image miroir");
				listStringCartes.add("Explosion des arcanes");
				listStringCartes.add("Métamorphose");
			case "Paladin": listStringCartes.add("Champion frisselame");
				listStringCartes.add("Bénédiction de puissance");
				listStringCartes.add("Consécration");
			case "Guerrier": listStringCartes.add("Tourbillon");
				listStringCartes.add("Avocat commis d'office");
				listStringCartes.add("Maîtrise du blocage");
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
			case "Soldat du comté-de-l'or": carte = new CarteSoldatComteOr();
				carte = new EffetProvoc((Serviteur) carte);
			case "Chevaucheur de loup": carte = new CarteChevaucheurDeLoup();
				carte = new EffetCharge((Serviteur) carte);
			case "Chef de raid": carte = new CarteChefDeRaid();
				carte = new EffetChefDeRaid((Serviteur) carte);
			case "Yéti noroit": carte = new CarteYetiNoroit();
			case "Image miroir": carte = new CarteMageImageMiroir();
			case "Explosion des arcanes": carte = new CarteMageExplosionDesArcanes();
			case "Métamorphose": carte = new CarteMageMetamorphose();
			case "Champion frisselame": carte = new CartePalaChampionFrisselame();
				carte = new EffetCharge((Serviteur) carte);
				carte = new EffetVolDeVie((Serviteur) carte);
			case "Bénédiction de puissance": carte = new CartePalaBenedictionDePuissance();
			case "Consécration": carte = new CartePalaConsecration();
			case "Tourbillon": carte = new CarteGuerrierTourbillon();
			case "Avocat commis d'office": carte = new CarteGuerrierAvocasCommisDoffice();
				carte = new EffetProvoc((Serviteur) carte);
			case "Maîtrise du blocage": carte = new CarteGuerrierMaitriseDuBlocage();
		}
		return carte;
		
	}

}
