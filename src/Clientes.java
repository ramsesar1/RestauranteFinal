import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clientes extends JFrame {

	private JPanel contentPane;

	private JPanel panelClientes;

	private JPanel panelMini;

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public Clientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		panelClientes = new JPanel();
		contentPane.add(panelClientes);
		panelClientes.setLayout(null);

		panelMini = new JPanel();
		panelMini.setLayout(null);
		panelMini.setBackground(Color.WHITE);
		panelMini.setOpaque(false);
		panelMini.setBounds(60, 241, 827, 347);
		panelClientes.add(panelMini);

		JLabel clienteIcon = new JLabel(new ImageIcon("clientelogo2.jpeg"));
		clienteIcon.setBounds(0, 0, 951, 631);
		clienteIcon.setVisible(true);
		clienteIcon.setOpaque(true);
		panelClientes.add(clienteIcon);


		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsultar.setBackground(new Color(255, 128, 0));
		btnConsultar.setBounds(112, 95, 217, 60);
		btnConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				historialCliente consulta = new historialCliente();
				contentPane.add(consulta.getContentPane());
				contentPane.remove(panelClientes);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		panelMini.add(btnConsultar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditar.setBackground(new Color(255, 128, 0));
		btnEditar.setBounds(112, 198, 217, 60);
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				editarCliente editar = new editarCliente();
				contentPane.add(editar.getContentPane());
				contentPane.remove(panelClientes);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		panelMini.add(btnEditar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBackground(new Color(255, 128, 0));
		btnEliminar.setBounds(490, 198, 217, 60);
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarCliente eliminar = new eliminarCliente();
				contentPane.add(eliminar.getContentPane());
				contentPane.remove(panelClientes);
				contentPane.revalidate();
				contentPane.repaint();

			}
		});
		panelMini.add(btnEliminar);

		JButton btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCrear.setBackground(new Color(255, 128, 0));
		btnCrear.setBounds(490, 95, 217, 60);
		panelMini.add(btnCrear);

		btnCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CrearCliente crear = new CrearCliente();
				contentPane.add(crear.getContentPane());
				contentPane.remove(panelClientes);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});

		JLabel lblNewLabel = new JLabel("panelClientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(422, 0, 126, 55);
		panelClientes.add(lblNewLabel);
	}

	public void mostrar(){
		contentPane.setVisible(true);
	}
}