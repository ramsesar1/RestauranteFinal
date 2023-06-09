import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.event.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class Restaurante extends JFrame {

	private JPanel contentPane;
	private JTextField textfieldusername;
	private JTextField nombreusuario;
	private JPasswordField contras;
	private JLabel lblContrasea;

	private Timer updateTimer;





	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		migrateTables();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurante frame = new Restaurante();
					frame.setVisible(true);
					frame.setResizable(false);
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
		JPanel PanelConsultaOrden = new JPanel();
		JPanel CrearOrden = new JPanel();
		JPanel EliminarOrden= new JPanel();
		JPanel EditarOrden = new JPanel();
		JPanel PanelEditarOrden = new JPanel();


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
		logotipo.setBounds(410,0,120,150);
		menufondito.add(logotipo);

		JLabel nombreLogo = new JLabel(new ImageIcon("tituloR (1).png"));
		nombreLogo.setBounds(298,70,350,233);
		menufondito.add(nombreLogo);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(273, 250, 391, 313);
		menufondito.add(panel_1);
		panel_1.setLayout(null);


		nombreusuario = new JTextField();
		nombreusuario.setColumns(10);
		nombreusuario.setBounds(30, 57, 328, 45);
		panel_1.add(nombreusuario);

		contras = new JPasswordField();
		contras.setColumns(10);
		contras.setBounds(30, 180, 328, 45);
		panel_1.add(contras);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(30, 26, 149, 28);
		panel_1.add(lblNewLabel);

		lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblContrasea.setBounds(30, 142, 149, 28);
		panel_1.add(lblContrasea);

		JButton btnparalogin = new JButton("Login");
		btnparalogin.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnparalogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = new String(nombreusuario.getText());
				String password = new String(contras.getPassword());

				// Establish a database connection
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/credenciales", "root", "");
					String query = "SELECT * FROM iniciosesion LIMIT 1";
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					ResultSet resultSet = preparedStatement.executeQuery();

					if (resultSet.next()) {
						String storedUsername = resultSet.getString("Usuario");
						String storedPassword = resultSet.getString("Contrasena");

						System.out.println("Entered Username: " + username);
						System.out.println("Stored Username: " + storedUsername);
						System.out.println("Entered Password: " + password);
						System.out.println("Stored Password: " + storedPassword);

						if (username.equals(storedUsername) && password.equals(storedPassword)) {
							// Login successful
							remove(login);
							add(Inicio);
							repaint();
							revalidate();
						} else {
							// Login failed
							JOptionPane.showMessageDialog(login, "Usuario incorrecto, ingrese credenciales correctas", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						// No rows found in the table
						JOptionPane.showMessageDialog(login, "No se encontraron registros en la tabla", "Error", JOptionPane.ERROR_MESSAGE);
					}

					resultSet.close();
					preparedStatement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println("SQLException: " + ex.getMessage());
				}
			}
		});

		btnparalogin.setBackground(new Color(255, 255, 255));
		btnparalogin.setBounds(30, 236, 110, 45);
		panel_1.add(btnparalogin);


		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial Black", Font.PLAIN, 18));
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

		JLabel logotipoInicio = new JLabel(new ImageIcon("iconochido.gif"));
		logotipoInicio.setBounds(300,0,120,150);
		panelmenu.add(logotipoInicio);

		JLabel nombreLogoInicio = new JLabel(new ImageIcon("tituloR (1).png"));
		nombreLogoInicio.setBounds(178,90,350,233);
		panelmenu.add(nombreLogoInicio);

		JButton btnplatillos = new JButton("Platillos\r\n");
		btnplatillos.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnplatillos.setFocusable(false);
		btnplatillos.setBackground(new Color(255, 128, 0));
		btnplatillos.setBounds(53, 300, 279, 100);
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
		btnNewButtonclientes.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnNewButtonclientes.setFocusable(false);
		btnNewButtonclientes.setBackground(new Color(255, 128, 0));
		btnNewButtonclientes.setBounds(53, 420, 279, 100);
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
		btnentrarinventario.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnentrarinventario.setBackground(new Color(255, 128, 0));
		btnentrarinventario.setFocusable(false);
		btnentrarinventario.setBounds(364, 420, 279, 100);
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
		btnNewButtonOrden.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnNewButtonOrden.setBackground(new Color(255, 128, 0));
		btnNewButtonOrden.setFocusable(false);
		btnNewButtonOrden.setBounds(364, 300, 279, 100);
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




		//--------------------------------------------platillos---------------------------------------------------------


		//----Menu principal de platillos-----


//		contentPane.add(Platillos);
		Platillos.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(61, 241, 827, 347);
		panel.setOpaque(false);
		Platillos.add(panel);
		panel.setLayout(null);

		JButton btnconsultar = new JButton("Consultar");
		btnconsultar.setBackground(new Color(255, 128, 0));
		btnconsultar.setFocusable(false);
		btnconsultar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnconsultar.setBounds(183, 94, 217, 60);
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
		btnEditar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnEditar.setBackground(new Color(255, 128, 0));
		btnEditar.setFocusable(false);
		btnEditar.setBounds(430, 94, 217, 60);
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
		btnIngredientes.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnIngredientes.setBackground(new Color(255, 128, 0));
		btnIngredientes.setBounds(183, 197, 217, 60);
		btnIngredientes.setFocusable(false);
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


		JButton btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnCrear.setBackground(new Color(255, 128, 0));
		btnCrear.setFocusable(false);
		btnCrear.setBounds(430, 197, 217, 60);
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

		JLabel lblplatillos = new JLabel(new ImageIcon("menuplatillos (1).png"));
		lblplatillos.setBounds(301, 51, 350, 233);
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







