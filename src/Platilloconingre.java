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

public class Platilloconingre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Platilloconingre() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 977, 681);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel ConsultaIngredientes = new JPanel();
        ConsultaIngredientes.setBackground(new Color(255, 128, 0));
        contentPane.add(ConsultaIngredientes);
        ConsultaIngredientes.setLayout(null);

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Sushi empanizado");
        model.addElement("Hamburguesa");
        model.addElement("Lasagna");
        model.addElement("Pizza");
        model.addElement("Alitas");
                
        
        
        
        JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(10, 11, 52, 43);
		ConsultaIngredientes.add(btnNewButton);
        
        
                JLabel lblNewLabel = new JLabel("Ingredientes");
                lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
                lblNewLabel.setBounds(387, 11, 254, 52);
                ConsultaIngredientes.add(lblNewLabel);
                
                JPanel panel = new JPanel();
                panel.setBounds(37, 62, 877, 570);
                ConsultaIngredientes.add(panel);
                panel.setLayout(null);
                
                JPanel panel_1 = new JPanel();
                panel_1.setBackground(new Color(255, 255, 255));
                panel_1.setBounds(433, 5, 444, 565);
                panel.add(panel_1);
                panel_1.setLayout(null);
                
                JLabel lblNewLabel_2 = new JLabel("Detalles del Ingrediente\r\n");
                lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
                lblNewLabel_2.setBounds(63, 11, 357, 61);
                panel_1.add(lblNewLabel_2);
                
                JLabel lblNewLabel_2_1 = new JLabel("Ingrediente: Queso amarillo\r\n\r\n");
                lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
                lblNewLabel_2_1.setBounds(61, 111, 317, 61);
                panel_1.add(lblNewLabel_2_1);
                
                JTextArea txtrDescripcinDescubreNuestro = new JTextArea();
                txtrDescripcinDescubreNuestro.setFont(new Font("Tahoma", Font.PLAIN, 19));
                txtrDescripcinDescubreNuestro.setTabSize(10);
                txtrDescripcinDescubreNuestro.setText("Descripción: Queso imitación tipo chedar\r\n    en rebanadas, usado para hamburguesas.");
                txtrDescripcinDescubreNuestro.setBounds(22, 201, 399, 177);
                panel_1.add(txtrDescripcinDescubreNuestro);
                
                JPanel panel_3 = new JPanel();
                panel_3.setBackground(new Color(255, 128, 0));
                panel_3.setBounds(47, 459, 331, 70);
                panel_1.add(panel_3);
                panel_3.setLayout(null);
                
                JButton btnNewButton1 = new JButton("Platillos\r\n");
                btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 35));
                btnNewButton1.setBounds(10, 11, 311, 48);
                panel_3.add(btnNewButton1);
                
                JLabel lblNewLabel_2_1_1 = new JLabel("Consultar platillos con el ingrediente\r\n");
                lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
                lblNewLabel_2_1_1.setBounds(46, 389, 357, 61);
                panel_1.add(lblNewLabel_2_1_1);
                
                JPanel panel_2 = new JPanel();
                panel_2.setBackground(new Color(255, 128, 0));
                panel_2.setBounds(35, 40, 288, 519);
                panel.add(panel_2);
                panel_2.setLayout(null);
                
                JList list = new JList();
                list.setBounds(0, 449, 278, -448);
                panel_2.add(list);
                
                JButton btnNewButton_1 = new JButton("Queso amarillo\r\n");
                btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
                btnNewButton_1.setBounds(10, 12, 257, 39);
                panel_2.add(btnNewButton_1);
                
                JLabel lblNewLabel_1 = new JLabel("Seleccione ingrediente");
                lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
                lblNewLabel_1.setBounds(72, 5, 213, 36);
                panel.add(lblNewLabel_1);

    }
}
