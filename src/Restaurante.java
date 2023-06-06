import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.NumberFormatter;
import javax.swing.text.PlainDocument;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.sql.*;


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

		//clientes
		JPanel EliminarClientes = new JPanel();
		JPanel Clientes = new JPanel();
		JPanel ConsultaClientes = new JPanel();
		JPanel EditarClientes = new JPanel();
		JPanel EditarTabla = new JPanel();
		JPanel CrearClientes = new JPanel();
		JPanel InfoCliente = new JPanel();


		//platillos
		JPanel Platillos = new JPanel();
		JPanel ConsultaPlatillos = new JPanel();
		JPanel EditarPlat = new JPanel();
		JPanel Crearplat = new JPanel();
		JPanel Platillosconingre = new JPanel();
		JPanel ElimPlatillos = new JPanel();


		//Ordenes
		JPanel Ordenes= new JPanel();
		JPanel ConsultarOrden = new JPanel();
		JPanel EditarOrden = new JPanel();
		JPanel CrearOrden = new JPanel();
		JPanel EliminarOrden= new JPanel();
		JPanel EditarTablaOrd = new JPanel();



		//inventarios
		JPanel Inventario = new JPanel();
		JPanel ConsultaInv = new JPanel();
		JPanel EditarINv = new JPanel();
		JPanel EliminarINv = new JPanel();
		JPanel NuevoArticulo = new JPanel();


		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		//--------------------------------------panel Login----------------------------------------------------


		JPanel login = new JPanel();
		contentPane.add(login);
		login.setLayout(null);



		JLabel menufondito = new JLabel(new ImageIcon("Menufondo.png"));
		menufondito.setBounds(0, 0, 977, 681);
		menufondito.setLayout(null);
		login.add(menufondito);

		JLabel logotipo = new JLabel(new ImageIcon("iconochido.gif"));
		logotipo.setBounds(390,0,120,150);
		menufondito.add(logotipo);

		JLabel nombreLogo = new JLabel("RamSausage");
		nombreLogo.setFont((new Font("Roboto", Font.ITALIC, 40)));
		nombreLogo.setForeground(Color.decode("#AB0F0A"));
		nombreLogo.setBounds(350,145,350,60);
		menufondito.add(nombreLogo);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(273, 205, 391, 313);
		menufondito.add(panel_1);
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
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setBounds(226, 236, 130, 45);
		panel_1.add(btnCancelar);


		//--------------------------------------panel menu inicio----------------------------------------------------


		//contentPane.add(Inicio);
		Inicio.setLayout(null);


		JLabel menufondito2 = new JLabel(new ImageIcon("Menufondo.png"));
		menufondito2.setBounds(0, 0, 977, 681);
		menufondito2.setLayout(null);
		Inicio.add(menufondito2);

		JPanel panelmenu = new JPanel();
		panelmenu.setBackground(new Color(255, 255, 255));
		panelmenu.setBounds(124, 33, 692, 539);
		panelmenu.setLayout(null);
		panelmenu.setOpaque(false);
		menufondito2.add(panelmenu);

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

		btnNewButtonclientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Inicio);
				add(Clientes);
				repaint();
				revalidate();
			}
		});



		JButton btnentrarinventario = new JButton("Inventario\r\n");
		btnentrarinventario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnentrarinventario.setBackground(new Color(255, 128, 0));
		btnentrarinventario.setBounds(364, 279, 279, 234);
		panelmenu.add(btnentrarinventario);

		btnentrarinventario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Inicio);
				add(Inventario);
				repaint();
				revalidate();
			}
		});


		JButton btnNewButtonOrden = new JButton("Ordenes\r\n");
		btnNewButtonOrden.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonOrden.setBackground(new Color(255, 128, 0));
		btnNewButtonOrden.setBounds(364, 22, 279, 234);
		panelmenu.add(btnNewButtonOrden);

		btnNewButtonOrden.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Inicio);
				add(Ordenes);
				repaint();
				revalidate();
			}
		});




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

		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Platillos);
				add(EditarPlat);
				repaint();
				revalidate();
			}
		});


		JButton btnIngredientes = new JButton("Ingredientes");
		btnIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIngredientes.setBackground(new Color(255, 128, 0));
		btnIngredientes.setBounds(183, 197, 217, 60);
		panel.add(btnIngredientes);

		btnIngredientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Platillos);
				add(Platillosconingre);
				repaint();
				revalidate();
			}
		});

		JButton btneliminar = new JButton("Eliminar");
		btneliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btneliminar.setBackground(new Color(255, 128, 0));
		btneliminar.setBounds(439, 197, 217, 60);
		panel.add(btneliminar);

		btneliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Platillos);
				add(ElimPlatillos);
				repaint();
				revalidate();
			}
		});

		JButton btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCrear.setBackground(new Color(255, 128, 0));
		btnCrear.setBounds(548, 94, 217, 60);
		panel.add(btnCrear);

		btnCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Platillos);
				add(Crearplat);
				repaint();
				revalidate();
			}
		});

		JLabel lblplatillos = new JLabel("Platillos\r\n");
		lblplatillos.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblplatillos.setBounds(421, 11, 186, 41);
		Platillos.add(lblplatillos);

		JButton backplatillos = new JButton(new ImageIcon("BotonRetroceder.png"));
		backplatillos.setBounds(10, 11, 35, 33);
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
		btnbackconsultaplat.setBounds(10, 11, 80, 29);
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


		EditarPlat.setBackground(new Color(255, 128, 64));
		EditarPlat.setBounds(0, 0, 961, 642);
		//	contentPane.add(EditarPlat);
		EditarPlat.setLayout(null);

		JPanel paneledplat = new JPanel();
		paneledplat.setBackground(new Color(255, 218, 168));
		paneledplat.setBounds(10, 59, 930, 572);
		EditarPlat.add(paneledplat);
		paneledplat.setLayout(null);

		JTextField NombrePlatEdField = new JTextField();
		NombrePlatEdField.setColumns(10);
		NombrePlatEdField.setBounds(23, 73, 372, 33);
		paneledplat.add(NombrePlatEdField);

		JTextField PrecioEdPlat = new JTextField();
		PrecioEdPlat.setColumns(10);
		PrecioEdPlat.setBounds(23, 479, 372, 33);
		paneledplat.add(PrecioEdPlat);

		JTextArea Descripcionarea = new JTextArea();
		Descripcionarea.setBounds(23, 266, 372, 147);
		paneledplat.add(Descripcionarea);

		JComboBox ingredientebox = new JComboBox();
		ingredientebox.setBounds(23, 163, 372, 33);
		paneledplat.add(ingredientebox);

		JLabel lblnombreplateditar = new JLabel("Nombre del Platillo:");
		lblnombreplateditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblnombreplateditar.setBounds(23, 43, 242, 19);
		paneledplat.add(lblnombreplateditar);

		JLabel lblIngredientes = new JLabel("Ingredientes:\r\n");
		lblIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIngredientes.setBounds(23, 117, 265, 37);
		paneledplat.add(lblIngredientes);

		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescripcin.setBounds(23, 222, 331, 33);
		paneledplat.add(lblDescripcin);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(23, 435, 293, 33);
		paneledplat.add(lblPrecio);

		JButton btnEditarPlat = new JButton("Editar\r\n");
		btnEditarPlat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditarPlat.setBackground(new Color(254, 211, 122));
		btnEditarPlat.setBounds(404, 526, 150, 43);
		paneledplat.add(btnEditarPlat);

		JButton btnAdjuntarImagen = new JButton("Adjuntar Imagen\r\n");
		btnAdjuntarImagen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdjuntarImagen.setBackground(new Color(254, 211, 122));
		btnAdjuntarImagen.setBounds(704, 444, 211, 43);
		paneledplat.add(btnAdjuntarImagen);

		JLabel EditarPLatillotitulo = new JLabel("Editar Platillo\r\n");
		EditarPLatillotitulo.setFont(new Font("Tahoma", Font.PLAIN, 27));
		EditarPLatillotitulo.setBounds(390, 11, 234, 38);
		EditarPlat.add(EditarPLatillotitulo);

		JButton btnbackeditarplatillos = new JButton("Back");
		btnbackeditarplatillos.setBounds(10, 11, 80, 29);
		EditarPlat.add(btnbackeditarplatillos);

		btnbackeditarplatillos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(EditarPlat);
				add(Platillos);
				repaint();
				revalidate();
			}
		});


		//----Crear Platillos-----

		Crearplat.setBackground(new Color(255, 128, 0));
		Crearplat.setBounds(0, 0, 961, 642);
		//	contentPane.add(Crearplat);
		Crearplat.setLayout(null);

		JPanel panelcrearplat = new JPanel();
		panelcrearplat.setBackground(new Color(255, 218, 168));
		panelcrearplat.setBounds(10, 59, 930, 572);
		Crearplat.add(panelcrearplat);
		panelcrearplat.setLayout(null);

		JTextField NombrePlatCrearField = new JTextField();
		NombrePlatCrearField.setColumns(10);
		NombrePlatCrearField.setBounds(23, 73, 372, 33);
		panelcrearplat.add(NombrePlatCrearField);

		JTextField PreciocrearPlat = new JTextField();
		PreciocrearPlat.setColumns(10);
		PreciocrearPlat.setBounds(23, 479, 372, 33);
		panelcrearplat.add(PreciocrearPlat);

		JTextArea Descripcionareacrear = new JTextArea();
		Descripcionareacrear.setBounds(23, 266, 372, 147);
		panelcrearplat.add(Descripcionareacrear);

		JComboBox ingredienteboxcrear = new JComboBox();
		ingredienteboxcrear.setBounds(23, 163, 372, 33);
		panelcrearplat.add(ingredienteboxcrear);

		JLabel nombreplatcrearlaberl = new JLabel("Nombre del Platillo:");
		nombreplatcrearlaberl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombreplatcrearlaberl.setBounds(23, 43, 242, 19);
		panelcrearplat.add(nombreplatcrearlaberl);

		JLabel comboingredcrear = new JLabel("Ingredientes:\r\n");
		comboingredcrear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboingredcrear.setBounds(23, 117, 265, 37);
		panelcrearplat.add(comboingredcrear);

		JLabel Descripcioncrearplatlabel = new JLabel("Descripción:");
		Descripcioncrearplatlabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Descripcioncrearplatlabel.setBounds(23, 222, 331, 33);
		panelcrearplat.add(Descripcioncrearplatlabel);

		JLabel lblPreciocrearplat = new JLabel("Precio:");
		lblPreciocrearplat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPreciocrearplat.setBounds(23, 435, 293, 33);
		panelcrearplat.add(lblPreciocrearplat);

		JButton btnCrearPlat = new JButton("Crear");
		btnCrearPlat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCrearPlat.setBackground(new Color(254, 211, 122));
		btnCrearPlat.setBounds(404, 526, 150, 43);
		panelcrearplat.add(btnCrearPlat);

		JButton btnAdjuntarImagen2 = new JButton("Adjuntar Imagen\r\n");
		btnAdjuntarImagen2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdjuntarImagen2.setBackground(new Color(254, 211, 122));
		btnAdjuntarImagen2.setBounds(704, 444, 211, 43);
		panelcrearplat.add(btnAdjuntarImagen2);

		JLabel Crearplatlbl = new JLabel("Crear Platillo");
		Crearplatlbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Crearplatlbl.setBounds(387, 0, 227, 40);
		Crearplat.add(Crearplatlbl);


		JButton btnbackcrearplatillos = new JButton("Back");
		btnbackcrearplatillos.setBounds(10, 11, 80, 29);
		Crearplat.add(btnbackcrearplatillos);

		btnbackcrearplatillos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Crearplat);
				add(Platillos);
				repaint();
				revalidate();
			}
		});


		//----Platillos ingredientes-----


		Platillosconingre.setBackground(new Color(255, 128, 0));
		//	contentPane.add(Platillosconingre);
		Platillosconingre.setLayout(null);

		DefaultListModel<String> model2 = new DefaultListModel<>();
		model2.addElement("Sushi empanizado");
		model2.addElement("Hamburguesa");
		model2.addElement("Lasagna");
		model2.addElement("Pizza");
		model2.addElement("Alitas");


		JLabel lblingredientes = new JLabel("Ingredientes");
		lblingredientes.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblingredientes.setBounds(403, 0, 316, 52);
		Platillosconingre.add(lblingredientes);

		JPanel panelcrearingre = new JPanel();
		panelcrearingre.setBounds(37, 62, 877, 559);
		Platillosconingre.add(panelcrearingre);
		panelcrearingre.setLayout(null);


		JPanel panellista = new JPanel();
		panellista.setBackground(new Color(255, 255, 255));
		panellista.setBounds(433, 5, 444, 565);
		panelcrearingre.add(panellista);
		panellista.setLayout(null);

		JLabel Detallesingrelbl = new JLabel("Detalles de Ingredientes");
		Detallesingrelbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Detallesingrelbl.setBounds(57, 11, 357, 61);
		panellista.add(Detallesingrelbl);

		JLabel Tipoingredientelbl = new JLabel("Ingrediente: Queso amarillo");
		Tipoingredientelbl.setFont(new Font("Tahoma", Font.PLAIN, 21));
		Tipoingredientelbl.setBounds(61, 111, 317, 61);
		panellista.add(Tipoingredientelbl);

		JTextArea txtrDescripcinQuesoImitacin = new JTextArea();
		txtrDescripcinQuesoImitacin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtrDescripcinQuesoImitacin.setText("Descripción: Queso imitación tipo chedar en rebanadas,\r\n usado para hamburguesas.");
		txtrDescripcinQuesoImitacin.setBounds(66, 228, 312, 249);
		panellista.add(txtrDescripcinQuesoImitacin);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 128, 0));
		panel_10.setBounds(35, 40, 288, 519);
		panelcrearingre.add(panel_10);
		panel_10.setLayout(null);

		JButton Ingredienteprueba2 = new JButton("Queso amarillo\r\n");
		Ingredienteprueba2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Ingredienteprueba2.setBounds(10, 11, 268, 53);
		panel_10.add(Ingredienteprueba2);

		JButton Ingredienteprueba1 = new JButton("Queso mozarella");
		Ingredienteprueba1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Ingredienteprueba1.setBounds(10, 75, 268, 53);
		panel_10.add(Ingredienteprueba1);

		JButton btnNewButton_1_2 = new JButton("Hamburguesa\r\n");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_2.setBounds(10, 75, 268, 53);
		panel_10.add(btnNewButton_1_2);

		JButton Ingredienteprueba4 = new JButton("Salsa de tomate");
		Ingredienteprueba4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Ingredienteprueba4.setBounds(10, 203, 268, 53);
		panel_10.add(Ingredienteprueba4);

		JButton Ingredienteprueba3 = new JButton("Tomate");
		Ingredienteprueba3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Ingredienteprueba3.setBounds(10, 139, 268, 53);
		panel_10.add(Ingredienteprueba3);

		JButton Ingredienteprueba6 = new JButton("Camarones");
		Ingredienteprueba6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Ingredienteprueba6.setBounds(10, 331, 268, 53);
		panel_10.add(Ingredienteprueba6);

		JButton Ingredienteprueba5 = new JButton("Pepperoni");
		Ingredienteprueba5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Ingredienteprueba5.setBounds(10, 267, 268, 53);
		panel_10.add(Ingredienteprueba5);

		JButton Ingredienteprueba7 = new JButton("Arroz");
		Ingredienteprueba7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Ingredienteprueba7.setBounds(10, 395, 268, 53);
		panel_10.add(Ingredienteprueba7);

		JButton Ingredienteprueba8 = new JButton("Harina de trigo");
		Ingredienteprueba8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Ingredienteprueba8.setBounds(10, 459, 268, 53);
		panel_10.add(Ingredienteprueba8);

		JLabel lblPlatillosconingre = new JLabel("Platillos con el ingrediente");
		lblPlatillosconingre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlatillosconingre.setBounds(72, 5, 213, 36);
		panelcrearingre.add(lblPlatillosconingre);

		JButton btnbackingredientes = new JButton("Back");
		btnbackingredientes.setBounds(10, 11, 80, 29);
		Platillosconingre.add(btnbackingredientes);

		btnbackingredientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Platillosconingre);
				add(Platillos);

				repaint();
				revalidate();
			}
		});


		//----Eliminar Platillos-----


		ElimPlatillos.setBackground(new Color(255, 128, 0));
		ElimPlatillos.setBounds(0, 0, 961, 642);
		//  contentPane.add(ElimPlatillos);
		ElimPlatillos.setLayout(null);

		JLabel lblEliminarPlatillos = new JLabel("Eliminar Platillos");
		lblEliminarPlatillos.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblEliminarPlatillos.setBounds(359, 80, 223, 50);
		ElimPlatillos.add(lblEliminarPlatillos);

		JList list = new JList();
		list.setBounds(230, 234, 463, 228);
		ElimPlatillos.add(list);

		JLabel platilloAEliminar = new JLabel("Platillo a Eliminar");
		platilloAEliminar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		platilloAEliminar.setBounds(376, 200, 279, 43);
		ElimPlatillos.add(platilloAEliminar);

		JButton backbtneliminarplat = new JButton("Back");
		backbtneliminarplat.setBounds(10, 11, 80, 29);
		ElimPlatillos.add(backbtneliminarplat);

		backbtneliminarplat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(ElimPlatillos);
				add(Platillos);
				repaint();
				revalidate();
			}
		});

		JLabel platilloIcon = new JLabel(new ImageIcon("Platillosfondo.png"));
		platilloIcon.setBounds(0, 0, 977, 681);
		platilloIcon.setVisible(true);
		platilloIcon.setOpaque(true);
		Platillos.add(platilloIcon);
		repaint();
		revalidate();


		//--------------------------------------------ordenes-----------------------------------------------------------

		Ordenes.setLayout(null);
		Ordenes.repaint();
		Ordenes.revalidate();

		JPanel panelOrdenes = new JPanel();
		panelOrdenes.setBounds(0, 0, 977, 681);
		panelOrdenes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Ordenes.add(panelOrdenes);
		panelOrdenes.revalidate();
		panelOrdenes.repaint();
		panelOrdenes.setLayout(null);

		JPanel panelMenuOrdenes = new JPanel();
		panelMenuOrdenes .setLayout(null);
		panelMenuOrdenes .setBackground(Color.WHITE);
		panelMenuOrdenes .setOpaque(false);
		panelMenuOrdenes .setBounds(60, 241, 827, 347);
		panelOrdenes.add(panelMenuOrdenes );

		JPanel panelMiniOrden = new JPanel();
		panelMiniOrden.setLayout(null);
		panelMiniOrden.setBackground(Color.WHITE);
		panelMiniOrden.setOpaque(false);
		panelMiniOrden.setBounds(60, 241, 827, 347);
		panelOrdenes.add(panelMiniOrden);

		JLabel IconOrden = new JLabel(new ImageIcon("ordenes.jpg"));
		IconOrden.setBounds(0, 0, 951, 631);
		IconOrden.setVisible(true);
		IconOrden.setOpaque(true);
		panelOrdenes.add(IconOrden);


		JButton btnConsultarorden = new JButton("Consultar");
		btnConsultarorden.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsultarorden.setBackground(new Color(255, 128, 0));
		btnConsultarorden.setBounds(112, 95, 217, 60);
		btnConsultarorden.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Ordenes);
				add(ConsultarOrden);
				repaint();
				revalidate();

			}
		});
		panelMiniOrden.add( btnConsultarorden);

		JButton btnEditarOrdenes = new JButton("Editar");
		btnEditarOrdenes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditarOrdenes.setBackground(new Color(255, 128, 0));
		btnEditarOrdenes.setBounds(112, 198, 217, 60);
		btnEditarOrdenes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Ordenes);
				add(EditarTablaOrd);
				repaint();
				revalidate();

			}
		});
		panelMiniOrden.add(btnEditarOrdenes);

		JButton btnEliminarOrden = new JButton("Eliminar");
		btnEliminarOrden.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminarOrden.setBackground(new Color(255, 128, 0));
		btnEliminarOrden.setBounds(490, 198, 217, 60);
		btnEliminarOrden.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Ordenes);
				add(EliminarOrden);
				repaint();
				revalidate();

			}
		});
		panelMiniOrden.add(btnEliminarOrden);

		JButton btnCrearOrden = new JButton("Crear");
		btnCrearOrden.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCrearOrden.setBackground(new Color(255, 128, 0));
		btnCrearOrden.setBounds(490, 95, 217, 60);
		panelMiniOrden.add(btnCrearOrden);

		btnCrearOrden.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Ordenes);
				add(CrearOrden);
				repaint();
				revalidate();

			}
		});

		JButton backOrdenes = new JButton("Back");
		backOrdenes.setBounds(10, 11, 80, 29);
		backOrdenes.repaint();
		backOrdenes.revalidate();
		backOrdenes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Ordenes);
				add(Inicio);
				repaint();
				revalidate();
			}
		});
		IconOrden.add(backOrdenes);


		//-----pantalla creacion Ordenes-----
		CrearOrden.setLayout(null);

		JLabel crearOrdenes = new JLabel("Crear Ordenes");
		crearOrdenes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		crearOrdenes.setBounds(400, 89, 311, 50);
		CrearOrden.add( crearOrdenes);

		JPanel FondoCrearorden = new JPanel();
		FondoCrearorden .setBounds(0, 0, 977, 681);
		FondoCrearorden .setBackground(new Color(255, 128, 0));
		FondoCrearorden .setLayout(null);
		CrearOrden.add(FondoCrearorden );


		JPanel panelCrearOrden = new JPanel();
		panelCrearOrden .setBounds(180, 150, 610, 426);

		FondoCrearorden .add(panelCrearOrden);
		panelCrearOrden.setLayout(null);



		JButton botonCrearOrden = new JButton("Crear Orden");
		botonCrearOrden .setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonCrearOrden .setBounds(400, 587, 147, 44);
		FondoCrearorden.add(botonCrearOrden );

		JButton backCCord = new JButton("Back");
		backCCord.setBounds(10, 11, 80, 29);
		backCCord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(CrearOrden);
				add(Ordenes);
				repaint();
				revalidate();
			}
		});
		FondoCrearorden.add(backCCord);

		//------pantalla edicion de Orden------
		EditarTablaOrd.setLayout(null);

		JPanel editarTablaOrden = new JPanel();
		editarTablaOrden.setBounds(0, 0, 977, 681);
		editarTablaOrden.setBackground(new Color(255, 128, 0));
		editarTablaOrden.setLayout(null);
		EditarTablaOrd.add(editarTablaOrden);


		JTable tablaOrdenes = new JTable();
		tablaOrdenes.setModel(new DefaultTableModel(
				new Object[][]{
						{"Orden #5", "Editar"},
						{"Orden  #4", "Editar"},
						{"Orden  #3", "Editar"},
						{"Orden  #2", "Editar"},
						{"Orden  #1", "Editar"},
				},
				new String[]{
						"Orden", "ver"
				}
		));
		tablaOrdenes.setBounds(181, 257, 606, 80);
		editarTablaOrden.add(tablaOrdenes);

		JPanel panelEditarOrd = new JPanel();
		panelEditarOrd.setBackground(Color.GRAY);
		panelEditarOrd.setBounds(181, 215, 606, 42);
		editarTablaOrden.add(panelEditarOrd);
		panelEditarOrd.setLayout(null);

		JLabel OrdenAEditar = new JLabel("Orden a Editar");
		OrdenAEditar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OrdenAEditar.setBounds(225, 11, 182, 20);
		panelEditarOrd.add(OrdenAEditar);

		JLabel editar_ordenes = new JLabel("Editar Ordenes");
		editar_ordenes.setFont(new Font("Arial Black", Font.PLAIN, 20));
		editar_ordenes.setBounds(400, 137, 181, 50);
		editarTablaOrden.add(editar_ordenes);

		JButton btnEdit = new JButton("Editar Orden");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.setBounds(400, 587, 147, 44);
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(EditarTabla);
				add(EditarClientes);
				repaint();
				revalidate();
			}
		});
		editarTablaOrden.add(btnEdit);

		JButton backETOrd = new JButton("Back");
		backETOrd.setBounds(10, 11, 80, 29);
		backETOrd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(EditarTablaOrd);
				add(Ordenes);
				repaint();
				revalidate();
			}
		});
		editarTablaOrden.add(backETOrd);




		//-----pantalla consulta de Ordenes-----
		ConsultarOrden.setLayout(null);

		JPanel consultarOrdenes1 = new JPanel();
		consultarOrdenes1.setBounds(0, 0, 977, 681);
		consultarOrdenes1.setBackground(new Color(255, 128, 0));
		consultarOrdenes1.setLayout(null);
		ConsultarOrden.add(consultarOrdenes1);

		JTable tablaConsultaOrden = new JTable();
		tablaConsultaOrden.setModel(new DefaultTableModel(
				new Object[][]{
						{"Orden #5", "Consultar"},
						{"Orden #4", "Consultar"},
						{"Orden #3", "Consultar"},
						{"Orden #2", "Consultar"},
						{"Orden #1", "Consultar"},
				},
				new String[]{
						"Ver", "Costo"
				}
		));
		tablaConsultaOrden.setBounds(181, 257, 606, 80);
		consultarOrdenes1.add(tablaConsultaOrden);

		JPanel panelConsultaOrd2 = new JPanel();
		panelConsultaOrd2 .setBackground(Color.GRAY);
		panelConsultaOrd2 .setBounds(181, 215, 606, 42);
		consultarOrdenes1.add(panelConsultaOrd2 );
		panelConsultaOrd2 .setLayout(null);

		JLabel Ver = new JLabel("Ver");
		Ver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Ver.setBounds(86, 11, 115, 20);
		panelConsultaOrd2.add(Ver);

		JLabel Costo = new JLabel("Costo");
		Costo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Costo.setBounds(426, 11, 115, 20);
		panelConsultaOrd2.add(Costo);

		JLabel orders = new JLabel("Consultar Ordenes");
		orders .setFont(new Font("Tahoma", Font.PLAIN, 16));
		orders .setBounds(417, 137, 181, 50);
		consultarOrdenes1.add(orders );

		JButton backConsultaOrder = new JButton("Back");
		backConsultaOrder.setBounds(10, 11, 80, 29);
		backConsultaOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(ConsultarOrden);
				add(Ordenes);
				repaint();
				revalidate();
			}
		});
		consultarOrdenes1.add(backConsultaOrder);


		//----pantalla eliminar Ordenes----
		EliminarOrden.setLayout(null);

		JPanel eliminarOrders = new JPanel();
		eliminarOrders.setBounds(0, 0, 977, 681);
		eliminarOrders.setBackground(new Color(255, 128, 0));
		eliminarOrders.setLayout(null);
		EliminarOrden.add(eliminarOrders);

		JTable tablaEliminarOrder = new JTable();
		tablaEliminarOrder.setModel(new DefaultTableModel(
				new Object[][]{
						{"Orden #5", "Eliminar"},
						{"Orden #4", "Eliminar"},
						{"Orden #3", "Eliminar"},
						{"Orden #2", "Eliminar"},
						{"Orden #1", "Eliminar"},
				},
				new String[]{
						"Ver", "Eliminar"
				}
		));
		tablaEliminarOrder.setBounds(181, 257, 606, 80);
		eliminarOrders.add(tablaEliminarOrder);

		JPanel panellOrd = new JPanel();
		panellOrd.setBackground(Color.GRAY);
		panellOrd.setBounds(181, 215, 606, 42);
		panellOrd.setLayout(null);
		eliminarOrders.add(panellOrd);

		JLabel lblTituloOrd = new JLabel("Orden a Eliminar");
		lblTituloOrd.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblTituloOrd.setBounds(225, 11, 182, 20);
		panellOrd.add(lblTituloOrd);

		JLabel lblEliminarOrd = new JLabel("Eliminar Ordenes");
		lblEliminarOrd .setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblEliminarOrd .setBounds(417, 137, 181, 50);
		eliminarOrders.add(lblEliminarOrd);

		JButton backEliminarOrdenn = new JButton("Back");
		backEliminarOrdenn.setBounds(10, 11, 80, 29);
		backEliminarOrdenn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(EliminarOrden);
				add(Ordenes);
				repaint();
				revalidate();
			}
		});
		eliminarOrders.add(backEliminarOrdenn);






		//--------------------------------------------inventario--------------------------------------------------------


		//-----Menu inventario------

		//	contentPane.add(Inventario);
		Inventario.setLayout(null);

		JPanel Panelinventario = new JPanel();
		Panelinventario.setLayout(null);
		Panelinventario.setBackground(Color.WHITE);
		Panelinventario.setBounds(59, 241, 827, 347);
		Inventario.add(Panelinventario);

		JButton Consultarinventario = new JButton("Consultar");
		Consultarinventario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Consultarinventario.setBackground(new Color(255, 128, 0));
		Consultarinventario.setBounds(112, 95, 217, 60);
		Panelinventario.add(Consultarinventario);

		Consultarinventario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Inventario);
				add(ConsultaInv);
				repaint();
				revalidate();
			}
		});

		JButton EditarInventario = new JButton("Editar");
		EditarInventario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EditarInventario.setBackground(new Color(255, 128, 0));
		EditarInventario.setBounds(112, 198, 217, 60);
		Panelinventario.add(EditarInventario);

		EditarInventario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Inventario);
				add(EditarINv);
				repaint();
				revalidate();
			}
		});

		JButton EliminarInventario = new JButton("Eliminar");
		EliminarInventario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EliminarInventario.setBackground(new Color(255, 128, 0));
		EliminarInventario.setBounds(490, 198, 217, 60);
		Panelinventario.add(EliminarInventario);

		EliminarInventario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Inventario);
				add(EliminarINv);
				repaint();
				revalidate();
			}
		});

		JButton CrearInventario = new JButton("Crear");
		CrearInventario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CrearInventario.setBackground(new Color(255, 128, 0));
		CrearInventario.setBounds(490, 95, 217, 60);
		Panelinventario.add(CrearInventario);

		CrearInventario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Inventario);
				add(NuevoArticulo);
				repaint();
				revalidate();
			}
		});


		JLabel TituloInventario = new JLabel("Inventario");
		TituloInventario.setFont(new Font("Tahoma", Font.PLAIN, 26));
		TituloInventario.setBounds(405, -16, 218, 76);
		Inventario.add(TituloInventario);


		JButton btnbackinventario = new JButton("Back");
		btnbackinventario.setBounds(10, 11, 80, 29);
		Inventario.add(btnbackinventario);
		btnbackinventario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Inventario);
				add(Inicio);
				repaint();
				revalidate();
			}
		});

		JLabel InventarioIcon = new JLabel(new ImageIcon("Inventariofondo.png"));
		InventarioIcon.setBounds(0, 0, 977, 681);
		InventarioIcon.setVisible(true);
		InventarioIcon.setOpaque(true);
		Inventario.add(InventarioIcon);
		repaint();
		revalidate();


		//----Consultar inventario-----

		ConsultaInv.setBackground(new Color(255, 128, 0));
		//	contentPane.add(ConsultaInv);
		ConsultaInv.setLayout(null);


		JLabel consultarInventario = new JLabel("Consultar Inventario");
		consultarInventario.setFont(new Font("Tahoma", Font.PLAIN, 26));
		consultarInventario.setBackground(new Color(128, 128, 0));
		consultarInventario.setForeground(new Color(0, 0, 0));
		consultarInventario.setBounds(331, 23, 243, 58);
		ConsultaInv.add(consultarInventario);

		JLabel lblArticulosporacabar = new JLabel("Articulos por agotarse\r\n");
		lblArticulosporacabar.setForeground(new Color(255, 255, 255));
		lblArticulosporacabar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblArticulosporacabar.setBounds(354, 74, 279, 29);
		ConsultaInv.add(lblArticulosporacabar);

		JPanel widget1 = new JPanel();
		widget1.setBounds(34, 129, 197, 58);
		ConsultaInv.add(widget1);

		JPanel widget2 = new JPanel();
		widget2.setBounds(265, 129, 197, 58);
		ConsultaInv.add(widget2);

		JPanel widget3 = new JPanel();
		widget3.setBounds(729, 129, 197, 58);
		ConsultaInv.add(widget3);

		JPanel widget4 = new JPanel();
		widget4.setBounds(498, 129, 197, 58);
		ConsultaInv.add(widget4);

		JPanel paneldetablainventario = new JPanel();
		paneldetablainventario.setBounds(34, 277, 892, 36);
		ConsultaInv.add(paneldetablainventario);
		paneldetablainventario.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel articulodeinventario = new JLabel("Articulo");
		articulodeinventario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		paneldetablainventario.add(articulodeinventario);

		JLabel tipodeunidadlbl = new JLabel("Unidad");
		tipodeunidadlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		paneldetablainventario.add(tipodeunidadlbl);

		JLabel cantidadeninvlbl = new JLabel("Cantidad");
		cantidadeninvlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		paneldetablainventario.add(cantidadeninvlbl);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 218, 168));
		panel_4.setBounds(34, 312, 892, 257);
		ConsultaInv.add(panel_4);


		JButton btnbackinvconsultar = new JButton("Back");
		btnbackinvconsultar.setBounds(10, 11, 80, 29);
		ConsultaInv.add(btnbackinvconsultar);

		btnbackinvconsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(ConsultaInv);
				add(Inventario);
				repaint();
				revalidate();
			}
		});


		//----Editar inventario-----


		EditarINv.setBackground(new Color(255, 128, 0));
		EditarINv.setBounds(0, 0, 961, 642);
		//    contentPane.add(EditarINv);
		EditarINv.setLayout(null);


		JLabel Editarinvlbl = new JLabel("Editar Inventario\r\n");
		Editarinvlbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Editarinvlbl.setBounds(388, -16, 214, 115);
		EditarINv.add(Editarinvlbl);

		JPanel editarinv2 = new JPanel();
		editarinv2.setBackground(new Color(255, 218, 168));
		editarinv2.setBounds(10, 204, 941, 427);
		EditarINv.add(editarinv2);
		editarinv2.setLayout(null);

		JLabel muestralbl1 = new JLabel("Articulo #5\r\n");
		muestralbl1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		muestralbl1.setBounds(55, 11, 145, 31);
		editarinv2.add(muestralbl1);

		JLabel muestralbl2 = new JLabel("Articulo #4\r\n\r\n");
		muestralbl2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		muestralbl2.setBounds(55, 63, 145, 31);
		editarinv2.add(muestralbl2);

		JLabel muestralbl3 = new JLabel("Articulo #2\r\n\r\n");
		muestralbl3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		muestralbl3.setBounds(55, 171, 145, 31);
		editarinv2.add(muestralbl3);

		JLabel muestralbl4 = new JLabel("Articulo #3\r\n");
		muestralbl4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		muestralbl4.setBounds(55, 118, 145, 31);
		editarinv2.add(muestralbl4);

		JLabel muestralbl5 = new JLabel("Articulo #1\r\n");
		muestralbl5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		muestralbl5.setBounds(55, 225, 145, 31);
		editarinv2.add(muestralbl5);

		JButton editar1btn = new JButton("Editar");
		editar1btn.setBounds(732, 19, 128, 23);
		editarinv2.add(editar1btn);

		JButton editarbtn = new JButton("Editar");
		editarbtn.setBounds(732, 71, 128, 23);
		editarinv2.add(editarbtn);

		JButton editar2btn = new JButton("Editar");
		editar2btn.setBounds(732, 126, 128, 23);
		editarinv2.add(editar2btn);

		JButton editar3btn = new JButton("Editar");
		editar3btn.setBounds(732, 179, 128, 23);
		editarinv2.add(editar3btn);

		JButton editar4btn = new JButton("Editar");
		editar4btn.setBounds(732, 233, 128, 23);
		editarinv2.add(editar4btn);

		JPanel Editarinv3pnl = new JPanel();
		Editarinv3pnl.setBounds(10, 156, 941, 48);
		EditarINv.add(Editarinv3pnl);
		Editarinv3pnl.setLayout(null);

		JLabel Articuloaeditarlbl = new JLabel("Articulo a Editar");
		Articuloaeditarlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Articuloaeditarlbl.setBounds(395, 0, 210, 43);
		Editarinv3pnl.add(Articuloaeditarlbl);

		JButton btnbackeditarinv = new JButton("Back");
		btnbackeditarinv.setBounds(10, 11, 80, 29);
		EditarINv.add(btnbackeditarinv);
		btnbackeditarinv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(EditarINv);
				add(Inventario);
				repaint();
				revalidate();
			}
		});


		//----Eliminar inventario------


		EliminarINv.setBackground(new Color(255, 128, 0));
		EliminarINv.setBounds(0, 0, 961, 642);
