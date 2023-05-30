import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;

import java.awt.BorderLayout;
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

		//JPanel de ventanas definidos

		JPanel Inicio = new JPanel();
		JPanel Platillos = new JPanel();
		JPanel ConsultaPlatillos = new JPanel();


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
				remove(login);
				add(Inicio);
				repaint();
				revalidate();
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



		//contentPane.add(Inicio);
		Inicio.setLayout(null);

		JPanel panelmenu = new JPanel();
		panelmenu.setBackground(new Color(255, 255, 255));
		panelmenu.setBounds(124, 33, 692, 539);
		Inicio.add(panelmenu);
		panelmenu.setLayout(null);

		JButton btnplatillos = new JButton("Platillos\r\n");
		btnplatillos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnplatillos.setBackground(new Color(255, 128, 0));
		btnplatillos.setBounds(53, 22, 279, 234);
		panelmenu.add(btnplatillos);

		btnplatillos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Inicio);
				add(Platillos);
				repaint();
				revalidate();
			}
		});




		JButton btnNewButtonclientes = new JButton("Clientes\r\n");
		btnNewButtonclientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonclientes.setBackground(new Color(255, 128, 0));
		btnNewButtonclientes.setBounds(53, 279, 279, 234);
		panelmenu.add(btnNewButtonclientes);

		JButton btnNewButton_3 = new JButton("Inventario\r\n");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBackground(new Color(255, 128, 0));
		btnNewButton_3.setBounds(364, 279, 279, 234);
		panelmenu.add(btnNewButton_3);

		JButton btnNewButton_2 = new JButton("Ordenes\r\n");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBackground(new Color(255, 128, 0));
		btnNewButton_2.setBounds(364, 22, 279, 234);
		panelmenu.add(btnNewButton_2);





		//--------------------------------------------platillos---------------------------------------------------------


		//----Menu principal de platillos-----


