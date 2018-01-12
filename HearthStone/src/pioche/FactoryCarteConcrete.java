package pioche;

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

public class FactoryCarteConcrete extends FactoryCarte {

	@Override
	public Carte fabriquerCarte(String nom) {
		Carte carte = null;
		switch(nom) {
			case "Sanglier brocheroc": carte = new CarteSanglierBrocheroc();
			case "Soldat du comt�-de-l'or": carte = new CarteSoldatComteOr();
			case "Chevaucheur de loup": carte = new CarteChevaucheurDeLoup();
			case "Chef de raid": carte = new CarteChefDeRaid();
			case "Y�ti noroit": carte = new CarteYetiNoroit();
			case "Image miroir": carte = new CarteMageImageMiroir();
			case "Explosion des arcanes": carte = new CarteMageExplosionDesArcanes();
			case "M�tamorphose": carte = new CarteMageMetamorphose();
			case "Champion frisselame": carte = new CartePalaChampionFrisselame();
			case "B�n�diction de puissance": carte = new CartePalaBenedictionDePuissance();
			case "Cons�cration": carte = new CartePalaConsecration();
			case "Tourbillon": carte = new CarteGuerrierTourbillon();
			case "Avocat commis d'office": carte = new CarteGuerrierAvocasCommisDoffice();
			case "Ma�trise du blocage": carte = new CarteGuerrierMaitriseDuBlocage();
		}
		return carte;
		
	}

}
