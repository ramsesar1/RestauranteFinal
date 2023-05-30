import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Restaurante extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField contras;
	private JLabel lblContrasea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurante frame = new Restaurante();
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
	public Restaurante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		//--------------------------------------panel Login----------------------------------------------------
		
		
		JPanel login = new JPanel();
		contentPane.add(login);
		login.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(273, 205, 391, 313);
		login.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(30, 57, 328, 45);
		panel_1.add(textField);
		
		contras = new JPasswordField();
		contras.setColumns(10);
		contras.setBounds(30, 180, 328, 45);
		panel_1.add(contras);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(30, 26, 149, 28);
		panel_1.add(lblNewLabel);
		
		lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(30, 142, 149, 28);
		panel_1.add(lblContrasea);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(30, 236, 110, 45);
		panel_1.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setBounds(248, 236, 110, 45);
		panel_1.add(btnCancelar);
		
		
		
		
		//--------------------------------------panel menu inicio----------------------------------------------------

		
		JPanel inicio = new JPanel();

		//--------------------------------------------platillos---------------------------------------------------------
		//--------------------------------------------ordenes-----------------------------------------------------------
		//--------------------------------------------inventario--------------------------------------------------------
		//--------------------------------------------clientes----------------------------------------------------------
		//pantalla clientes principal
		/*
		JPanel panelClientes = new JPanel();
		contentPane.add(panelClientes);
		panelClientes.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(60, 241, 827, 347);
		panelClientes.add(panel);*/

		//pantalla creacion clientes
		/*JPanel panel = new JPanel();
		panel.setBounds(221, 150, 610, 426);
		frame.getContentPane().add(panel);
		panel.setLayout(null);*/

		//pantalla edicion de cliente
		/*JPanel panel = new JPanel();
		panel.setBounds(221, 150, 610, 426);
		frame.getContentPane().add(panel);
		panel.setLayout(null);*/

		//pantalla seleccion editar cliente
		/*JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(181, 215, 606, 42);
		frame.getContentPane().add(panel);
		panel.setLayout(null);*/



		
		
		
		
		
		
		
		
		
		
	}
}
