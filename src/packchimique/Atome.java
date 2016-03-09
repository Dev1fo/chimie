package packchimique;

public class Atome {
	// Declaration des attributs: 
	private String nom;
	private String symbole;
	private String famille;
	private int periode;
	private int col;
	private int numAtomiqueZ;
	private double masseMolaire;
	private int nbrLiaison;
	
	public Atome(String nom, String symbole, String famille, int numAtomiqueZ, double masseMolaire, int periode, int col,int nbrLiaison) {
		
		this.nom = nom;
		this.symbole = symbole;
		this.famille = famille;
		this.numAtomiqueZ = numAtomiqueZ;
		this.masseMolaire = masseMolaire;
		this.periode = periode;
		this.col = col;
		this.nbrLiaison=nbrLiaison ;
	}
	
	public int getNbrLiaison() {
		return nbrLiaison;
	}

	
	public String getNom() {
		return nom;
	}
	
	public String getSymbole() {
		return symbole;
	}
	
	public String getFamille() {
		return famille;
	}
	
	public int getNumAtomiqueZ() {
		return numAtomiqueZ;
	}
	
	public double getmasseMolaire() {
		return masseMolaire;
	}
	
	public int getPeriode() {
		return periode;
	}
	
	public int getColonne() {
		return col;
	}
	
	public String chargeIonique(){
		
		switch (col){
		
		case 1: return symbole + "<sup>[+]</sup>";
		// Ions négatif colonne : 15, 16,17 : Anions
		case 15: return symbole + "<sup>[" + nbrLiaison + "-]</sup>";
		case 16: return symbole + "<sup>[" + nbrLiaison + "-]</sup>";
		case 17:return symbole + "<sup>[-]</sup>";
		// Pas d'ions pour les gaz nobles
		case 18:return famille;
		//Colonne 2 a 14 : Cations
		default:return symbole + "<sup>[" + nbrLiaison + "+]</sup>";
		}
		
	}

	public String coucheExterne(){
		
		
		switch (periode){
		
			case 1: return "[K]";
			case 2:	return "[K L]";
			case 3:	return "[K L M]";
			case 4:	return "[K L M N]";
			case 5:	return "[K L M N O]";
			case 6: return "[K L M N O P]";
			default:return "[K L M N O P Q]";
		}
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atome other = (Atome) obj;
		if (col != other.col)
			return false;
		if (famille == null) {
			if (other.famille != null)
				return false;
		} else if (!famille.equals(other.famille))
			return false;
		if (Double.doubleToLongBits(masseMolaire) != Double
				.doubleToLongBits(other.masseMolaire))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numAtomiqueZ != other.numAtomiqueZ)
			return false;
		if (periode != other.periode)
			return false;
		if (symbole == null) {
			if (other.symbole != null)
				return false;
		} else if (!symbole.equals(other.symbole))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nom Atome:[" + nom + "]|Symbole chimique:[" + symbole + "]|Famille:["
				+ famille + "]|Numero Atomique:"
				+ numAtomiqueZ + "|Masse Atomique:" + masseMolaire
				+ "|Periode:" + periode + "|Col:" + col +"|NbrLiaison:"+nbrLiaison+"";
	}


}