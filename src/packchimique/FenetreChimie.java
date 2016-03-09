package packchimique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.BorderFactory;
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
	private JPanel panneauAtome;
	private JLabel nomAtomeLabelS;
	private JLabel nomAtomeLabelZ;
	private JLabel nomAtomeLabelM;
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
	private JLabel masseAtomeLabel = new JLabel();
	// Ajout des boutons
	private JButton atomeBouton; // Bouton correspondant à l'atome
	private JButton couleurFamilleBouton; // Bouton correspondant à la couleur de la famille
	
	private JPanel panneauTitre = new JPanel(); // Titre
	private JPanel panneauTablePeriodique = new JPanel(); // Tableau périodique
	private JPanel panneauLegende = new JPanel(); 
	private JPanel panneauComplet = new JPanel();

	public FenetreChimie() throws ParseException, AtomeDejaAjouterException,AtomeInexistantException {
	
		this.setTitle("Tableau Périodique De Mendeleiev");
		this.setResizable(true);
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		this.setSize(1400,900);
		// Mode plein ecran
		//this.getToolkit().getScreenSize()
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
		panneauLegende.setLocation(1150,500);
		panneauLegende.setBackground(Color.black);
	
		panneauComplet.setLayout(new GridLayout(4,1));
		panneauComplet.setLayout(null);
		panneauComplet.setPreferredSize(new Dimension(900, 700));
				
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
				atomeBouton.setFont(new Font ("Consolas",Font.BOLD,14));
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
				atomeBouton.setForeground(Color.BLACK);
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
	
		panneauComplet.add(panneauTitre);
		panneauComplet.add(panneauLegende);
		panneauComplet.add(panneauTablePeriodique);
		
		this.setContentPane(panneauComplet);
		
		
		 
	   }

	@Override
	public void actionPerformed(ActionEvent e) {
		
			// Fenetre Informative
			
			JFrame fenetre = new JFrame("Illustration");
			// Pour que l'utilisateur ne puisse pas agrandir la fenetre
			
			// Si on veut centrer la fenetre
			//fenetre.setLocationRelativeTo(null); 
		for(int i=0; i<tableChimique.getCurrentAtomCount(); i++){
			  if(e.getActionCommand() == tableChimique.atomes.get(i).getSymbole()){
				  		
				  	DecimalFormat df = new DecimalFormat("0.##");
				  	DecimalFormat df2 = new DecimalFormat("0");
				  	  
					  fenetre.setTitle("Illustration: " + tableChimique.atomes.get(i).getNom());
					  titre2Label = new JLabel("<html><body><u>Information Générale de l'atome</u></body></html>",JLabel.CENTER);
					  titre2Label.setFont (new Font ("Consolas", Font.BOLD, 15));
					  titre2Label.setForeground(Color.red);
					  nomLabel = new JLabel ("Nom: "+tableChimique.atomes.get(i).getNom());
					  symboleLabel = new JLabel ("Symbole: [" + tableChimique.atomes.get(i).getSymbole()+"]");
					  familleLabel = new JLabel("Famille: " + tableChimique.atomes.get(i).getFamille());
					  masseAtomeLabel = new JLabel("<html><body>Masse: "+df.format(tableChimique.calculMasseAtome(tableChimique.atomes.get(i).getNom()))+" 10<sup>-27</sup> kg</body> </html>");
					  nbrLiaisonLabel = new JLabel ("Nombre de liaisons: " + tableChimique.atomes.get(i).getNbrLiaison());
					  masseMolaireLabel = new JLabel ("<html><body>Masse molaire: " + df.format(tableChimique.atomes.get(i).getmasseMolaire())+" g.mol<sup>-1</sup></body></html>");
					  periodeLabel = new JLabel ("Période: " + tableChimique.atomes.get(i).getPeriode());
					  colonneLabel = new JLabel ("Colonne: " + tableChimique.atomes.get(i).getColonne());
					  numeroAtomiqueLabel  = new JLabel ("Numéro atomique(Z):  " + tableChimique.atomes.get(i).getNumAtomiqueZ());
					  ionLabel = new JLabel ("<html><body>Charge ionique: " + tableChimique.atomes.get(i).chargeIonique()+"</body></html>");
					  coucheElectroniqueLabel = new JLabel ("Couche electronique: " + tableChimique.atomes.get(i).coucheExterne());
					  	
					  	nomAtomeLabelS = new JLabel(tableChimique.atomes.get(i).getSymbole());
						nomAtomeLabelS.setFont(new Font ("Consolas", Font.BOLD, 22));
						nomAtomeLabelS.setForeground(Color.blue);
						
						nomAtomeLabelZ= new JLabel("<html>Z<sup>"+tableChimique.atomes.get(i).getNumAtomiqueZ()+"</sup></html>");
						nomAtomeLabelZ.setForeground(Color.red);
						nomAtomeLabelZ.setFont(new Font ("Consolas", Font.BOLD, 15));
						
						nomAtomeLabelM= new JLabel("<html>M<sup>"+df2.format(tableChimique.atomes.get(i).getmasseMolaire())+"</sup></html>");
						nomAtomeLabelM.setForeground(Color.black);
						nomAtomeLabelM.setFont(new Font ("Consolas", Font.BOLD, 15));
						// panneauAtome: Nom d'atome Selectionner
						panneauAtome=new JPanel();
						panneauAtome.setLayout(new GridLayout(1,3));
						panneauAtome.setBorder(BorderFactory.createLineBorder(Color.red,3));
						panneauAtome.setBackground(lightgreen);
						panneauAtome.setSize(130, 80);
						panneauAtome.setLocation(350, 100);
						panneauAtome.add(nomAtomeLabelZ);
						panneauAtome.add(nomAtomeLabelS);
						panneauAtome.add(nomAtomeLabelM);
						
				
						
			  }
			  
		}
		
		
		// Affichage du Symbole de l'atome 
		
		panneauComplet.add(panneauAtome);
		panneauAtome.updateUI();
		panneauComplet.setVisible(true);
		
		
		JPanel panneauFenetreIllustration = new JPanel();
		panneauFenetreIllustration.setLayout(new GridLayout(12,1));
		panneauFenetreIllustration.setBackground(lightgreen);
		panneauFenetreIllustration.add(titre2Label);
		panneauFenetreIllustration.add(nomLabel);
		panneauFenetreIllustration.add(symboleLabel);
		panneauFenetreIllustration.add(familleLabel);
		panneauFenetreIllustration.add(masseAtomeLabel);
		panneauFenetreIllustration.add(nbrLiaisonLabel);
		panneauFenetreIllustration.add(masseMolaireLabel);
		panneauFenetreIllustration.add(periodeLabel);
		panneauFenetreIllustration.add(colonneLabel);
		panneauFenetreIllustration.add(numeroAtomiqueLabel);
		panneauFenetreIllustration.add(ionLabel);
		panneauFenetreIllustration.add(coucheElectroniqueLabel);
	
		
		fenetre.setContentPane(panneauFenetreIllustration);
		fenetre.setResizable(false);
		fenetre.setSize (280,400);
		fenetre.setLocation (1080, 80);
		fenetre.setVisible(true);
	
	
	}
	

	public static void main(String[] args) throws ParseException, AtomeDejaAjouterException,AtomeInexistantException {
		FenetreChimie GestionDonne = new FenetreChimie();
		GestionDonne.setResizable(false);
		GestionDonne.setVisible(true);
		

	}
}
