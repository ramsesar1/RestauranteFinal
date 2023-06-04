import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class CrearCliente extends JFrame{

    private JPanel contentPane;
    private JTextField nametxt;
    private JTextField apellidotxt;
    private JTextField celtxt;
    private JTextField direcciontxt;


    public CrearCliente() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 977, 681);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Crear Cliente");
        lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 24));
        lblNewLabel_1.setBounds(428, 89, 311, 50);
        contentPane.add(lblNewLabel_1);

        JPanel panelCrear = new JPanel();
        panelCrear.setBounds(221, 150, 610, 426);
        contentPane.add(panelCrear);
        panelCrear.setLayout(null);

        JLabel name = new JLabel("Nombre");
        name.setFont(new Font("Arial Black", Font.PLAIN, 16));
        name.setBounds(10, 11, 121, 14);
        panelCrear.add(name);

        nametxt = new JTextField();
        nametxt.setBounds(10, 36, 454, 27);
        panelCrear.add(nametxt);
        nametxt.setColumns(10);

        apellidotxt = new JTextField();
        apellidotxt.setColumns(10);
        apellidotxt.setBounds(10, 129, 454, 27);
        panelCrear.add(apellidotxt);

        celtxt = new JTextField();
        celtxt.setColumns(10);
        celtxt.setBounds(10, 238, 276, 27);
        panelCrear.add(celtxt);

        direcciontxt = new JTextField();
        direcciontxt.setColumns(10);
        direcciontxt.setBounds(10, 337, 454, 27);
        panelCrear.add(direcciontxt);

        JLabel lblApellidos = new JLabel("Apellidos");
        lblApellidos.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblApellidos.setBounds(10, 104, 121, 14);
        panelCrear.add(lblApellidos);

        JLabel lblTelefono = new JLabel("Telefono");
        lblTelefono.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblTelefono.setBounds(10, 213, 121, 14);
        panelCrear.add(lblTelefono);

        JLabel lblDireccion = new JLabel("Direccion");
        lblDireccion.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblDireccion.setBounds(10, 312, 121, 14);
        panelCrear.add(lblDireccion);

        JButton btnCrear = new JButton("Crear Cliente");
        btnCrear.setFont(new Font("Arial Black", Font.PLAIN, 15));
        btnCrear.setBounds(444, 587, 147, 44);
        contentPane.add(btnCrear);
    }

}