//		contentPane.add(EliminarINv);
		EliminarINv.setLayout(null);


		JLabel Eliminarinvlbl = new JLabel("Eliminar Inventario\r\n");
		Eliminarinvlbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Eliminarinvlbl.setBounds(388, -16, 252, 115);
		EliminarINv.add(Eliminarinvlbl);

		JPanel eliminarinvpnl2 = new JPanel();
		eliminarinvpnl2.setBackground(new Color(255, 218, 168));
		eliminarinvpnl2.setBounds(10, 204, 941, 427);
		EliminarINv.add(eliminarinvpnl2);
		eliminarinvpnl2.setLayout(null);

		JLabel articulo5lbl = new JLabel("Articulo #5\r\n");
		articulo5lbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		articulo5lbl.setBounds(55, 11, 145, 31);
		eliminarinvpnl2.add(articulo5lbl);

		JLabel articulo4lbl = new JLabel("Articulo #4\r\n\r\n");
		articulo4lbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		articulo4lbl.setBounds(55, 63, 145, 31);
		eliminarinvpnl2.add(articulo4lbl);

		JLabel articulo3lbl = new JLabel("Articulo #2\r\n\r\n");
		articulo3lbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		articulo3lbl.setBounds(55, 171, 145, 31);
		eliminarinvpnl2.add(articulo3lbl);

		JLabel articulo2lbl = new JLabel("Articulo #3\r\n");
		articulo2lbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		articulo2lbl.setBounds(55, 118, 145, 31);
		eliminarinvpnl2.add(articulo2lbl);

		JLabel articulo1lbl = new JLabel("Articulo #1\r\n");
		articulo1lbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		articulo1lbl.setBounds(55, 225, 145, 31);
		eliminarinvpnl2.add(articulo1lbl);

		JButton btnNewButton1 = new JButton("Eliminar");
		btnNewButton1.setBounds(732, 19, 128, 23);
		eliminarinvpnl2.add(btnNewButton1);

		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.setBounds(732, 71, 128, 23);
		eliminarinvpnl2.add(btnNewButton_1);

		JButton eliminarjbutonninv = new JButton("Eliminar");
		eliminarjbutonninv.setBounds(732, 126, 128, 23);
		eliminarinvpnl2.add(eliminarjbutonninv);

		JButton btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.setBounds(732, 179, 128, 23);
		eliminarinvpnl2.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Eliminar");
		btnNewButton_4.setBounds(732, 233, 128, 23);
		eliminarinvpnl2.add(btnNewButton_4);

		JPanel panel2eliminv = new JPanel();
		panel2eliminv.setBounds(10, 156, 941, 48);
		EliminarINv.add(panel2eliminv);
		panel2eliminv.setLayout(null);

		JLabel lblarticuloinv = new JLabel("Articulo a Eliminar");
		lblarticuloinv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblarticuloinv.setBounds(395, 0, 210, 43);
		panel2eliminv.add(lblarticuloinv);


		JButton btnbackeliminarinventario = new JButton("Back");
		btnbackeliminarinventario.setBounds(10, 11, 80, 29);
		EliminarINv.add(btnbackeliminarinventario);

		btnbackeliminarinventario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(EliminarINv);
				add(Inventario);
				repaint();
				revalidate();
			}
		});


		//----Añadir al inventario ------


		NuevoArticulo.setBackground(new Color(255, 128, 0));
		NuevoArticulo.setBounds(0, 0, 961, 642);
		//	contentPane.add(NuevoArticulo);
		NuevoArticulo.setLayout(null);


		JLabel lblnuevoarticulo = new JLabel("Nuevo Articulo\r\n");
		lblnuevoarticulo.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblnuevoarticulo.setBounds(393, 11, 311, 48);
		NuevoArticulo.add(lblnuevoarticulo);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 218, 168));
		panel2.setBounds(10, 104, 941, 473);
		NuevoArticulo.add(panel2);
		panel2.setLayout(null);

		JLabel lblnombrearticulonuevoinv = new JLabel("Nombre del articulo:");
		lblnombrearticulonuevoinv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblnombrearticulonuevoinv.setBounds(358, 23, 250, 43);
		panel2.add(lblnombrearticulonuevoinv);

		textField = new JTextField();
		textField.setBounds(358, 62, 238, 33);
		panel2.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Tipo de unidad:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(358, 106, 250, 43);
		panel2.add(lblNewLabel_1_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(358, 143, 238, 30);
		panel2.add(comboBox);

		JLabel lblNewLabel_1_1_1 = new JLabel("Color del widget:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(358, 184, 250, 43);
		panel2.add(lblNewLabel_1_1_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(358, 221, 238, 30);
		panel2.add(comboBox_1);

		JLabel lblNewLabel_1_2 = new JLabel("Cantidad:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(358, 276, 250, 43);
		panel2.add(lblNewLabel_1_2);

		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(358, 315, 238, 33);
		panel2.add(textField_1);

		JButton Creararticulobtn = new JButton("Crear");
		Creararticulobtn.setBackground(new Color(255, 128, 64));
		Creararticulobtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Creararticulobtn.setBounds(411, 419, 124, 43);
		panel2.add(Creararticulobtn);

		JButton btnbackcreararticuloinv = new JButton("Back");
		btnbackcreararticuloinv.setBounds(10, 11, 80, 29);
		NuevoArticulo.add(btnbackcreararticuloinv);

		btnbackcreararticuloinv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(NuevoArticulo);
				add(Inventario);
				repaint();
				revalidate();
			}
		});



		//--------------------------------------------clientes----------------------------------------------------------
		//-----pantalla clientes principal-----

		Clientes.setLayout(null);
		Clientes.repaint();
		Clientes.revalidate();

		JPanel panelClientes = new JPanel();
		panelClientes.setBounds(0, 0, 977, 681);
		panelClientes.setFont(new Font("Arial Black", Font.PLAIN, 20));
		Clientes.add(panelClientes);
		panelClientes.revalidate();
		panelClientes.repaint();
		panelClientes.setLayout(null);

		JPanel panelMenuClientes = new JPanel();
		panelMenuClientes.setLayout(null);
		panelMenuClientes.setBackground(Color.WHITE);
		panelMenuClientes.setOpaque(false);
		panelMenuClientes.setBounds(60, 241, 827, 347);
		panelClientes.add(panelMenuClientes);

		JPanel panelMini = new JPanel();
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
		btnConsultar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnConsultar.setBackground(new Color(255, 128, 0));
		btnConsultar.setFocusable(false);
		btnConsultar.setBounds(112, 95, 217, 60);
		btnConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Clientes);
				add(ConsultaClientes);
				repaint();
				revalidate();

			}
		});
		panelMini.add(btnConsultar);

		JButton btnEditarClientes = new JButton("Editar");
		btnEditarClientes.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnEditarClientes.setBackground(new Color(255, 128, 0));
		btnEditarClientes.setFocusable(false);
		btnEditarClientes.setBounds(112, 198, 217, 60);
		btnEditarClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Clientes);
				add(EditarTabla);
				repaint();
				revalidate();

			}
		});
		panelMini.add(btnEditarClientes);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnEliminar.setBackground(new Color(255, 128, 0));
		btnEliminar.setFocusable(false);
		btnEliminar.setBounds(490, 198, 217, 60);
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Clientes);
				add(EliminarClientes);
				repaint();
				revalidate();

			}
		});
		panelMini.add(btnEliminar);

		JButton btnCrearClientes = new JButton("Crear");
		btnCrearClientes.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnCrearClientes.setBackground(new Color(255, 128, 0));
		btnCrearClientes.setFocusable(false);
		btnCrearClientes.setBounds(490, 95, 217, 60);
		panelMini.add(btnCrearClientes);

		btnCrearClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Clientes);
				add(CrearClientes);
				repaint();
				revalidate();

			}
		});

		JButton backClientes = new JButton(new ImageIcon("BotonRetroceder.png"));
		backClientes.setBounds(10, 11, 35, 33);
		backClientes.repaint();
		backClientes.setFocusable(false);
		backClientes.revalidate();
		backClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Clientes);
				add(Inicio);
				repaint();
				revalidate();
			}
		});
		clienteIcon.add(backClientes);


		//-----pantalla creacion clientes-----
		CrearClientes.setLayout(null);

		JLabel crearCliente = new JLabel("Crear Cliente");
		crearCliente.setFont(new Font("Arial Black", Font.PLAIN, 20));
		crearCliente.setBounds(400, 89, 311, 50);
		CrearClientes.add(crearCliente);

		JPanel FondoCrear = new JPanel();
		FondoCrear.setBounds(0, 0, 977, 681);
		FondoCrear.setBackground(new Color(255, 128, 0));
		FondoCrear.setLayout(null);
		CrearClientes.add(FondoCrear);


		JPanel panelCrearCliente = new JPanel();
		panelCrearCliente.setBounds(180, 150, 610, 426);

		FondoCrear.add(panelCrearCliente);
		panelCrearCliente.setLayout(null);

		JLabel name = new JLabel("Nombre");
		name.setFont(new Font("Arial Black", Font.PLAIN, 16));
		name.setBounds(10, 11, 121, 14);
		panelCrearCliente.add(name);

		JTextField nametxt = new JTextField();
		nametxt.setColumns(10);
		nametxt.setBounds(10, 36, 454, 27);
		nametxt.setDocument(new PlainDocument() {
		    @Override
		    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		        if (str == null)
		            return;

		        for (char c : str.toCharArray()) {
		            if (!Character.isLetter(c)) {
		                return; // Ignora la inserción de caracteres no alfabéticos
		            }
		        }

		        super.insertString(offset, str, attr);
		    }
		});
		nametxt.addKeyListener(new KeyListener() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c)) {
		            e.consume(); // Ignora la entrada de caracteres no alfabéticos
		        }
		    }

		    @Override
		    public void keyPressed(KeyEvent e) {
		        // No se requiere ninguna acción en este método
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		        // No se requiere ninguna acción en este método
		    }
		});
		panelCrearCliente.add(nametxt);

		JTextField apellidotxt = new JTextField();
		apellidotxt.setColumns(10);
		apellidotxt.setBounds(10, 129, 454, 27);
		apellidotxt.setDocument(new PlainDocument() {
		    @Override
		    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		        if (str == null)
		            return;

		        for (char c : str.toCharArray()) {
		            if (!Character.isLetter(c)) {
		                return; // Ignora la inserción de caracteres no alfabéticos
		            }
		        }

		        super.insertString(offset, str, attr);
		    }
		});
		apellidotxt.addKeyListener(new KeyListener() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c)) {
		            e.consume(); // Ignora la entrada de caracteres no alfabéticos
		        }
		    }

		    @Override
		    public void keyPressed(KeyEvent e) {
		        // No se requiere ninguna acción en este método
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		        // No se requiere ninguna acción en este método
		    }
		});
		panelCrearCliente.add(apellidotxt);

		JTextField celtxt = new JTextField();
		celtxt.setColumns(10);
		celtxt.setBounds(10, 238, 276, 27);
		celtxt.setDocument(new PlainDocument() {
		    @Override
		    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		        if (str == null)
		            return;

		        for (char c : str.toCharArray()) {
		            if (!Character.isDigit(c)) {
		                return; // Ignora la inserción de caracteres no numéricos
		            }
		        }

		        super.insertString(offset, str, attr);
		    }
		});
		celtxt.addKeyListener(new KeyListener() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isDigit(c)) {
		            e.consume(); // Ignora la entrada de caracteres no numéricos
		        }
		    }

		    @Override
		    public void keyPressed(KeyEvent e) {
		        // No se requiere ninguna acción en este método
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		        // No se requiere ninguna acción en este método
		    }
		});
		panelCrearCliente.add(celtxt);

		JTextField direcciontxt = new JTextField();
		direcciontxt.setColumns(10);
		direcciontxt.setBounds(10, 337, 454, 27);
		panelCrearCliente.add(direcciontxt);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblApellidos.setBounds(10, 104, 121, 14);
		panelCrearCliente.add(lblApellidos);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblTelefono.setBounds(10, 213, 121, 14);
		panelCrearCliente.add(lblTelefono);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblDireccion.setBounds(10, 312, 121, 14);
		panelCrearCliente.add(lblDireccion);

		JButton btnCrearCliente = new JButton("Crear Cliente");
		btnCrearCliente.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnCrearCliente.setBounds(400, 587, 190, 44);
		btnCrearCliente.setFocusable(false);
		FondoCrear.add(btnCrearCliente);
		btnCrearCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = nametxt.getText();
				String apellidos = apellidotxt.getText();
				String telefono = celtxt.getText();
				String direccion = direcciontxt.getText();

				// Insertar valores en base de datos
				try {
					// Conexion con base de datos
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");

					//  crear un statement con parametros de query
					String query = "INSERT INTO clientes (Nombre, Apellidos, Teléfono, Dirección) VALUES (?, ?, ?, ?)";
					PreparedStatement statement = connection.prepareStatement(query);

					// crear los parametros para los valores
					statement.setString(1, nombre);
					statement.setString(2, apellidos);
					statement.setString(3, telefono);
					statement.setString(4, direccion);

					//Ejecturas el query
					int rowsAffected = statement.executeUpdate();

					if (rowsAffected > 0) {
						System.out.println("Fila insertada");
						// limpiar los jtextfields despues de añadir nuevo
						nametxt.setText("");
						apellidotxt.setText("");
						celtxt.setText("");
						direcciontxt.setText("");
					}

					// Cierra statement y conexion
					statement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});


		JButton backCC = new JButton(new ImageIcon("BotonRetroceder.png"));
		backCC.setFocusable(false);
		backCC.setBounds(10, 11, 35, 33);
		backCC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(CrearClientes);
				add(Clientes);
				repaint();
				revalidate();
			}
		});
		FondoCrear.add(backCC);



		//------pantalla edicion de cliente------


		EditarTabla.setLayout(null);

		JPanel editarTablaCliente = new JPanel();
		editarTablaCliente.setBounds(0, 0, 977, 681);
		editarTablaCliente.setBackground(new Color(255, 128, 0));
		editarTablaCliente.setLayout(null);
		EditarTabla.add(editarTablaCliente);

		String[] columnNamesEdicion = {"Nombre", "Apellidos", "Teléfono", "Dirección"};
		DefaultTableModel tableModelEdicion = new DefaultTableModel(columnNamesEdicion, 0);
		JTable tablaEdicion = new JTable(tableModelEdicion);

		tablaEdicion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPaneEdicion = new JScrollPane(tablaEdicion);
		scrollPaneEdicion.setBounds(131, 257, 606, 300);
		editarTablaCliente.add(scrollPaneEdicion);

		JPanel panelEditar = new JPanel();
		panelEditar.setBackground(Color.GRAY);
		panelEditar.setBounds(131, 215, 606, 42);
		editarTablaCliente.add(panelEditar);
		panelEditar.setLayout(null);

		JLabel clienteAEditar = new JLabel("Cliente a Editar");
		clienteAEditar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		clienteAEditar.setBounds(220, 11, 182, 20);
		panelEditar.add(clienteAEditar);

		JLabel consultar_clientes = new JLabel("Consultar Clientes");
		consultar_clientes.setFont(new Font("Arial Black", Font.PLAIN, 30));
		consultar_clientes.setBounds(300, 137, 350, 50);
		editarTablaCliente.add(consultar_clientes);

		JComboBox<String> comboBox2 = new JComboBox<>();
		comboBox2.setBounds(760, 245, 156, 29);
		editarTablaCliente.add(comboBox2);

		JButton btnEdit1 = new JButton("Editar Cliente");
		btnEdit1.setBounds(760, 295, 156, 30);
		btnEdit1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(EditarTabla);
				add(EditarClientes);
				repaint();
				revalidate();
			}
		});
		editarTablaCliente.add(btnEdit1);

		JButton backET = new JButton(new ImageIcon("BotonRetroceder.png"));
		backET.setBounds(10, 11, 35, 33);
		backET.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(EditarTabla);
				add(Clientes);
				repaint();
				revalidate();
			}
		});
		editarTablaCliente.add(backET);

		try {
			// Conectar a base de datos
			String url = "jdbc:mysql://localhost:3306/clientes";
			String username = "root";
			String password = "";
			Connection connection = DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();

			String query = "SELECT Nombre, Apellidos, Teléfono, Dirección FROM clientes";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String nombre = resultSet.getString("Nombre");
				String apellidos = resultSet.getString("Apellidos");
				String telefono = resultSet.getString("Teléfono");
				String direccion = resultSet.getString("Dirección");

				// añadir fila
				Object[] rowData = {nombre, apellidos, telefono, direccion};
				tableModelEdicion.addRow(rowData);

				// valor combinado para el combobox
				String nameAndLastname = nombre + " " + apellidos;

				// añade valores al combobox
				comboBox2.addItem(nameAndLastname);
			}

			// cierra set, statement y conexion
			statement.close();
			resultSet.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}




		//-----pantalla seleccion editar cliente-----
		EditarClientes.setLayout(null);

		JPanel editarCliente = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		editarCliente.setBounds(0, 0, 977, 681);
		editarCliente.setBackground(new Color(255, 128, 0));
		editarCliente.setBorder(new EmptyBorder(5, 5, 5, 5));
		editarCliente.setLayout(null);
		EditarClientes.add(editarCliente);

		JLabel lblClienteNum = new JLabel("Editar Informacion");
		lblClienteNum.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblClienteNum.setBounds(428, 89, 351, 50);
		editarCliente.add(lblClienteNum);

		JPanel paneleditar2 = new JPanel();
		paneleditar2.setBounds(180, 150, 610, 426);
		editarCliente.add(paneleditar2);
		paneleditar2.setLayout(null);

		JLabel lblNameEdit = new JLabel("Nombre");
		lblNameEdit.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNameEdit.setBounds(10, 11, 121, 14);
		paneleditar2.add(lblNameEdit);

		JTextField textoEdit1 = new JTextField();
		textoEdit1.setColumns(10);
		textoEdit1.setBounds(10, 36, 454, 27);
		textoEdit1.setDocument(new PlainDocument() {
		    @Override
		    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		        if (str == null)
		            return;

		        for (char c : str.toCharArray()) {
		            if (!Character.isLetter(c)) {
		                return; // Ignorar la inserción de caracteres no alfabéticos
		            }
		        }

		        super.insertString(offset, str, attr);
		    }
		});
		textoEdit1.addKeyListener(new KeyListener() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c)) {
		            e.consume(); // Ignorar la entrada de caracteres no alfabéticos
		        }
		    }

		    @Override
		    public void keyPressed(KeyEvent e) {
		        // No se requiere ninguna acción en este método
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		        // No se requiere ninguna acción en este método
		    }
		});
		paneleditar2.add(textoEdit1);

		JTextField textoEdit2 = new JTextField();
		textoEdit2.setColumns(10);
		textoEdit2.setBounds(10, 129, 454, 27);
		textoEdit2.setDocument(new PlainDocument() {
		    @Override
		    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		        if (str == null)
		            return;

		        for (char c : str.toCharArray()) {
		            if (!Character.isLetter(c)) {
		                return; // Ignorar la inserción de caracteres no alfabéticos
		            }
		        }

		        super.insertString(offset, str, attr);
		    }
		});
		textoEdit2.addKeyListener(new KeyListener() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c)) {
		            e.consume(); // Ignorar la entrada de caracteres no alfabéticos
		        }
		    }

		    @Override
		    public void keyPressed(KeyEvent e) {
		        // No se requiere ninguna acción en este método
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		        // No se requiere ninguna acción en este método
		    }
		});
		paneleditar2.add(textoEdit2);


		JTextField textoEdit3 = new JTextField();
		textoEdit3.setColumns(10);
		textoEdit3.setBounds(10, 238, 276, 27);
		textoEdit3.setDocument(new PlainDocument() {
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;

        try {
            Integer.parseInt(str);
            super.insertString(offset, str, attr);
        } catch (NumberFormatException e) {
            // Ignorar la inserción de caracteres no numéricos
        }
    }
});
	textoEdit3.addKeyListener(new KeyListener() {
	    @Override
	    public void keyTyped(KeyEvent e) {
	        char c = e.getKeyChar();
	        if (!Character.isDigit(c)) {
	            e.consume();
	        }
	    }
	
	    @Override
	    public void keyPressed(KeyEvent e) {
	        // No se requiere ninguna acción en este método
	    }
	
	    @Override
	    public void keyReleased(KeyEvent e) {
	        // No se requiere ninguna acción en este método
			    }
		});
		paneleditar2.add(textoEdit3);

		JTextField textoEdit4 = new JTextField();
		textoEdit4.setColumns(10);
		textoEdit4.setBounds(10, 337, 454, 27);
		paneleditar2.add(textoEdit4);

		JLabel apellidoEdit = new JLabel("Apellidos");
		apellidoEdit.setFont(new Font("Arial Black", Font.PLAIN, 16));
		apellidoEdit.setBounds(10, 104, 121, 14);
		paneleditar2.add(apellidoEdit);

		JLabel telefonoEdit = new JLabel("Telefono");
		telefonoEdit.setFont(new Font("Arial Black", Font.PLAIN, 16));
		telefonoEdit.setBounds(10, 213, 121, 14);
		paneleditar2.add(telefonoEdit);

		JLabel direccionEdit = new JLabel("Direccion");
		direccionEdit.setFont(new Font("Arial Black", Font.PLAIN, 16));
		direccionEdit.setBounds(10, 312, 121, 14);
		paneleditar2.add(direccionEdit);

		JButton btnEditarCliente = new JButton("Editar Cliente");
		btnEditarCliente.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnEditarCliente.setBounds(444, 587, 147, 44);
		editarCliente.add(btnEditarCliente);



		editarCliente.add(btnEditarCliente);

		btnEditarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedClient = (String) comboBox2.getSelectedItem();
				String[] nameAndLastname = selectedClient.split(" ");
				String nombre = textoEdit1.getText();
				String apellidos = textoEdit2.getText();
				String telefono = textoEdit3.getText();
				String direccion = textoEdit4.getText();

				try {
					// Connect to the database
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "root");

					// Create a statement with query parameters
					String query = "UPDATE clientes SET Nombre = ?, Apellidos = ?, Teléfono = ?, Dirección = ? WHERE Nombre = ? AND Apellidos = ?";
					PreparedStatement statement = connection.prepareStatement(query);

					// Set the parameters for the values
					statement.setString(1, nombre);
					statement.setString(2, apellidos);
					statement.setString(3, telefono);
					statement.setString(4, direccion);
					statement.setString(5, nameAndLastname[0]);
					statement.setString(6, nameAndLastname[1]);

					// Execute the query
					int rowsAffected = statement.executeUpdate();

					if (rowsAffected > 0) {
						System.out.println("Fila actualizada");
						// Clear the JTextFields after updating
						textoEdit1.setText("");
						textoEdit2.setText("");
						textoEdit3.setText("");
						textoEdit4.setText("");
					}

					// Close the statement and connection
					statement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

