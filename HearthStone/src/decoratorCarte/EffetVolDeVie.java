package decoratorCarte;

import carte.Serviteur;

public class EffetVolDeVie extends DecoratorEffet {

	public EffetVolDeVie(Serviteur serv) {
		this.description = "Effet Vol de vie : Lorsque le serviteur inflige des dégats, votre héros récupère des points de vie" + 
				"à la hauteur des dégats infligés";
		this.serv = serv;
		this.serv.getListEffets().add("serv");
		this.serv.ajoutDescription(this.description);
	}
	
}
