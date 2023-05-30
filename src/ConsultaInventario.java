import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class ConsultaInventario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaInventario frame = new ConsultaInventario();
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
	public ConsultaInventario() {
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 977, 681);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	        setContentPane(contentPane);
	        contentPane.setLayout(new GridLayout(0, 1, 0, 0));
	        
	        JPanel ConsultaInv = new JPanel();
	        ConsultaInv.setBackground(new Color(255, 128, 0));
	        contentPane.add(ConsultaInv);
	        ConsultaInv.setLayout(null);
	        
	        
	        JButton btnNewButton = new JButton("Back");
			btnNewButton.setBounds(10, 11, 52, 43);
			ConsultaInv.add(btnNewButton);
	        
	        
	        JLabel lblNewLabel = new JLabel("Consultar Inventario");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
	        lblNewLabel.setBackground(new Color(128, 128, 0));
	        lblNewLabel.setForeground(new Color(0, 0, 0));
	        lblNewLabel.setBounds(331, 23, 243, 58);
	        ConsultaInv.add(lblNewLabel);
	        
	        JLabel lblNewLabel_1 = new JLabel("Articulos por agotarse\r\n");
	        lblNewLabel_1.setForeground(new Color(255, 255, 255));
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblNewLabel_1.setBounds(354, 74, 279, 29);
	        ConsultaInv.add(lblNewLabel_1);
	        
	        JPanel panel = new JPanel();
	        panel.setBounds(34, 129, 197, 58);
	        ConsultaInv.add(panel);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBounds(265, 129, 197, 58);
	        ConsultaInv.add(panel_1);
	        
	        JPanel panel_1_1 = new JPanel();
	        panel_1_1.setBounds(729, 129, 197, 58);
	        ConsultaInv.add(panel_1_1);
	        
	        JPanel panel_2 = new JPanel();
	        panel_2.setBounds(498, 129, 197, 58);
	        ConsultaInv.add(panel_2);
	        
	        JPanel panel_3 = new JPanel();
	        panel_3.setBounds(34, 277, 892, 36);
	        ConsultaInv.add(panel_3);
	        panel_3.setLayout(new GridLayout(0, 3, 0, 0));
	        
	        JLabel lblNewLabel_2 = new JLabel("Articulo");
	        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        panel_3.add(lblNewLabel_2);
	        
	        JLabel lblNewLabel_2_1 = new JLabel("Unidad");
	        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        panel_3.add(lblNewLabel_2_1);
	        
	        JLabel lblNewLabel_2_2 = new JLabel("Cantidad");
	        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        panel_3.add(lblNewLabel_2_2);
	        
	        JPanel panel_4 = new JPanel();
	        panel_4.setBackground(new Color(255, 218, 168));
	        panel_4.setBounds(34, 312, 892, 257);
	        ConsultaInv.add(panel_4);
	}
}
