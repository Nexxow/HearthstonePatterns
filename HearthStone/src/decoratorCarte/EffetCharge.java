package decoratorCarte;

import carte.Carte;

public class EffetCharge extends DecoratorEffet {

	public EffetCharge(Carte carte) {
		this.description = "Effet charge : : le serviteur peut attaquer d�s qu�il est pos� sur le plateau, sans attendre le tour \r\n" + 
				"suivant.";
		this.carte = carte;
		this.carte.getListEffets().add(this);
	}
	
}
