package projetoCG;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CoordenadasMouse extends JPanel {

	BufferedImage imagemPlot;
	
	int valorx, valory;
	static boolean limpaDesenho = false;

	public CoordenadasMouse() {

		// MÉTODO QUE CAPTURA AS COORDENADAS DO MOUSE
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override

			public void mouseMoved(MouseEvent arg0) {

				valorx = posicionaNoPlanoX(arg0.getX());
				valory = posicionaNoPlanoY(arg0.getY());
				TelaPrincipal.lblX.setText(Integer.toString(valorx));
				TelaPrincipal.lblY.setText(Integer.toString(valory));

			}
		});

		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(450, 25, 600, 600);
		setLayout(null);
		imagemPlot = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);

	}

	/**
	 * Retorna a posi��o do valor de X
	 * 
	 * @param x
	 * @return posi��o normalizada da viewport
	 */
	public static int posicionaNoPlanoX(int x) {
		return x - 300;
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
}