// ----Consultar platillos-----

		ConsultaPlatillos.setBackground(new Color(255, 128, 0));
		ConsultaPlatillos.setLayout(null);

		DefaultListModel<String> model = new DefaultListModel<>();

		JLabel lblconsultaplatillos = new JLabel("Consultar Platillos");
		lblconsultaplatillos.setFont(new Font("Arial Black", Font.PLAIN, 26));
		lblconsultaplatillos.setBounds(360, 11, 300, 52);
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
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(111, 11, 300, 61);
		panelplati_1.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Platillo: \r\n");
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.PLAIN, 21));
		lblNewLabel_2_1.setBounds(22, 111, 264, 61);
		panelplati_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("Precio: ");
		lblNewLabel_2_1_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_2_1_2.setBounds(22, 389, 400, 61);
		panelplati_1.add(lblNewLabel_2_1_2);

		JTextArea txtrDescripcinDescubreNuestro = new JTextArea();
		txtrDescripcinDescubreNuestro.setFont(new Font("Arial Black", Font.PLAIN, 19));
		txtrDescripcinDescubreNuestro.setTabSize(10);
		txtrDescripcinDescubreNuestro.setText("Descripción: ");
		txtrDescripcinDescubreNuestro.setBounds(22, 201, 399, 177);
		panelplati_1.add(txtrDescripcinDescubreNuestro);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 128, 0));
		panel_3.setBounds(47, 459, 331, 70);
		panelplati_1.add(panel_3);
		panel_3.setLayout(null);

		JButton btnIngredientes2 = new JButton("Ingredientes");
		btnIngredientes2.setFont(new Font("Arial Black", Font.PLAIN, 35));
		btnIngredientes2.setBackground(new Color(255, 128, 0));
		btnIngredientes2.setFocusable(false);
		btnIngredientes2.setOpaque(true);
		btnIngredientes2.setBounds(0, 0, 331, 70);
		panel_3.add(btnIngredientes2);



		String[] nombrecolumns = {"Platillo"};
		Object[][] data = {

		};

		DefaultTableModel tablemodelconsultaplat = new DefaultTableModel(data, nombrecolumns);

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos", "root", "");
			Statement statement = connection.createStatement();
			ResultSet tableResultSet = statement.executeQuery("SHOW TABLES");

			while (tableResultSet.next()) {
				String tableName = tableResultSet.getString(1);
				tablemodelconsultaplat.addRow(new Object[]{tableName});
			}

			tableResultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		JLabel lblNewLabel_1 = new JLabel("Seleccione platillo");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(100, 5, 300, 36);
		panelplati.add(lblNewLabel_1);

		JButton btnbackconsultaplat = new JButton(new ImageIcon("BotonRetroceder.png"));
		btnbackconsultaplat.setBounds(10, 11, 35, 33);
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

		JTable consultaplattable = new JTable(tablemodelconsultaplat);

		consultaplattable.setModel(tablemodelconsultaplat);

		JScrollPane scrollconsultaplattable = new JScrollPane(consultaplattable);
		scrollconsultaplattable.setBounds(35, 40, 288, 519);
		panelplati.add(scrollconsultaplattable);


		// ...

		MouseListener tableRowMouseListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = consultaplattable.getSelectedRow();

				if (rowIndex != -1) {
					String tableName = tablemodelconsultaplat.getValueAt(rowIndex, 0).toString();

					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos", "root", "");
						Statement statement = connection.createStatement();
						ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);

						if (resultSet.next()) {
							String precio = resultSet.getString("precio");
							String descripcion = resultSet.getString("descripcion");

							lblNewLabel_2_1.setText("Platillo: " + tableName);
							lblNewLabel_2_1_2.setText("Precio: " + precio);
							txtrDescripcinDescubreNuestro.setText("Descripcion: " + descripcion);
						}

						resultSet.close();
						statement.close();
						connection.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			}
		};

		btnIngredientes2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRowIndex = consultaplattable.getSelectedRow();

				if (selectedRowIndex != -1) {
					String tableName = tablemodelconsultaplat.getValueAt(selectedRowIndex, 0).toString();

					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos", "root", "");
						Statement statement = connection.createStatement();
						ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);

						StringBuilder ingredientesBuilder = new StringBuilder();
						while (resultSet.next()) {
							String ingredientes = resultSet.getString("Ingrediente");
							ingredientesBuilder.append(ingredientes).append("\n");
						}
						String allIngredientes = ingredientesBuilder.toString().trim();

						JFrame ingredientsFrame = new JFrame("Ingredientes del Platillo");
						ingredientsFrame.setSize(400, 300);
						ingredientsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						ingredientsFrame.setLayout(new BorderLayout());

						JTextArea textArea = new JTextArea(allIngredientes);
						textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
						textArea.setEditable(false);
						JScrollPane scrollPane = new JScrollPane(textArea);
						ingredientsFrame.add(scrollPane, BorderLayout.CENTER);

						JButton btnClose = new JButton("Close");
						btnClose.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								ingredientsFrame.setVisible(false);
								ingredientsFrame.dispose();
							}
						});
						ingredientsFrame.add(btnClose, BorderLayout.SOUTH);

						ingredientsFrame.setVisible(true);

						resultSet.close();
						statement.close();
						connection.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			}
		});



		consultaplattable.addMouseListener(tableRowMouseListener);

		Timer timer = new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				tablemodelconsultaplat.setRowCount(0);

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos", "root", "");
					Statement statement = connection.createStatement();
					ResultSet tableResultSet = statement.executeQuery("SHOW TABLES");

					while (tableResultSet.next()) {
						String tableName = tableResultSet.getString(1);
						tablemodelconsultaplat.addRow(new Object[]{tableName});
					}

					tableResultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		timer.start();



		/*
// Create a custom MouseListener for the table rows
		MouseListener tableRowMouseListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Get the selected row index
				int rowIndex = consultaplattable.getSelectedRow();

				// Perform actions based on the selected row
				if (rowIndex != -1) {
					// Assuming the table name is stored in the first column (index 0)
					String tableName = tablemodelconsultaplat.getValueAt(rowIndex, 0).toString();

					// Fetch the details from the respective table in the database
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos", "root", "root");
						Statement statement = connection.createStatement();
						ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);

						// Assuming "precio" and "descripcion" are the column names in the table
						if (resultSet.next()) {
							String precio = resultSet.getString("precio");
							String descripcion = resultSet.getString("descripcion");

							// Update the JLabels with the retrieved information
							lblNewLabel_2_1.setText("Platillo: " + tableName);
							lblNewLabel_2_1_2.setText("Precio: " + precio);
							txtrDescripcinDescubreNuestro.setText(descripcion);
						}

						resultSet.close();
						statement.close();
						connection.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
						// Handle the exception if an error occurs while fetching data from the database
					}
				}
			}
		};

// Add the custom MouseListener to the JTable
		consultaplattable.addMouseListener(tableRowMouseListener);

// ...
*/






		//----Crear Platillos-----

		Crearplat.setBackground(new Color(255, 128, 0));
		Crearplat.setBounds(0, 0, 961, 642);
		//	contentPane.add(Crearplat);
		Crearplat.setLayout(null);



		JPanel panelcrearplat = new JPanel();
		panelcrearplat.setBackground(new Color(255, 218, 168));
		panelcrearplat.setBounds(10, 45, 930, 580);
		Crearplat.add(panelcrearplat);
		panelcrearplat.setLayout(null);


		JTextField NombrePlatCrearField = new JTextField();
		NombrePlatCrearField.setColumns(10);
		NombrePlatCrearField.setBounds(23, 41, 372, 33);
		panelcrearplat.add(NombrePlatCrearField);

		JTextField PreciocrearPlat = new JTextField();
		PreciocrearPlat.setColumns(10);
		PreciocrearPlat.setBounds(23, 495, 372, 33);
		panelcrearplat.add(PreciocrearPlat);

		JTextArea Descripcionareacrear = new JTextArea();
		Descripcionareacrear.setBounds(23, 359, 372, 101);
		panelcrearplat.add(Descripcionareacrear);

		JComboBox ingredienteboxcrear = new JComboBox();
		ingredienteboxcrear.setBounds(23, 108, 372, 33);
		panelcrearplat.add(ingredienteboxcrear);

		JLabel nombreplatcrearlaberl = new JLabel("Nombre del Platillo:");
		nombreplatcrearlaberl.setFont(new Font("Arial Black", Font.PLAIN, 20));
		nombreplatcrearlaberl.setBounds(23, 11, 242, 19);
		panelcrearplat.add(nombreplatcrearlaberl);

		JLabel comboingredcrear = new JLabel("Ingredientes y unidad\r\n:\r\n");
		comboingredcrear.setFont(new Font("Arial Black", Font.PLAIN, 20));
		comboingredcrear.setBounds(23, 74, 265, 37);
		panelcrearplat.add(comboingredcrear);

		JLabel Descripcioncrearplatlabel = new JLabel("Descripción:");
		Descripcioncrearplatlabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		Descripcioncrearplatlabel.setBounds(23, 315, 331, 33);
		panelcrearplat.add(Descripcioncrearplatlabel);

		JLabel lblPreciocrearplat = new JLabel("Precio:");
		lblPreciocrearplat.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblPreciocrearplat.setBounds(23, 460, 293, 33);
		panelcrearplat.add(lblPreciocrearplat);

		JButton btnCrearPlat = new JButton("Crear");
		btnCrearPlat.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnCrearPlat.setBackground(new Color(254, 211, 122));
		btnCrearPlat.setBounds(434, 526, 150, 43);
		panelcrearplat.add(btnCrearPlat);


		JTextField cantidadingrediente2 = new JTextField();
		cantidadingrediente2.setColumns(10);
		cantidadingrediente2.setBounds(23, 177, 372, 33);
		panelcrearplat.add(cantidadingrediente2);

		JLabel Cantidadinglbl = new JLabel("Cantidad del ingrediente\r\n");
		Cantidadinglbl.setFont(new Font("Arial Black", Font.PLAIN, 20));
		Cantidadinglbl.setBounds(23, 147, 300, 33);
		panelcrearplat.add(Cantidadinglbl);

		JButton btnAadirIngrediente = new JButton("Añadir ingrediente\r\n");
		btnAadirIngrediente.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnAadirIngrediente.setBackground(new Color(254, 211, 122));
		btnAadirIngrediente.setBounds(23, 224, 211, 43);
		panelcrearplat.add(btnAadirIngrediente);


		JButton btncrearplat2 = new JButton("Crear");
		btncrearplat2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btncrearplat2.setBackground(new Color(254, 211, 122));
		btncrearplat2.setBounds(434, 526, 150, 43);
		panelcrearplat.add(btncrearplat2);


		JLabel Crearplatlbl = new JLabel("Crear Platillo");
		Crearplatlbl.setFont(new Font("Arial Black", Font.PLAIN, 26));
		Crearplatlbl.setBounds(387, 0, 227, 40);
		Crearplat.add(Crearplatlbl);


		btnCrearPlat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tableName = NombrePlatCrearField.getText();
				String precio = PreciocrearPlat.getText().isEmpty() ? null : PreciocrearPlat.getText();
				String[] ingredienteData = ingredienteboxcrear.getSelectedItem().toString().split(" - ");
				String ingrediente = ingredienteData[0];
				String unidad = ingredienteData[1];
				String cantidad = cantidadingrediente2.getText().isEmpty() ? null : cantidadingrediente2.getText();
				String descripcion = Descripcionareacrear.getText();

				if (cantidadingrediente2.getText().isEmpty() || PreciocrearPlat.getText().isEmpty() || Descripcionareacrear.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill in all the required fields");
				} else {
					String url = "jdbc:mysql://localhost:3306/platillos";
					String username = "root";
					String password = "";

					try (Connection connection = DriverManager.getConnection(url, username, password)) {
						DatabaseMetaData metaData = connection.getMetaData();
						ResultSet resultSet = metaData.getTables(null, null, tableName, null);

						if (resultSet.next()) {
							JOptionPane.showMessageDialog(null, "Para editar platillo, vaya a la sección de editar");
						} else {
							Statement statement = connection.createStatement();

							String createTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " (Precio FLOAT, Ingrediente VARCHAR(50), Unidad VARCHAR(50), Cantidad FLOAT, Descripcion VARCHAR(255))";
							statement.executeUpdate(createTableQuery);

							String insertDataQuery = "INSERT INTO " + tableName + " (Precio, Ingrediente, Unidad, Cantidad, Descripcion) VALUES (?, ?, ?, ?, ?)";
							PreparedStatement preparedStatement = connection.prepareStatement(insertDataQuery);
							if (precio == null) {
								preparedStatement.setNull(1, Types.FLOAT);
							} else {
								preparedStatement.setFloat(1, Float.parseFloat(precio));
							}
							preparedStatement.setString(2, ingrediente);
							preparedStatement.setString(3, unidad);
							if (cantidad == null) {
								preparedStatement.setNull(4, Types.FLOAT);
							} else {
								preparedStatement.setFloat(4, Float.parseFloat(cantidad));
							}
							preparedStatement.setString(5, descripcion);
							preparedStatement.executeUpdate();

							System.out.println("Data inserted successfully!");
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			}
		});




		btnAadirIngrediente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tableName = NombrePlatCrearField.getText();

				String[] ingredienteData = ingredienteboxcrear.getSelectedItem().toString().split(" - ");
				String ingrediente = ingredienteData[0];
				String unidad = ingredienteData[1];
				String cantidad = cantidadingrediente2.getText();
				String precio = PreciocrearPlat.getText();

				if (!ingredientExists(tableName, ingrediente)) {
					String url = "jdbc:mysql://localhost:3306/platillos";
					String username = "root";
					String password = "";

					try (Connection connection = DriverManager.getConnection(url, username, password)) {
						Statement statement = connection.createStatement();

						String insertDataQuery = "INSERT INTO " + tableName + " (Precio, Ingrediente, Unidad, Cantidad) VALUES (?, ?, ?, ?)";
						PreparedStatement preparedStatement = connection.prepareStatement(insertDataQuery);

						// Check and handle empty values
						if (precio == null || precio.isEmpty()) {
							preparedStatement.setNull(1, Types.FLOAT);
						} else {
							preparedStatement.setFloat(1, Float.parseFloat(precio));
						}
						preparedStatement.setString(2, ingrediente);
						preparedStatement.setString(3, unidad);
						if (cantidad == null || cantidad.isEmpty()) {
							preparedStatement.setNull(4, Types.FLOAT);
						} else {
							preparedStatement.setFloat(4, Float.parseFloat(cantidad));
						}

						preparedStatement.executeUpdate();

						JOptionPane.showMessageDialog(null, "Ingrediente añadido correctamente");
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ingrediente ya existe en el platillo");
				}
			}
		});





		JButton btnbackcrearplatillos = new JButton(new ImageIcon("BotonRetroceder.png"));
		btnbackcrearplatillos.setBounds(10, 11, 35, 33);
		Crearplat.add(btnbackcrearplatillos);


		String url2 = "jdbc:mysql://localhost:3306/clientes";
		String username2 = "root";
		String password2 = "";

		try (Connection connection = DriverManager.getConnection(url2, username2, password2)) {
			Statement statement = connection.createStatement();

			String query = "SELECT Nombre, Unidad FROM inventario";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String nombre = resultSet.getString("Nombre");
				String unidad = resultSet.getString("Unidad");
				String displayValue = nombre + " - " + unidad;
				ingredienteboxcrear.addItem(displayValue);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		Timer timer7 = new Timer(15000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Clear the existing items in the ingredienteboxcrear JComboBox
				ingredienteboxcrear.removeAllItems();

				// Re-populate the ingredienteboxcrear JComboBox with updated data
				try (Connection connection = DriverManager.getConnection(url2, username2, password2)) {
					Statement statement = connection.createStatement();

					String query = "SELECT Nombre, Unidad FROM inventario";
					ResultSet resultSet = statement.executeQuery(query);

					while (resultSet.next()) {
						String nombre = resultSet.getString("Nombre");
						String unidad = resultSet.getString("Unidad");
						String displayValue = nombre + " - " + unidad;
						ingredienteboxcrear.addItem(displayValue);
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		timer7.start();







		btnbackcrearplatillos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Crearplat);
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
		NombrePlatEdField.setBounds(23, 112, 372, 33);
		paneledplat.add(NombrePlatEdField);

		JTextField PrecioEdPlat = new JTextField();
		PrecioEdPlat.setColumns(10);
		PrecioEdPlat.setBounds(23, 504, 372, 33);
		paneledplat.add(PrecioEdPlat);

		JTextArea Descripcionareaediplat = new JTextArea();
		Descripcionareaediplat.setBounds(23, 374, 372, 101);
		paneledplat.add(Descripcionareaediplat);

		JComboBox ingredientebox = new JComboBox();
		ingredientebox.setBounds(23, 179, 372, 33);
		paneledplat.add(ingredientebox);

		JLabel nombreplatedilbl = new JLabel("Nombre del Platillo:");
		nombreplatedilbl.setFont(new Font("Arial Black", Font.PLAIN, 20));
		nombreplatedilbl.setBounds(23, 92, 242, 19);
		paneledplat.add(nombreplatedilbl);

		JLabel lblIngredientes = new JLabel("Ingredientes del platillo:\r\n");
		lblIngredientes.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblIngredientes.setBounds(23, 145, 300, 37);
		paneledplat.add(lblIngredientes);

		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblDescripcin.setBounds(23, 341, 331, 33);
		paneledplat.add(lblDescripcin);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblPrecio.setBounds(23, 470, 293, 33);
		paneledplat.add(lblPrecio);

		JButton btnEditarPlat = new JButton("Editar\r\n");
		btnEditarPlat.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnEditarPlat.setBackground(new Color(254, 211, 122));
		btnEditarPlat.setBounds(404, 536, 150, 33);
		paneledplat.add(btnEditarPlat);


		JComboBox Platilloaeditarbox = new JComboBox();
		Platilloaeditarbox.setBounds(23, 48, 372, 33);
		paneledplat.add(Platilloaeditarbox);

		JLabel seleccionediplat = new JLabel("Escoja platillo a editar\r\n");
		seleccionediplat.setFont(new Font("Arial Black", Font.PLAIN, 20));
		seleccionediplat.setBounds(23, 18, 300, 33);
		paneledplat.add(seleccionediplat);

		JButton btnEliminarIngredienteedi = new JButton("Eliminar ingrediente\r\n");
		btnEliminarIngredienteedi.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnEliminarIngredienteedi.setBackground(new Color(254, 211, 122));
		btnEliminarIngredienteedi.setBounds(23, 249, 230, 43);
		paneledplat.add(btnEliminarIngredienteedi);

		JComboBox ingredientebox_1 = new JComboBox();
		ingredientebox_1.setBounds(475, 149, 372, 33);
		paneledplat.add(ingredientebox_1);

		JButton btnediAadirIngrediente = new JButton("Añadir ingrediente\r\n");
		btnediAadirIngrediente.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnediAadirIngrediente.setBackground(new Color(254, 211, 122));
		btnediAadirIngrediente.setBounds(475, 281, 211, 43);
		paneledplat.add(btnediAadirIngrediente);

		JLabel comoingreeditarplat = new JLabel("Ingredientes y unidad\r\n:\r\n");
		comoingreeditarplat.setFont(new Font("Arial Black", Font.PLAIN, 20));
		comoingreeditarplat.setBounds(475, 105, 265, 37);
		paneledplat.add(comoingreeditarplat);

		textfieldusername = new JTextField();
		textfieldusername.setColumns(10);
		textfieldusername.setBounds(475, 224, 372, 33);
		paneledplat.add(textfieldusername);

		JLabel Cantidadingreedilbl = new JLabel("Cantidad del ingrediente\r\n");
		Cantidadingreedilbl.setFont(new Font("Arial Black", Font.PLAIN, 20));
		Cantidadingreedilbl.setBounds(475, 190, 300, 33);
		paneledplat.add(Cantidadingreedilbl);

		JLabel editarplatlbl = new JLabel("Editar Platillo\r\n");
		editarplatlbl.setFont(new Font("Arial Black", Font.PLAIN, 27));
		editarplatlbl.setBounds(390, 11, 234, 38);
		EditarPlat.add(editarplatlbl);

		JButton btnEliminarPlatillo = new JButton("Eliminar platillo");
		btnEliminarPlatillo.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnEliminarPlatillo.setBackground(new Color(254, 211, 122));
		btnEliminarPlatillo.setBounds(475, 48, 211, 33);
		paneledplat.add(btnEliminarPlatillo);

		JButton btnbackeditarplatillos = new JButton(new ImageIcon("BotonRetroceder.png"));
		btnbackeditarplatillos.setBounds(10, 11, 35, 33);
		EditarPlat.add(btnbackeditarplatillos);


		btnEliminarPlatillo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the table?", "Confirmation", JOptionPane.YES_NO_OPTION);

				if (confirm == JOptionPane.YES_OPTION) {
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/platillos", "root", "");

						String selectedTable = (String) Platilloaeditarbox.getSelectedItem();

						String deleteQuery = "DROP TABLE IF EXISTS " + selectedTable;
						PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
						deleteStatement.executeUpdate();
						deleteStatement.close();

						JOptionPane.showMessageDialog(null, "Table deleted successfully");

						connection.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			}
		});


		Platilloaeditarbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/clientes", "root", "");

					Statement statement = connection.createStatement();

					String selectedTable = (String) Platilloaeditarbox.getSelectedItem();

					ResultSet resultSet = statement.executeQuery("SELECT Nombre, Unidad FROM inventario");

					ingredientebox_1.removeAllItems();

					while (resultSet.next()) {
						String nombre = resultSet.getString("Nombre");
						String unidad = resultSet.getString("Unidad");
						String combinedValue = nombre + " - " + unidad;
						ingredientebox_1.addItem(combinedValue);
					}

					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});



		Platilloaeditarbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedTable = (String) Platilloaeditarbox.getSelectedItem();
					if (selectedTable != null && !selectedTable.isEmpty()) {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/platillos", "root", "");
						Statement statement = connection.createStatement();

						ResultSet resultSet = statement.executeQuery("SELECT Ingrediente, Unidad, Cantidad, Precio, Descripcion FROM " + selectedTable);

						ingredientebox.removeAllItems();

						if (resultSet.next()) {
							String ingrediente = resultSet.getString("Ingrediente");
							String unidad = resultSet.getString("Unidad");
							String cantidad = resultSet.getString("Cantidad");
							String combinedValue = ingrediente + " - " + unidad + " - " + cantidad;
							ingredientebox.addItem(combinedValue);

							PrecioEdPlat.setText(resultSet.getString("Precio"));
							Descripcionareaediplat.setText(resultSet.getString("Descripcion"));
						}

						resultSet.close();
						statement.close();
						connection.close();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		Timer timer2 = new Timer(30000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/platillos", "root", "");
					Statement statement = connection.createStatement();

					ResultSet resultSet = statement.executeQuery("SHOW TABLES");

					Platilloaeditarbox.removeAllItems();

					while (resultSet.next()) {
						String tableName = resultSet.getString(1);
						Platilloaeditarbox.addItem(tableName);
					}

					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		timer2.start();

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/platillos", "root", "");

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SHOW TABLES");

			Platilloaeditarbox.removeAllItems();

			while (resultSet.next()) {
				String tableName = resultSet.getString(1);
				Platilloaeditarbox.addItem(tableName);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Timer ingredientUpdateTimer = new Timer(30000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedTable = (String) Platilloaeditarbox.getSelectedItem();
					if (selectedTable != null && !selectedTable.isEmpty()) {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/platillos", "root", "");
						Statement statement = connection.createStatement();

						ResultSet resultSet = statement.executeQuery("SELECT Ingrediente, Unidad, Cantidad, Precio, Descripcion FROM " + selectedTable);

						ingredientebox.removeAllItems();

						while (resultSet.next()) {
							String ingrediente = resultSet.getString("Ingrediente");
							String unidad = resultSet.getString("Unidad");
							String cantidad = resultSet.getString("Cantidad");
							String combinedValue = ingrediente + " - " + unidad + " - " + cantidad;
							ingredientebox.addItem(combinedValue);

							PrecioEdPlat.setText(resultSet.getString("Precio"));
							Descripcionareaediplat.setText(resultSet.getString("Descripcion"));
						}

						resultSet.close();
						statement.close();
						connection.close();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		ingredientUpdateTimer.start();



		btnediAadirIngrediente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/platillos", "root", "");

					String selectedTable = (String) Platilloaeditarbox.getSelectedItem();

					String selectedIngredient_1 = (String) ingredientebox_1.getSelectedItem();
					String[] ingredientParts_1 = selectedIngredient_1.split(" - ");
					String nombre_1 = ingredientParts_1[0];
					String unidad_1 = ingredientParts_1[1];

					String cantidad = textfieldusername.getText();

					String query = "INSERT INTO " + selectedTable + "(Ingrediente, Unidad, Cantidad) VALUES (?, ?, ?)";
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setString(1, nombre_1);
					statement.setString(2, unidad_1);
					statement.setString(3, cantidad);

					statement.executeUpdate();

					statement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});



		btnEliminarIngredienteedi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/platillos", "root", "");

					String selectedTable = (String) Platilloaeditarbox.getSelectedItem();
					String selectedIngredient = (String) ingredientebox.getSelectedItem();
					String[] ingredientParts = selectedIngredient.split(" - ");
					String ingredientName = ingredientParts[0];

					String deleteQuery = "DELETE FROM " + selectedTable + " WHERE Ingrediente = ?";
					PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
					deleteStatement.setString(1, ingredientName);
					deleteStatement.executeUpdate();
					deleteStatement.close();

					ingredientebox.removeItem(selectedIngredient);

					JOptionPane.showMessageDialog(null, "Ingrediente eliminado correctamente");

					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});



		btnbackeditarplatillos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(EditarPlat);
				add(Platillos);
				repaint();
				revalidate();
			}
		});



		btnEditarPlat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/platillos", "root", "");

					String selectedTable = (String) Platilloaeditarbox.getSelectedItem();
					String newTableName = NombrePlatEdField.getText();

					if (!newTableName.isEmpty()) {
						String query = "ALTER TABLE " + selectedTable + " RENAME TO " + newTableName;
						PreparedStatement statement = connection.prepareStatement(query);
						statement.executeUpdate();
						statement.close();

						selectedTable = newTableName;

						JOptionPane.showMessageDialog(null, "Nombre del ingrediente actualizado");
					} else {
						JOptionPane.showMessageDialog(null, "No se puede dejar espacio de nombre vacio");
					}

					String precioValue = PrecioEdPlat.getText();
					if (!precioValue.isEmpty()) {
						float precio = Float.parseFloat(precioValue);
						String updateQuery = "UPDATE " + selectedTable + " SET Precio = ? LIMIT 1";
						PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
						updateStatement.setFloat(1, precio);
						updateStatement.executeUpdate();
						updateStatement.close();

						JOptionPane.showMessageDialog(null, "Precio actualizado correctamente");
					}

					String descripcionValue = Descripcionareaediplat.getText();
					if (!descripcionValue.isEmpty()) {
						ResultSet resultSet = connection.getMetaData().getColumns(null, null, selectedTable, "Descripcion");
						if (!resultSet.next()) {
							String alterQuery = "ALTER TABLE " + selectedTable + " ADD Descripcion TEXT";
							PreparedStatement alterStatement = connection.prepareStatement(alterQuery);
							alterStatement.executeUpdate();
							alterStatement.close();
						}

						String updateQuery = "UPDATE " + selectedTable + " SET Descripcion = ? LIMIT 1";
						PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
						updateStatement.setString(1, descripcionValue);
						updateStatement.executeUpdate();
						updateStatement.close();

						JOptionPane.showMessageDialog(null, "Descripción actualizada correctamente");
					}

					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
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
		lblingredientes.setFont(new Font("Arial Black", Font.PLAIN, 26));
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

		JLabel Detallesingrelbl = new JLabel("Platillos con el ingrediente");
		Detallesingrelbl.setFont(new Font("Arial Black", Font.PLAIN, 20));
		Detallesingrelbl.setBounds(50, 11, 390, 61);
		panellista.add(Detallesingrelbl);

		JLabel Tipoingredientelbl = new JLabel("Platillos: ");
		Tipoingredientelbl.setFont(new Font("Arial Black", Font.PLAIN, 19));
		Tipoingredientelbl.setBounds(20, 90, 450, 450);
		panellista.add(Tipoingredientelbl);


		JPanel panelconsultadeingredientes = new JPanel();
		panelconsultadeingredientes.setBackground(new Color(255, 128, 0));
		panelconsultadeingredientes.setBounds(35, 40, 288, 519);
		panelcrearingre.add(panelconsultadeingredientes);
		panelconsultadeingredientes.setLayout(null);

		JTable ingredientTable = new JTable();
		ingredientTable.setModel(new DefaultTableModel());

		JScrollPane ingredientScrollPane = new JScrollPane(ingredientTable);
		ingredientScrollPane.setBounds(0, 0, panelconsultadeingredientes.getWidth(), panelconsultadeingredientes.getHeight());
		panelconsultadeingredientes.add(ingredientScrollPane);
		DefaultTableModel ingredientTableModel = new DefaultTableModel();


		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT Nombre FROM inventario");

			ingredientTableModel.addColumn("Nombre");
			ingredientTable.setModel(ingredientTableModel);

			while (resultSet.next()) {
				String nombre = resultSet.getString("Nombre");
				ingredientTableModel.addRow(new Object[]{nombre});
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}



		ingredientTable.setRowSelectionAllowed(false);
		ingredientTable.setColumnSelectionAllowed(false);

		ingredientTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = ingredientTable.rowAtPoint(e.getPoint());

				if (rowIndex != -1) {
					String ingredientName = ingredientTable.getValueAt(rowIndex, 0).toString();
					StringBuilder matchingTables = new StringBuilder();

					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos", "root", "");
						Statement statement = connection.createStatement();
						ResultSet resultSet = statement.executeQuery("SHOW TABLES");

						while (resultSet.next()) {
							String tableName = resultSet.getString(1);
							Statement innerStatement = connection.createStatement();
							ResultSet tableData = innerStatement.executeQuery("SELECT * FROM " + tableName);

							while (tableData.next()) {
								String ingredient = tableData.getString("Ingrediente");

								if (ingredient.equals(ingredientName)) {
									matchingTables.append(tableName).append(", ");
									break;
								}
							}

							tableData.close();
							innerStatement.close();
						}

						resultSet.close();
						statement.close();
						connection.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}

					String tablesText = matchingTables.toString();
					if (!tablesText.isEmpty()) {
						tablesText = tablesText.substring(0, tablesText.length() - 2);
					} else {
						tablesText = "No hay platillos \n" +
								"con el ingrediente.";
					}

					Tipoingredientelbl.setText("Platillos: " + tablesText);
				}
			}
		});


		Timer timer4 = new Timer(15000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT Nombre FROM inventario");

					ingredientTableModel.setRowCount(0);

					while (resultSet.next()) {
						String nombre = resultSet.getString("Nombre");
						ingredientTableModel.addRow(new Object[]{nombre});
					}

					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		timer4.start();






















		JLabel lblPlatillosconingre = new JLabel("Platillos con el ingrediente");
		lblPlatillosconingre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlatillosconingre.setBounds(72, 5, 213, 36);
		panelcrearingre.add(lblPlatillosconingre);

		JButton btnbackingredientes = new JButton(new ImageIcon("BotonRetroceder.png"));
		btnbackingredientes.setBounds(10, 11, 35, 33);
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

		JLabel logoOrdenes = new JLabel(new ImageIcon("menuordenes.png"));
		logoOrdenes.setBounds(300,30,350,233);
		IconOrden.add(logoOrdenes);


		JButton btnEditarOrdenes = new JButton("Eliminar");
		btnEditarOrdenes.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnEditarOrdenes.setBackground(new Color(255, 128, 0));
		btnEditarOrdenes.setFocusable(false);
		btnEditarOrdenes.setBounds(112, 95, 217, 60);
		btnEditarOrdenes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Ordenes);
				add( EditarOrden);
				repaint();
				revalidate();

			}
		});
		panelMiniOrden.add(btnEditarOrdenes);


		JButton btnCrearOrden = new JButton("Crear");
		btnCrearOrden.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnCrearOrden.setBackground(new Color(255, 128, 0));
		btnCrearOrden.setFocusable(false);
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

		JButton backOrdenes = new JButton(new ImageIcon("BotonRetroceder.png"));
		backOrdenes.setBounds(10, 11, 35, 33);
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
		crearOrdenes.setFont(new Font("Arial Black", Font.PLAIN, 30));
		crearOrdenes.setBounds(350, 40, 351, 50);
		CrearOrden.add( crearOrdenes);

		JPanel FondoCrearorden = new JPanel();
		FondoCrearorden .setBounds(0, 0, 977, 681);
		FondoCrearorden .setBackground(new Color(255, 128, 0));
		FondoCrearorden .setLayout(null);
		CrearOrden.add(FondoCrearorden );


		JPanel panelCrearOrden = new JPanel();
		panelCrearOrden.setBounds(100, 100, 750, 426);
		FondoCrearorden.add(panelCrearOrden);
		panelCrearOrden.setLayout(null);

		//labels de compra

		JLabel clienteaelegirlbl = new JLabel("Seleccione al cliente para la orden");
		clienteaelegirlbl.setForeground(new Color(0, 0, 0));
		clienteaelegirlbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		clienteaelegirlbl.setBounds(10, 10, 360, 32);
		panelCrearOrden.add(clienteaelegirlbl);

		JLabel platilloaelegirlbl = new JLabel("Seleccione los platillos para la orden");
		platilloaelegirlbl.setForeground(new Color(0, 0, 0));
		platilloaelegirlbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		platilloaelegirlbl.setBounds(10, 110, 360, 32);
		panelCrearOrden.add(platilloaelegirlbl);

		JLabel platilloaremover = new JLabel("Seleccione los platillos a remover");
		platilloaremover.setForeground(new Color(0, 0, 0));
		platilloaremover.setFont(new Font("Tahoma", Font.BOLD, 17));
		platilloaremover.setBounds(10, 210, 360, 32);
		panelCrearOrden.add(platilloaremover);

		JLabel Totalporcompralbl = new JLabel("Total ");
		Totalporcompralbl.setForeground(new Color(0, 0, 0));
		Totalporcompralbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		Totalporcompralbl.setBounds(10, 350, 360, 32);
		panelCrearOrden.add(Totalporcompralbl);



		//JBUttons

		JButton platilloaremoverbtn = new JButton("Remover platillo");
		platilloaremoverbtn.setFont(new Font("Tahoma", Font.BOLD, 17));
		platilloaremoverbtn.setBounds(10, 300, 270, 32);
		panelCrearOrden.add(platilloaremoverbtn);


		JButton Agregarplatilloaordenbtn = new JButton("Añadir platillo a orden");
		Agregarplatilloaordenbtn.setBounds(390, 150, 340, 32);
		Agregarplatilloaordenbtn.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelCrearOrden.add(Agregarplatilloaordenbtn);



		JButton CrearOrdenn = new JButton("Crear Orden");
		CrearOrdenn.setForeground(new Color(0, 0, 0));
		CrearOrdenn.setFont(new Font("Tahoma", Font.BOLD, 11));
		CrearOrdenn.setBounds(350, 383, 113, 32);
		panelCrearOrden.add(CrearOrdenn);

		JButton cancelarordenbtn = new JButton("Cancelar orden");
		cancelarordenbtn.setForeground(new Color(0, 0, 0));
		cancelarordenbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		cancelarordenbtn.setBounds(600, 383, 113, 32);
		panelCrearOrden.add(cancelarordenbtn);

		//comboboxes

		JComboBox<String> clienteaelegirbox = new JComboBox<>();
		clienteaelegirbox.setFont(new Font("Tahoma", Font.BOLD, 17));
		clienteaelegirbox.setBounds(10, 50, 360, 32);
		panelCrearOrden.add(clienteaelegirbox);

		JComboBox<String> platilloaelegirlbox = new JComboBox<>();
		platilloaelegirlbox.setFont(new Font("Tahoma", Font.BOLD, 17));
		platilloaelegirlbox.setBounds(10, 150, 360, 32);
		panelCrearOrden.add(platilloaelegirlbox);

		JComboBox<String> platilloaremoverbox = new JComboBox<>();
		platilloaremoverbox.setFont(new Font("Tahoma", Font.BOLD, 17));
		platilloaremoverbox.setBounds(10, 250, 360, 32);
		panelCrearOrden.add(platilloaremoverbox);

		JTable platillosenordentable = new JTable();
		platillosenordentable.setBounds(390, 210, 340, 160);

		panelCrearOrden.add(platillosenordentable);

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");
			Statement statement = connection.createStatement();
			String query = "SELECT Nombre, Apellidos FROM clientes";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String nombre = resultSet.getString("Nombre");
				String apellidos = resultSet.getString("Apellidos");
				String clienteData = nombre + " " + apellidos;
				clienteaelegirbox.addItem(clienteData);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}


		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos", "root", "");
			Statement statement = connection.createStatement();
			String query = "SHOW TABLES";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String tableName = resultSet.getString(1);

				String price = "";
				String getPriceQuery = "SELECT Precio FROM " + tableName + " LIMIT 1";
				Statement getPriceStatement = connection.createStatement();
				ResultSet getPriceResult = getPriceStatement.executeQuery(getPriceQuery);
				if (getPriceResult.next()) {
					price = getPriceResult.getString("Precio");
				}
				getPriceResult.close();
				getPriceStatement.close();

				String itemData = tableName + " - Precio: " + price;
				platilloaelegirlbox.addItem(itemData);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		Timer platilloTimer = new Timer(15000, e -> {
			platilloaelegirlbox.removeAllItems();
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos", "root", "");
				Statement statement = connection.createStatement();
				String query = "SHOW TABLES";
				ResultSet resultSet = statement.executeQuery(query);

				while (resultSet.next()) {
					String tableName = resultSet.getString(1);

					String price = "";
					String getPriceQuery = "SELECT Precio FROM " + tableName + " LIMIT 1";
					Statement getPriceStatement = connection.createStatement();
					ResultSet getPriceResult = getPriceStatement.executeQuery(getPriceQuery);
					if (getPriceResult.next()) {
						price = getPriceResult.getString("Precio");
					}
					getPriceResult.close();
					getPriceStatement.close();

					String itemData = tableName + " - Precio: " + price;
					platilloaelegirlbox.addItem(itemData);
				}

				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});

		platilloTimer.start();






		Timer clienteTimer = new Timer(15000, e -> {
			clienteaelegirbox.removeAllItems(); // Clear the combo box

			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");
				Statement statement = connection.createStatement();
				String query = "SELECT Nombre, Apellidos FROM clientes";
				ResultSet resultSet = statement.executeQuery(query);

				while (resultSet.next()) {
					String nombre = resultSet.getString("Nombre");
					String apellidos = resultSet.getString("Apellidos");
					String clienteData = nombre + " " + apellidos;
					clienteaelegirbox.addItem(clienteData);
				}

				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});

		clienteTimer.start();





		DefaultTableModel tablemodeltablaorden = new DefaultTableModel();
		tablemodeltablaorden.addColumn("Platillo");
		tablemodeltablaorden.addColumn("Precio");
		platillosenordentable.setModel(tablemodeltablaorden);




