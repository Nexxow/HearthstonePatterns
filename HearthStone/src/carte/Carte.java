package carte;

import java.util.ArrayList;

import plateau.Observable;
import plateau.Observer;
import etatCarte.EtatCarte;

public abstract class Carte implements Observable {
	public EtatCarte etat;
	private ArrayList<Observer> obs;
	
	public void jouer() { this.etat.jouer(); }
	
	public void invoquer() { this.etat.invoquer(); }

	public void detruire() { this.etat.detruire(); }

	
	public void enregistrerObs(Observer ob){ this.obs.add(ob); }
	
	public void notifierObs(){
		for (Observer observer : obs) {
			observer.actualiser();
		}
	}
}
