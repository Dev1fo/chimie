package packchimique;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Pauli extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Atome atome;

	public Pauli(Atome atome) {
		super();
		this.atome = atome;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int couches []= atome.calculeCouche();
		int longueur = getWidth()/2;//250/2
		int hauteur = getHeight()/2;
		int ecart_entre_oval=0;
			
		g.setColor(Color.RED); // noyau
		g.drawOval(longueur-8,hauteur-8,15,15);
		g.fillOval(longueur-8,hauteur-8,15,15);
		for (int i=0;i<couches.length;i++) {
			if(couches[i]!=0){
				
				ecart_entre_oval+=70;
				g.setColor(Color.black);
				g.drawOval(longueur-ecart_entre_oval/4,hauteur-ecart_entre_oval/4,ecart_entre_oval/2,ecart_entre_oval/2);
				g.setColor(Color.blue);

				for (int j = 0; j < couches[i]; j++) {
					double t = 2 * Math.PI * j / couches[i];
					
					int x = (int) Math.round(longueur - ecart_entre_oval/4 * Math.cos(t));
					int y = (int) Math.round(hauteur -ecart_entre_oval/4 * Math.sin(t));
					g.fillOval(x-3 , y-2, 10 , 10 );
				}
				
			}
		}
		    
	}
}

