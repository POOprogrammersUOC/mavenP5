package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class Principal extends JFrame {
	private JLabel lblImageSetUsuario;
	private JLabel lblPanelDerechoSetUsuario;
	private JLabel lblPanelDerechoSetRol;
	private JPanel panelBody;
	private JPanel panelHome;
	private JPanel panelSocios;
	private JPanel panelEmpleados;
	private JPanel panelProyectos;
	private JButton btnHome;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		getContentPane().setPreferredSize(new Dimension(10, 10));
		setPreferredSize(new Dimension(1000, 700));
		setSize(new Dimension(1000, 700));
		setTitle("ONG Entreculturas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0, 0));
		panel.setBackground(new Color(177, 191, 212));
		panel.setBounds(0, 0, 201, 662);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblImageSetUsuario = new JLabel("");
		lblImageSetUsuario.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/mini_usuario.png")));
		lblImageSetUsuario.setBounds(40, 11, 105, 122);
		panel.add(lblImageSetUsuario);
		
		JLabel lblPanelDerechoUsuario = new JLabel("Usuario:");
		lblPanelDerechoUsuario.setBounds(26, 147, 59, 14);
		panel.add(lblPanelDerechoUsuario);
		lblPanelDerechoUsuario.setForeground(Color.BLACK);
		
		JLabel lblPanelDerechoRol = new JLabel("Privilegios:");
		lblPanelDerechoRol.setBounds(26, 167, 77, 14);
		panel.add(lblPanelDerechoRol);
		lblPanelDerechoRol.setForeground(Color.BLACK);
		
		lblPanelDerechoSetUsuario = new JLabel("Tipo_usuario");
		lblPanelDerechoSetUsuario.setBounds(95, 147, 96, 14);
		panel.add(lblPanelDerechoSetUsuario);
		lblPanelDerechoSetUsuario.setForeground(Color.BLACK);
		
		lblPanelDerechoSetRol = new JLabel("Tipo_rol");
		lblPanelDerechoSetRol.setBounds(95, 167, 96, 14);
		panel.add(lblPanelDerechoSetRol);
		lblPanelDerechoSetRol.setForeground(Color.BLACK);
		
		final JButton btnSocios = new JButton("Socios      ");
		btnSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBody.removeAll();
				panelBody.repaint();
				panelBody.revalidate();
				panelBody.add(panelSocios);
				panelBody.revalidate();
			}
		});
		btnSocios.setBounds(0, 319, 201, 38);
		panel.add(btnSocios);
		btnSocios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSocios.setBackground(new Color(100, 127, 189));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSocios.setBackground(new Color(177, 191, 212));
			}
		});
		btnSocios.setForeground(Color.WHITE);
		btnSocios.setBackground(new Color(177, 191, 212));
		btnSocios.setFocusPainted(false);
		btnSocios.setBorderPainted(false);
		btnSocios.setBorder(null);
		btnSocios.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/apreton-de-manos24.png")));
		
		final JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBody.removeAll();
				panelBody.repaint();
				panelBody.revalidate();
				panelBody.add(panelEmpleados);
				panelBody.revalidate();
			}
		});
		btnEmpleados.setBounds(0, 356, 201, 38);
		panel.add(btnEmpleados);
		btnEmpleados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEmpleados.setBackground(new Color(100, 127, 189));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEmpleados.setBackground(new Color(177, 191, 212));
			}
		});
		btnEmpleados.setForeground(Color.WHITE);
		btnEmpleados.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/trabajo-en-equipo24.png")));
		btnEmpleados.setFocusPainted(false);
		btnEmpleados.setBorderPainted(false);
		btnEmpleados.setBorder(null);
		btnEmpleados.setBackground(new Color(177, 191, 212));
		
		final JButton btnProyectos = new JButton("Proyectos");
		btnProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBody.removeAll();
				panelBody.repaint();
				panelBody.revalidate();
				panelBody.add(panelProyectos);
				panelBody.revalidate();
			}
		});
		btnProyectos.setBounds(0, 393, 201, 38);
		panel.add(btnProyectos);
		btnProyectos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnProyectos.setBackground(new Color(100, 127, 189));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnProyectos.setBackground(new Color(177, 191, 212));
			}
		});
		btnProyectos.setForeground(Color.WHITE);
		btnProyectos.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/proyectos24.png")));
		btnProyectos.setFocusPainted(false);
		btnProyectos.setBorderPainted(false);
		btnProyectos.setBorder(null);
		btnProyectos.setBackground(new Color(177, 191, 212));
		
		btnHome = new JButton("Home       ");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBody.removeAll();
				panelBody.repaint();
				panelBody.revalidate();
				panelBody.add(panelHome);
				panelBody.revalidate();
			}
		});
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHome.setBackground(new Color(100, 127, 189));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnHome.setBackground(new Color(177, 191, 212));
			}
		});
		btnHome.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/home24.png")));
		btnHome.setForeground(Color.WHITE);
		btnHome.setFocusPainted(false);
		btnHome.setBorderPainted(false);
		btnHome.setBorder(null);
		btnHome.setBackground(new Color(177, 191, 212));
		btnHome.setBounds(0, 279, 201, 38);
		panel.add(btnHome);
		
		panelBody = new JPanel();
		panelBody.setBounds(200, 0, 784, 662);
		getContentPane().add(panelBody);
		panelBody.setLayout(new CardLayout(0, 0));
		
		panelHome = new JPanel();
		panelHome.setBounds(new Rectangle(200, 0, 784, 662));
		panelBody.add(panelHome, "name_161162941260200");
		
		panelSocios = new JPanel();
		panelSocios.setBackground(SystemColor.inactiveCaptionBorder);
		panelBody.add(panelSocios, "name_161214080585300");
		panelSocios.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nº de socio:");
		lblNewLabel.setBounds(10, 302, 68, 14);
		panelSocios.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 317, 96, 20);
		panelSocios.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(138, 302, 68, 14);
		panelSocios.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(138, 317, 96, 20);
		panelSocios.add(textField_1);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(258, 302, 68, 14);
		panelSocios.add(lblApellido);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(258, 317, 96, 20);
		panelSocios.add(textField_2);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setBounds(377, 302, 68, 14);
		panelSocios.add(lblDireccin);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(377, 317, 96, 20);
		panelSocios.add(textField_3);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setBounds(498, 302, 68, 14);
		panelSocios.add(lblTelfono);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(498, 317, 96, 20);
		panelSocios.add(textField_4);
		
		JLabel lblCifOng = new JLabel("Cif Ong:");
		lblCifOng.setBounds(10, 363, 68, 14);
		panelSocios.add(lblCifOng);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(10, 378, 96, 20);
		panelSocios.add(textField_5);
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.setBounds(123, 455, 89, 23);
		panelSocios.add(btnNewButton);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(234, 455, 89, 23);
		panelSocios.add(btnInsertar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(345, 455, 89, 23);
		panelSocios.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(453, 455, 89, 23);
		panelSocios.add(btnModificar);
		
		JLabel lblNewLabel_1 = new JLabel("SOCIOS");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		panelSocios.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 28, 666, 238);
		panelSocios.add(panel_1);
		
		panelEmpleados = new JPanel();
		panelEmpleados.setBackground(Color.CYAN);
		panelBody.add(panelEmpleados, "name_161410589258100");
		
		panelProyectos = new JPanel();
		panelProyectos.setBackground(Color.ORANGE);
		panelBody.add(panelProyectos, "name_161445339611100");
	}
	public JLabel getLblImageSetUsuario() {
		return lblImageSetUsuario;
	}
	public JLabel getLblPanelDerechoSetUsuario() {
		return lblPanelDerechoSetUsuario;
	}
	public JLabel getLblPanelDerechoSetRol() {
		return lblPanelDerechoSetRol;
	}
	public JPanel getPanelBody() {
		return panelBody;
	}
	public JPanel getPanelHome() {
		return panelHome;
	}
	public JPanel getPanelSocios() {
		return panelSocios;
	}
	public JPanel getPanelEmpleados() {
		return panelEmpleados;
	}
	public JPanel getPanelProyectos() {
		return panelProyectos;
	}
}
