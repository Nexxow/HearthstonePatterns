package plateau;

import java.util.ArrayList;

import carte.Serviteur;
import partie.Joueur;

public class Plateau implements Observer {
	private ArrayList<Serviteur> serviteursJ1;
	private ArrayList<Serviteur> serviteursJ2;
	private Joueur j1;
	private Joueur j2;
	
	public Plateau(Joueur j1, Joueur j2) {
		this.j1 = j1;
		this.j2 = j2;
		this.serviteursJ1=new ArrayList<Serviteur>();
		this.serviteursJ2=new ArrayList<Serviteur>();
	}
	
	public Joueur getJoueur(boolean isJ1){
		return (isJ1) ? this.j1 : this.j2;
	}
	
	public ArrayList<Serviteur> getServiteurJoueur(boolean isJ1){
		return (isJ1) ? this.serviteursJ1 : this.serviteursJ2;
	}
	
	public void monstreAttaqueMonstre(int attaquant, int defenseur, boolean isJ1){
		this.getServiteurJoueur(!isJ1).get(defenseur).ajoutDefense(-this.getServiteurJoueur(isJ1).get(attaquant).getAttaque());
		if (this.asVolDeVie(this.getServiteurJoueur(isJ1).get(attaquant))){
			this.effetVolDeVie(attaquant, isJ1);	
		}
		
		this.getServiteurJoueur(isJ1).get(attaquant).ajoutDefense(-this.getServiteurJoueur(!isJ1).get(defenseur).getAttaque());
		if (this.asVolDeVie(this.getServiteurJoueur(!isJ1).get(defenseur))){
			this.effetVolDeVie(defenseur, !isJ1);	
		}
		
		// Destruction des cartes si elles sont mortes
		this.isCarteMorte(attaquant, isJ1);
		this.isCarteMorte(defenseur, !isJ1);
	
	}
	
	private void effetVolDeVie(int attaquant, boolean isJ1) {
		this.getJoueur(isJ1).attaquePV(-this.getServiteurJoueur(isJ1).get(attaquant).getAttaque()) ; 
		
	}
	
	public void boostAttaque(int nb, int serviteur, boolean isJ1){
		this.getServiteurJoueur(isJ1).get(serviteur).ajoutAttaque(nb);
	}

	private void isCarteMorte(int serviteur, boolean isJ1) {
		if (this.getServiteurJoueur(isJ1).get(serviteur).getDefense()<=0)
			this.getServiteurJoueur(isJ1).remove(serviteur);
	}

	public void attaquerJoueur(int degat, boolean isJ1){
		this.getJoueur(!isJ1).attaquePV(degat);
	}
	
	public void sortAttaqueMonstre(int degat, int defenseur, boolean isJ1){
		this.getServiteurJoueur(!isJ1).get(defenseur).ajoutDefense(-degat);
		this.isCarteMorte(defenseur, !isJ1);
	}
	
	public void SoinMonstre(int valeur, int defenseur, boolean isJ1){
		this.sortAttaqueMonstre(-valeur, defenseur, isJ1);
	}
	
	public void invoquerServiteur(Serviteur s1, boolean isJ1){
		s1.etat.invoquer();
		s1 = this.effetCharge(s1);
		this.getServiteurJoueur(isJ1).add(s1);
	}
	
	/**
	 * si le serviteur dispose de l'effet charge, il peut jouer dès son invocation
	 * @param s1 , le serviteur en paramètre
	 * @return
	 */
	private Serviteur effetCharge(Serviteur s1){
		ArrayList<String> effets = s1.getListEffets();
		for (String string : effets) {
			if (string.contains("effet charge")) s1.etat.autoriserJeu();
		}
		return s1;
	}
	
	/**
	 * 
	 * @param isJ1 
	 * @return les serviteurs avec l'effet Taunt de l'adversaire. Sinon, Null.
	 */
	public ArrayList<Serviteur> getEffetTaunt(boolean isJ1){
		ArrayList<Serviteur> serviteurs = null;
		for (Serviteur s1 : (!isJ1) ? serviteursJ1 : serviteursJ2) {
			ArrayList<String> effets = s1.getListEffets();
			for (String string : effets) {
				if (string.contains("effet provoc")) serviteurs.add(s1);
			}
		}
		return serviteurs;
	}
	
	private boolean asVolDeVie(Serviteur s1){
		for (String string : s1.getListEffets()) {
			if (string.contains("effet vol de vie"))return true;
		}
		return false;
	}
	
	@Override
	public void actualiser(Observable o) {
		this.toString();
		//TODO
	}

}
