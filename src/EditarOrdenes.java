
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 127, 80));
		panel_1.setBounds(128, 193, 677, 378);
		EditarOrdenes.add(panel_1);
		panel_1.setLayout(null);
		
		JTable table = new JTable();
		table.setBackground(new Color(255, 127, 80));
		table.setBounds(149, 166, 375, 112);
		table.setModel(new DefaultTableModel(
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
		table.setForeground(new Color(0, 0, 0));
		table.setCellSelectionEnabled(true);
		panel_1.add(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(169, 169, 169));
		panel_2.setBounds(0, 0, 677, 48);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Orden a editar");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 26));
		panel_2.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel = new JLabel("Editar ordenes");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 40));
		lblNewLabel.setBounds(347, 23, 319, 96);
		EditarOrdenes.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(26, 11, 52, 43);
		EditarOrdenes.add(btnNewButton);
	}
}
