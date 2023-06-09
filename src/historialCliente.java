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

public class historialCliente extends JFrame{

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    historialCliente window = new historialCliente();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

    /**
     * Create the application.
     */
    public historialCliente() {
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
                        {"Usuario #5", "Consultar"},
                        {"Usuario #4", "Consultar"},
                        {"Usuario #3", "Consultar"},
                        {"Usuario #2", "Consultar"},
                        {"Usuario #1", "Consultar"},
                },
                new String[] {
                        "Historia", "Direccion"
                }
        ));
        table.setBounds(181, 257, 606, 80);
        contentPane.add(table);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(181, 215, 606, 42);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Historial");
        lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblNewLabel.setBounds(86, 11, 115, 20);
        panel.add(lblNewLabel);

        JLabel lblDireccion = new JLabel("Direccion");
        lblDireccion.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblDireccion.setBounds(426, 11, 115, 20);
        panel.add(lblDireccion);

        JLabel lblNewLabel_1 = new JLabel("Consultar Clientes");
        lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(417, 137, 181, 50);
        contentPane.add(lblNewLabel_1);
    }

}