
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

public class EditarOrdenes {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarOrdenes window = new EditarOrdenes();
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
	public EditarOrdenes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 977 ,681);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel EditarOrdenes = new JPanel();
		EditarOrdenes.setBackground(new Color(255, 69, 0));
		frame.getContentPane().add(EditarOrdenes, BorderLayout.CENTER);
		EditarOrdenes.setLayout(null);
		
		JPanel EditarOrdenes1 = new JPanel();
		EditarOrdenes1.setBackground(new Color(255, 127, 80));
		EditarOrdenes1.setBounds(128, 193, 677, 378);
		EditarOrdenes.add(EditarOrdenes1);
		EditarOrdenes1.setLayout(null);
		
		JTable EditarOrdentable = new JTable();
		EditarOrdentable.setBackground(new Color(255, 127, 80));
		EditarOrdentable.setBounds(149, 166, 375, 112);
		EditarOrdentable.setModel(new DefaultTableModel(
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
		EditarOrdentable.setForeground(new Color(0, 0, 0));
		EditarOrdentable.setCellSelectionEnabled(true);
		EditarOrdenes1.add(EditarOrdentable);
		
		JPanel EditarOrdenes2 = new JPanel();
		EditarOrdenes2.setBackground(new Color(169, 169, 169));
		EditarOrdenes2.setBounds(0, 0, 677, 48);
		EditarOrdenes1.add(EditarOrdenes2);
		
		JLabel OrdenAeditarLabel = new JLabel("Orden a editar");
		OrdenAeditarLabel.setForeground(new Color(0, 0, 0));
		OrdenAeditarLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 26));
		EditarOrdenes2.add(OrdenAeditarLabel);
		
		
		
		JLabel EditarOrdenLabel = new JLabel("Editar ordenes");
		EditarOrdenLabel .setForeground(new Color(0, 0, 0));
		EditarOrdenLabel .setFont(new Font("Tw Cen MT", Font.PLAIN, 40));
		EditarOrdenLabel .setBounds(347, 23, 319, 96);
		EditarOrdenes.add(EditarOrdenLabel);
		
		ImageIcon iconRetroceso2 = new ImageIcon("BotonRetroceder.png");
		Image imagenR2 = iconRetroceso2.getImage();
		Image imagenRedimensionada2 = imagenR2.getScaledInstance(35, 33, java.awt.Image.SCALE_SMOOTH);
		JButton Back2 = new JButton();
		 Back2.setIcon(new ImageIcon(imagenRedimensionada2));
		 Back2.setBounds(26, 11, 35, 33);
		 EditarOrdenes.add(Back2);
	}
}
