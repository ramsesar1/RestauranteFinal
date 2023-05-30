package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

public class Ingredientes extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ingredientes frame = new Ingredientes();
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
    public Ingredientes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 977, 681);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel Platillosconingre = new JPanel();
        Platillosconingre.setBackground(new Color(255, 128, 0));
        contentPane.add(Platillosconingre);
        Platillosconingre.setLayout(null);

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Sushi empanizado");
        model.addElement("Hamburguesa");
        model.addElement("Lasagna");
        model.addElement("Pizza");
        model.addElement("Alitas");

        JButton btnNewButton = new JButton("Back");
        btnNewButton.setBounds(10, 11, 52, 43);
        Platillosconingre.add(btnNewButton);



        JLabel lblNewLabel = new JLabel("Ingredientes");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel.setBounds(403, 0, 316, 52);
        Platillosconingre.add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBounds(37, 62, 877, 559);
        Platillosconingre.add(panel);
        panel.setLayout(null);



        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(433, 5, 444, 565);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Detalles de Ingredientes");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel_2.setBounds(57, 11, 357, 61);
        panel_1.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("Ingrediente: Queso amarillo");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblNewLabel_2_1.setBounds(61, 111, 317, 61);
        panel_1.add(lblNewLabel_2_1);

        JTextArea txtrDescripcinQuesoImitacin = new JTextArea();
        txtrDescripcinQuesoImitacin.setFont(new Font("Tahoma", Font.PLAIN, 17));
        txtrDescripcinQuesoImitacin.setText("Descripción: Queso imitación tipo chedar en rebanadas,\r\n usado para hamburguesas.");
        txtrDescripcinQuesoImitacin.setBounds(66, 228, 312, 249);
        panel_1.add(txtrDescripcinQuesoImitacin);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 128, 0));
        panel_2.setBounds(35, 40, 288, 519);
        panel.add(panel_2);
        panel_2.setLayout(null);

        JButton btnNewButton_1 = new JButton("Queso amarillo\r\n");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1.setBounds(10, 11, 268, 53);
        panel_2.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("Queso mozarella");
        btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1_1.setBounds(10, 75, 268, 53);
        panel_2.add(btnNewButton_1_1);

        JButton btnNewButton_1_2 = new JButton("Hamburguesa\r\n");
        btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1_2.setBounds(10, 75, 268, 53);
        panel_2.add(btnNewButton_1_2);

        JButton btnNewButton_1_2_1 = new JButton("Salsa de tomate");
        btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1_2_1.setBounds(10, 203, 268, 53);
        panel_2.add(btnNewButton_1_2_1);

        JButton btnNewButton_1_3 = new JButton("Tomate");
        btnNewButton_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1_3.setBounds(10, 139, 268, 53);
        panel_2.add(btnNewButton_1_3);

        JButton btnNewButton_1_2_2 = new JButton("Camarones");
        btnNewButton_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1_2_2.setBounds(10, 331, 268, 53);
        panel_2.add(btnNewButton_1_2_2);

        JButton btnNewButton_1_4 = new JButton("Pepperoni");
        btnNewButton_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1_4.setBounds(10, 267, 268, 53);
        panel_2.add(btnNewButton_1_4);

        JButton btnNewButton_1_4_1 = new JButton("Arroz");
        btnNewButton_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1_4_1.setBounds(10, 395, 268, 53);
        panel_2.add(btnNewButton_1_4_1);

        JButton btnNewButton_1_2_2_1 = new JButton("Harina de trigo");
        btnNewButton_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1_2_2_1.setBounds(10, 459, 268, 53);
        panel_2.add(btnNewButton_1_2_2_1);

        JLabel lblNewLabel_1 = new JLabel("Platillos con el ingrediente");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(72, 5, 213, 36);
        panel.add(lblNewLabel_1);

    }
}