//jbutton actionlisteners
		Agregarplatilloaordenbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedPlatillo = (String) platilloaelegirlbox.getSelectedItem();
				platilloaremoverbox.addItem(selectedPlatillo);

				String tableName = selectedPlatillo.substring(0, selectedPlatillo.indexOf(" - "));
				double price = 0.0;

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos", "root", "");
					Statement statement = connection.createStatement();
					String getPriceQuery = "SELECT Precio FROM " + tableName + " LIMIT 1";
					ResultSet getPriceResult = statement.executeQuery(getPriceQuery);
					if (getPriceResult.next()) {
						price = getPriceResult.getDouble("Precio");
					}
					getPriceResult.close();
					statement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

				DefaultTableModel model = (DefaultTableModel) platillosenordentable.getModel();
				model.addRow(new Object[]{tableName, price});

				double total = 0.0;
				for (int i = 0; i < model.getRowCount(); i++) {
					String rowPrice = model.getValueAt(i, 1).toString();
					total += Double.parseDouble(rowPrice);
				}

				Totalporcompralbl.setText("Total: " + total);

				model.fireTableDataChanged();
				platillosenordentable.repaint();
			}
		});



		platilloaremoverbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = platilloaremoverbox.getSelectedIndex();
				if (selectedIndex != -1) {
					platilloaremoverbox.removeItemAt(selectedIndex);

					DefaultTableModel tableModel = (DefaultTableModel) platillosenordentable.getModel();
					double removedPrice = Double.parseDouble(tableModel.getValueAt(selectedIndex, 1).toString());

					tableModel.removeRow(selectedIndex);

					double total = 0.0;
					for (int i = 0; i < tableModel.getRowCount(); i++) {
						String rowPrice = tableModel.getValueAt(i, 1).toString();
						total += Double.parseDouble(rowPrice);
					}

					Totalporcompralbl.setText("Total: " + total);

					tableModel.fireTableDataChanged();
					platillosenordentable.repaint();
				}
			}
		});


		cancelarordenbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) platillosenordentable.getModel();
				model.setRowCount(0);

				platilloaremoverbox.removeAllItems();

				Totalporcompralbl.setText("Total: 0");
			}
		});






		CrearOrdenn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedPlatillo = platillosenordentable.getValueAt(0, 0).toString();

				int quantity = tablemodeltablaorden.getRowCount();

				Map<String, Float> ingredientesCantidadMap = new HashMap<>();

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos", "root", "");
					Statement statement = connection.createStatement();

					String tableName = selectedPlatillo;
					String query = "SELECT Ingrediente, Cantidad FROM " + tableName;
					ResultSet resultSet = statement.executeQuery(query);

					while (resultSet.next()) {
						String ingrediente = resultSet.getString("Ingrediente");
						float cantidad = resultSet.getFloat("Cantidad");

						cantidad *= quantity;

						ingredientesCantidadMap.put(ingrediente, cantidad);
					}

					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");
					Statement statement = connection.createStatement();

					String tableName = "inventario";
					for (Map.Entry<String, Float> entry : ingredientesCantidadMap.entrySet()) {
						String ingrediente = entry.getKey();
						float cantidad = entry.getValue();

						String updateQuery = "UPDATE " + tableName + " SET Cantidad = Cantidad - " + cantidad + " WHERE Nombre = '" + ingrediente + "'";
						statement.executeUpdate(updateQuery);
					}

					statement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

				int confirmation = JOptionPane.showConfirmDialog(null, "¿Está seguro de realizar esta orden?", "Confirmación", JOptionPane.YES_NO_OPTION);

				if (confirmation == JOptionPane.YES_OPTION) {
					String selectedCliente = clienteaelegirbox.getSelectedItem().toString();
					String selectedDireccion = "";

					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");
						Statement statement = connection.createStatement();

						String query = "SELECT Dirección FROM clientes WHERE Nombre = '" + selectedCliente + "'";
						ResultSet resultSet = statement.executeQuery(query);

						if (resultSet.next()) {
							selectedDireccion = resultSet.getObject("Dirección").toString();
						}

						resultSet.close();
						statement.close();
						connection.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}

					DefaultTableModel platillosTableModel = (DefaultTableModel) platillosenordentable.getModel();
					double total = 0.0;

					StringBuilder platillosBuilder = new StringBuilder();
					StringBuilder precioBuilder = new StringBuilder();

					for (int i = 0; i < platillosTableModel.getRowCount(); i++) {
						String platillo = platillosTableModel.getValueAt(i, 0).toString();
						String precio = platillosTableModel.getValueAt(i, 1).toString();

						platillosBuilder.append(platillo);
						precioBuilder.append(precio);

						if (i < platillosTableModel.getRowCount() - 1) {
							platillosBuilder.append(", ");
							precioBuilder.append(", ");
						}

						total += Double.parseDouble(precio);
					}

					int orderId = 1;
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordenes", "root", "");
						Statement statement = connection.createStatement();

						String tableName = "ordenes";
						String query = "SELECT MAX(ID) FROM " + tableName;
						ResultSet resultSet = statement.executeQuery(query);

						if (resultSet.next()) {
							orderId = resultSet.getInt(1) + 1;
						}

						resultSet.close();
						statement.close();
						connection.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}

					String tableName = orderId + "_" + selectedCliente.replace(" ", "_");

					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordenes", "root", "");
						Statement statement = connection.createStatement();

						// Create the table
						String createTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
								"(ID INT AUTO_INCREMENT, Nombre VARCHAR(255), Direccion VARCHAR(255), Platillos VARCHAR(255), Precio VARCHAR(255), Total DOUBLE, PRIMARY KEY (ID))";
						statement.executeUpdate(createTableQuery);

						// Insert the data
						String insertQuery = "INSERT INTO " + tableName + "(Nombre, Direccion, Platillos, Precio, Total) " +
								"VALUES ('" + selectedCliente + "', '" + selectedDireccion + "', '" + platillosBuilder.toString() + "', '" +
								precioBuilder.toString() + "', " + total + ")";
						statement.executeUpdate(insertQuery);

						statement.close();
						connection.close();

						JOptionPane.showMessageDialog(null, "Orden creada", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}

					platillosTableModel.setRowCount(0);

					platilloaelegirlbox.setSelectedIndex(-1);
					platilloaremoverbox.setSelectedIndex(-1);
					platilloaremoverbox.removeAllItems();
					Totalporcompralbl.setText("Total: 0");
				}
			}
		});












		JButton backCCord = new JButton(new ImageIcon("BotonRetroceder.png"));
		backCCord.setBounds(10, 11, 35, 33);
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

		EditarOrden.setLayout(null);

		JPanel EditarOrdenes = new JPanel();
		EditarOrdenes.setBounds(0, 0, 977, 681);
		EditarOrdenes.setBackground(new Color(255, 128, 0));
		EditarOrdenes.setLayout(null);
		EditarOrden.add(EditarOrdenes);

		String[] columnNamesEditarOrd = {"ID","Nombre","Platillos","Total"};
		DefaultTableModel tableModelEditarOrd = new DefaultTableModel(columnNamesEditarOrd, 0);
		JTable tablaEditarOrd = new JTable(tableModelEditarOrd);

		tablaEditarOrd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPaneEditarOrd = new JScrollPane(tablaEditarOrd);
		scrollPaneEditarOrd.setBounds(131, 257, 606, 300);
		EditarOrdenes.add(scrollPaneEditarOrd);

		DefaultComboBoxModel<String> comboBoxModelEditarOrd = new DefaultComboBoxModel<>();
		JComboBox<String> comboBoxEditarOrd = new JComboBox<>(comboBoxModelEditarOrd);
		comboBoxEditarOrd.setBounds(757, 257, 160, 30);
		EditarOrdenes.add(comboBoxEditarOrd);



		JButton btnEditarTablaOrd = new JButton("Eliminar Orden");
		btnEditarTablaOrd.setFocusable(false);
		btnEditarTablaOrd.setBounds(757, 383, 160, 32);
		EditarOrdenes.add(btnEditarTablaOrd);




		JPanel panelEditarOrd2 = new JPanel();
		panelEditarOrd2.setBackground(Color.GRAY);
		panelEditarOrd2.setBounds(131, 215, 606, 42);
		EditarOrdenes.add(panelEditarOrd2);
		panelEditarOrd2.setLayout(null);

		JLabel tituloEditOrd = new JLabel("Orden a Editar");
		tituloEditOrd .setFont(new Font("Arial Black", Font.PLAIN, 16));
		tituloEditOrd .setBounds(250, 11, 190, 20);
		panelEditarOrd2.add(tituloEditOrd );

		JLabel Editartitulo = new JLabel("Editar Ordenes");
		Editartitulo .setFont(new Font("Arial Black", Font.PLAIN, 30));
		Editartitulo .setBounds(330, 137, 300, 50);
		EditarOrdenes.add(Editartitulo );


		JButton backETOrd = new JButton(new ImageIcon("BotonRetroceder.png"));
		backETOrd.setBounds(10, 11, 35, 33);
		backETOrd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove( EditarOrden);
				add(Ordenes);
				repaint();
				revalidate();
			}
		});
		EditarOrdenes.add(backETOrd);


