import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Menuinicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menuinicio frame = new Menuinicio();
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
	public Menuinicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel Inicio = new JPanel();
		contentPane.add(Inicio);
		Inicio.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(124, 33, 692, 539);
		Inicio.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Platillos\r\n");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBackground(new Color(255, 128, 0));
		btnNewButton_1.setBounds(53, 22, 279, 234);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Clientes\r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(255, 128, 0));
		btnNewButton.setBounds(53, 279, 279, 234);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Inventario\r\n");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBackground(new Color(255, 128, 0));
		btnNewButton_3.setBounds(364, 279, 279, 234);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Ordenes\r\n");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBackground(new Color(255, 128, 0));
		btnNewButton_2.setBounds(364, 22, 279, 234);
		panel_1.add(btnNewButton_2);
	}

}
