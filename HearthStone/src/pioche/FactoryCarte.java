package pioche;

import carte.Carte;

public abstract class FactoryCarte {

	public Carte creerCarte(String nom) {
		Carte carte = this.fabriquerCarte(nom);
		return carte;
	}
	
	public abstract Carte fabriquerCarte(String nom);
}