//tabla conecta base de datos
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordenes", "root", "");
			Statement statement = connection.createStatement();

			String selectQuery = "SELECT ID, Nombre, Platillos, Total FROM historialbueno";
			ResultSet resultSet = statement.executeQuery(selectQuery);

			tableModelEditarOrd.setRowCount(0);

			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String nombre = resultSet.getString("Nombre");
				String platillos = resultSet.getString("Platillos");
				double total = resultSet.getDouble("Total");

				Object[] rowData = {id, nombre, platillos, total};
				tableModelEditarOrd.addRow(rowData);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

//conecta el combobox con la base de datos


		comboBoxModelEditarOrd.removeAllElements();

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordenes", "root", "");
			Statement statement = connection.createStatement();

			String selectQuery = "SELECT ID, Nombre FROM historialbueno";
			ResultSet resultSet = statement.executeQuery(selectQuery);

			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String nombre = resultSet.getString("Nombre");

				String item = id + " - " + nombre;
				comboBoxModelEditarOrd.addElement(item);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		btnEditarTablaOrd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = comboBoxEditarOrd.getSelectedIndex();
				if (selectedIndex != -1) {

					int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la orden?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {
						String selectedItem = comboBoxEditarOrd.getItemAt(selectedIndex);
						String[] parts = selectedItem.split(" - ");
						int selectedItemId = Integer.parseInt(parts[0]);

						try {
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordenes", "root", "");
							String deleteQuery = "DELETE FROM historialbueno WHERE ID=?";
							PreparedStatement statement = connection.prepareStatement(deleteQuery);
							statement.setInt(1, selectedItemId);

							int rowsDeleted = statement.executeUpdate();
							if (rowsDeleted > 0) {

								JOptionPane.showMessageDialog(null, "Orden eliminada correctamente", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("Row deleted successfully.");

								// Remove item from combo box
								comboBoxEditarOrd.removeItemAt(selectedIndex);
							} else {
								System.out.println("Failed to delete the row.");
							}

							statement.close();
							connection.close();
						} catch (SQLException ex) {
							ex.printStackTrace();
						}

						DefaultTableModel model = (DefaultTableModel) tablaEditarOrd.getModel();
						model.removeRow(selectedIndex);
					}
				}

				repaint();
				revalidate();
			}
		});
















		//---------------parte final-----------------------------------------------------panel editar Ordenes-----
		PanelEditarOrden.setLayout(null);

		JPanel EditOrdenes1 = new JPanel();
		EditOrdenes1.setBounds(0, 0, 977, 681);
		EditOrdenes1.setBackground(new Color(255, 128, 0));
		EditOrdenes1.setLayout(null);
		PanelEditarOrden.add(EditOrdenes1);

		JPanel EditOrdenes2 = new JPanel();
		EditOrdenes2.setBounds(100, 100, 750, 426);
		EditOrdenes1.add(EditOrdenes2);
		EditOrdenes2.setLayout(null);



		JLabel clienteaelegirlbl2 = new JLabel("Seleccione al cliente para la orden");
		clienteaelegirlbl2.setForeground(new Color(0, 0, 0));
		clienteaelegirlbl2.setFont(new Font("Tahoma", Font.BOLD, 17));
		clienteaelegirlbl2.setBounds(10, 10, 360, 32);
		EditOrdenes2.add(clienteaelegirlbl2);

		JLabel platilloaelegirlbl2 = new JLabel("Seleccione los platillos para la orden");
		platilloaelegirlbl2.setForeground(new Color(0, 0, 0));
		platilloaelegirlbl2.setFont(new Font("Tahoma", Font.BOLD, 17));
		platilloaelegirlbl2.setBounds(10, 110, 360, 32);
		EditOrdenes2.add(platilloaelegirlbl2);

		JLabel platilloaremover2 = new JLabel("Seleccione los platillos a remover");
		platilloaremover2.setForeground(new Color(0, 0, 0));
		platilloaremover2.setFont(new Font("Tahoma", Font.BOLD, 17));
		platilloaremover2.setBounds(10, 210, 360, 32);
		EditOrdenes2.add(platilloaremover2);

		JLabel Totalporcompralbl2 = new JLabel("Total ");
		Totalporcompralbl2.setForeground(new Color(0, 0, 0));
		Totalporcompralbl2.setFont(new Font("Tahoma", Font.BOLD, 17));
		Totalporcompralbl2.setBounds(10, 350, 360, 32);
		EditOrdenes2.add(Totalporcompralbl2);