//		contentPane.add(Platillos);
		Platillos.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(61, 241, 827, 347);
		Platillos.add(panel);
		panel.setLayout(null);

		JButton btnconsultar = new JButton("Consultar");
		btnconsultar.setBackground(new Color(255, 128, 0));
		btnconsultar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnconsultar.setBounds(61, 94, 217, 60);
		panel.add(btnconsultar);

		btnconsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Platillos);
				add(ConsultaPlatillos);
				repaint();
				revalidate();
			}
		});

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

		JLabel lblplatillos = new JLabel("Platillos\r\n");
		lblplatillos.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblplatillos.setBounds(421, 11, 186, 41);
		Platillos.add(lblplatillos);

		JButton backplatillos = new JButton("Back");
		backplatillos.setBounds(10, 11, 44, 29);
		Platillos.add(backplatillos);

		backplatillos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Platillos);
				add(Inicio);
				repaint();
				revalidate();
			}
		});

		//----Consultar platillos-----



        ConsultaPlatillos.setBackground(new Color(255, 128, 0));
   //     contentPane.add(ConsultaPlatillos);
        ConsultaPlatillos.setLayout(null);

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Sushi empanizado");
        model.addElement("Hamburguesa");
        model.addElement("Lasagna");
        model.addElement("Pizza");
        model.addElement("Alitas");

                JLabel lblconsultaplatillos = new JLabel("Consultar Platillos");
                lblconsultaplatillos.setFont(new Font("Tahoma", Font.PLAIN, 26));
                lblconsultaplatillos.setBounds(360, 11, 254, 52);
                ConsultaPlatillos.add(lblconsultaplatillos);

                JPanel panelplati = new JPanel();
                panelplati.setBounds(37, 51, 877, 570);
                ConsultaPlatillos.add(panelplati);
                panelplati.setLayout(null);

                JPanel panelplati_1 = new JPanel();
                panelplati_1.setBackground(new Color(255, 255, 255));
                panelplati_1.setBounds(433, 5, 444, 565);
                panelplati.add(panelplati_1);
                panelplati_1.setLayout(null);

                JLabel lblNewLabel_2 = new JLabel("Detalles del platillo\r\n");
                lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
                lblNewLabel_2.setBounds(111, 11, 225, 61);
                panelplati_1.add(lblNewLabel_2);

                JLabel lblNewLabel_2_1 = new JLabel("Platillo: Sushi empanizado\r\n");
                lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
                lblNewLabel_2_1.setBounds(93, 111, 264, 61);
                panelplati_1.add(lblNewLabel_2_1);

                JLabel lblNewLabel_2_1_2 = new JLabel("Precio: $135");
                lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
                lblNewLabel_2_1_2.setBounds(150, 389, 132, 61);
                panelplati_1.add(lblNewLabel_2_1_2);

                JTextArea txtrDescripcinDescubreNuestro = new JTextArea();
                txtrDescripcinDescubreNuestro.setFont(new Font("Tahoma", Font.PLAIN, 19));
                txtrDescripcinDescubreNuestro.setTabSize(10);
                txtrDescripcinDescubreNuestro.setText("Descripción: Descubre nuestro irresistible sushi\r\nempanizado con aguacate y zanahoria: 12\r\npiezas con sabores frescos y deliciosos. Una\r\nexperiencia gastronónmica única que te dejará\r\n             deseando más.");
                txtrDescripcinDescubreNuestro.setBounds(22, 201, 399, 177);
                panelplati_1.add(txtrDescripcinDescubreNuestro);

                JPanel panel_3 = new JPanel();
                panel_3.setBackground(new Color(255, 128, 0));
                panel_3.setBounds(47, 459, 331, 70);
                panelplati_1.add(panel_3);
                panel_3.setLayout(null);

                JButton btnIngredientes2 = new JButton("Ingredientes");
                btnIngredientes2.setFont(new Font("Tahoma", Font.PLAIN, 35));
                btnIngredientes2.setBounds(10, 11, 311, 48);
                panel_3.add(btnIngredientes2);

                JPanel panel_2 = new JPanel();
                panel_2.setBackground(new Color(255, 128, 0));
                panel_2.setBounds(35, 40, 288, 519);
                panelplati.add(panel_2);

                JLabel lblNewLabel_1 = new JLabel("Seleccione platillo");
                lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
                lblNewLabel_1.setBounds(100, 5, 213, 36);
                panelplati.add(lblNewLabel_1);

                JButton btnbackconsultaplat = new JButton("Back");
                btnbackconsultaplat.setBounds(10, 11, 44, 29);
                ConsultaPlatillos.add(btnbackconsultaplat);

		btnbackconsultaplat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(ConsultaPlatillos);
				add(Platillos);
				repaint();
				revalidate();
			}
		});

		//----Editar Platillos-----

		/*
		JPanel EditarPlat = new JPanel();
        EditarPlat.setBackground(new Color(250, 183, 133));
        EditarPlat.setBounds(10, 51, 941, 548);
        contentPane.add(EditarPlat);
        EditarPlat.setLayout(null);

        textField = new JTextField();
        textField.setBounds(10, 41, 372, 33);
        EditarPlat.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(10, 447, 372, 33);
        EditarPlat.add(textField_1);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 234, 372, 147);
        EditarPlat.add(textArea);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(10, 131, 372, 33);
        EditarPlat.add(comboBox);

        JLabel lblNewLabel = new JLabel("Nombre del Platillo:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(10, 11, 242, 19);
        EditarPlat.add(lblNewLabel);

        JLabel lblIngredientes = new JLabel("Ingredientes:\r\n");
        lblIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblIngredientes.setBounds(10, 85, 265, 37);
        EditarPlat.add(lblIngredientes);

        JLabel lblDescripcin = new JLabel("Descripción:");
        lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDescripcin.setBounds(10, 190, 331, 33);
        EditarPlat.add(lblDescripcin);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPrecio.setBounds(10, 403, 293, 33);
        EditarPlat.add(lblPrecio);

        JButton btnEditarPlat = new JButton("Editar\r\n");
        btnEditarPlat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnEditarPlat.setBackground(new Color(254, 211, 122));
        btnEditarPlat.setBounds(391, 494, 150, 43);
        EditarPlat.add(btnEditarPlat);

        JButton btnAdjuntarImagen = new JButton("Adjuntar Imagen\r\n");
        btnAdjuntarImagen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAdjuntarImagen.setBackground(new Color(254, 211, 122));
        btnAdjuntarImagen.setBounds(691, 412, 211, 43);
        EditarPlat.add(btnAdjuntarImagen);

        JLabel lblNewLabel_1 = new JLabel("Editar Platillo");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel_1.setBounds(428, 11, 277, 29);
        contentPane.add(lblNewLabel_1);

		 */




		//----Crear Platillos-----

		/*
		JPanel Crearplat = new JPanel();
        Crearplat.setBackground(new Color(250, 183, 133));
        Crearplat.setBounds(10, 51, 941, 548);
        contentPane.add(Crearplat);
        Crearplat.setLayout(null);

        textField = new JTextField();
        textField.setBounds(10, 41, 372, 33);
        Crearplat.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(10, 447, 372, 33);
        Crearplat.add(textField_1);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 234, 372, 147);
        Crearplat.add(textArea);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(10, 131, 372, 33);
        Crearplat.add(comboBox);

        JLabel lblNewLabel = new JLabel("Nombre del Platillo:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(10, 11, 242, 19);
        Crearplat.add(lblNewLabel);

        JLabel lblIngredientes = new JLabel("Ingredientes:\r\n");
        lblIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblIngredientes.setBounds(10, 85, 265, 37);
        Crearplat.add(lblIngredientes);

        JLabel lblDescripcin = new JLabel("Descripción:");
        lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDescripcin.setBounds(10, 190, 331, 33);
        Crearplat.add(lblDescripcin);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPrecio.setBounds(10, 403, 293, 33);
        Crearplat.add(lblPrecio);

        JButton btnCrearPlat = new JButton("Crear");
        btnCrearPlat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCrearPlat.setBackground(new Color(254, 211, 122));
        btnCrearPlat.setBounds(391, 494, 150, 43);
        Crearplat.add(btnCrearPlat);

        JButton btnAdjuntarImagen = new JButton("Adjuntar Imagen\r\n");
        btnAdjuntarImagen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAdjuntarImagen.setBackground(new Color(254, 211, 122));
        btnAdjuntarImagen.setBounds(691, 412, 211, 43);
        Crearplat.add(btnAdjuntarImagen);

        JLabel lblNewLabel_1 = new JLabel("Crear Platillo");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel_1.setBounds(398, 0, 227, 40);
        contentPane.add(lblNewLabel_1);




		 */




		//----Platillos ingredientes-----
