package projetoCG;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import algoritmo.operacoes3d.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class PanelPrincipal extends JFrame {

	public static PanelPlanoCartesiano planoCartesiano = new PanelPlanoCartesiano();
	public static PanelNormalizacao panelNormalizacao = new PanelNormalizacao();

	/**
	 * Lista de {@link Ponto} em 2D (duas dimensões)
	 */

	public static JPanel PanelPrincipal;
	public static JLabel lblX;
	public static JLabel lblY;
	public static JLabel lblNdcx;
	public static JLabel lblNdcy;
	public static JLabel lblDcx;
	public static JLabel lblDcy;
	boolean flagPanelA = true;
	boolean flagPanelB = true;
	JMenuItem mntmSair;
	protected int Posx;
	protected int Posy;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPrincipal frame = new PanelPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	
	/**
	 * Create the frame.
	 */
	public PanelPrincipal() {
		//setExtendedState(Frame.MAXIMIZED_BOTH);

		// **************PANEL PRINCIPAL**************************
		PanelPrincipal = new JPanel();

		PanelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelPrincipal);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 800);
		setTitle("Projeto Computa��o Gr�fica");
		planoCartesiano = new PanelPlanoCartesiano();
		// ************************LABELS***************************************************
		JLabel lblCoordenadaX = new JLabel("Coordenada X:");
		lblCoordenadaX.setBounds(64, 646, 176, 14);
		PanelPrincipal.add(lblCoordenadaX);

		JLabel lblCoordenadaY = new JLabel("Coordenada Y:");
		lblCoordenadaY.setBounds(64, 672, 154, 14);
		PanelPrincipal.add(lblCoordenadaY);

		lblX = new JLabel();
		lblX.setBounds(223, 646, 28, 14);
		PanelPrincipal.add(lblX);

		lblY = new JLabel();
		lblY.setBounds(224, 672, 32, 14);
		PanelPrincipal.add(lblY);

		JLabel lblCoordenadaNdcx = new JLabel("Coordenada NDCX:");
		lblCoordenadaNdcx.setBounds(303, 646, 169, 14);
		PanelPrincipal.add(lblCoordenadaNdcx);

		JLabel lblCoordenadaNdcy = new JLabel("Coordenada NDCY:");
		lblCoordenadaNdcy.setBounds(303, 672, 169, 14);
		PanelPrincipal.add(lblCoordenadaNdcy);

		JLabel lblCoordenadaDcx = new JLabel("Coordenada DCX:");
		lblCoordenadaDcx.setBounds(482, 646, 181, 14);
		PanelPrincipal.add(lblCoordenadaDcx);

		JLabel lblCoordenadaDcy = new JLabel("Coordenada DCY:");
		lblCoordenadaDcy.setBounds(482, 671, 181, 14);
		PanelPrincipal.add(lblCoordenadaDcy);

		lblNdcx = new JLabel();
		lblNdcx.setBounds(411, 646, 46, 14);
		PanelPrincipal.add(lblNdcx);

		lblNdcy = new JLabel();
		lblNdcy.setBounds(411, 672, 46, 14);
		PanelPrincipal.add(lblNdcy);

		lblDcx = new JLabel();
		lblDcx.setBounds(617, 646, 46, 14);
		PanelPrincipal.add(lblDcx);

		lblDcy = new JLabel();
		lblDcy.setBounds(617, 671, 46, 14);
		PanelPrincipal.add(lblDcy);
		// Obter posi��o do mouse no Plano Cartesiano
		planoCartesiano.addMouseMotionListener(new MouseMotionAdapter() {
			FuncoesDeNormalizacao funcoesDeNormalizacao = new FuncoesDeNormalizacao();

			@SuppressWarnings("static-access")
			@Override
			public void mouseMoved(MouseEvent eventoDeMouse) {
				Posx = (int) getMousePosition().getX();
				Posy = (int) getMousePosition().getY();
				int dcx = eventoDeMouse.getX() - 300;
				int dcy = (eventoDeMouse.getY() - 300) * -1;

				double ndcx = funcoesDeNormalizacao.calcularNDCX(planoCartesiano.LARGURA, dcx);
				double ndcy = funcoesDeNormalizacao.calcularNDCX(planoCartesiano.ALTURA, dcy);

				lblCoordenadaNdcx.setText("Ndc X :  " + String.format("%.4f", ndcx));
				lblCoordenadaNdcy.setText("Ndc Y :  " + String.format("%.4f", ndcy));

				lblCoordenadaDcx.setText("DcX:  " + Integer.toString(funcoesDeNormalizacao.calcularDCX(600, ndcx)));
				lblCoordenadaDcy.setText("DcY:  " + Integer.toString(funcoesDeNormalizacao.calcularDCY(600, ndcy)));

				lblCoordenadaX.setText("x: " + (Integer.valueOf(Posx) - 350));
				lblCoordenadaY.setText("y: " + (Integer.valueOf(Posy) - 381) * (-1));
			}
		});
		planoCartesiano.setLocation(50, 30);
		PanelPrincipal.add(planoCartesiano);

		PanelPrincipal.repaint();
		flagPanelA = true;
		flagPanelB = false;

		// **********BARRA DE MENUS*********************

		JMenuBar barraDeMenu = new JMenuBar();
		setJMenuBar(barraDeMenu);

		PanelPrincipal.setLayout(null);

		JMenu mnAjuda = new JMenu("Sobre");
		barraDeMenu.add(mnAjuda);

		JMenuItem mntmEquippe = new JMenuItem("Equipe");
		mnAjuda.add(mntmEquippe);
		mntmEquippe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String team = "Equipe: \n"+"Gabriel Alves\n" + "Mateus Viana\n" + "Marcelo Pedrosa";
				JOptionPane.showMessageDialog(null, team);
			}
		});

	}

}