// JButtons

		JButton platilloaremoverbtn2 = new JButton("Remover platillo");
		platilloaremoverbtn2.setFont(new Font("Tahoma", Font.BOLD, 17));
		platilloaremoverbtn2.setBounds(10, 300, 270, 32);
		EditOrdenes2.add(platilloaremoverbtn2);

		JButton Agregarplatilloaordenbtn2 = new JButton("Añadir platillo a orden");
		Agregarplatilloaordenbtn2.setBounds(390, 150, 340, 32);
		Agregarplatilloaordenbtn2.setFont(new Font("Tahoma", Font.BOLD, 17));
		EditOrdenes2.add(Agregarplatilloaordenbtn2);

		JButton editarOrdenbtn = new JButton("Editar Orden");
		editarOrdenbtn.setForeground(new Color(0, 0, 0));
		editarOrdenbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		editarOrdenbtn.setBounds(350, 383, 113, 32);
		EditOrdenes2.add(editarOrdenbtn);

		JButton cancelarordenbtn2 = new JButton("Cancelar orden");
		cancelarordenbtn2.setForeground(new Color(0, 0, 0));
		cancelarordenbtn2.setFont(new Font("Tahoma", Font.BOLD, 11));
		cancelarordenbtn2.setBounds(600, 383, 113, 32);
		EditOrdenes2.add(cancelarordenbtn2);

// ComboBoxes

		JComboBox<String> clienteaelegirbox2 = new JComboBox<>();
		clienteaelegirbox2.setFont(new Font("Tahoma", Font.BOLD, 17));
		clienteaelegirbox2.setBounds(10, 50, 360, 32);
		EditOrdenes2.add(clienteaelegirbox2);

		JComboBox<String> platilloaelegirlbox2 = new JComboBox<>();
		platilloaelegirlbox2.setFont(new Font("Tahoma", Font.BOLD, 17));
		platilloaelegirlbox2.setBounds(10, 150, 360, 32);
		EditOrdenes2.add(platilloaelegirlbox2);

		JComboBox<String> platilloaremoverbox2 = new JComboBox<>();
		platilloaremoverbox2.setFont(new Font("Tahoma", Font.BOLD, 17));
		platilloaremoverbox2.setBounds(10, 250, 360, 32);
		EditOrdenes2.add(platilloaremoverbox2);





		JLabel OrdenesEdiTitulo = new JLabel("Editar Orden");
		OrdenesEdiTitulo.setFont(new Font("Arial Black", Font.PLAIN, 30));
		OrdenesEdiTitulo.setBounds(350, 55, 300, 50);
		EditOrdenes1.add(OrdenesEdiTitulo);





		//CONECTORES


		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");
			Statement statement = connection.createStatement();
			String query = "SELECT Nombre, Apellidos FROM clientes";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String nombre = resultSet.getString("Nombre");
				String apellidos = resultSet.getString("Apellidos");
				String clienteData = nombre + " " + apellidos;
				clienteaelegirbox2.addItem(clienteData);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}


		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos", "root", "");
			Statement statement = connection.createStatement();
			String query = "SHOW TABLES";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String tableName = resultSet.getString(1);

				String price = "";
				String getPriceQuery = "SELECT Precio FROM " + tableName + " LIMIT 1";
				Statement getPriceStatement = connection.createStatement();
				ResultSet getPriceResult = getPriceStatement.executeQuery(getPriceQuery);
				if (getPriceResult.next()) {
					price = getPriceResult.getString("Precio");
				}
				getPriceResult.close();
				getPriceStatement.close();

				String itemData = tableName + " - Precio: " + price;
				platilloaelegirlbox2.addItem(itemData);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}



		JTable platillosenordentable2 = new JTable();
		platillosenordentable2.setBounds(390, 210, 340, 160);

		DefaultTableModel tablemodeltablaorden2 = new DefaultTableModel();
		tablemodeltablaorden2.addColumn("Platillo");
		tablemodeltablaorden2.addColumn("Precio");
		platillosenordentable2.setModel(tablemodeltablaorden2);

		JScrollPane scrollPane231 = new JScrollPane(platillosenordentable2);
		scrollPane231.setBounds(390, 210, 340, 160);
		EditOrdenes2.add(scrollPane231);


