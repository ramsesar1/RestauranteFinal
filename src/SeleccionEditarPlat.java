import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;

public class SeleccionEditarPlat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionEditarPlat frame = new SeleccionEditarPlat();
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
	public SeleccionEditarPlat() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 977, 681);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel Editarplatillos = new JPanel();
        Editarplatillos.setBounds(0, 0, 961, 642);
        Editarplatillos.setBackground(new Color(255, 128, 0));
        contentPane.add(Editarplatillos);
        Editarplatillos.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Editar Platillos");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel.setBounds(373, 77, 223, 50);
        Editarplatillos.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Platillo a Editar\r\n");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel_1.setBounds(380, 195, 279, 43);
        Editarplatillos.add(lblNewLabel_1);
        
        JList list = new JList();
        list.setBounds(228, 233, 463, 228);
        Editarplatillos.add(list);
	}

}
