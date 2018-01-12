package decoratorCarte;

import carte.Carte;

public class EffetVolDeVie extends DecoratorEffet {

	public EffetVolDeVie(Carte carte) {
		this.description = "Effet Vol de vie : Lorsque le serviteur inflige des d�g�ts, votre h�ros r�cup�re des points de vie" + 
				"� la hauteur des d�g�ts inflig�s";
		this.carte = carte;
		this.carte.getListEffets().add(this);
	}
	
}