/*




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
 */

		//----Eliminar Platillos-----



		/*
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


		 */



		//--------------------------------------------ordenes-----------------------------------------------------------














		//--------------------------------------------inventario--------------------------------------------------------






		//--------------------------------------------clientes----------------------------------------------------------
		//-----pantalla clientes principal-----
		/*
		JPanel panelClientes = new JPanel();
		contentPane.add(panelClientes);
		panelClientes.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(60, 241, 827, 347);
		panelClientes.add(panel);*/

		//-----pantalla creacion clientes-----
		/*JPanel panel = new JPanel();
		panel.setBounds(221, 150, 610, 426);
		frame.getContentPane().add(panel);
		panel.setLayout(null);*/

		//------pantalla edicion de cliente------
		/*JPanel panel = new JPanel();
		panel.setBounds(221, 150, 610, 426);
		frame.getContentPane().add(panel);
		panel.setLayout(null);*/

		//-----pantalla seleccion editar cliente-----
		/*JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(181, 215, 606, 42);
		frame.getContentPane().add(panel);
		panel.setLayout(null);*/

		//-----pantalla consulta de clientes-----
		/*JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(181, 215, 606, 42);
		frame.getContentPane().add(panel);
		panel.setLayout(null);*/

		//----pantalla eliminar clientes----
		/* JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(181, 215, 606, 42);
        frame.getContentPane().add(panel);

        panel.setLayout(null);
        
        //----pantalla principal ordenes----
        JPanel PanelOrdenes = new JPanel();
		contentPane.add(PanelOrdenes);
		PanelOrdenes.setLayout(null);

		JPanel PanelOrdenes1 = new JPanel();
		PanelOrdenes1 .setLayout(null);
		PanelOrdenes1 .setBackground(Color.WHITE);
		PanelOrdenes1 .setBounds(60, 241, 827, 347);
		PanelOrdenes.add(PanelOrdenes1 );
        
        //----pantalla consultar ordenes----
        JPanel ConsultarOrden = new JPanel();
		ConsultarOrden.setBackground(new Color(255, 69, 0));
		frame.getContentPane().add(ConsultarOrden, BorderLayout.CENTER);
		ConsultarOrden.setLayout(null);
		
		//----pantalla crear ordenes----
		JPanel CrearOrden = new JPanel();
		CrearOrden.setBackground(new Color(255, 69, 0));
		frame.getContentPane().add(CrearOrden, BorderLayout.CENTER);
		CrearOrden.setLayout(null);
		
		//----pantalla editar ordenes----
		JPanel EditarOrdenes = new JPanel();
		EditarOrdenes.setBackground(new Color(255, 69, 0));
		frame.getContentPane().add(EditarOrdenes, BorderLayout.CENTER);
		EditarOrdenes.setLayout(null);
		
		//----pantalla eliminar ordenes----
		JPanel EliminarOrden = new JPanel();
		EliminarOrden.setBackground(new Color(255, 69, 0));
		frame.getContentPane().add(EliminarOrden, BorderLayout.CENTER);
		EliminarOrden.setLayout(null);
      
       
       
    
        
        */

       



		
		
		
		
		
		
		
		
		
		
	}
}