//jbutton actionlisteners
		Agregarplatilloaordenbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedPlatillo = (String) platilloaelegirlbox2.getSelectedItem();
				platilloaremoverbox2.addItem(selectedPlatillo);

				String tableName = selectedPlatillo.substring(0, selectedPlatillo.indexOf(" - "));
				double price = 0.0;

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platillos", "root", "");
					Statement statement = connection.createStatement();
					String getPriceQuery = "SELECT Precio FROM " + tableName + " LIMIT 1";
					ResultSet getPriceResult = statement.executeQuery(getPriceQuery);
					if (getPriceResult.next()) {
						price = getPriceResult.getDouble("Precio");
					}
					getPriceResult.close();
					statement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

				DefaultTableModel model = (DefaultTableModel) platillosenordentable2.getModel();
				model.addRow(new Object[]{tableName, price});

				double total = 0.0;
				for (int i = 0; i < model.getRowCount(); i++) {
					String rowPrice = model.getValueAt(i, 1).toString();
					total += Double.parseDouble(rowPrice);
				}

				Totalporcompralbl2.setText("Total: " + total);

				model.fireTableDataChanged();
				platillosenordentable2.repaint();
			}
		});


		platilloaremoverbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = platilloaremoverbox2.getSelectedIndex();
				if (selectedIndex != -1) {
					platilloaremoverbox2.removeItemAt(selectedIndex);

					DefaultTableModel tableModel = (DefaultTableModel) platillosenordentable2.getModel();
					double removedPrice = Double.parseDouble(tableModel.getValueAt(selectedIndex, 1).toString());

					tableModel.removeRow(selectedIndex);

					double total = 0.0;
					for (int i = 0; i < tableModel.getRowCount(); i++) {
						String rowPrice = tableModel.getValueAt(i, 1).toString();
						total += Double.parseDouble(rowPrice);
					}

					Totalporcompralbl2.setText("Total: " + total);

					tableModel.fireTableDataChanged();
					platillosenordentable2.repaint();
				}
			}
		});

		JButton backEditOrd = new JButton(new ImageIcon("BotonRetroceder.png"));
		backEditOrd .setBounds(10, 11, 35, 33);
		backEditOrd .addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove( PanelEditarOrden);
				add(EditarOrden);
				repaint();
				revalidate();
			}
		});
		EditOrdenes1.add(backEditOrd);


		editarOrdenbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = platillosenordentable2.getSelectedRow();
				if (selectedRow != -1) {
					String selectedCliente = clienteaelegirbox2.getSelectedItem().toString();
					String selectedPlatillo = platillosenordentable2.getValueAt(selectedRow, 0).toString();
					double total = Double.parseDouble(Totalporcompralbl2.getText().substring(7));

					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordenes", "root", "");
						String updateQuery = "UPDATE historialbueno SET Nombre=?, Platillos=?, Total=? WHERE ID=?";
						PreparedStatement statement = connection.prepareStatement(updateQuery);
						statement.setString(1, selectedCliente);
						statement.setString(2, selectedPlatillo);
						statement.setDouble(3, total);
						statement.setInt(4, selectedRow + 1); // Assuming ID starts from 1

						int rowsUpdated = statement.executeUpdate();
						if (rowsUpdated > 0) {
							System.out.println("Row updated successfully.");
						} else {
							System.out.println("Failed to update the row.");
						}

						statement.close();
						connection.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}

					DefaultTableModel model = (DefaultTableModel) platillosenordentable2.getModel();
					model.setValueAt(selectedCliente, selectedRow, 1);
					model.setValueAt(selectedPlatillo, selectedRow, 2);
					model.setValueAt(total, selectedRow, 3);

					model.fireTableDataChanged();
					platillosenordentable2.repaint();
				}
			}
		});

		Timer timercomboboxtabla = new Timer(20000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordenes", "root", "");
					Statement statement = connection.createStatement();

					String selectQuery = "SELECT ID, Nombre, Platillos, Total FROM historialbueno";
					ResultSet resultSet = statement.executeQuery(selectQuery);

					tableModelEditarOrd.setRowCount(0);

					while (resultSet.next()) {
						int id = resultSet.getInt("ID");
						String nombre = resultSet.getString("Nombre");
						String platillos = resultSet.getString("Platillos");
						double total = resultSet.getDouble("Total");

						Object[] rowData = {id, nombre, platillos, total};
						tableModelEditarOrd.addRow(rowData);
					}

					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

				// actualiza JComboBox
				comboBoxModelEditarOrd.removeAllElements();

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordenes", "root", "");
					Statement statement = connection.createStatement();

					String selectQuery = "SELECT ID, Nombre FROM historialbueno";
					ResultSet resultSet = statement.executeQuery(selectQuery);

					while (resultSet.next()) {
						int id = resultSet.getInt("ID");
						String nombre = resultSet.getString("Nombre");

						String item = id + " - " + nombre;
						comboBoxModelEditarOrd.addElement(item);
					}

					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});


		timercomboboxtabla.start();









































		//----pantalla eliminar Ordenes----
		EliminarOrden.setLayout(null);

		JPanel eliminarOrders = new JPanel();
		eliminarOrders.setBounds(0, 0, 977, 681);
		eliminarOrders.setBackground(new Color(255, 128, 0));
		eliminarOrders.setLayout(null);
		EliminarOrden.add(eliminarOrders);

		String[] columnNamesEliminarOrd = {"Ordenes"};
		DefaultTableModel tableModelEliminarOrd = new DefaultTableModel(columnNamesEliminarOrd, 0);
		JTable tablaEliminarOrd = new JTable(tableModelEliminarOrd);

		tablaEliminarOrd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPaneEliminarOrd = new JScrollPane(tablaEliminarOrd);
		scrollPaneEliminarOrd.setBounds(131, 257, 606, 300);
		eliminarOrders.add(scrollPaneEliminarOrd);

		DefaultComboBoxModel<String> comboBoxModelEliminarOrd = new DefaultComboBoxModel<>();
		JComboBox<String> comboBoxEliminarOrd = new JComboBox<>(comboBoxModelEliminarOrd );
		comboBoxEliminarOrd.setBounds(757, 257, 160, 30);
		eliminarOrders.add(comboBoxEliminarOrd);

		JButton btnEliminarTablaOrd = new JButton("Eliminar Orden");
		btnEliminarTablaOrd.setFocusable(false);
		btnEliminarTablaOrd.setBounds(757, 297, 160, 30);
		eliminarOrders.add(btnEliminarTablaOrd);

		JPanel panelEliminarOrd2 = new JPanel();
		panelEliminarOrd2.setBackground(Color.GRAY);
		panelEliminarOrd2.setBounds(131, 215, 606, 42);
		eliminarOrders.add(panelEliminarOrd2);
		panelEliminarOrd2.setLayout(null);

		JLabel tituloDeleteOrd = new JLabel("Orden a Eliminar");
		tituloDeleteOrd.setFont(new Font("Arial Black", Font.PLAIN, 16));
		tituloDeleteOrd.setBounds(230, 11, 190, 20);
		panelEliminarOrd2.add(tituloDeleteOrd);

		JLabel Deletestitulo = new JLabel("Eliminar Ordenes");
		Deletestitulo .setFont(new Font("Arial Black", Font.PLAIN, 30));
		Deletestitulo .setBounds(300, 137, 300, 50);
		eliminarOrders.add(Deletestitulo );


		JButton backEliminarOrdenn = new JButton(new ImageIcon("BotonRetroceder.png"));
		backEliminarOrdenn.setBounds(10, 11, 35, 33);
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
		Panelinventario.setOpaque(false);
		Panelinventario.setBounds(59, 241, 827, 347);
		Inventario.add(Panelinventario);

		JButton Consultarinventario = new JButton("Consultar");
		Consultarinventario.setFont(new Font("Arial Black", Font.PLAIN, 20));
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
		EditarInventario.setFont(new Font("Arial Black", Font.PLAIN, 20));
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
		EliminarInventario.setFont(new Font("Arial Black", Font.PLAIN, 20));
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
		CrearInventario.setFont(new Font("Arial Black", Font.PLAIN, 20));
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


		JLabel TituloInventario = new JLabel(new ImageIcon("menuinventario.png"));
		TituloInventario.setBounds(300, 20, 350, 233);
		Inventario.add(TituloInventario);


		JButton btnbackinventario = new JButton(new ImageIcon("BotonRetroceder.png"));
		btnbackinventario.setBounds(10, 11, 35, 33);
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
// contentPane.add(ConsultaInv);
		ConsultaInv.setLayout(null);

		JLabel consultarInventario = new JLabel("Consultar Inventario");
		consultarInventario.setFont(new Font("Arial Black", Font.PLAIN, 24));
		consultarInventario.setBackground(new Color(128, 128, 0));
		consultarInventario.setForeground(new Color(0, 0, 0));
		consultarInventario.setBounds(331, 23, 300, 58);
		ConsultaInv.add(consultarInventario);

		JLabel lblArticulosporacabar = new JLabel("Articulos por agotarse\r\n");
		lblArticulosporacabar.setForeground(new Color(255, 255, 255));
		lblArticulosporacabar.setFont(new Font("Arial Black", Font.PLAIN, 20));
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
		paneldetablainventario.setBounds(34, 277, 892, 35);
		paneldetablainventario.setBackground(Color.gray);
		paneldetablainventario.setLayout(null);
		ConsultaInv.add(paneldetablainventario);

		JLabel articulodeinventario = new JLabel("Articulo");
		articulodeinventario.setFont(new Font("Arial Black", Font.PLAIN, 20));
		articulodeinventario.setBounds(110,-5,100,50);
		paneldetablainventario.add(articulodeinventario);

		JLabel tipodeunidadlbl = new JLabel("Unidad");
		tipodeunidadlbl.setFont(new Font("Arial Black", Font.PLAIN, 20));
		tipodeunidadlbl.setBounds(400,-5,100,50);
		paneldetablainventario.add(tipodeunidadlbl);

		JLabel cantidadeninvlbl = new JLabel("Cantidad");
		cantidadeninvlbl.setFont(new Font("Arial Black", Font.PLAIN, 20));
		cantidadeninvlbl.setBounds(695,-5,100,50);
		paneldetablainventario.add(cantidadeninvlbl);



		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 218, 168));
		panel_4.setBounds(34, 312, 892, 257);
		ConsultaInv.add(panel_4);
		panel_4.setLayout(new BorderLayout());

		JTable consultainvtable = new JTable();
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Unidad");
		tableModel.addColumn("Cantidad");
		consultainvtable.setModel(tableModel);

		JScrollPane scrollPane = new JScrollPane(consultainvtable);
		panel_4.add(scrollPane, BorderLayout.CENTER);


		try {
			String url = "jdbc:mysql://localhost:3306/clientes";
			String username = "root";
			String password = "";
			Connection connection = DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();
			String query = "SELECT Nombre, Unidad, Cantidad FROM inventario";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String nombre = resultSet.getString("Nombre");
				String unidad = resultSet.getString("Unidad");
				int cantidad = resultSet.getInt("Cantidad");
				tableModel.addRow(new Object[]{nombre, unidad, cantidad});
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}



		JButton btnbackinvconsultar = new JButton(new ImageIcon("BotonRetroceder.png"));
		btnbackinvconsultar.setBounds(10, 11, 35, 33);
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
		Editarinvlbl.setFont(new Font("Arial Black", Font.PLAIN, 30));
		Editarinvlbl.setBounds(300, 40, 350, 115);
		EditarINv.add(Editarinvlbl);

		JPanel Articuledipan = new JPanel();
		Articuledipan.setBackground(new Color(255, 218, 168));
		Articuledipan.setBounds(76, 203, 679, 381);
		EditarINv.add(Articuledipan);

		DefaultTableModel tablamodelinvconsulta = new DefaultTableModel(
				new Object[]{"Nombre","Unidad","Color","Cantidad"	}, 0);

		JTable tablaeditarart = new JTable(tablamodelinvconsulta);

		JScrollPane scrollPaneediart = new JScrollPane(tablaeditarart);
		Articuledipan.setLayout(new BorderLayout());
		Articuledipan.add(scrollPaneediart, BorderLayout.CENTER);


		JPanel panel_1EDI = new JPanel();
		panel_1EDI.setBounds(76, 155, 679, 48);
		panel_1EDI.setBackground(Color.gray);
		EditarINv.add(panel_1EDI);
		panel_1EDI.setLayout(null);

		JLabel Ediartlbl2 = new JLabel("Articulo a Editar");
		Ediartlbl2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		Ediartlbl2.setBounds(262, 0, 250, 43);
		panel_1EDI.add(Ediartlbl2);

		JButton btneditarart = new JButton("Editar");
		btneditarart.setBounds(770, 224, 166, 30);
		EditarINv.add(btneditarart);

		JComboBox editarartbox = new JComboBox();
		editarartbox.setBounds(770, 170, 160, 30);
		EditarINv.add(editarartbox);

		JButton btnbackeditarinv = new JButton(new ImageIcon("BotonRetroceder.png"));
		btnbackeditarinv.setBounds(10, 11, 35, 33);
		EditarINv.add(btnbackeditarinv);

		//-----Edicion--------

		JPanel editingPanel = new JPanel();
		editingPanel.setBackground(new Color(255, 128, 0));
		editingPanel.setBounds(0, 0, 961, 642);
		editingPanel.setLayout(null);

		JLabel tituloEditardentro = new JLabel("Editar Articulo");
		tituloEditardentro.setBounds(380,50,300,50);
		tituloEditardentro.setFont(new Font("Arial Black", Font.PLAIN, 30));
		editingPanel.add(tituloEditardentro);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 218, 168));
		panel2.setBounds(10, 104, 932, 473);
		NuevoArticulo.add(panel2);
		panel2.setLayout(null);

		JPanel editarInventario2 = new JPanel();
		editarInventario2.setBackground(new Color(255, 218, 168));
		editarInventario2.setBounds(10, 104, 932, 473);
		editarInventario2.setLayout(null);
		editingPanel.add(editarInventario2);

		JLabel lblnombrearticulonuevoinv2 = new JLabel("Nombre del articulo:");
		lblnombrearticulonuevoinv2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblnombrearticulonuevoinv2.setBounds(358, 23, 300, 43);
		editarInventario2.add(lblnombrearticulonuevoinv2);

		JTextField textField3 = new JTextField();
		textField3.setBounds(358, 62, 238, 33);
		editarInventario2.add(textField3);
		textField3.setColumns(10);


		JLabel unidadartbox4 = new JLabel("Tipo de unidad:");
		unidadartbox4.setFont(new Font("Arial Black", Font.PLAIN, 20));
		unidadartbox4.setBounds(358, 100, 250, 43);
		editarInventario2.add(unidadartbox4);


		JComboBox<String> comboBoxunidad2 = new JComboBox<>();
		comboBoxunidad2.setBounds(358, 143, 238, 30);
		editarInventario2.add(comboBoxunidad2);

		comboBoxunidad2.addItem("kg");
		comboBoxunidad2.addItem("L");
		comboBoxunidad2.addItem("4L");
		comboBoxunidad2.addItem("2L");



		JLabel colorwidgetbox2 = new JLabel("Color del widget:");
		colorwidgetbox2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		colorwidgetbox2.setBounds(358, 182, 250, 43);
		editarInventario2.add(colorwidgetbox2);

		JComboBox<String> comboboxcolor2 = new JComboBox<>();
		comboboxcolor2.setBounds(358, 221, 238, 30);
		editarInventario2.add(comboboxcolor2);

		comboboxcolor2.addItem("Blanco");
		comboboxcolor2.addItem("Amarillo");
		comboboxcolor2.addItem("Azul");
		comboboxcolor2.addItem("Verde");
		comboboxcolor2.addItem("Rojo");
		comboboxcolor2.addItem("Beige");
		comboboxcolor2.addItem("Morado");

		JLabel cantidaddelarticulo2 = new JLabel("Cantidad de articulo:");
		cantidaddelarticulo2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		cantidaddelarticulo2.setBounds(358, 272, 250, 43);
		editarInventario2.add(cantidaddelarticulo2);

		JTextField textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(358, 315, 238, 33);
		editarInventario2.add(textField_21);

		JButton editararticulobtn = new JButton("Editar");
		editararticulobtn.setBackground(new Color(255, 128, 64));
		editararticulobtn.setFont(new Font("Arial Black", Font.PLAIN, 18));
		editararticulobtn.setBounds(411, 419, 124, 43);
		editarInventario2.add(editararticulobtn);



		//Combobox
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT Nombre, Unidad, Color, Cantidad FROM inventario");

			while (resultSet.next()) {
				String nombre = resultSet.getString("Nombre");
				editarartbox.addItem(nombre);
			}

			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}



		//tabla

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT Nombre, Unidad, Color, Cantidad FROM inventario");

			while (resultSet.next()) {
				String nombre = resultSet.getString("Nombre");
				String unidad = resultSet.getString("Unidad");
				String color = resultSet.getString("Color");
				String cantidad = resultSet.getString("Cantidad");

				Object[] rowData = {nombre, unidad, color, cantidad};
				tablamodelinvconsulta.addRow(rowData);
			}

			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		editararticulobtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (editarartbox.getSelectedIndex() != -1) {
					String selectedArticulo = (String) editarartbox.getSelectedItem();
					String nombre = selectedArticulo;

					int option = JOptionPane.showConfirmDialog(null, "¿Desea editar el artículo seleccionado?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						try {
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");

							String nuevoNombre = textField3.getText();
							String nuevaUnidad = (String) comboBoxunidad2.getSelectedItem();
							String nuevoColor = (String) comboboxcolor2.getSelectedItem();
							String nuevaCantidad = textField_21.getText();

							String query = "UPDATE inventario SET Nombre=?, Unidad=?, Color=?, Cantidad=? WHERE Nombre=?";
							PreparedStatement statement = connection.prepareStatement(query);
							statement.setString(1, nuevoNombre);
							statement.setString(2, nuevaUnidad);
							statement.setString(3, nuevoColor);
							statement.setString(4, nuevaCantidad);
							statement.setString(5, nombre);
							statement.executeUpdate();

							statement.close();
							connection.close();

							// Find the row index in the table model with the matching Nombre
							int rowCount = tablamodelinvconsulta.getRowCount();
							int rowIndex = -1;
							for (int i = 0; i < rowCount; i++) {
								String rowNombre = (String) tablamodelinvconsulta.getValueAt(i, 0);
								if (rowNombre.equals(nombre)) {
									rowIndex = i;
									break;
								}
							}

							if (rowIndex != -1) {
								// Remove the row from the table model
								tablamodelinvconsulta.removeRow(rowIndex);

								// Insert the updated row at the same position
								Object[] rowData = {nuevoNombre, nuevaUnidad, nuevoColor, nuevaCantidad};
								tablamodelinvconsulta.insertRow(rowIndex, rowData);
							}

							// Remove the selected item from the combobox
							editarartbox.removeItem(selectedArticulo);
							editarartbox.setSelectedIndex(-1);
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});


		JButton backButton = new JButton(new ImageIcon("BotonRetroceder.png"));
		backButton.setBounds(10, 11, 35, 33);
		editingPanel.add(backButton);
		btneditarart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(EditarINv);
				add(editingPanel);

				repaint();
				revalidate();

			}
		});

		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(editingPanel);
				add(EditarINv);

				repaint();
				revalidate();

			}
		});





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


		JPanel panel2eliminv = new JPanel();
		panel2eliminv.setBounds(76, 155, 679, 48);
		panel2eliminv.setBackground(Color.gray);
		EliminarINv.add(panel2eliminv);
		panel2eliminv.setLayout(null);

		JLabel lblarticuloinv = new JLabel("Articulo a Eliminar");
		lblarticuloinv.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblarticuloinv.setBounds(260, 5, 210, 43);
		panel2eliminv.add(lblarticuloinv);

		JComboBox eliminarartbox = new JComboBox();
		eliminarartbox.setBounds(770, 175, 160, 30);
		EliminarINv.add(eliminarartbox);

		JButton btneliminarart = new JButton("Eliminar\r\n");
		btneliminarart.setBounds(770, 224, 160, 30);
		EliminarINv.add(btneliminarart);


		JLabel Eliminarinvlbl = new JLabel("Eliminar Inventario\r\n");
		Eliminarinvlbl.setFont(new Font("Arial Black", Font.PLAIN, 30));
		Eliminarinvlbl.setBounds(290, 40, 350, 115);
		EliminarINv.add(Eliminarinvlbl);

		JPanel eliminarinvpnl2 = new JPanel();
		eliminarinvpnl2.setBackground(new Color(255, 218, 168));
		eliminarinvpnl2.setBounds(76, 203, 679, 381);
		EliminarINv.add(eliminarinvpnl2);
		eliminarinvpnl2.setLayout(null);

		DefaultTableModel modelo = new DefaultTableModel(
				new Object[]{"Nombre", "Unidad", "Color", "Cantidad"}, 0);
		JTable tablaeliminventario = new JTable(modelo);

		JScrollPane scrollpaneelminv = new JScrollPane(tablaeliminventario);
		scrollpaneelminv.setBounds(0, 0, eliminarinvpnl2.getWidth(), eliminarinvpnl2.getHeight());
		eliminarinvpnl2.add(scrollpaneelminv);



		btneliminarart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedArticulo = (String) eliminarartbox.getSelectedItem();
				String nombre = selectedArticulo;

				int option = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el artículo seleccionado?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");

						String query = "DELETE FROM inventario WHERE Nombre = ?";
						PreparedStatement statement = connection.prepareStatement(query);
						statement.setString(1, nombre);
						statement.executeUpdate();

						statement.close();
						connection.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}

					int rowCount = modelo.getRowCount();
					for (int i = 0; i < rowCount; i++) {
						String tableNombre = (String) modelo.getValueAt(i, 0);
						if (tableNombre.equals(nombre)) {
							modelo.removeRow(i);
							break;
						}
					}

					eliminarartbox.removeItem(selectedArticulo);
					eliminarartbox.setSelectedIndex(-1);
				}
			}
		});



		EliminarINv.add(eliminarartbox);

		//combobox

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT Nombre, Unidad, Color, Cantidad FROM inventario");

			while (resultSet.next()) {
				String nombre = resultSet.getString("Nombre");
				eliminarartbox.addItem(nombre);
			}

			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}



