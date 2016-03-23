package test;

	import java.text.ParseException;

import packchimique.AtomeDejaAjouterException;
import packchimique.AtomeInexistantException;
import packchimique.GestionDonne;

	//Nous effectuons le test d'affichage du tableau et de la couche electronique d'un atome
	public class  TestAffichageAtome {


		public static void main(String[] args) throws AtomeDejaAjouterException,AtomeInexistantException, ParseException {
			
			GestionDonne tableElementChimique = new GestionDonne();
		
			System.out.println("\n### Affichage de la couche electronique d'un atome avec la règle de Pauli ###");
			tableElementChimique.coucheElectronique("Xe");
			
			System.out.println("\n###Lecture du tableau périodique des éléments ###\n");
			System.out.println(tableElementChimique.toString());
			
		}
		 
		
			

		}
	