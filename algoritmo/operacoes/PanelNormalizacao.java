package algoritmo.operacoes;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelNormalizacao extends JPanel {

	PanelPlanoCartesiano panelPlanoCartesiano = new PanelPlanoCartesiano();
	FuncoesDeNormalizacao funcoesDeNormalizacao = new FuncoesDeNormalizacao();

	static JLabel labelDCX;
	static JLabel labelDCY;
	static JLabel labelNDCX;
	static JLabel labelNDCY;
	static JLabel lblY;
	static JLabel lblX;

	/**
	 * Create the panel.
	 */
	public PanelNormalizacao() {
		setBackground(Color.DARK_GRAY);

		setBounds(0, 0, 1008, 660);
		setLayout(null);

		panelPlanoCartesiano.setBounds(456, 30, 600, 600);

		add(panelPlanoCartesiano);

		labelNDCX = new JLabel("ndcx: ");
		labelNDCX.setForeground(Color.WHITE);
		labelNDCX.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		labelNDCX.setBounds(10, 238, 348, 41);
		add(labelNDCX);

		labelNDCY = new JLabel("ndcy: ");
		labelNDCY.setForeground(Color.WHITE);
		labelNDCY.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		labelNDCY.setBounds(10, 270, 348, 41);
		add(labelNDCY);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 343, 358, 41);
		add(panel);

		JLabel lblCoordenadasDoDispositivo = new JLabel("Coordenadas do dispositivo");
		lblCoordenadasDoDispositivo.setForeground(Color.WHITE);
		lblCoordenadasDoDispositivo.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblCoordenadasDoDispositivo.setBounds(10, 0, 307, 41);
		panel.add(lblCoordenadasDoDispositivo);

		lblX = new JLabel("x: ");
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblX.setBounds(10, 395, 348, 41);
		add(lblX);

		lblY = new JLabel("y: ");
		lblY.setForeground(Color.WHITE);
		lblY.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblY.setBounds(10, 427, 348, 41);
		add(lblY);

	}
}