//tabla

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT Nombre, Unidad, Color, Cantidad FROM inventario");

			while (resultSet.next()) {
				String nombre = resultSet.getString("Nombre");
				String unidad = resultSet.getString("Unidad");
				String color = resultSet.getString("Color");
				String cantidad = resultSet.getString("Cantidad");

				Object[] rowData = {nombre, unidad, color, cantidad};
				modelo.addRow(rowData);
			}

			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}



		JButton btnbackeliminarinventario = new JButton(new ImageIcon("BotonRetroceder.png"));
		btnbackeliminarinventario.setBounds(10, 11, 35, 33);
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
		lblnuevoarticulo.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblnuevoarticulo.setBounds(370, 25, 311, 48);
		NuevoArticulo.add(lblnuevoarticulo);

		JPanel panelInventarioCrear = new JPanel();
		panelInventarioCrear.setBackground(new Color(255, 218, 168));
		panelInventarioCrear.setBounds(10, 104, 932, 473);
		NuevoArticulo.add(panelInventarioCrear);
		panelInventarioCrear.setLayout(null);

		JLabel lblnombrearticulonuevoinv = new JLabel("Nombre del articulo:");
		lblnombrearticulonuevoinv.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblnombrearticulonuevoinv.setBounds(358, 23, 250, 43);
		panel2.add(lblnombrearticulonuevoinv);

		JTextField textField = new JTextField();
		textField.setBounds(358, 62, 238, 33);
		panel2.add(textField);
		textField.setColumns(10);


		JLabel unidadartbox = new JLabel("Tipo de unidad:");
		unidadartbox.setFont(new Font("Arial Black", Font.PLAIN, 20));
		unidadartbox.setBounds(358, 100, 250, 43);
		panel2.add(unidadartbox);


		JComboBox<String> comboBoxunidad = new JComboBox<>();
		comboBoxunidad.setBounds(358, 143, 238, 30);
		panel2.add(comboBoxunidad);

		comboBoxunidad.addItem("kg");
		comboBoxunidad.addItem("L");
		comboBoxunidad.addItem("4L");
		comboBoxunidad.addItem("2L");


		JLabel colorwidgetbox = new JLabel("Color del widget:");
		colorwidgetbox.setFont(new Font("Arial Black", Font.PLAIN, 20));
		colorwidgetbox.setBounds(358, 182, 250, 43);
		panel2.add(colorwidgetbox);

		JComboBox<String> comboboxcolor = new JComboBox<>();
		comboboxcolor.setBounds(358, 221, 238, 30);
		panel2.add(comboboxcolor);

		comboboxcolor.addItem("Blanco");
		comboboxcolor.addItem("Amarillo");
		comboboxcolor.addItem("Azul");
		comboboxcolor.addItem("Verde");
		comboboxcolor.addItem("Rojo");
		comboboxcolor.addItem("Beige");
		comboboxcolor.addItem("Morado");

		JLabel cantidaddelarticulo = new JLabel("Cantidad de articulo:");
		cantidaddelarticulo.setFont(new Font("Arial Black", Font.PLAIN, 20));
		cantidaddelarticulo.setBounds(358, 272, 350, 43);
		panel2.add(cantidaddelarticulo);

		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(358, 315, 238, 33);
		panel2.add(textField_1);

		JButton Creararticulobtn = new JButton("Crear");
		Creararticulobtn.setBackground(new Color(255, 128, 64));
		Creararticulobtn.setFont(new Font("Arial Black", Font.PLAIN, 16));
		Creararticulobtn.setBounds(405, 419, 124, 43);
		panel2.add(Creararticulobtn);

		Creararticulobtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirmResult = JOptionPane.showConfirmDialog(null, "¿Está seguro de crear un nuevo artículo en el inventario?", "Confirmación", JOptionPane.YES_NO_OPTION);
				if (confirmResult == JOptionPane.YES_OPTION) {
					String nombre = textField.getText();
					String unidad = (String) comboBoxunidad.getSelectedItem();
					String color = (String) comboboxcolor.getSelectedItem();
					String cantidad = textField_1.getText();

					if (nombre.isEmpty() || unidad.isEmpty() || color.isEmpty() || cantidad.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Campos incompletos", JOptionPane.ERROR_MESSAGE);
						return;
					}

					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");

						String query = "INSERT INTO inventario (Nombre, Unidad, Color, Cantidad) VALUES (?, ?, ?, ?)";
						PreparedStatement statement = connection.prepareStatement(query);

						statement.setString(1, nombre);
						statement.setString(2, unidad);
						statement.setString(3, color);
						statement.setString(4, cantidad);

						int rowsAffected = statement.executeUpdate();

						if (rowsAffected > 0) {
							System.out.println("New row added to the inventory");
							textField.setText("");
							comboBoxunidad.setSelectedIndex(0);
							comboboxcolor.setSelectedIndex(0);
							textField_1.setText("");
						}

						statement.close();
						connection.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				} else {
					textField.setText("");
					comboBoxunidad.setSelectedIndex(0);
					comboboxcolor.setSelectedIndex(0);
					textField_1.setText("");
				}
			}
		});



		JButton btnbackcreararticuloinv = new JButton(new ImageIcon("BotonRetroceder.png"));
		btnbackcreararticuloinv.setBounds(10, 11, 35, 33);
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
		panelMini.setBounds(20, 241, 900, 347);
		panelClientes.add(panelMini);

		JLabel clienteIcon = new JLabel(new ImageIcon("clientelogo2.jpeg"));
		clienteIcon.setBounds(0, 0, 951, 631);
		clienteIcon.setVisible(true);
		clienteIcon.setOpaque(true);
		panelClientes.add(clienteIcon);

		JLabel menuClientesLogo = new JLabel(new ImageIcon("menuclientes().png"));
		menuClientesLogo.setBounds(300,0,350,233);
		clienteIcon.add(menuClientesLogo);


		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnConsultar.setBackground(new Color(255, 128, 0));
		btnConsultar.setFocusable(false);
		btnConsultar.setBounds(0, 280, 217, 60);
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
		btnEditarClientes.setBounds(230, 280, 217, 60);
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
		btnEliminar.setBounds(460, 280, 217, 60);
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
		btnCrearClientes.setBounds(690, 280, 207, 60);
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




		String[] columnNamesFuera = {"Nombre", "Apellidos", "Teléfono", "Dirección"};
		DefaultTableModel tableModelFuera = new DefaultTableModel(columnNamesFuera, 0);
		JTable tablaFuera = new JTable(tableModelFuera);

		tablaFuera.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPaneFuera = new JScrollPane(tablaFuera);
		scrollPaneFuera.setBounds(171, 207, 606, 300);
		clienteIcon.add(scrollPaneFuera);

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");

			Statement statement = connection.createStatement();

			// EJecutar query fetch
			String queryConsulta = "SELECT * FROM clientes";
			ResultSet resultSetConsulta = statement.executeQuery(queryConsulta);

			tableModelFuera.setRowCount(0);



			while (resultSetConsulta.next()) {
				String nombre = resultSetConsulta.getString("Nombre");
				String apellidos = resultSetConsulta.getString("Apellidos");
				String telefono = resultSetConsulta.getString("Teléfono");
				String direccion = resultSetConsulta.getString("Dirección");

				Object[] rowData = {nombre, apellidos, telefono, direccion};

				tableModelFuera.addRow(rowData);


			}

			resultSetConsulta.close();
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		Timer timer20 = new Timer(5000, e -> {
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");
				Statement statement = connection.createStatement();

				String queryConsulta = "SELECT * FROM clientes";
				ResultSet resultSetConsulta = statement.executeQuery(queryConsulta);

				tableModelFuera.setRowCount(0);

				while (resultSetConsulta.next()) {
					String nombre = resultSetConsulta.getString("Nombre");
					String apellidos = resultSetConsulta.getString("Apellidos");
					String telefono = resultSetConsulta.getString("Teléfono");
					String direccion = resultSetConsulta.getString("Dirección");

					Object[] rowData = {nombre, apellidos, telefono, direccion};

					tableModelFuera.addRow(rowData);
				}

				resultSetConsulta.close();
				statement.close();
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});

		timer20.start();






		//-----pantalla creacion clientes-----
		CrearClientes.setLayout(null);

		JLabel crearCliente = new JLabel("Crear Cliente");
		crearCliente.setFont(new Font("Arial Black", Font.PLAIN, 30));
		crearCliente.setBounds(380, 89, 311, 50);
		CrearClientes.add(crearCliente);

		JPanel FondoCrear = new JPanel();
		FondoCrear.setBounds(0, 0, 977, 681);
		FondoCrear.setBackground(new Color(255, 128, 0));
		FondoCrear.setLayout(null);
		CrearClientes.add(FondoCrear);


		JPanel panelCrearCliente = new JPanel();
		panelCrearCliente.setBounds(180, 150, 610, 406);

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
		celtxt.setBounds(10, 238, 454, 27);
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
		btnCrearCliente.setBounds(380, 580, 190, 44);
		btnCrearCliente.setFocusable(false);
		FondoCrear.add(btnCrearCliente);

		FondoCrear.add(btnCrearCliente);
		btnCrearCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "¿Desea crear un nuevo cliente?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					String nombre = nametxt.getText();
					String apellidos = apellidotxt.getText();
					String telefono = celtxt.getText();
					String direccion = direcciontxt.getText();

					// Validate if any text field is empty
					if (nombre.isEmpty() || apellidos.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Campos incompletos", JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Insertar valores en base de datos
					try {
						// Conexion con base de datos
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");

						// Crear un statement con parametros de query
						String query = "INSERT INTO clientes (Nombre, Apellidos, Teléfono, Dirección) VALUES (?, ?, ?, ?)";
						PreparedStatement statement = connection.prepareStatement(query);

						// Crear los parametros para los valores
						statement.setString(1, nombre);
						statement.setString(2, apellidos);
						statement.setString(3, telefono);
						statement.setString(4, direccion);

						// Ejecutar el query
						int rowsAffected = statement.executeUpdate();

						if (rowsAffected > 0) {
							System.out.println("Fila insertada");
							// Limpiar los JTextFields despues de añadir nuevo
							nametxt.setText("");
							apellidotxt.setText("");
							celtxt.setText("");
							direcciontxt.setText("");
						}

						// Cerrar statement y conexion
						statement.close();
						connection.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				} else {
					nametxt.setText("");
					apellidotxt.setText("");
					celtxt.setText("");
					direcciontxt.setText("");
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

		JLabel consultar_clientes = new JLabel("Editar Clientes");
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
				int option = JOptionPane.showConfirmDialog(null, "¿Desea editar la información del cliente?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					String selectedClient = (String) comboBox2.getSelectedItem();
					String[] nameAndLastname = selectedClient.split(" ");
					String nombre = textoEdit1.getText();
					String apellidos = textoEdit2.getText();
					String telefono = textoEdit3.getText();
					String direccion = textoEdit4.getText();

					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");

						String query = "UPDATE clientes SET Nombre = ?, Apellidos = ?, Teléfono = ?, Dirección = ? WHERE Nombre = ? AND Apellidos = ?";
						PreparedStatement statement = connection.prepareStatement(query);

						statement.setString(1, nombre);
						statement.setString(2, apellidos);
						statement.setString(3, telefono);
						statement.setString(4, direccion);
						statement.setString(5, nameAndLastname[0]);
						statement.setString(6, nameAndLastname[1]);

						int rowsAffected = statement.executeUpdate();

						if (rowsAffected > 0) {
							System.out.println("Fila actualizada");
							textoEdit1.setText("");
							textoEdit2.setText("");
							textoEdit3.setText("");
							textoEdit4.setText("");

							// Update the table model if a row is selected
							int selectedRow = tablaEdicion.getSelectedRow();
							if (selectedRow >= 0) {
								tableModelEdicion.setValueAt(nombre, selectedRow, 0);
								tableModelEdicion.setValueAt(apellidos, selectedRow, 1);
								tableModelEdicion.setValueAt(telefono, selectedRow, 2);
								tableModelEdicion.setValueAt(direccion, selectedRow, 3);
							}

							tableModelEdicion.setRowCount(0);
							statement = connection.prepareStatement("SELECT Nombre, Apellidos, Teléfono, Dirección FROM clientes");
							ResultSet resultSet = statement.executeQuery();

							while (resultSet.next()) {
								String updatedNombre = resultSet.getString("Nombre");
								String updatedApellidos = resultSet.getString("Apellidos");
								String updatedTelefono = resultSet.getString("Teléfono");
								String updatedDireccion = resultSet.getString("Dirección");

								Object[] rowData = {updatedNombre, updatedApellidos, updatedTelefono, updatedDireccion};
								tableModelEdicion.addRow(rowData);
							}
						}

						// Close the statement and connection
						statement.close();
						connection.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
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

		DefaultComboBoxModel<String> comboBoxModelConsulta = new DefaultComboBoxModel<>();
		JComboBox<String> comboBoxConsulta = new JComboBox<>(comboBoxModelConsulta);
		comboBoxConsulta.setBounds(757, 257, 140, 30);
		consultarClientes.add(comboBoxConsulta);

		JButton btnConsultaTabla = new JButton("Consultar Cliente");
		btnConsultaTabla.setFocusable(false);
		btnConsultaTabla.setBounds(757, 297, 160, 30);

		JButton btnConsultaDireccion = new JButton("Consultar Dirección");
		btnConsultaDireccion.setFocusable(false);
		btnConsultaDireccion.setBounds(757, 337, 160, 30);

		consultarClientes.add(btnConsultaDireccion);

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");

			Statement statement = connection.createStatement();

			// EJecutar query fetch
			String queryConsulta = "SELECT * FROM clientes";
			ResultSet resultSetConsulta = statement.executeQuery(queryConsulta);

			tableModelConsulta.setRowCount(0);

			comboBoxModelConsulta.removeAllElements();

			while (resultSetConsulta.next()) {
				String nombre = resultSetConsulta.getString("Nombre");
				String apellidos = resultSetConsulta.getString("Apellidos");
				String telefono = resultSetConsulta.getString("Teléfono");
				String direccion = resultSetConsulta.getString("Dirección");

				Object[] rowData = {nombre, apellidos, telefono, direccion};

				tableModelConsulta.addRow(rowData);

				comboBoxModelConsulta.addElement(nombre + " " + apellidos);
			}

			resultSetConsulta.close();
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

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

		btnConsultaDireccion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableModelConsulta.setColumnIdentifiers(new String[]{"Nombre", "Apellidos", "Dirección"});

				tablaConsulta.repaint();
			}
		});
		consultarClientes.add(btnConsultaDireccion);

		JPanel panelConsulta2 = new JPanel();
		panelConsulta2.setBackground(Color.GRAY);
		panelConsulta2.setBounds(131, 215, 606, 42);
		consultarClientes.add(panelConsulta2);
		panelConsulta2.setLayout(null);

		JLabel historiallbl = new JLabel("Cliente a Consultar");
		historiallbl.setFont(new Font("Arial Black", Font.PLAIN, 16));
		historiallbl.setBounds(210, 11, 190, 20);
		panelConsulta2.add(historiallbl);

		JLabel clientes = new JLabel("Consultar Clientes");
		clientes.setFont(new Font("Arial Black", Font.PLAIN, 30));
		clientes.setBounds(280, 137, 320, 50);
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

		String[] columnNamesInfo = {"Historial", "Orden"};
		DefaultTableModel tableModelInfo = new DefaultTableModel(columnNamesInfo, 0);
		JTable tablaInfo = new JTable(tableModelInfo);

		tablaInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPaneInfo = new JScrollPane(tablaInfo);
		scrollPaneInfo.setBounds(0, 20, 620, 230);
		sobreFondoInfo.add(scrollPaneInfo);

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");

			Statement statement = connection.createStatement();

			String queryInfo = "SELECT * FROM historial";
			ResultSet resultSetInfo = statement.executeQuery(queryInfo);

			tableModelInfo.setRowCount(0);

			while (resultSetInfo.next()) {
				String historial = resultSetInfo.getString("Historial");
				String orden = resultSetInfo.getString("Orden");

				Object[] rowData = {historial, orden};

				tableModelInfo.addRow(rowData);
			}

			resultSetInfo.close();
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}



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
		lblEliminar.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblEliminar.setBounds(280, 137, 350, 50);
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


		String[] columnNames = {"Nombre", "Apellidos", "Teléfono", "Dirección"};
		DefaultTableModel tableModel1 = new DefaultTableModel(columnNames, 0);
		JTable tablaEliminar = new JTable(tableModel1);

		tablaEliminar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollpanetablainvconsulta = new JScrollPane(tablaEliminar);
		scrollpanetablainvconsulta.setBounds(131, 257, 606, 300);
		eliminarClientes.add(scrollpanetablainvconsulta);



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

				int option = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el cliente seleccionado?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					try {
						String url = "jdbc:mysql://localhost:3306/clientes";
						String username = "root";
						String password = "";
						Connection connection = DriverManager.getConnection(url, username, password);

						Statement statement = connection.createStatement();

						String deleteQuery = "DELETE FROM clientes WHERE Nombre='" + nombre + "' AND Apellidos='" + apellidos + "'";
						statement.executeUpdate(deleteQuery);
						System.out.println("Linea elminada");

						int rowCount = tableModel1.getRowCount();
						for (int i = 0; i < rowCount; i++) {
							String tableNombre = (String) tableModel1.getValueAt(i, 0);
							String tableApellidos = (String) tableModel1.getValueAt(i, 1);
							if (tableNombre.equals(nombre) && tableApellidos.equals(apellidos)) {
								tableModel1.removeRow(i);
								break;
							}
						}

						comboBox1.removeItem(selectedClient);

						comboBox1.setSelectedIndex(-1);

						statement.close();
						connection.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			}
		});




		updateTimer = new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateComponents(tableModel1, tableModelInfo, tableModelEdicion, tableModelConsulta, comboBox1, comboBoxConsulta, comboBox2);
			}
		});

		updateTimer.start();

		updateTimer = new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateComponents(tablamodelinvconsulta, tableModel, modelo, editarartbox, eliminarartbox);
			}
		});

		updateTimer.start();



	}



	public void updateComponents(DefaultTableModel tableModel1, DefaultTableModel tableModelInfo, DefaultTableModel tableModelEdicion, DefaultTableModel tableModelConsulta, JComboBox<String> comboBox1, JComboBox<String> comboBoxConsulta, JComboBox<String> comboBox2) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");

			// actualiza ptabla  1
			Statement statement1 = connection.createStatement();
			String query1 = "SELECT Nombre, Apellidos, Teléfono, Dirección FROM clientes";
			ResultSet resultSet1 = statement1.executeQuery(query1);
			tableModel1.setRowCount(0);

			// limpia combobox para que no se empiece a duplicar
			DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) comboBox1.getModel();
			comboBoxModel.removeAllElements();

			// limpia comboBoxConsulta para que no se empiece a duplicar
			DefaultComboBoxModel<String> comboBoxModelConsulta = (DefaultComboBoxModel<String>) comboBoxConsulta.getModel();
			comboBoxModelConsulta.removeAllElements();

			// limpia comboBox2 para que no se empiece a duplicar
			DefaultComboBoxModel<String> comboBoxModel2 = (DefaultComboBoxModel<String>) comboBox2.getModel();
			comboBoxModel2.removeAllElements();



			//actualiza combobox1
			while (resultSet1.next()) {
				String nombre = resultSet1.getString("Nombre");
				String apellidos = resultSet1.getString("Apellidos");
				String telefono = resultSet1.getString("Teléfono");
				String direccion = resultSet1.getString("Dirección");

				Object[] rowData = {nombre, apellidos, telefono, direccion};
				tableModel1.addRow(rowData);

				String nameAndLastname = nombre + " " + apellidos;
				comboBox1.addItem(nameAndLastname);
				comboBoxConsulta.addItem(nameAndLastname);
				comboBox2.addItem(nameAndLastname);
			}

			resultSet1.close();
			statement1.close();







			// actualiza tabla informacion
			Statement statement2 = connection.createStatement();
			String query2 = "SELECT * FROM historial";
			ResultSet resultSet2 = statement2.executeQuery(query2);
			tableModelInfo.setRowCount(0);

			while (resultSet2.next()) {
				String historial = resultSet2.getString("Historial");
				String orden = resultSet2.getString("Orden");

				Object[] rowData = {historial, orden};
				tableModelInfo.addRow(rowData);
			}

			resultSet2.close();
			statement2.close();


			//actualiza tabla afuera clientes


			// actualiza tabla edicion
			Statement statement3 = connection.createStatement();
			String query3 = "SELECT Nombre, Apellidos, Teléfono, Dirección FROM clientes";
			ResultSet resultSet3 = statement3.executeQuery(query3);
			tableModelEdicion.setRowCount(0);

			while (resultSet3.next()) {
				String nombre = resultSet3.getString("Nombre");
				String apellidos = resultSet3.getString("Apellidos");
				String telefono = resultSet3.getString("Teléfono");
				String direccion = resultSet3.getString("Dirección");

				Object[] rowData = {nombre, apellidos, telefono, direccion};
				tableModelEdicion.addRow(rowData);
			}

			resultSet3.close();
			statement3.close();

			//  actualiza tabla consulta
			Statement statementConsulta = connection.createStatement();
			String queryConsulta = "SELECT * FROM clientes";
			ResultSet resultSetConsulta = statementConsulta.executeQuery(queryConsulta);
			tableModelConsulta.setRowCount(0);

			while (resultSetConsulta.next()) {
				String nombre = resultSetConsulta.getString("Nombre");
				String apellidos = resultSetConsulta.getString("Apellidos");
				String telefono = resultSetConsulta.getString("Teléfono");
				String direccion = resultSetConsulta.getString("Dirección");

				Object[] rowData = {nombre, apellidos, telefono, direccion};
				tableModelConsulta.addRow(rowData);
			}

			resultSetConsulta.close();
			statementConsulta.close();

			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}




	public void updateComponents(DefaultTableModel tablamodelinvconsulta, DefaultTableModel tableModel, DefaultTableModel eliminartableModel, JComboBox<String> editarartComboBox, JComboBox<String> eliminarartComboBox) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");



			// Update tablaeditarart

			Statement statementInv = connection.createStatement();
			String queryInv = "SELECT Nombre, Unidad, Color ,Cantidad FROM inventario";
			ResultSet resultSetInv = statementInv.executeQuery(queryInv);
			tablamodelinvconsulta.setRowCount(0);

			while (resultSetInv.next()) {
				String nombre = resultSetInv.getString("Nombre");
				String unidad = resultSetInv.getString("Unidad");
				String color = resultSetInv.getString("Color");
				int cantidad = resultSetInv.getInt("Cantidad");

				Object[] rowData = {nombre, unidad, color, cantidad};
				tablamodelinvconsulta.addRow(rowData);
			}

			resultSetInv.close();
			statementInv.close();

			// Update consultainvtable

			Statement statementEdit = connection.createStatement();
			String queryEdit = "SELECT Nombre, Unidad, Cantidad FROM inventario";
			ResultSet resultSetEdit = statementEdit.executeQuery(queryEdit);
			tableModel.setRowCount(0);

			while (resultSetEdit.next()) {
				String nombre = resultSetEdit.getString("Nombre");
				String unidad = resultSetEdit.getString("Unidad");
				int cantidad = resultSetEdit.getInt("Cantidad");

				Object[] rowData = {nombre, unidad, cantidad};
				tableModel.addRow(rowData);
			}

			resultSetEdit.close();
			statementEdit.close();

