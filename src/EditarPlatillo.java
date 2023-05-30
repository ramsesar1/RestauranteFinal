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

public class EditarPlatillo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public EditarPlatillo() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 977, 681);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);


        JPanel EditarPlat = new JPanel();
        EditarPlat.setBackground(new Color(250, 183, 133));
        EditarPlat.setBounds(10, 51, 941, 548);
        contentPane.add(EditarPlat);
        EditarPlat.setLayout(null);

        textField = new JTextField();
        textField.setBounds(10, 41, 372, 33);
        EditarPlat.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(10, 447, 372, 33);
        EditarPlat.add(textField_1);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 234, 372, 147);
        EditarPlat.add(textArea);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(10, 131, 372, 33);
        EditarPlat.add(comboBox);

        JLabel lblNewLabel = new JLabel("Nombre del Platillo:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(10, 11, 242, 19);
        EditarPlat.add(lblNewLabel);

        JLabel lblIngredientes = new JLabel("Ingredientes:\r\n");
        lblIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblIngredientes.setBounds(10, 85, 265, 37);
        EditarPlat.add(lblIngredientes);

        JLabel lblDescripcin = new JLabel("Descripción:");
        lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDescripcin.setBounds(10, 190, 331, 33);
        EditarPlat.add(lblDescripcin);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPrecio.setBounds(10, 403, 293, 33);
        EditarPlat.add(lblPrecio);

        JButton btnEditarPlat = new JButton("Editar\r\n");
        btnEditarPlat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnEditarPlat.setBackground(new Color(254, 211, 122));
        btnEditarPlat.setBounds(391, 494, 150, 43);
        EditarPlat.add(btnEditarPlat);

        JButton btnAdjuntarImagen = new JButton("Adjuntar Imagen\r\n");
        btnAdjuntarImagen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAdjuntarImagen.setBackground(new Color(254, 211, 122));
        btnAdjuntarImagen.setBounds(691, 412, 211, 43);
        EditarPlat.add(btnAdjuntarImagen);

        JLabel lblNewLabel_1 = new JLabel("Editar Platillo");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel_1.setBounds(428, 11, 277, 29);
        contentPane.add(lblNewLabel_1);
	}
}
