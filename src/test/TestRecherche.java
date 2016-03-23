package test;
	import java.text.ParseException;

import packchimique.AtomeDejaAjouterException;
import packchimique.AtomeInexistantException;
import packchimique.GestionDonne;

	// Nous effectuons les tests des differents recherches: Famille, Periode,Colonne
	public class  TestRecherche {
		
		public static void main(String[] args) throws AtomeDejaAjouterException,AtomeInexistantException, ParseException {
			
			GestionDonne tableElementChimique = new GestionDonne();
			System.out.println("\n###La Recherche par Famille: Gaz Noble ###\n");
			tableElementChimique.gestionParFamille("Gaz noble");
			
			
			System.out.println("\n###La Recherche Par Période: Saisir une période ###\n");
			tableElementChimique.gestionParPeriode(1);
	
			System.out.println("\n### La Recherche par Colonne: Saisir une colonne ###\n");
			tableElementChimique.gestionParColonne(2);
		
		}
	}
