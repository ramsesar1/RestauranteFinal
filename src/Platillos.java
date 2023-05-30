import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class Platillos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Platillos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));


		JPanel Platillos = new JPanel();
		contentPane.add(Platillos);
		Platillos.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(61, 241, 827, 347);
		Platillos.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBackground(new Color(255, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(61, 94, 217, 60);
		panel.add(btnNewButton);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditar.setBackground(new Color(255, 128, 0));
		btnEditar.setBounds(307, 94, 217, 60);
		panel.add(btnEditar);
		
		JButton btnIngredientes = new JButton("Ingredientes");
		btnIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIngredientes.setBackground(new Color(255, 128, 0));
		btnIngredientes.setBounds(183, 197, 217, 60);
		panel.add(btnIngredientes);
		
		JButton btnNewButton_1_1 = new JButton("Eliminar");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setBackground(new Color(255, 128, 0));
		btnNewButton_1_1.setBounds(439, 197, 217, 60);
		panel.add(btnNewButton_1_1);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCrear.setBackground(new Color(255, 128, 0));
		btnCrear.setBounds(548, 94, 217, 60);
		panel.add(btnCrear);
		
		JLabel lblNewLabel = new JLabel("Platillos\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(421, 11, 186, 41);
		Platillos.add(lblNewLabel);
	}
}
