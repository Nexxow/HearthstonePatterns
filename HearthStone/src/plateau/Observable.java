package plateau;

public interface Observable {

	public void enregistrerObs(Observer ob);
	
	public void supprimerObs(Observer ob);
	
	public void notifierObs();
}