// ...

		JButton backEC = new JButton(new ImageIcon("BotonRetroceder.png"));
		backEC.setBounds(10, 11, 35, 33);
		backEC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(EditarClientes);
				add(EditarTabla);
				repaint();
				revalidate();
			}
		});
		editarCliente.add(backEC);



		//-----pantalla consulta de clientes-----
		ConsultaClientes.setLayout(null);

		JPanel consultarClientes = new JPanel();
		consultarClientes.setBounds(0, 0, 977, 681);
		consultarClientes.setBackground(new Color(255, 128, 0));
		consultarClientes.setLayout(null);
		ConsultaClientes.add(consultarClientes);

		String[] columnNamesConsulta = {"Nombre", "Apellidos", "Teléfono", "Dirección"};
		DefaultTableModel tableModelConsulta = new DefaultTableModel(columnNamesConsulta, 0);
		JTable tablaConsulta = new JTable(tableModelConsulta);

		tablaConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPaneConsulta = new JScrollPane(tablaConsulta);
		scrollPaneConsulta.setBounds(131, 257, 606, 300);
		consultarClientes.add(scrollPaneConsulta);

		JComboBox<String> comboBoxConsulta = new JComboBox<>();
		comboBoxConsulta.setBounds(757, 257, 140, 30);
		consultarClientes.add(comboBoxConsulta);

		JButton btnConsultaTabla = new JButton("Consultar Cliente");
		btnConsultaTabla.setFocusable(false);
		btnConsultaTabla.setBounds(757, 297, 140, 30);
		btnConsultaTabla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(ConsultaClientes);
				add(InfoCliente);
				repaint();
				revalidate();
			}
		});
		consultarClientes.add(btnConsultaTabla);


		JPanel panelConsulta2 = new JPanel();
		panelConsulta2.setBackground(Color.GRAY);
		panelConsulta2.setBounds(131, 215, 606, 42);
		consultarClientes.add(panelConsulta2);
		panelConsulta2.setLayout(null);

		JLabel historial = new JLabel("Cliente a Consultar");
		historial.setFont(new Font("Arial Black", Font.PLAIN, 16));
		historial.setBounds(210, 11, 190, 20);
		panelConsulta2.add(historial);


		JLabel clientes = new JLabel("Consultar Clientes");
		clientes.setFont(new Font("Arial Black", Font.PLAIN, 20));
		clientes.setBounds(350, 137, 220, 50);
		consultarClientes.add(clientes);

		JButton backConsulta = new JButton(new ImageIcon("BotonRetroceder.png"));
		backConsulta.setFocusable(false);
		backConsulta.setBounds(10, 11, 35, 33);
		backConsulta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(ConsultaClientes);
				add(Clientes);
				repaint();
				revalidate();
			}
		});
		consultarClientes.add(backConsulta);


		//-------Informacion de Cliente--------

		InfoCliente.setLayout(null);

		JPanel infoCliente = new JPanel();
		infoCliente.setBounds(0,0,977,681);
		infoCliente.setBackground(new Color(255, 128, 0));
		infoCliente.setLayout(null);
		InfoCliente.add(infoCliente);

		JLabel infoTitulo = new JLabel("Informacion del Cliente");
		infoTitulo.setBounds(270,70,400,50);
		infoTitulo.setFont(new Font("Arial Black", Font.PLAIN, 30));
		infoCliente.add(infoTitulo);

		JPanel sobreFondoInfo = new JPanel();
		sobreFondoInfo.setBounds(150,120,620,470);
		sobreFondoInfo.setLayout(null);
		infoCliente.add(sobreFondoInfo);

		String[] columnNamesInfo = {"Nombre", "Apellidos", "Teléfono", "Dirección"};
		DefaultTableModel tableModelInfo = new DefaultTableModel(columnNamesInfo, 0);
		JTable tablaInfo = new JTable(tableModelInfo);

		tablaInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPaneInfo = new JScrollPane(tablaInfo);
		scrollPaneInfo.setBounds(0, 20, 620, 230);
		sobreFondoInfo.add(scrollPaneInfo);

		JButton backInfoConsulta = new JButton(new ImageIcon("BotonRetroceder.png"));
		backInfoConsulta.setFocusable(false);
		backInfoConsulta.setBounds(10, 11, 35, 33);
		backInfoConsulta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(InfoCliente);
				add(ConsultaClientes);
				repaint();
				revalidate();
			}
		});
		infoCliente.add(backInfoConsulta);


		//----pantalla eliminar clientes----

		EliminarClientes.setLayout(null);

		JPanel eliminarClientes = new JPanel();
		eliminarClientes.setBounds(0, 0, 977, 681);
		eliminarClientes.setBackground(new Color(255, 128, 0));
		eliminarClientes.setLayout(null);
		EliminarClientes.add(eliminarClientes);

		String[] columnNames = {"Nombre", "Apellidos", "Teléfono", "Dirección"};
		DefaultTableModel tableModel1 = new DefaultTableModel(columnNames, 0);
		JTable tablaEliminar = new JTable(tableModel1);

		tablaEliminar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane(tablaEliminar);
		scrollPane.setBounds(131, 257, 606, 300);
		eliminarClientes.add(scrollPane);

		JComboBox<String> comboBox1 = new JComboBox<>();
		comboBox1.setBounds(757, 257, 140, 30);
		eliminarClientes.add(comboBox1);

		JButton eliminarcliente = new JButton("Eliminar cliente");
		eliminarcliente.setBounds(757, 297, 140, 30);
		eliminarClientes.add(eliminarcliente);

		JPanel panelsito = new JPanel();
		panelsito.setBackground(Color.GRAY);
		panelsito.setBounds(131, 215, 606, 42);
		panelsito.setLayout(null);
		eliminarClientes.add(panelsito);

		JLabel lblTitulo = new JLabel("Cliente a Eliminar");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblTitulo.setBounds(225, 11, 182, 20);
		panelsito.add(lblTitulo);

		JLabel lblEliminar = new JLabel("Eliminar Clientes");
		lblEliminar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblEliminar.setBounds(370, 137, 210, 50);
		eliminarClientes.add(lblEliminar);

		JButton backEliminar = new JButton(new ImageIcon("BotonRetroceder.png"));
		backEliminar.setFocusable(false);
		backEliminar.setBounds(10, 11, 35, 33);
		backEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(EliminarClientes);
				add(Clientes);
				repaint();
				revalidate();
			}
		});
		eliminarClientes.add(backEliminar);

		try {

			String url = "jdbc:mysql://localhost:3306/clientes";
			String username = "root";
			String password = "";
			Connection connection = DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();

			String query = "SELECT Nombre, Apellidos, Teléfono, Dirección FROM clientes";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String nombre = resultSet.getString("Nombre");
				String apellidos = resultSet.getString("Apellidos");
				String telefono = resultSet.getString("Teléfono");
				String direccion = resultSet.getString("Dirección");


				Object[] rowData = {nombre, apellidos, telefono, direccion};
				tableModel1.addRow(rowData);

				String nameAndLastname = nombre + " " + apellidos;

				// añadir valores a combobox
				comboBox1.addItem(nameAndLastname);
			}
			repaint();

			statement.close();
			resultSet.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		eliminarcliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedClient = (String) comboBox1.getSelectedItem();
				String[] nameAndLastname = selectedClient.split(" ");
				String nombre = nameAndLastname[0];
				String apellidos = nameAndLastname[1];

				try {
					// Conectar

					String url = "jdbc:mysql://localhost:3306/clientes";
					String username = "root";
					String password = "";
					Connection connection = DriverManager.getConnection(url, username, password);

					Statement statement = connection.createStatement();

					// ELIMINAr fila de la base ded atos
					String deleteQuery = "DELETE FROM clientes WHERE Nombre='" + nombre + "' AND Apellidos='" + apellidos + "'";
					statement.executeUpdate(deleteQuery);

					// eliminar fila seleccionada del jtable
					int rowCount = tableModel1.getRowCount();
					for (int i = 0; i < rowCount; i++) {
						String tableNombre = (String) tableModel1.getValueAt(i, 0);
						String tableApellidos = (String) tableModel1.getValueAt(i, 1);
						if (tableNombre.equals(nombre) && tableApellidos.equals(apellidos)) {
							tableModel1.removeRow(i);
							break;
						}
					}

					// Eliminar seleccionado del combobox
					comboBox1.removeItem(selectedClient);

					// Limpiar seleccion del combobox
					comboBox1.setSelectedIndex(-1);

					statement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});


	}}