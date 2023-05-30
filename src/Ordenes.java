
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class Ordenes extends JFrame {

	private JPanel contentPane;


	public Ordenes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel PanelOrdenes = new JPanel();
		contentPane.add(PanelOrdenes);
		PanelOrdenes.setLayout(null);

		JPanel PanelOrdenes1 = new JPanel();
		PanelOrdenes1 .setLayout(null);
		PanelOrdenes1 .setBackground(Color.WHITE);
		PanelOrdenes1 .setBounds(60, 241, 827, 347);
		PanelOrdenes.add(PanelOrdenes1 );

		JButton ConsultarButton = new JButton("Consultar");
		ConsultarButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ConsultarButton.setBackground(new Color(255, 128, 0));
		ConsultarButton.setBounds(112, 95, 217, 60);
		PanelOrdenes1 .add(ConsultarButton);

		JButton EditarButton = new JButton("Editar");
		EditarButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EditarButton.setBackground(new Color(255, 128, 0));
		EditarButton.setBounds(112, 198, 217, 60);
		PanelOrdenes1 .add(EditarButton);

		JButton EliminarButton = new JButton("Eliminar");
		EliminarButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EliminarButton.setBackground(new Color(255, 128, 0));
		EliminarButton.setBounds(490, 198, 217, 60);
		PanelOrdenes1 .add(EliminarButton);

		JButton CrearButton = new JButton("Crear");
		CrearButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CrearButton.setBackground(new Color(255, 128, 0));
		CrearButton.setBounds(490, 95, 217, 60);
		PanelOrdenes1 .add(CrearButton);

		CrearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(PanelOrdenes);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});

		JLabel OrdenesLabel = new JLabel("Ordenes");
		OrdenesLabel.setBounds(401, 40, 126, 55);
		PanelOrdenes.add(OrdenesLabel);
		OrdenesLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
	}
}