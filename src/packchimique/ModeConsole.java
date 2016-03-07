package packchimique;
	import java.text.ParseException;

	public class  ModeConsole {


		public static void main(String[] args) throws AtomeDejaAjouterException,AtomeInexistantException, ParseException {
			
			GestionDonne tableElementChimique = new GestionDonne();
		/*	System.out.println("\n### La Recherche Par Symbole: \"Ar\" ###\n");
			tableElementChimique.gestionParSymbole("Ar");
		*/	
			System.out.println("\n### Affichage de la couche electronique d'un atome avec la règle de Pauli ###");
			tableElementChimique.coucheElectronique("Xe");
		//	}
			/*
			System.out.println("\n###Lecture du tableau périodique des éléments ###\n");
			
			
			System.out.println(tableElementChimique.toString());
			
			
		
			System.out.println("\n###La Recherche par Famille: Gaz Noble ###\n");
			tableElementChimique.gestionParFamille("Gaz noble");
			
			
			System.out.println("\n###La Recherche Par Période: Saisir une période ###\n");
			tableElementChimique.gestionParPeriode(1);
	
			System.out.println("\n### La Recherche par Colonne: Saisir une colonne ###\n");
			tableElementChimique.gestionParColonne(2);
		
			
			System.out.println("\n### Calcul du Nombre d'Electrons d'un atome:  ###\n");
			tableElementChimique.calculElectron("C");
			
			System.out.println("\n### Calcul du Nombre de protons d'un atome:  ###\n");
			tableElementChimique.calculElectron("Xe");
			
			System.out.println("\n### Le nombre de Neutrons d'un atome:###\n");
			tableElementChimique.calculNeutron("Fe");
			*/
			
			
			 
		
			

		}
	}
