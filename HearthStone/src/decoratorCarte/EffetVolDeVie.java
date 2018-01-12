package decoratorCarte;

import carte.Carte;

public class EffetVolDeVie extends DecoratorEffet {

	public EffetVolDeVie(Carte carte) {
		this.description = "Effet Vol de vie : Lorsque le serviteur inflige des dégâts, votre héros récupère des points de vie" + 
				"à la hauteur des dégâts infligés";
		this.carte = carte;
		this.carte.getListEffets().add(this);
	}
	
}
