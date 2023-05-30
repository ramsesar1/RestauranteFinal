import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;

public class EliminarPlatillo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarPlatillo frame = new EliminarPlatillo();
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
	public EliminarPlatillo() {
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 977, 681);
	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(255, 128, 0));
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        
	        JPanel ElimPlatillos = new JPanel();
	        ElimPlatillos.setBackground(new Color(255, 128, 0));
	        ElimPlatillos.setBounds(0, 0, 961, 642);
	        contentPane.add(ElimPlatillos);
	        ElimPlatillos.setLayout(null);
	        
	        JLabel lblEliminarPlatillos = new JLabel("Eliminar Platillos");
	        lblEliminarPlatillos.setFont(new Font("Tahoma", Font.PLAIN, 26));
	        lblEliminarPlatillos.setBounds(359, 80, 223, 50);
	        ElimPlatillos.add(lblEliminarPlatillos);
	        
	        JList list = new JList();
	        list.setBounds(230, 234, 463, 228);
	        ElimPlatillos.add(list);
	        
	        JLabel lblNewLabel_1 = new JLabel("Platillo a Eliminar");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
	        lblNewLabel_1.setBounds(376, 200, 279, 43);
	        ElimPlatillos.add(lblNewLabel_1);

	        
	}

}
