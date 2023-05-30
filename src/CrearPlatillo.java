import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class CrearPlatillo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public CrearPlatillo() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 977, 681);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel Crearplat = new JPanel();
        Crearplat.setBackground(new Color(250, 183, 133));
        Crearplat.setBounds(10, 51, 941, 548);
        contentPane.add(Crearplat);
        Crearplat.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(10, 41, 372, 33);
        Crearplat.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(10, 447, 372, 33);
        Crearplat.add(textField_1);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 234, 372, 147);
        Crearplat.add(textArea);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(10, 131, 372, 33);
        Crearplat.add(comboBox);
        
        JLabel lblNewLabel = new JLabel("Nombre del Platillo:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(10, 11, 242, 19);
        Crearplat.add(lblNewLabel);
        
        JLabel lblIngredientes = new JLabel("Ingredientes:\r\n");
        lblIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblIngredientes.setBounds(10, 85, 265, 37);
        Crearplat.add(lblIngredientes);
        
        JLabel lblDescripcin = new JLabel("Descripción:");
        lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDescripcin.setBounds(10, 190, 331, 33);
        Crearplat.add(lblDescripcin);
        
        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPrecio.setBounds(10, 403, 293, 33);
        Crearplat.add(lblPrecio);
        
        JButton btnCrearPlat = new JButton("Crear");
        btnCrearPlat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCrearPlat.setBackground(new Color(254, 211, 122));
        btnCrearPlat.setBounds(391, 494, 150, 43);
        Crearplat.add(btnCrearPlat);
        
        JButton btnAdjuntarImagen = new JButton("Adjuntar Imagen\r\n");
        btnAdjuntarImagen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAdjuntarImagen.setBackground(new Color(254, 211, 122));
        btnAdjuntarImagen.setBounds(691, 412, 211, 43);
        Crearplat.add(btnAdjuntarImagen);
        
        JLabel lblNewLabel_1 = new JLabel("Crear Platillo");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel_1.setBounds(398, 0, 227, 40);
        contentPane.add(lblNewLabel_1);
	}
}
