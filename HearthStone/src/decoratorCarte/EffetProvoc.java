package decoratorCarte;

import carte.Carte;

public class EffetProvoc extends DecoratorEffet {

	public EffetProvoc(Carte carte) {
		this.description = "Effet Provocation : votre adversaire est oblig´e d’attaquer ce serviteur avant d’attaquer votre h´eros\r\n" + 
				"ou un autre serviteur sans provocation";
		this.carte = carte;
		this.carte.getListEffets().add(this);
	}
	
}
