

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(51, 144, 860, 403);
		CrearOrden.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(376, 282, -97, -76);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Crear ordenes");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 36));
		lblNewLabel.setBounds(373, 23, 319, 96);
		CrearOrden.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(26, 11, 52, 43);
		CrearOrden.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Confirmar orden ");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnNewButton_1.setBounds(373, 576, 212, 32);
		CrearOrden.add(btnNewButton_1);
	}
}
