package decoratorCarte;

import carte.Serviteur;

public class EffetCharge extends DecoratorEffet {

	public EffetCharge(Serviteur serv) {
		this.description = "Effet charge : : le serviteur peut attaquer dès qu'il est posé sur le plateau, sans attendre le tour \r\n" + 
				"suivant.";
		this.serv = serv;
		this.serv.getListEffets().add("charge");
	}
	
}
