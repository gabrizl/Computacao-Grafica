package algoritmo.operacoes3d;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.util.List;

public class EscalaInterface extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtTranslacaoX;
	private JTextField txtTranslacaoY;
	public String x, y;
	protected boolean status;
	public static List<Ponto> lstPontos;
	JLabel lblEscala;

	/**
	 * Create the dialog.
	 * 
	 * @param tipo
	 */
	public EscalaInterface() {

		status = true;
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setAutoRequestFocus(false);

		setBounds(100, 100, 307, 276);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblEscala = new JLabel("Escala");
		lblEscala.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEscala.setBounds(10, 11, 102, 40);
		contentPanel.add(lblEscala);

		setTxtTranslacaoX(new JTextField());
		getTxtTranslacaoX().setText("0");
		getTxtTranslacaoX().setBounds(151, 75, 86, 30);
		contentPanel.add(getTxtTranslacaoX());
		getTxtTranslacaoX().setColumns(10);

		setTxtTranslacaoY(new JTextField());
		getTxtTranslacaoY().setText("0");
		getTxtTranslacaoY().setBounds(151, 129, 86, 30);
		contentPanel.add(getTxtTranslacaoY());
		getTxtTranslacaoY().setColumns(10);

		JLabel lblTranslaoEmX = new JLabel("Transla\u00E7\u00E3o em X");
		lblTranslaoEmX.setBounds(20, 75, 102, 30);
		contentPanel.add(lblTranslaoEmX);

		JLabel lblTranslaoEmY = new JLabel("Transla\u00E7\u00E3o em Y");
		lblTranslaoEmY.setBounds(20, 129, 102, 30);
		contentPanel.add(lblTranslaoEmY);
	}

	/**
	 * @return the txtTranslacaoY
	 */
	public JTextField getTxtTranslacaoY() {
		return txtTranslacaoY;
	}

	/**
	 * @param txtTranslacaoY
	 *                       the txtTranslacaoY to set
	 */
	public void setTxtTranslacaoY(JTextField txtTranslacaoY) {
		this.txtTranslacaoY = txtTranslacaoY;
	}

	/**
	 * @return the txtTranslacaoX
	 */
	public JTextField getTxtTranslacaoX() {
		return txtTranslacaoX;
	}

	/**
	 * @param txtTranslacaoX
	 *                       the txtTranslacaoX to set
	 */
	public void setTxtTranslacaoX(JTextField txtTranslacaoX) {
		this.txtTranslacaoX = txtTranslacaoX;
	}
}
