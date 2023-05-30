
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
import javax.swing.JScrollPane;

public class EliminarOrdenes {

	private JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public EliminarOrdenes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 977 ,681);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel EliminarOrden = new JPanel();
		EliminarOrden.setBackground(new Color(255, 69, 0));
		frame.getContentPane().add(EliminarOrden, BorderLayout.CENTER);
		EliminarOrden.setLayout(null);
		
		JPanel EliminarOrden1 = new JPanel();
		EliminarOrden1.setBackground(new Color(255, 127, 80));
		EliminarOrden1.setBounds(128, 193, 677, 378);
		EliminarOrden.add(EliminarOrden1);
		EliminarOrden1.setLayout(null);
		
		JTable EliminarOrdentable = new JTable();
		EliminarOrdentable.setBackground(new Color(255, 127, 80));
		EliminarOrdentable.setBounds(149, 166, 375, 112);
		EliminarOrdentable.setModel(new DefaultTableModel(
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
		EliminarOrdentable.setForeground(new Color(0, 0, 0));
		EliminarOrdentable.setCellSelectionEnabled(true);
		EliminarOrden1.add(EliminarOrdentable);
		
		JPanel EliminarOrden3 = new JPanel();
		EliminarOrden3.setBackground(new Color(169, 169, 169));
		EliminarOrden3.setBounds(0, 0, 677, 48);
		EliminarOrden1.add(EliminarOrden3);
		
		JLabel OrdenAeliminarLabel = new JLabel("Orden a eliminar");
		OrdenAeliminarLabel.setForeground(new Color(0, 0, 0));
		OrdenAeliminarLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 26));
		EliminarOrden3.add(OrdenAeliminarLabel);
		
		
		
		JLabel EliminarOrdenLabel = new JLabel("Eliminar ordenes");
		EliminarOrdenLabel.setForeground(new Color(0, 0, 0));
		EliminarOrdenLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 40));
		EliminarOrdenLabel.setBounds(347, 23, 319, 96);
		EliminarOrden.add(EliminarOrdenLabel);
		
		ImageIcon iconRetroceso = new ImageIcon("BotonRetroceder.png");
		Image imagenR = iconRetroceso.getImage();
		Image imagenRedimensionada = imagenR.getScaledInstance(35, 33, java.awt.Image.SCALE_SMOOTH);
		JButton Back = new JButton();
		 Back.setIcon(new ImageIcon(imagenRedimensionada));
		 Back.setBounds(26, 11, 35, 33);
		EliminarOrden.add(Back);
	}
}
