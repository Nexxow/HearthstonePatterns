package carte;

import java.util.ArrayList;

import plateau.Observable;
import plateau.Observer;

public class Serviteur extends Carte implements Observable {

	protected int attaque;
	protected int defense;
	
	private ArrayList<Observer> obs;
	
	public void enregistrerObs(Observer ob){ this.obs.add(ob); }
	
	public void supprimerObs(Observer ob){ this.obs.remove(ob); }
	
	public void notifierObs(){
		for (Observer observer : obs) {
			observer.actualiser(this);
		}
	}
	
	public void AjoutDefense(int i){
		this.defense += i;
		this.notifierObs();
	}
	
	public void AjoutAttaque(int i){
		this.attaque += i;
		this.notifierObs();
	}

	public int getAttaque() {
		return attaque;
	}

	public int getDefense() {
		return defense;
	}
	
}
