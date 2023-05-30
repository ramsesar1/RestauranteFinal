

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

public class CrearOrdenes {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearOrdenes window = new CrearOrdenes();
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
	public CrearOrdenes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 977 ,681);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel CrearOrden = new JPanel();
		CrearOrden.setBackground(new Color(255, 69, 0));
		frame.getContentPane().add(CrearOrden, BorderLayout.CENTER);
		CrearOrden.setLayout(null);
		
		JPanel CrearOrden1 = new JPanel();
		CrearOrden1 .setBackground(new Color(240, 248, 255));
		CrearOrden1 .setBounds(51, 144, 860, 403);
		CrearOrden.add(CrearOrden1 );
		CrearOrden1 .setLayout(null);
		
	
		
		JLabel CrearOrdenLabel = new JLabel("Crear ordenes");
		CrearOrdenLabel.setForeground(new Color(0, 0, 0));
		CrearOrdenLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 36));
		CrearOrdenLabel.setBounds(373, 23, 319, 96);
		CrearOrden.add(CrearOrdenLabel);
		
		ImageIcon iconRetroceso3 = new ImageIcon("BotonRetroceder.png");
		Image imagenR3 = iconRetroceso3.getImage();
		Image imagenRedimensionada3 = imagenR3.getScaledInstance(35, 33, java.awt.Image.SCALE_SMOOTH);
		JButton Back3 = new JButton();
		Back3.setIcon(new ImageIcon(imagenRedimensionada3));
	    Back3.setBounds(26, 11, 35, 33);
		CrearOrden.add(Back3);
		
		JButton ConfirmarOrdenBoton = new JButton("Confirmar orden ");
		ConfirmarOrdenBoton.setForeground(Color.BLACK);
		ConfirmarOrdenBoton.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		ConfirmarOrdenBoton.setBounds(373, 576, 212, 32);
		CrearOrden.add(ConfirmarOrdenBoton);
	}
}
