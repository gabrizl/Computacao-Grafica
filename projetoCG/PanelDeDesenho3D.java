/*package projetoCG;

import java.awt.Color;					---- TESTE COMENTADO ----
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelDeDesenho3D extends JPanel {
	
	BufferedImage imagemPlot;
	SistemaDeCoordenadas converte = new SistemaDeCoordenadas();
	int valorx, valory;
	static boolean limpaDesenho = false;
	
	public PanelDeDesenho3D() {
	

	// M�TODO QUE CAPTURA AS COORDENADAS DO MOUSE
	addMouseMotionListener(new MouseMotionAdapter() {
		@Override
		
		public void mouseMoved(MouseEvent arg0) {
			
			
			//System.out.println("coordenada X: "+arg0.getX()+" coordenada Y: " +arg0.getY());
			valorx = posicionaNoPlanoX(arg0.getX());
			valory = posicionaNoPlanoY(arg0.getY());
			PanelPrincipal.lblX.setText(Integer.toString(valorx));
			PanelPrincipal.lblY.setText(Integer.toString(valory));
			PanelPrincipal.lblNdcx.setText(String.format("%.3f",(converte.paraNDCX(valorx))));
			PanelPrincipal.lblNdcy.setText(String.format("%.3f",(converte.paraNDCY(valory))));
			PanelPrincipal.lblDcx.setText(Integer.toString(converte.paraNCX()));
			PanelPrincipal.lblDcy.setText(Integer.toString(converte.paraNCY()));
			
		}
	});
	
	
	setBackground(Color.WHITE);
	setBorder(new LineBorder(new Color(0, 0, 0)));
	setBounds(450, 25, 600, 600);
	setLayout(null);
	imagemPlot = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
	limpaPainel();
	//setPixelTeste();
	//PanelPrincipal.PanelPrincipal.add(panelPlot);
	}
	
	public static int posicionaNoPlanoX(int x){
		return  x - 300;
	}
	
	public static int posicionaNoPlanoY(int y){
		//return (y - 300)*(-1);
		return 300 - y;
	}
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		
		if(limpaDesenho){
			limpaPainel();
			limpaDesenho = false;
		}
		g.drawImage((Image)imagemPlot, 0, 0, null);
//		ORIGINAL
//		g.drawLine(300, 0, 300, 600); //x
//		g.drawLine(0, 300, 600, 300);
//		g.drawLine(600, 0,0, 600);
		
		// Alterado
		g.drawLine(300, 0, 300, 300); //x
		g.drawLine(300, 300, 600, 300);
		g.drawLine(300, 300, 0, 600);
		
	}
	public void limpaPainel(){
		for(int i=0; i<600; i++){
			for(int j=0; j<600; j++){
				imagemPlot.setRGB(i, j, Color.BLACK.getRGB() );
			}
		}
	}
	
	public void setPixel(int x, int y){
		if (x >= 300 || y >= 300) {
			return;
		}
		imagemPlot.setRGB(x+300, 300-y, Color.MAGENTA.getRGB());
		repaint();
		
	}

	public void setPixelTeste(){
		
		for (int i = 0; i < imagemPlot.getWidth()/2; i++) {
				imagemPlot.setRGB(i, i, Color.BLACK.getRGB());
				repaint();
				
			
		}
		//ge.drawImage(imagemPlot, 0, 0, null);
		
	}
	
	
}*/
