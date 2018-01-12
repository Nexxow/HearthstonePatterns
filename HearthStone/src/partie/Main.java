package partie;

import java.util.Scanner;

import heros.Heros;

public class Main {

	public static void main(String[] args) {
		
		
		Joueur j1 = new Joueur();
		Joueur j2 = new Joueur();
		
		System.out.println("J1 : Choisissez votre heros parmis 3 classes : Mage, Guerrier, Paladin /n"
				+ "ecrivez exactement le nom de la classe choisie");
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		Heros heros = new Heros(line);
		j1.setHeros(heros);
		System.out.println("Heros selectionne : " + j1.getHeros().getType());
		
		System.out.println("J2 : Choisissez votre heros parmis 3 classes : Mage, Guerrier, Paladin /n"
				+ "ecrivez exactement le nom de la classe choisie");
		
		line = sc.nextLine();
		
		Heros heros2 = new Heros(line);
		j2.setHeros(heros2);
		System.out.println("Heros selectionne : " + j2.getHeros().getType());
		
		Jeu jeu = new Jeu(j1, j2);
		jeu.lancerPartie();
		

	}

}
