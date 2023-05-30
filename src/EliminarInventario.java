import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class EliminarInventario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarInventario frame = new EditarInventario();
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
	public EliminarInventario() {
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 977, 681);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        
	        JPanel EliminarINv = new JPanel();
	        EliminarINv.setBackground(new Color(255, 128, 0));
	        EliminarINv.setBounds(0, 0, 961, 642);
	        contentPane.add(EliminarINv);
	        EliminarINv.setLayout(null);
	        
	        JButton btnNewButton = new JButton("Back");
	     			btnNewButton.setBounds(10, 11, 52, 43);
	     			EliminarINv.add(btnNewButton);
	        
	        JLabel lblNewLabel = new JLabel("Eliminar Inventario\r\n");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
	        lblNewLabel.setBounds(388, -16, 252, 115);
	        EliminarINv.add(lblNewLabel);
	        
	        JPanel panel = new JPanel();
	        panel.setBackground(new Color(255, 218, 168));
	        panel.setBounds(10, 204, 941, 427);
	        EliminarINv.add(panel);
	        panel.setLayout(null);
	        
	        JLabel lblNewLabel_2 = new JLabel("Articulo #5\r\n");
	        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
	        lblNewLabel_2.setBounds(55, 11, 145, 31);
	        panel.add(lblNewLabel_2);
	        
	        JLabel lblNewLabel_2_1 = new JLabel("Articulo #4\r\n\r\n");
	        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
	        lblNewLabel_2_1.setBounds(55, 63, 145, 31);
	        panel.add(lblNewLabel_2_1);
	        
	        JLabel lblNewLabel_2_1_1 = new JLabel("Articulo #2\r\n\r\n");
	        lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
	        lblNewLabel_2_1_1.setBounds(55, 171, 145, 31);
	        panel.add(lblNewLabel_2_1_1);
	        
	        JLabel lblNewLabel_2_2 = new JLabel("Articulo #3\r\n");
	        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
	        lblNewLabel_2_2.setBounds(55, 118, 145, 31);
	        panel.add(lblNewLabel_2_2);
	        
	        JLabel lblNewLabel_2_3 = new JLabel("Articulo #1\r\n");
	        lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
	        lblNewLabel_2_3.setBounds(55, 225, 145, 31);
	        panel.add(lblNewLabel_2_3);
	        
	        JButton btnNewButton1 = new JButton("Eliminar");
	        btnNewButton1.setBounds(732, 19, 128, 23);
	        panel.add(btnNewButton1);
	        
	        JButton btnNewButton_1 = new JButton("Eliminar");
	        btnNewButton_1.setBounds(732, 71, 128, 23);
	        panel.add(btnNewButton_1);
	        
	        JButton btnNewButton_2 = new JButton("Eliminar");
	        btnNewButton_2.setBounds(732, 126, 128, 23);
	        panel.add(btnNewButton_2);
	        
	        JButton btnNewButton_3 = new JButton("Eliminar");
	        btnNewButton_3.setBounds(732, 179, 128, 23);
	        panel.add(btnNewButton_3);
	        
	        JButton btnNewButton_4 = new JButton("Eliminar");
	        btnNewButton_4.setBounds(732, 233, 128, 23);
	        panel.add(btnNewButton_4);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBounds(10, 156, 941, 48);
	        EliminarINv.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JLabel lblNewLabel_1 = new JLabel("Articulo a Eliminar");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblNewLabel_1.setBounds(395, 0, 210, 43);
	        panel_1.add(lblNewLabel_1);
	}

}
