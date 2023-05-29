import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;

public class editarCliente {

    private JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    editarCliente window = new editarCliente();
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
    public editarCliente() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 116, 38));
        frame.setBounds(100, 100, 977, 681);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

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
        frame.getContentPane().add(table);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(181, 215, 606, 42);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblDireccion = new JLabel("Cliente a Editar");
        lblDireccion.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblDireccion.setBounds(225, 11, 182, 20);
        panel.add(lblDireccion);

        JLabel lblNewLabel_1 = new JLabel("Consultar Clientes");
        lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(417, 137, 181, 50);
        frame.getContentPane().add(lblNewLabel_1);
    }
}
