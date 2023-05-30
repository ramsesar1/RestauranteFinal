
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ConsultarOrdenes {

	private JFrame frame;
	private JTable ConsultarOrdentable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 ConsultarOrdenes window = new  ConsultarOrdenes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public  ConsultarOrdenes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 977 ,681);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel ConsultarOrden = new JPanel();
		ConsultarOrden.setBackground(new Color(255, 69, 0));
		frame.getContentPane().add(ConsultarOrden, BorderLayout.CENTER);
		ConsultarOrden.setLayout(null);
		
		JPanel ConsultarOrden1 = new JPanel();
		ConsultarOrden1.setBackground(new Color(255, 127, 80));
		ConsultarOrden1.setBounds(128, 193, 677, 378);
		ConsultarOrden.add(ConsultarOrden1);
		ConsultarOrden1.setLayout(null);
		
		 ConsultarOrdentable = new JTable();
		 ConsultarOrdentable.setBackground(new Color(255, 127, 80));
		 ConsultarOrdentable.setBounds(149, 166, 375, 112);
		 ConsultarOrdentable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		 ConsultarOrdentable.setForeground(new Color(0, 0, 0));
		 ConsultarOrdentable.setCellSelectionEnabled(true);
		ConsultarOrden1.add( ConsultarOrdentable);
		
		JPanel ConsultarOrden2 = new JPanel();
		ConsultarOrden2.setBackground(new Color(169, 169, 169));
		ConsultarOrden2.setBounds(0, 0, 677, 48);
		ConsultarOrden1.add(ConsultarOrden2);
		
		JLabel OrdenAconsultarLabel = new JLabel("Orden a Consultar");
		OrdenAconsultarLabel.setForeground(new Color(0, 0, 0));
		OrdenAconsultarLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 26));
		ConsultarOrden2.add(OrdenAconsultarLabel);
		
		JLabel ConsultarOrdenLabel = new JLabel("Consultar ordenes");
		ConsultarOrdenLabel.setForeground(new Color(0, 0, 0));
		ConsultarOrdenLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 36));
		ConsultarOrdenLabel.setBounds(338, 50, 319, 96);
		ConsultarOrden.add(ConsultarOrdenLabel);
		
		ImageIcon iconRetroceso1 = new ImageIcon("BotonRetroceder.png");
		Image imagenR1 = iconRetroceso1.getImage();
		Image imagenRedimensionada1 = imagenR1.getScaledInstance(35, 33, java.awt.Image.SCALE_SMOOTH);
		JButton Back1 = new JButton();
		 Back1.setIcon(new ImageIcon(imagenRedimensionada1));
		 Back1.setBounds(26, 11, 35, 33);
		 ConsultarOrden.add(Back1);
	}
}
