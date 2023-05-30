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

public class editarCliente extends JFrame{

    private JFrame frame;
    private JTable table;

    public JPanel contentPane;

    /**
     * Launch the application.
     */


    /**
     * Create the application.
     */
    public editarCliente() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 977, 681);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"Cliente #5", "Editar"},
                        {"Cliente #4", "Editar"},
                        {"Cliente #3", "Editar"},
                        {"Cliente #2", "Editar"},
                        {"Cliente #1", "Editar"},
                },
                new String[] {
                        "Historia", "Direccion"
                }
        ));
        table.setBounds(181, 257, 606, 80);
        contentPane.add(table);

        JPanel panelEditar = new JPanel();
        panelEditar.setBackground(Color.GRAY);
        panelEditar.setBounds(181, 215, 606, 42);
        contentPane.add(panelEditar);
        panelEditar.setLayout(null);

        JLabel lblDireccion = new JLabel("Cliente a Editar");
        lblDireccion.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblDireccion.setBounds(225, 11, 182, 20);
        panelEditar.add(lblDireccion);

        JLabel lblNewLabel_1 = new JLabel("Consultar Clientes");
        lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(417, 137, 181, 50);
        contentPane.add(lblNewLabel_1);
    }


    public void mostrar(){
        contentPane.setVisible(true);
    }
}
