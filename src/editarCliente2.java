import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class editarCliente2 extends JFrame{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;


    public editarCliente2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 977, 681);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Cliente #5");
        lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 24));
        lblNewLabel_1.setBounds(428, 89, 311, 50);
        contentPane.add(lblNewLabel_1);

        JPanel panel = new JPanel();
        panel.setBounds(221, 150, 610, 426);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblNewLabel.setBounds(10, 11, 121, 14);
        panel.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(10, 36, 454, 27);
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(10, 129, 454, 27);
        panel.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(10, 238, 276, 27);
        panel.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(10, 337, 454, 27);
        panel.add(textField_3);

        JLabel lblApellidos = new JLabel("Apellidos");
        lblApellidos.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblApellidos.setBounds(10, 104, 121, 14);
        panel.add(lblApellidos);

        JLabel lblTelefono = new JLabel("Telefono");
        lblTelefono.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblTelefono.setBounds(10, 213, 121, 14);
        panel.add(lblTelefono);

        JLabel lblDireccion = new JLabel("Direccion");
        lblDireccion.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblDireccion.setBounds(10, 312, 121, 14);
        panel.add(lblDireccion);

        JButton btnNewButton = new JButton("Editar Cliente");
        btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
        btnNewButton.setBounds(444, 587, 147, 44);
        contentPane.add(btnNewButton);
    }

}