// Update tablaeliminventario
			Statement statementDelete = connection.createStatement();
			String queryDelete = "SELECT Nombre, Unidad, Color, Cantidad FROM inventario";
			ResultSet resultSetDelete = statementDelete.executeQuery(queryDelete);
			eliminartableModel.setRowCount(0);

			while (resultSetDelete.next()) {
				String nombre = resultSetDelete.getString("Nombre");
				String unidad = resultSetDelete.getString("Unidad");
				String color = resultSetDelete.getString("Color");
				int cantidad = resultSetDelete.getInt("Cantidad");

				Object[] rowData = {nombre, unidad, color, cantidad};
				eliminartableModel.addRow(rowData);
			}

			resultSetDelete.close();
			statementDelete.close();


			// Update editarartbox combo box
			DefaultComboBoxModel<String> editarartComboBoxModel = (DefaultComboBoxModel<String>) editarartComboBox.getModel();
			editarartComboBoxModel.removeAllElements();

			Statement statementCombo = connection.createStatement();
			String queryCombo = "SELECT Nombre FROM inventario";
			ResultSet resultSetCombo = statementCombo.executeQuery(queryCombo);

			while (resultSetCombo.next()) {
				String nombre = resultSetCombo.getString("Nombre");
				editarartComboBoxModel.addElement(nombre);
			}

			resultSetCombo.close();
			statementCombo.close();

			// Update eliminarartbox combo box
			DefaultComboBoxModel<String> eliminarartComboBoxModel = (DefaultComboBoxModel<String>) eliminarartComboBox.getModel();
			eliminarartComboBoxModel.removeAllElements();

			Statement statementCombo2 = connection.createStatement();
			String queryCombo2 = "SELECT Nombre FROM inventario";
			ResultSet resultSetCombo2 = statementCombo2.executeQuery(queryCombo2);

			while (resultSetCombo2.next()) {
				String nombre = resultSetCombo2.getString("Nombre");
				eliminarartComboBoxModel.addElement(nombre);
			}

			resultSetCombo2.close();
			statementCombo2.close();

			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}


	public static void migrateTables() {

		Timer timer = new Timer(10000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection sourceConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordenes", "root", "");
					DatabaseMetaData metaData = sourceConnection.getMetaData();

					ResultSet tables = metaData.getTables("ordenes", null, null, new String[]{"TABLE"});

					Connection targetConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordenes", "root", "");
					Statement targetStatement = targetConnection.createStatement();

					targetStatement.executeUpdate("DELETE FROM historialbueno");

					ResultSet idResult = targetStatement.executeQuery("SELECT MAX(ID) FROM historialbueno");
					int nextId = 1;
					if (idResult.next()) {
						nextId = idResult.getInt(1) + 1;
					}

					while (tables.next()) {
						String tableName = tables.getString("TABLE_NAME");

						if (!tableName.equals("historialbueno")) {
							String columnNames = "Nombre, Platillos, Total";
							String selectQuery = "SELECT " + columnNames + " FROM " + tableName;
							ResultSet resultSet = sourceConnection.createStatement().executeQuery(selectQuery);

							while (resultSet.next()) {
								StringBuilder insertQuery = new StringBuilder("INSERT INTO historialbueno (ID, ");
								StringBuilder values = new StringBuilder("VALUES (");
								insertQuery.append(columnNames.replace(",", ", ")).append(") ");
								values.append("'").append(nextId++).append("', ");
								values.append("'").append(resultSet.getString("Nombre")).append("', ");
								values.append("'").append(resultSet.getString("Platillos")).append("', ");
								values.append(resultSet.getDouble("Total")).append(")");

								insertQuery.append(values);

								targetStatement.executeUpdate(insertQuery.toString());
							}
						}
					}

					tables.close();
					sourceConnection.close();
					targetStatement.close();
					targetConnection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});


		timer.start();

	}


























	private boolean ingredientExists(String tableName, String ingredient) {
		String url = "jdbc:mysql://localhost:3306/platillos";
		String username = "root";
		String password = "";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			Statement statement = connection.createStatement();

			String checkIngredientQuery = "SELECT COUNT(*) FROM " + tableName + " WHERE Ingrediente = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(checkIngredientQuery);
			preparedStatement.setString(1, ingredient);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				return count > 0;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

}