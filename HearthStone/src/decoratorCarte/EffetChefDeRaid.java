package decoratorCarte;

import carte.Carte;

public class EffetChefDeRaid extends DecoratorEffet {

	public EffetChefDeRaid(Carte carte) {
		this.description = "Effet Chef de Raid : +1 d’attaque pour tous les serviteurs alliés du plateau (tant que ce\r\n" + 
				"serviteur est vivant)";
		this.carte = carte;
		this.carte.getListEffets().add(this);
	}
	
}
