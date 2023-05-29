import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class EditarPlatillo extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditarPlatillo frame = new EditarPlatillo();
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
    public EditarPlatillo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 977, 681);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel ConsultaPlatillos = new JPanel();
        ConsultaPlatillos.setBackground(new Color(255, 128, 0));
        contentPane.add(ConsultaPlatillos);
        ConsultaPlatillos.setLayout(null);

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Sushi empanizado");
        model.addElement("Hamburguesa");
        model.addElement("Lasagna");
        model.addElement("Pizza");
        model.addElement("Alitas");
                
                JLabel lblNewLabel = new JLabel("Consultar Platillos");
                lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
                lblNewLabel.setBounds(360, 11, 254, 52);
                ConsultaPlatillos.add(lblNewLabel);
                
                JPanel panel = new JPanel();
                panel.setBounds(37, 51, 877, 570);
                ConsultaPlatillos.add(panel);
                panel.setLayout(null);
                
                JPanel panel_1 = new JPanel();
                panel_1.setBackground(new Color(255, 255, 255));
                panel_1.setBounds(433, 5, 444, 565);
                panel.add(panel_1);
                panel_1.setLayout(null);
                
                JLabel lblNewLabel_2 = new JLabel("Detalles del platillo\r\n");
                lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
                lblNewLabel_2.setBounds(111, 11, 225, 61);
                panel_1.add(lblNewLabel_2);
                
                JLabel lblNewLabel_2_1 = new JLabel("Platillo: Sushi empanizado\r\n");
                lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
                lblNewLabel_2_1.setBounds(93, 111, 264, 61);
                panel_1.add(lblNewLabel_2_1);
                
                JLabel lblNewLabel_2_1_2 = new JLabel("Precio: $135");
                lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
                lblNewLabel_2_1_2.setBounds(150, 389, 132, 61);
                panel_1.add(lblNewLabel_2_1_2);
                
                JTextArea txtrDescripcinDescubreNuestro = new JTextArea();
                txtrDescripcinDescubreNuestro.setFont(new Font("Tahoma", Font.PLAIN, 19));
                txtrDescripcinDescubreNuestro.setTabSize(10);
                txtrDescripcinDescubreNuestro.setText("Descripción: Descubre nuestro irresistible sushi\r\nempanizado con aguacate y zanahoria: 12\r\npiezas con sabores frescos y deliciosos. Una\r\nexperiencia gastronónmica única que te dejará\r\n             deseando más.");
                txtrDescripcinDescubreNuestro.setBounds(22, 201, 399, 177);
                panel_1.add(txtrDescripcinDescubreNuestro);
                
                JPanel panel_3 = new JPanel();
                panel_3.setBackground(new Color(255, 128, 0));
                panel_3.setBounds(47, 459, 331, 70);
                panel_1.add(panel_3);
                panel_3.setLayout(null);
                
                JButton btnNewButton = new JButton("Ingredientes");
                btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
                btnNewButton.setBounds(10, 11, 311, 48);
                panel_3.add(btnNewButton);
                
                JPanel panel_2 = new JPanel();
                panel_2.setBackground(new Color(255, 128, 0));
                panel_2.setBounds(35, 40, 288, 519);
                panel.add(panel_2);
                
                JLabel lblNewLabel_1 = new JLabel("Seleccione platillo");
                lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
                lblNewLabel_1.setBounds(100, 5, 213, 36);
                panel.add(lblNewLabel_1);
                
                JButton btnNewButton_1 = new JButton("Back");
                btnNewButton_1.setBounds(10, 11, 44, 29);
                ConsultaPlatillos.add(btnNewButton_1);
                
              

    }
}
