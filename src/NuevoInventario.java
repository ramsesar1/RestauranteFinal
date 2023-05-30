import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class NuevoInventario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoInventario frame = new NuevoInventario();
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
	public NuevoInventario() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 977, 681);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        
	        JPanel NuevoArticulo = new JPanel();
	        NuevoArticulo.setBackground(new Color(255, 128, 0));
	        NuevoArticulo.setBounds(0, 0, 961, 642);
	        contentPane.add(NuevoArticulo);
	        NuevoArticulo.setLayout(null);
	        
	        
	        JButton btnNewButton = new JButton("Back");
	     			btnNewButton.setBounds(10, 11, 52, 43);
	     			NuevoArticulo.add(btnNewButton);
	     			
	     			JLabel lblNewLabel = new JLabel("Nuevo Articulo\r\n");
	     			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
	     			lblNewLabel.setBounds(393, 11, 311, 48);
	     			NuevoArticulo.add(lblNewLabel);
	     			
	     			JPanel panel = new JPanel();
	     			panel.setBackground(new Color(255, 218, 168));
	     			panel.setBounds(10, 104, 941, 473);
	     			NuevoArticulo.add(panel);
	     			panel.setLayout(null);
	     			
	     			JLabel lblNewLabel_1 = new JLabel("Nombre del articulo:");
	     			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	     			lblNewLabel_1.setBounds(358, 23, 250, 43);
	     			panel.add(lblNewLabel_1);
	     			
	     			textField = new JTextField();
	     			textField.setBounds(358, 62, 238, 33);
	     			panel.add(textField);
	     			textField.setColumns(10);
	     			
	     			JLabel lblNewLabel_1_1 = new JLabel("Tipo de unidad:");
	     			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	     			lblNewLabel_1_1.setBounds(358, 106, 250, 43);
	     			panel.add(lblNewLabel_1_1);
	     			
	     			JComboBox comboBox = new JComboBox();
	     			comboBox.setBounds(358, 143, 238, 30);
	     			panel.add(comboBox);
	     			
	     			JLabel lblNewLabel_1_1_1 = new JLabel("Color del widget:");
	     			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	     			lblNewLabel_1_1_1.setBounds(358, 184, 250, 43);
	     			panel.add(lblNewLabel_1_1_1);
	     			
	     			JComboBox comboBox_1 = new JComboBox();
	     			comboBox_1.setBounds(358, 221, 238, 30);
	     			panel.add(comboBox_1);
	     			
	     			JLabel lblNewLabel_1_2 = new JLabel("Cantidad:");
	     			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	     			lblNewLabel_1_2.setBounds(358, 276, 250, 43);
	     			panel.add(lblNewLabel_1_2);
	     			
	     			textField_1 = new JTextField();
	     			textField_1.setColumns(10);
	     			textField_1.setBounds(358, 315, 238, 33);
	     			panel.add(textField_1);
	     			
	     			JButton btnNewButton_1 = new JButton("Crear");
	     			btnNewButton_1.setBackground(new Color(255, 128, 64));
	     			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	     			btnNewButton_1.setBounds(411, 419, 124, 43);
	     			panel.add(btnNewButton_1);
	        
	}
}
