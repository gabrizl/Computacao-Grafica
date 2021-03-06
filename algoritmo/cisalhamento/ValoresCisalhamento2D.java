package algoritmo.cisalhamento;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import algoritmo.operacoes3d.*;
import algoritmo.operacoes2D.*;
import projetoCG.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class ValoresCisalhamento2D extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	public String x, y, z;
	protected boolean status;
	private JTextField txtZ;

	/**
	 * Create the dialog.
	 * 
	 * @param tipo
	 */
	public ValoresCisalhamento2D() {

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

		JLabel lblTranslao = new JLabel("Cisalhamento");
		lblTranslao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTranslao.setBounds(10, 16, 102, 40);
		contentPanel.add(lblTranslao);

		setTxtTranslacaoX(new JTextField());
		getTxtTranslacaoX().setText("0");
		getTxtTranslacaoX().setBounds(151, 72, 86, 30);
		contentPanel.add(getTxtTranslacaoX());
		getTxtTranslacaoX().setColumns(10);

		setTxtTranslacaoY(new JTextField());
		getTxtTranslacaoY().setText("0");
		getTxtTranslacaoY().setBounds(151, 118, 86, 30);
		contentPanel.add(getTxtTranslacaoY());
		getTxtTranslacaoY().setColumns(10);

		JLabel lblCisalhamentoEmX = new JLabel("Cisalhamento em X");
		lblCisalhamentoEmX.setBounds(20, 72, 121, 30);
		contentPanel.add(lblCisalhamentoEmX);

		JLabel lblCisalhamentoEmY = new JLabel("Cisalhamento em Y");
		lblCisalhamentoEmY.setBounds(20, 118, 121, 30);
		contentPanel.add(lblCisalhamentoEmY);
		
		JLabel lblCisalhamentoEmZ = new JLabel("Cisalhamento em Z");
		lblCisalhamentoEmZ.setBounds(20, 164, 121, 30);
		contentPanel.add(lblCisalhamentoEmZ);
		
		txtZ = new JTextField();
		txtZ.setText("0");
		txtZ.setColumns(10);
		txtZ.setBounds(151, 164, 86, 30);
		contentPanel.add(txtZ);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelReta.panelPlanoCartesiano.limparImagem();
				
				x = txtX.getText();
				y = txtY.getText();
				
				
				List<Ponto> listaPontos = null;
				if (!(x.isEmpty() || x.equals("0"))) {
					listaPontos = cisalhamentoX(Double.valueOf(x), Double.valueOf(y));	
				} 
				if (!(y.isEmpty() || y.equals("0"))) {
					listaPontos = cisalhamentoY(Double.valueOf(x), Double.valueOf(y));	
				}
				if (!(z.isEmpty() || z.equals("0"))) {
					listaPontos = cisalhamentoZ(Double.valueOf(x), Double.valueOf(y));	
				}
				
				if (PanelPrincipal.getLista().isEmpty()) {
					System.out.println(PanelPrincipal.getLista().toString());
				}
				
				PanelPlanoCartesiano.add3D(true);
				PanelPrincipal.setLista(listaPontos); 
				PanelPrincipal.povoar3D(Color.BLUE);
				PanelPrincipal.planoCartesiano.repaint();
				setVisible(false);
			}

			private List<Ponto> cisalhamentoZ(Double a, Double b) {
				List<Ponto> lis = new Operacoes().cisalhamentoEmZ(PanelPrincipal.getLista(), a, b); 
				return lis;
			}

			private List<Ponto> cisalhamentoY(Double a, Double b) {
				List<Ponto> lis = new Operacoes().cisalhamentoEmY(PanelPrincipal.getLista(), a, b); 
				return lis;
			}

			private List<Ponto> cisalhamentoX(Double a, Double b) {
				List<Ponto> lis = new Operacoes().cisalhamentoEmX(PanelPrincipal.getLista(), a, b); 
				return lis;
			}

		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				status = false;
				setVisible(false);
			}
		});

		cancelButton.setActionCommand("Cancelar");
		buttonPane.add(cancelButton);

	}

	/**
	 * @return the txtTranslacaoY
	 */
	public JTextField getTxtTranslacaoY() {
		return txtY;
	}

	/**
	 * @param txtTranslacaoY
	 *            the txtTranslacaoY to set
	 */
	public void setTxtTranslacaoY(JTextField txtTranslacaoY) {
		this.txtY = txtTranslacaoY;
	}

	/**
	 * @return the txtTranslacaoX
	 */
	public JTextField getTxtTranslacaoX() {
		return txtX;
	}

	/**
	 * @param txtTranslacaoX
	 *            the txtTranslacaoX to set
	 */
	public void setTxtTranslacaoX(JTextField txtTranslacaoX) {
		this.txtX = txtTranslacaoX;
	}
}
