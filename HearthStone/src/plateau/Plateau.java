package plateau;

import java.util.ArrayList;

import carte.Serviteur;
import partie.Joueur;

public class Plateau implements Observer {
	private ArrayList<Serviteur> serviteursJ1;
	private ArrayList<Serviteur> serviteursJ2;
	private Joueur j1;
	private Joueur j2;
	
	
	public void monstreAttaqueMonstre(Serviteur c1, Serviteur c2, boolean isJ1){
		
		c2.ajoutDefense(c1.getAttaque());
		if (this.asVolDeVie(c1)){
			this.effetVolDeVie(c1, isJ1);	
		}
		
		c1.ajoutDefense(c2.getAttaque());
		if (this.asVolDeVie(c2)){
			this.effetVolDeVie(c2, !isJ1);	
		}
		
		// Destruction des cartes si elles sont mortes
		this.isCarteMorte(c1, isJ1);
		this.isCarteMorte(c2, !isJ1);
	
	}
	
	private void effetVolDeVie(Serviteur c1, boolean isJ1) {
		if (isJ1) j1.addPV(c1.getAttaque()) ; 
		else j2.addPV(c1.getAttaque());
		
	}

	private void isCarteMorte(Serviteur c1, boolean isJ1) {
		if (c1.getDefense()<=0){	
			if (isJ1){
				for (int i = 0; i < serviteursJ1.size(); i++) {
					if(serviteursJ1.get(i)==c1) serviteursJ1.remove(i);
				}
			}else{
				for (int i = 0; i < serviteursJ2.size(); i++) {
					if(serviteursJ2.get(i)==c1) serviteursJ2.remove(i);
				}
			}
		}	
	}

	public void sortAttaqueMonstre(int degat, Serviteur c2){
		c2.ajoutDefense(-degat);
	}
	
	public void SoinMonstre(int degat, Serviteur c2){
		this.sortAttaqueMonstre(-degat, c2);
	}
	
	public void invoquerServiteur(Serviteur s1, boolean isJ1){
		s1.etat.invoquer();
		s1 = this.effetCharge(s1);
		if (isJ1) this.serviteursJ1.add(s1);
		else this.serviteursJ2.add(s1);
		
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

	public ArrayList<Serviteur> getServiteursJ1() {
		return this.serviteursJ1;
	}

	public ArrayList<Serviteur> getServiteursJ2() {
		return this.serviteursJ2;
	}

}
