package carte;

import pioche.Pioche;
import plateau.Plateau;

public class CarteMageImageMiroir extends Sort {
	
	public CarteMageImageMiroir() {
		this.nom = "Image Miroir";
		this.coutMana = 1;
		this.description = "Invoque 2 serviteurs 0/2 avec provocation";
	}

	@Override
	public void activer(boolean isJ1, Plateau plateau) {
		Pioche pioche = new Pioche();
		Serviteur s1 = (Serviteur) pioche.creerCarte("Image miroir2");
		plateau.invoquerServiteur(s1, isJ1);
		plateau.invoquerServiteur(s1, isJ1);
		
		
	}
	
}
