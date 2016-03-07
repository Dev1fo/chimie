package packchimique;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FenetreChimie extends JFrame implements ActionListener{
	// Cela sert à la JVM pour identifier les objets lorsqu'il les sérialise/désérialise
	private static final long serialVersionUID = 1L;
	// Declaration des couleurs:
	Color hotPink=new Color(255,112,164);
	Color lightgreen=new Color(119,221,136);
	Color turquoise=new Color(87,247,247);
	Color lightskyblue=new Color(133,206,250);
	Color darkTurquoise=new Color(0,204,204);
	Color burlywood=new Color(222,184,135);
	Color thisle=new Color(216,191,216);
	Color blue_violet=new Color(138,43,226);
	Color violet=new Color(148,2,211);
	Color marron=new Color(115,61,26);
	Color violet_red=new Color(208,32,144);
	Color forest_green=new Color(34,139,34);
	private GestionDonne tableChimique;
	
	private JLabel titreLabel;
	private JLabel titre2Label; 
	private JLabel symboleLabel;
	private JLabel numeroAtomiqueLabel;
	private JLabel nomLabel;
	private JLabel nbrLiaisonLabel;
	private JLabel masseMolaireLabel;
	private JLabel periodeLabel;
	private JLabel colonneLabel;
	private JLabel familleLabel;
	private JLabel ionLabel = new JLabel();
	private JLabel coucheElectroniqueLabel = new JLabel();
	// Ajout des boutons
	private JButton atomeBouton; // Bouton correspondant à l'atome
	private JButton couleurFamilleBouton; // Bouton correspondant à la couleur de la famille
	
	private JPanel panneauTitre = new JPanel(); // Titre
	private JPanel panneauTablePeriodique = new JPanel(); // Tableau périodique
	private JPanel panneauLegende = new JPanel(); // Code couleur des familles
	private JPanel panneau4 = new JPanel();
	

	public FenetreChimie() throws ParseException, AtomeDejaAjouterException {
	
		setTitle("Tableau Périodique De Mendeleiev");
		setResizable(true);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setSize(this.getToolkit().getScreenSize());
		
		// panneauTitre: le titre
		titreLabel = new JLabel("Periodic Table of Elements");
		titreLabel.setFont(new Font ("Consolas", Font.BOLD, 40));
		titreLabel.setForeground(Color.white);
		panneauTitre.add(titreLabel);
		panneauTitre.setBackground(blue_violet);
		panneauTitre.setSize(580, 50);
		panneauTitre.setLocation(320, 0);
		// panneauTablePeriodique: Panneau fenetre
		panneauTablePeriodique.setLayout(new GridLayout(7,18)); 
		panneauTablePeriodique.setLayout(null);
		panneauTablePeriodique.setSize(1400,900);
		panneauTablePeriodique.setBackground(Color.black);
		
		//panneauLegende: la légende, GridLayout précise le nombre de lignes et colonnes
		panneauLegende.setLayout(new GridLayout(10,2));
		panneauLegende.setLayout(null);
		panneauLegende.setSize(210,200);
		panneauLegende.setLocation(10,450);
		panneauLegende.setBackground(Color.black);
		
		panneau4.setLayout(new GridLayout(3,1));
		panneau4.setLayout(null);
		panneau4.setSize(1400,900);
				
		tableChimique = new GestionDonne();
		int a= 1;
		int b= 1;
		
		for (int i=0; i<tableChimique.getCurrentAtomCount(); i++){
			// Création de boutons pour chaque atome en récupérant le symbole de l'atome
			atomeBouton = new JButton(tableChimique.atomes.get(i).getSymbole()); 
			atomeBouton.setSize(55,55);
			atomeBouton.setLocation(tableChimique.atomes.get(i).getColonne()*55,tableChimique.atomes.get(i).getPeriode()*55);
			panneauTablePeriodique.add (atomeBouton); // On ajoute chaque atome à un panneau
			
			atomeBouton.setToolTipText(tableChimique.atomes.get(i).getNom()); // On précise le nom de l'atome quand la souris passe dessus
			atomeBouton.addActionListener(this);
			if (tableChimique.atomes.get(i).getFamille().equals("Lanthanide") && !tableChimique.atomes.get(i).getNom().equals("Lanthane")){
				atomeBouton.setLocation((tableChimique.atomes.get(i).getColonne()+a)*55,(tableChimique.atomes.get(i).getPeriode()+3)*55);
				a++;
			}
			
			if (tableChimique.atomes.get(i).getFamille().equals("Actinide") && !tableChimique.atomes.get(i).getNom().equals("Actinium")){
				atomeBouton.setLocation((tableChimique.atomes.get(i).getColonne()+b)*55,(tableChimique.atomes.get(i).getPeriode()+3)*55);
				b++;
			}
			// On défini une couleur pour chaque type de famille
			if(tableChimique.atomes.get(i).getFamille().equals("Non-métaux")){
				atomeBouton.setBackground(Color.GREEN);
				atomeBouton.setFont(new Font ("Consolas",Font.BOLD,15));
				atomeBouton.setForeground(Color.white);
			}
			else if(tableChimique.atomes.get(i).getFamille().equals("Gaz noble")){
				atomeBouton.setBackground(Color.blue);
				atomeBouton.setFont(new Font ("Consolas",Font.BOLD,13));
				atomeBouton.setForeground(Color.white);
				
			}
			else if(tableChimique.atomes.get(i).getFamille().equals("Alcalin")){
				atomeBouton.setBackground(Color.ORANGE);
				atomeBouton.setFont(new Font ("Consolas",Font.BOLD,15));
				atomeBouton.setForeground(Color.white);
			
			}
			else if(tableChimique.atomes.get(i).getFamille().equals("Alcalino-terreux")){
				atomeBouton.setBackground(blue_violet);
				atomeBouton.setFont(new Font ("Consolas",Font.BOLD,14));
				atomeBouton.setForeground(Color.white);
				
			}
			else if(tableChimique.atomes.get(i).getFamille().equals("Métalloïde")){
				atomeBouton.setBackground(forest_green);
				atomeBouton.setFont(new Font ("Consolas",Font.BOLD,13));
				atomeBouton.setForeground(Color.white);
				
			}
			else if(tableChimique.atomes.get(i).getFamille().equals("Halogène")){
				atomeBouton.setBackground(turquoise);
				atomeBouton.setForeground(violet_red);
				atomeBouton.setFont(new Font ("Consolas",Font.BOLD,13));
			}
			else if(tableChimique.atomes.get(i).getFamille().equals("Post-transition metal")){
				atomeBouton.setBackground(darkTurquoise);
				atomeBouton.setFont(new Font ("Consolas",Font.BOLD,13));
				atomeBouton.setForeground(Color.white);
				
			}
			else if(tableChimique.atomes.get(i).getFamille().equals("Métal de transition")){
				atomeBouton.setBackground(hotPink);
				atomeBouton.setFont(new Font ("Consolas",Font.BOLD,14));
			}
			else if(tableChimique.atomes.get(i).getFamille().equals("Lanthanide")){
				atomeBouton.setBackground(burlywood);
				atomeBouton.setFont(new Font ("Consolas",Font.BOLD,13));
				atomeBouton.setForeground(marron);
			}
			else if(tableChimique.atomes.get(i).getFamille().equals("Actinide")){
				atomeBouton.setBackground(thisle);
				atomeBouton.setFont(new Font ("Consolas",Font.BOLD,13));
				atomeBouton.setForeground(Color.red);
			}	
			
		}
		
		int c=1;
		int d=1;
		for (int i=0; i<=9; i++){
			// On pourrait ouvrir une nouvelle fenetre pour avoir des informations sur chaque famille
			couleurFamilleBouton = new JButton();
			couleurFamilleBouton.setEnabled(false);
			couleurFamilleBouton.setSize(35, 20);
			
			familleLabel = new JLabel();
			familleLabel.setSize(120, 20);
			
			if(i==0){
				familleLabel.setText("Non-métaux");
				familleLabel.setLocation(40,5);
				familleLabel.setForeground(Color.green);
				couleurFamilleBouton.setBackground(Color.GREEN);
				couleurFamilleBouton.setLocation(1, 6);
				
			}
			else {
				couleurFamilleBouton.setLocation(1,c+25);
				c = c+ 18;
				familleLabel.setLocation(40,d+25);
				d = d + 18;
				
				if(i==1){
					familleLabel.setText("Gaz noble");
					familleLabel.setForeground(Color.blue);
					couleurFamilleBouton.setBackground(Color.blue);					
				}
				else if(i==2){
					familleLabel.setText("Alcalin");
					couleurFamilleBouton.setBackground(Color.ORANGE);
					familleLabel.setForeground(Color.ORANGE);
					
				}
				else if(i==3){
					familleLabel.setText("Alcalino-terreux");
					couleurFamilleBouton.setBackground(blue_violet);
					familleLabel.setForeground(blue_violet);
				}
				else if(i==4){
					familleLabel.setText("Métalloïde");
					couleurFamilleBouton.setBackground(forest_green);	
					familleLabel.setForeground(forest_green);
				}
				else if(i==5){
					familleLabel.setText("Halogène");
					couleurFamilleBouton.setBackground(turquoise);
					familleLabel.setForeground(turquoise);
					
				}
				else if(i==6){
					familleLabel.setText("Post-transition metal");
					couleurFamilleBouton.setBackground(darkTurquoise);	
					familleLabel.setForeground(darkTurquoise);
				}
				else if(i==7){
					familleLabel.setText("Métal de transition");
					couleurFamilleBouton.setBackground(hotPink);
					familleLabel.setForeground(hotPink);
					
				}
				else if(i==8){
					familleLabel.setText("Lanthanide");
					couleurFamilleBouton.setBackground(burlywood);
					familleLabel.setForeground(burlywood);
				}
				else{
					familleLabel.setText("Actinide");
					couleurFamilleBouton.setBackground(thisle);
					familleLabel.setForeground(thisle);
				}
			}
			panneauLegende.add(couleurFamilleBouton);
			panneauLegende.add(familleLabel);
		}
		
		panneau4.add(panneauTitre);
		panneau4.add(panneauLegende);
		panneau4.add(panneauTablePeriodique);
		this.setContentPane(panneau4);
		 
	   }

	// Fenetre: Lorsque on séléctionne un atome donné
	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame fenetre = new JFrame("Atome ");
		fenetre.setResizable(false);
		fenetre.setSize (400,400);
		fenetre.setLocation (10, 10);
	
		for(int i=0; i<tableChimique.getCurrentAtomCount(); i++){
			  if(e.getActionCommand() == tableChimique.atomes.get(i).getSymbole()){
				  
					  fenetre.setTitle("Illustration: " + tableChimique.atomes.get(i).getNom());
					  titre2Label = new JLabel("<html><body><u>Information Générale de l'atome</u></body></html>",JLabel.CENTER);
					  titre2Label.setFont (new Font ("Bank Gothic", Font.BOLD, 15));
					  titre2Label.setForeground(Color.red);
					  nomLabel = new JLabel ("Nom: " + tableChimique.atomes.get(i).getNom());
					  symboleLabel = new JLabel ("Symbole: [" + tableChimique.atomes.get(i).getSymbole()+"]");
					  familleLabel = new JLabel("Famille: " + tableChimique.atomes.get(i).getFamille());
					  nbrLiaisonLabel = new JLabel ("Nombre de liaisons: " + tableChimique.atomes.get(i).getNbrLiaison());
					  masseMolaireLabel = new JLabel ("Masse molaire: " + tableChimique.atomes.get(i).getmasseMolaire()+"u");
					  periodeLabel = new JLabel ("Période: " + tableChimique.atomes.get(i).getPeriode());
					  colonneLabel = new JLabel ("Colonne: " + tableChimique.atomes.get(i).getColonne());
					  numeroAtomiqueLabel  = new JLabel ("Numéro atomique(Z):  " + tableChimique.atomes.get(i).getNumAtomiqueZ());
					  ionLabel = new JLabel ("<html><body>Charge ionique: " + tableChimique.atomes.get(i).chargeIonique()+"</body></html>");
					  coucheElectroniqueLabel = new JLabel ("Couche electronique: " + tableChimique.atomes.get(i).coucheExterne());
			  }
			  
		}
		JPanel panneau5 = new JPanel();
		panneau5.setLayout(new GridLayout(11,1));
		panneau5.add(titre2Label);
		panneau5.add(nomLabel);
		panneau5.add(symboleLabel);
		panneau5.add(familleLabel);
		panneau5.add(nbrLiaisonLabel);
		panneau5.add(masseMolaireLabel);
		panneau5.add(periodeLabel);
		panneau5.add(colonneLabel);
		panneau5.add(numeroAtomiqueLabel);
		panneau5.add(ionLabel);
		panneau5.add(coucheElectroniqueLabel);
		// Centrer l'application
		fenetre.setLocationRelativeTo(null); 
		fenetre.setContentPane(panneau5);
		fenetre.setVisible(true);
		
	}
	
	public static void main(String[] args) throws ParseException, AtomeDejaAjouterException {
		FenetreChimie GestionDonne = new FenetreChimie();
		GestionDonne.setResizable(false);
		GestionDonne.setVisible(true);
		

	}
}
