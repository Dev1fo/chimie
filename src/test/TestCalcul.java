package test;
	import java.text.ParseException;

import packchimique.AtomeDejaAjouterException;
import packchimique.AtomeInexistantException;
import packchimique.GestionDonne;

	public class  TestCalcul {

		// Nous effectuons les diffrents test de calcul, electrons protons et neutrons
		public static void main(String[] args) throws AtomeDejaAjouterException,AtomeInexistantException, ParseException {
			
			GestionDonne tableElementChimique = new GestionDonne();
		
			System.out.println("\n### Calcul du Nombre d'Electrons d'un atome:  ###\n");
			tableElementChimique.calculElectron("C");
			
			System.out.println("\n### Calcul du Nombre de protons d'un atome:  ###\n");
			tableElementChimique.calculElectron("Xe");
			
			System.out.println("\n### Le nombre de Neutrons d'un atome:###\n");
			tableElementChimique.calculNeutron("Fe");
		
		}
	}
