package packchimique;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.lang.Math;

public class GestionDonne {
	public ArrayList<Atome> atomes = new ArrayList<Atome>();
	
	public GestionDonne() throws ParseException, AtomeDejaAjouterException {
		String line, fields[];
		try {
			BufferedReader reader = new BufferedReader(new FileReader("ressource/tableauchimique.csv"));
			while ((line = reader.readLine()) != null) {
				fields = line.split(";");
				int numeroAtomique = Integer.parseInt(fields[3]);
				int nombreLiaison = Integer.parseInt(fields[7]);
				NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
			    Number number = format.parse(fields[4]);	    
			    double masseAtomique = number.doubleValue();
				int periode = Integer.parseInt(fields[5]);
				int colonne = Integer.parseInt(fields[6]);	
				Atome atome = new Atome(fields[0],fields[1], fields[2], numeroAtomique, masseAtomique, periode, colonne,nombreLiaison);
				add(atome);
			}
			reader.close();
			System.out.println("### Lecture de la base de donnee s'est bien terminer ###");
		}
		catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public void gestionParPeriode(int periode) { 
		boolean trouve = false; 
		Iterator<Atome> iterator = atomes.iterator(); 
		while (iterator.hasNext()) { 
			Atome atome = iterator.next(); 
			if (atome.getPeriode() == periode) { 
				System.out.println(atome.toString()); 
				trouve = true; 
			} 
		} 
		if (trouve == false) System.out.println("Aucun atome n'a été trouvé"); 
	}

	public int gestionParPeriode(String nom) {  
		Iterator<Atome> iterator = atomes.iterator(); 
		while (iterator.hasNext()) { 
			Atome atome = iterator.next(); 
			if (atome.getNom().equals(nom)|| atome.getSymbole().equals(nom)) {  
				return atome.getPeriode();
			} 
		} 
		return -1;
	}
	
	public void gestionParSymbole(String symbole) { 
		boolean trouve = false; 
		Iterator<Atome> iterator = atomes.iterator(); 
		while (iterator.hasNext()) { 
			Atome atome = iterator.next(); 
			if (atome.getSymbole().equals(symbole)) { 
				System.out.println(atome.toString()); 
				trouve = true; 
			} 
		} 
		if (trouve == false) System.out.println("Aucun atome n'a été trouvé"); 
	}
	
	public void gestionParColonne(int colonne) { 
		boolean trouve = false; 
		Iterator<Atome> iterator = atomes.iterator(); 
		while (iterator.hasNext()) { 
			Atome atome = iterator.next(); 
			if (atome.getColonne() == colonne) { 
				System.out.println(atome.toString()); 
				trouve = true; 
			} 
		} 
		if (trouve == false) System.out.println("Aucun atome n'a été trouvé"); 
	}
	
	public void gestionParFamille(String famille) { 
		boolean trouve = false; 
		Iterator<Atome> iterator = atomes.iterator(); 
		while (iterator.hasNext()) { 
			Atome atome = iterator.next(); 
			if (atome.getFamille().equals(famille)) { 
				System.out.println(atome.toString()); 
				trouve = true; 
			} 
		} 
		if (trouve == false) System.out.println("Aucun atome n'a été trouvé"); 
	}
	
	public int getCurrentAtomCount() {
		return atomes.size();
	}
	
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i <= atomes.size() - 1; i++) {
			result += atomes.get(i).toString() + "\n";
		}
		return result;
	}
	// Ajout en fin liste
	public void add(Atome atome) throws AtomeDejaAjouterException {
		if (!atomes.contains(atome)) {
			atomes.add(atome);
		}
		else {
			throw new AtomeDejaAjouterException(atome.getNom());
		}
	}
	
	// Calcul du nombre d'electrons ou de proton, et Z: est le nombre d'electrons
	
	public void calculElectron(String nom) {
		
		boolean trouve = false;
		Iterator<Atome> iterator = atomes.iterator();
		while (iterator.hasNext()) {
			Atome atome = iterator.next();
			if (atome.getNom().equals(nom) || atome.getSymbole().equals(nom)) {
				System.out.println("Le [" + atome.getNom() + "]: " + atome.getNumAtomiqueZ() + " electron(s).");
				trouve = true;
			}
		}
		if (trouve == false) System.out.println("["+nom+"] n'existe pas dans la classification periodique\n Veuillez saisir un nom d'atome correcte"); 
	}
	
public void calculProton (String nom) {
		
		boolean trouve = false;
		Iterator<Atome> iterator = atomes.iterator();
		while (iterator.hasNext()) {
			Atome atome = iterator.next();
			if (atome.getNom().equals(nom) || atome.getSymbole().equals(nom)) {
				System.out.println("Le [" + atome.getNom() + "]: " + atome.getNumAtomiqueZ() + " proton(s).");
				trouve = true;
			}
		}
		if (trouve == false) System.out.println("["+nom+"] n'existe pas dans la classification periodique\n Veuillez saisir un nom d'atome correcte"); 
	}
	
	// Calcul du nombre de Neutrons :// N= A-Z

	public void calculNeutron(String nom) {
		boolean trouve = false;
		Iterator<Atome> iterator = atomes.iterator();
		while (iterator.hasNext()) {
			Atome atome = iterator.next();
			if (atome.getNom().equals(nom) || atome.getSymbole().equals(nom)) {
				
				int nbrProton = atome.getNumAtomiqueZ();
				int nbrMasse = (int) Math.round(atome.getMasseAtomique());
				int result = nbrMasse - nbrProton;
				System.out.println("Le [" + atome.getNom() + "]: " + result + " neutron(s).");
				trouve = true;
			}
		}
		if (trouve == false) System.out.println("["+nom+"] n'existe pas dans la classification periodique\n Veuillez saisir un nom d'atome correcte"); 
	}
	// Couche KLMNOP avec les periode
	public void coucheElectronique(String nom){
		String couche;
		
				switch (gestionParPeriode(nom)){
				
				case 1: couche="La couche electronique du ["+nom+"] est: [K]";break;
				case 2:	couche="La couche electronique du ["+nom+"] est: [K L]";break;
				case 3:	couche="La couche electronique du ["+nom+"] est: [K L M]";break;
				case 4:	couche="La couche electronique du ["+nom+"] est: [K L M N]";break;
				case 5:	couche="La couche electronique du ["+nom+"] est: [K L M N O]";break;
				case 6:	couche="La couche electronique du ["+nom+"] est: [K L M N O P]";break;
				case 7:	couche="La couche electronique du ["+nom+"] est: [K L M N O P Q]";break;
				default: couche="Invalide atome["+nom+"] n'existe pas dans la classification periodique\n Veuillez saisir un nom d'atome correcte";
		        break;
				}
				 System.out.println(couche);
			}
}
