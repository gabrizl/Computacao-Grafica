package projetoCG;

import java.awt.Color;
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

public class PanelDeDesenho2D extends JPanel {
	
	BufferedImage imagemPlot;
	SistemaDeCoordenadas converte = new SistemaDeCoordenadas();
	int valorx, valory;
	static boolean limpaDesenho = false;
	
	public PanelDeDesenho2D() {
	

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
//	limpaPainel();
	//setPixelTeste();
	//PanelPrincipal.PanelPrincipal.add(panelPlot);
	}
	
	/**
     * Retorna a posi��o do valor de X 
     * @param x
     * @return posi��o normalizada da viewport
     */
	public static int posicionaNoPlanoX(int x){
		return  x - 300;
	}
	
	/**
     * Retorna a posi��o do valor de Y
     * @param y
     * @return posi��o normalizada da viewport
     */
	public static int posicionaNoPlanoY(int y){
		//return (y - 300)*(-1);
		return 300 - y;
	}
	
	/**
     * Faz a limpeza da tela e desenha a imagem com o eixo de x e y.
     */
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		
		if(limpaDesenho){
			limpaPainel();
			limpaDesenho = false;
		}
		g.drawImage((Image)imagemPlot, 0, 0, null);
		g.drawLine(300, 0, 300, 600); //x
		g.drawLine(0, 300, 600, 300);
		
	}
	
	/**
     * Faz a limpeza da viewport
     */
	public void limpaPainel(){
		for(int i=0; i<600; i++){
			for(int j=0; j<600; j++){
				imagemPlot.setRGB(i, j, Color.BLACK.getRGB() );
			}
		}
	}
	
	/**
     * Desenha o pixel de acordo com o eixo cartesiano
     * @param x
     * @param y
     */
	public void setPixel(int x, int y){
		imagemPlot.setRGB(x+300, 300-y, Color.MAGENTA.getRGB());
		repaint();
	}

	public void setPixel(int x, int y, Color cor){
		if (x >= 300 || y >= 300) {
			return;
		} 
		imagemPlot.setRGB(x+300, 300-y, cor.getRGB());
		repaint();
	}
	
	public void setPixelTeste(){
		
		for (int i = 0; i < imagemPlot.getWidth()/2; i++) {
				imagemPlot.setRGB(i, i, Color.BLACK.getRGB());
				repaint();
				
			
		}
		//ge.drawImage(imagemPlot, 0, 0, null);
		
	}
}
