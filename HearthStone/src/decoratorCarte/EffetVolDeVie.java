package decoratorCarte;

import carte.Serviteur;

public class EffetVolDeVie extends DecoratorEffet {

	public EffetVolDeVie(Serviteur serv) {
		this.description = "Effet Vol de vie : Lorsque le serviteur inflige des degats, votre heros recupere des points de vie" + 
				"a  la hauteur des degats infliges";
		this.serv = serv;
		this.serv.getListEffets().add("serv");
		this.serv.ajoutDescription(this.description);
	}
	
}
