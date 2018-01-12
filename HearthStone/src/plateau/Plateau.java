package plateau;

import java.util.ArrayList;

import carte.Serviteur;
import partie.Joueur;

public class Plateau implements Observer {
	private ArrayList<Serviteur> serviteursJ1;
	private ArrayList<Serviteur> serviteursJ2;
	private Joueur j1;
	private Joueur j2;
	
	
	public void monstreAttaqueMonstre(Serviteur c1, Serviteur c2){
			c2.ajoutDefense(c1.getAttaque());
			c1.ajoutDefense(c2.getAttaque());
	}
	
	public void sortAttaqueMonstre(int degat, Serviteur c2){
		c2.ajoutDefense(-degat);
	}
	
	public void SoinMonstre(int degat, Serviteur c2){
		this.sortAttaqueMonstre(-degat, c2);
	}
	
	public void invoquerServiteur(Serviteur s1, boolean isJ1){
		this.readEffet(s1);
		//TODO
		
	}
	
	/**
	 * se lance à la création du 
	 */
	private void readEffet(Serviteur s1){
		//TODO
	}

	@Override
	public void actualiser(Observable o) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Serviteur> getServiteursJ1() {
		return this.serviteursJ1;
	}

	public ArrayList<Serviteur> getServiteursJ2() {
		return this.serviteursJ2;
	}

}
