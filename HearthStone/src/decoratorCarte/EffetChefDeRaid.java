package decoratorCarte;

import carte.Serviteur;

public class EffetChefDeRaid extends DecoratorEffet {

	public EffetChefDeRaid(Serviteur serv) {
		this.description = "Effet Chef de Raid : +1 d'attaque pour tous les serviteurs alliés du plateau (tant que ce\r\n" + 
				"serviteur est vivant)";
		this.serv = serv;
		this.serv.getListEffets().add("Chef");
	}
	
}
