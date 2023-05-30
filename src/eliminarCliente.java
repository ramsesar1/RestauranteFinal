import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eliminarCliente extends JFrame {


    private JTable table;

    private JPanel contentPane;

    private JPanel panelEliminar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    eliminarCliente frame = new eliminarCliente();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public eliminarCliente() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 977, 681);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelEliminar = new JPanel();
        panelEliminar.setBackground(new Color(255, 128, 0));
        panelEliminar.setBounds(0, 0, 961, 642);
        contentPane.add(panelEliminar);
        panelEliminar.setLayout(null);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {"Cliente #5", "Eliminar"},
                        {"Cliente #4", "Eliminar"},
                        {"Cliente #3", "Eliminar"},
                        {"Cliente #2", "Eliminar"},
                        {"Cliente #1", "Eliminar"},
                },
                new String[]{
                        "Historia", "Direccion"
                }
        ));
        table.setBounds(181, 257, 606, 80);
        panelEliminar.add(table);

        JPanel panelsito = new JPanel();
        panelsito.setBackground(Color.GRAY);
        panelsito.setBounds(181, 215, 606, 42);
        panelsito.setLayout(null);
        panelEliminar.add(panelsito);

        JLabel lblTitulo = new JLabel("Cliente a Eliminar");
        lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblTitulo.setBounds(225, 11, 182, 20);
        panelsito.add(lblTitulo);

        JLabel lblEliminar = new JLabel("Eliminar Clientes");
        lblEliminar.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblEliminar.setBounds(417, 137, 181, 50);
        panelEliminar.add(lblEliminar);

        JButton btnAtras = new JButton("Atras");
        btnAtras.setBounds(10, 28, 75, 23);
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clientes clienteInicio = new Clientes();
                contentPane.remove(panelEliminar);
                contentPane.add(clienteInicio.getContentPane());
                contentPane.revalidate();
                contentPane.repaint();


            }
        });
        panelEliminar.add(btnAtras);
    }

    public void mostrar(){
        panelEliminar.setVisible(true);
    }
}


