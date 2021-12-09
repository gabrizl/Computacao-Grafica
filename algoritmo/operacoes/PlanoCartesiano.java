package algoritmo.operacoes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PlanoCartesiano extends JPanel {

	public final static int ALTURA = 600;
	public final static int LARGURA = 600;
	private static BufferedImage imagemCoordenadas;

	public PlanoCartesiano() {

		setBounds(400, 30, LARGURA, ALTURA);
		imagemCoordenadas = new BufferedImage(LARGURA, ALTURA, BufferedImage.TYPE_INT_ARGB);
		limparImagem();
		setPixel();

	}

	/**
	 * Limpa a tela com branco. Ap�s limpar coloca as coordenadas.
	 */
	public void limparImagem() {
		for (int i = 0; i < ALTURA; i++) {
			for (int j = 0; j < LARGURA; j++) {
				imagemCoordenadas.setRGB(i, j, Color.WHITE.getRGB());
				repaint();
			}
		}
		addCoordenadas();
	}

	private void setPixel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouse) {
				imagemCoordenadas.setRGB(mouse.getX(), mouse.getY(),
						Color.black.getRGB());
				repaint();
			}
		});
	}

	private void addCoordenadas() {
		int metade = (int) LARGURA / 2;

		for (int j = 1; j < ALTURA - 1; j++) {
			imagemCoordenadas.setRGB(metade, j, Color.BLACK.getRGB());
			repaint();
		}
		metade = (int) ALTURA / 2;
		for (int j = 1; j < LARGURA - 1; j++) {
			imagemCoordenadas.setRGB(j, metade, Color.BLACK.getRGB());
			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.create();
		g.drawImage(imagemCoordenadas, 0, 0, null);

	}

	/**
	 * @return the altura
	 */
	public static int getAltura() {
		return ALTURA;
	}

	/**
	 * @return the largura
	 */
	public static int getLargura() {
		return LARGURA;
	}
}
