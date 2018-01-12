package decoratorCarte;

import carte.Serviteur;

public class EffetProvoc extends DecoratorEffet {

	public EffetProvoc(Serviteur serv) {
		this.description = "Effet Provocation : votre adversaire est oblige d'attaquer ce serviteur avant d'attaquer votre heros\r\n" + 
				"ou un autre serviteur sans provocation";
		this.serv = serv;
		this.serv.getListEffets().add("provocation");
		this.serv.ajoutDescription(this.description);
	}
	
}
