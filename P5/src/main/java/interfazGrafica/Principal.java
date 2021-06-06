package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.proogramers.uoc.P5.FillOutJTable;
import com.proogramers.uoc.P5.Empleados;
import com.proogramers.uoc.P5.LlenarJTable;
import com.proogramers.uoc.P5.Proyectos;
import com.proogramers.uoc.P5.RellenarJTable;
import com.proogramers.uoc.P5.Socios;

import DAO.DAOFactory;
import DAO.JPAProyectosDAO;

import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.SystemColor;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.util.Locale;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

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

	private static JTable table;
	private static JTable tabla;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JTextField idProyecto;
	private JTextField txtPais;
	private JTextField txtLocalizacion;
	private JTextField txtFinicio;
	private JTextField txtFfinal;
	private JTextField txtSocioLocal;
	private JTextField txtFinanciador;
	private JTextField txtFinanciacion;
	private JTextField txtPersonal;
	private JTextField txtVoluntarios;
	private JTextField txtCifOng;
	private JTextArea textAreaLinea;
	private JLabel lblNewLabel_13;
	private JScrollPane scrollPane_1;
	private JTextArea textAreaSublinea;
	private JLabel lblNewLabel_14;
	private JScrollPane scrollPane_2;
	private JTextArea textAreaAccion;
	private JButton btnLimpiar;
	private JButton btnInsertar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JLabel lbletiqueta;
	private JLabel lbletiqueta_1;
	private JLabel lbletiqueta_2;
	private JLabel lbletiqueta_3;
	private JLabel lbletiqueta_4;
	private JLabel lbletiqueta_5;
	private JLabel lbletiqueta_6;
	private JTextField idEmpleado;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JTextField txtOngCif;
	private JButton btnNuevo;
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnUpdate;

	private JTextField idSocio;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtVatNum;
	private JButton btnNew;
	private JButton btnAdd;
	private JButton btnErase;
	private JButton btnModify;

	static Logger log = LogManager.getRootLogger();
	private JScrollPane scrollPane_3;
	private JScrollPane scroll;
	private JLabel lblNewLabel_15;
	private JScrollPane scrollSocios;
	private static JTable table_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setLocationRelativeTo(null);
					cargarJtableProyectos();
					cargarJtableSocios();
					cargarJtableEmpleados();
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
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/interfazGrafica/img/mundo.png")));
		setResizable(false);
		setLocale(new Locale("es", "ES"));
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
		btnEmpleados
				.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/trabajo-en-equipo24.png")));
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

		// PANEL SOCIOS

		panelSocios = new JPanel();
		panelSocios.setBackground(SystemColor.inactiveCaptionBorder);
		panelBody.add(panelSocios, "name_161214080585300");
		panelSocios.setLayout(null);

		idSocio = new JTextField();
		idSocio.setEditable(false);
		idSocio.setBounds(10, 317, 96, 20);
		panelSocios.add(idSocio);
		idSocio.setColumns(10);

		JLabel lbltag_1 = new JLabel("Nombre:");
		lbltag_1.setBounds(138, 302, 68, 14);
		panelSocios.add(lbltag_1);

		JLabel lbltag_2 = new JLabel("Apellido:");
		lbltag_2.setBounds(258, 302, 68, 14);
		panelSocios.add(lbltag_2);

		JLabel lbltag_3 = new JLabel("Dirección:");
		lbltag_3.setBounds(377, 302, 68, 14);
		panelSocios.add(lbltag_3);

		JLabel lbltag_4 = new JLabel("Teléfono:");
		lbltag_4.setBounds(498, 302, 68, 14);
		panelSocios.add(lbltag_4);

		JLabel lbltag_5 = new JLabel("Cif Ong:");
		lbltag_5.setBounds(10, 363, 68, 14);
		panelSocios.add(lbltag_5);

		JLabel lblSociostitulo = new JLabel("SOCIOS");
		lblSociostitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSociostitulo.setBounds(10, 11, 68, 14);
		panelSocios.add(lblSociostitulo);

		JLabel lbltag = new JLabel("Nº Socio:");
		lbltag.setBounds(10, 302, 68, 14);
		panelSocios.add(lbltag);

		lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setOpaque(true);
		lblNewLabel_15.setBackground(Color.ORANGE);
		lblNewLabel_15.setBounds(0, 36, 764, 8);
		panelSocios.add(lblNewLabel_15);

		scrollSocios = new JScrollPane();
		scrollSocios.setAutoscrolls(true);

		scrollSocios.setBounds(10, 55, 764, 229);
		panelSocios.add(scrollSocios);

		table_1 = new JTable();
		scrollSocios.setViewportView(table_1);

		table_1 = new JTable();
		table_1.setSelectionBackground(Color.CYAN);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int getRegistro = table_1.getSelectedRow();
				idSocio.setText(table_1.getValueAt(getRegistro, 0).toString());
				txtName.setText(table_1.getValueAt(getRegistro, 1).toString());
				txtSurname.setText(table_1.getValueAt(getRegistro, 2).toString());
				txtAddress.setText(table_1.getValueAt(getRegistro, 3).toString());
				txtPhone.setText(table_1.getValueAt(getRegistro, 4).toString());
				txtVatNum.setText(table_1.getValueAt(getRegistro, 5).toString());

			}
		});
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollSocios.setViewportView(table_1);

		txtName = new JTextField();
		txtName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtName.setBackground(Color.CYAN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtName.setBackground(Color.WHITE);
			}
		});
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 45;
				if (txtName.getText().length() == limite) {
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite + " carácteres",
							"Límite de carácteres en el campo Nombre", JOptionPane.ERROR_MESSAGE, null);
					e.consume();
				}
			}
		});
		txtName.setBounds(138, 317, 96, 20);
		panelSocios.add(txtName);
		txtName.setColumns(10);

		txtSurname = new JTextField();
		txtSurname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSurname.setBackground(Color.CYAN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtSurname.setBackground(Color.WHITE);
			}
		});
		txtSurname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 45;
				if (txtSurname.getText().length() == limite) {
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite + " carácteres",
							"Límite de carácteres en el campo Apellido", JOptionPane.ERROR_MESSAGE, null);
					e.consume();
				}
			}
		});

		txtSurname.setBounds(258, 317, 96, 20);
		panelSocios.add(txtSurname);
		txtSurname.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAddress.setBackground(Color.CYAN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtAddress.setBackground(Color.WHITE);
			}
		});
		txtAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 45;
				if (txtAddress.getText().length() == limite) {
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite + " carácteres",
							"Límite de carácteres en el campo Direccion", JOptionPane.ERROR_MESSAGE, null);
					e.consume();
				}
			}
		});

		txtAddress.setBounds(377, 317, 96, 20);
		panelSocios.add(txtAddress);
		txtAddress.setColumns(10);

		txtPhone = new JTextField();
		txtPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPhone.setBackground(Color.CYAN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtPhone.setBackground(Color.WHITE);
			}
		});
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 45;
				if (txtPhone.getText().length() == limite) {
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite + " carácteres",
							"Límite de carácteres en el campo Telefono", JOptionPane.ERROR_MESSAGE, null);
					e.consume();
				}
			}
		});

		txtPhone.setBounds(498, 317, 96, 20);
		panelSocios.add(txtPhone);
		txtPhone.setColumns(10);

		txtVatNum = new JTextField();
		txtVatNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtVatNum.setBackground(Color.CYAN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtVatNum.setBackground(Color.WHITE);
			}
		});
		txtVatNum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 45;
				if (txtVatNum.getText().length() == limite) {
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite + " carácteres",
							"Límite de carácteres en el campo Ong Cif", JOptionPane.ERROR_MESSAGE, null);
					e.consume();
				}
			}
		});
		txtVatNum.setColumns(10);
		txtVatNum.setBounds(10, 386, 96, 20);
		panelSocios.add(txtVatNum);

		JButton btnAdd = new JButton("Nuevo");
		btnAdd.setFocusPainted(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				idSocio.setText("");
				txtName.setText("");
				txtSurname.setText("");
				txtAddress.setText("");
				txtPhone.setText("");
				txtVatNum.setText("");

			}
		});
		btnAdd.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/nuevo.png")));
		btnAdd.setBounds(105, 455, 101, 23);
		panelSocios.add(btnAdd);

		btnInsert = new JButton("Insertar");
		btnInsert.setFocusPainted(false);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ar0) {

				try {

					if (txtName.getText().isEmpty() || txtSurname.getText().isEmpty() || txtAddress.getText().isEmpty()
							|| txtPhone.getText().isEmpty() || txtVatNum.getText().isEmpty()) {
						// JOptionPane.showMessageDialog(null, "Las siguientes celdas no pueden estar
						// vacias: " + "\n" + "Pais" + "\n" + "Fecha de inicio" + "\n" +"Fecha de fin"
						// +"\n" + "Socio" + "\n" +"Financiación" + "\n" +"Personal" + "\n"
						// +"Voluntariados" + "\n" +"CIF de la ong", "Registro",
						// JOptionPane.ERROR_MESSAGE);
						// JOptionPane.showMessageDialog(null, "Las siguientes celdas no pueden estar
						// vacias: " + "\n" + "Nombre" + "\n" + "Apellido" + "\n" +"Direccion" +"\n" +
						// "Telefono" + "\n" +"Dni" + "\n" +"Ong Cif" + "Registro",
						// JOptionPane.ERROR_MESSAGE);
					} else {

						Socios socios = new Socios(txtName.getText(), txtSurname.getText(), txtAddress.getText(),
								txtPhone.getText(), txtVatNum.getText());

						DAOFactory.getDAOFactory(4).jpaSociosDAO().persist(socios);

					}

					// JOptionPane.showMessageDialog(null, "Registro insertado correctamente",
					// "Registro", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					// JOptionPane.showMessageDialog(null, "Registro erroneo", "Registro",
					// JOptionPane.ERROR_MESSAGE);
					// tx.rollback();
					// TODO: handle exception
				} finally {
					cargarJtableSocios();
				}

			}
		});
		btnInsert.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/insertar.png")));
		btnInsert.setBounds(226, 455, 101, 23);
		panelSocios.add(btnInsert);

		btnErase = new JButton("Eliminar");
		btnErase.setFocusPainted(false);
		btnErase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					if (idSocio.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Tiene que seleccionar un registro de la tabla para ser borrado", "Registro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						DAOFactory.getDAOFactory(4).jpaSociosDAO().eliminar(Integer.parseInt(idSocio.getText()));
					}

					// JOptionPane.showMessageDialog(null, "Registro eliminado correctamente",
					// "Registro", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					// JOptionPane.showMessageDialog(null, "Registro no borrado", "Registro",
					// JOptionPane.ERROR_MESSAGE);
					// tx1.rollback();
				} finally {
					cargarJtableSocios();
				}

			}

		});
		btnErase.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/eliminar.png")));
		btnErase.setBounds(347, 455, 107, 23);
		panelSocios.add(btnErase);

		btnModify = new JButton("Modificar");
		btnModify.setFocusPainted(false);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					if (idSocio.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Tiene que seleccionar un registro de la tabla para ser modificado", "Registro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						if (txtName.getText().isEmpty() || txtSurname.getText().isEmpty()
								|| txtAddress.getText().isEmpty() || txtPhone.getText().isEmpty()
								|| txtVatNum.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null,
									"Las siguientes celdas no pueden estar vacias: " + "\n" + "Nombre" + "\n"
											+ "Apellido" + "\n" + "\n" + "Direccion" + "\n" + "Telefono" + "\n"
											+ "CIF de la ong",
									"Registro", JOptionPane.ERROR_MESSAGE);
						} else {
							Socios sociosMod = DAOFactory.getDAOFactory(4).jpaSociosDAO()
									.leerId(Integer.parseInt(idSocio.getText()));

							sociosMod.setNombre(txtName.getText());
							sociosMod.setApellidos(txtSurname.getText());
							sociosMod.setDireccion(txtAddress.getText());
							sociosMod.setTelefono(txtPhone.getText());
							sociosMod.setOngCif(txtVatNum.getText());

							DAOFactory.getDAOFactory(4).jpaSociosDAO().actualizar(sociosMod);
						}

					}

					// JOptionPane.showMessageDialog(null, "Registro modificado correctamente",
					// "Registro", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					// JOptionPane.showMessageDialog(null, "Registro no modificado", "Registro",
					// JOptionPane.ERROR_MESSAGE);
					// tx1.rollback();
				} finally {
					cargarJtableSocios();
				}

			}
		});
		btnModify.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/reload.png")));
		btnModify.setBounds(464, 455, 117, 23);
		panelSocios.add(btnModify);

		// PANEL EMPLEADOS

		//PANEL EMPLEADOS
		
		panelEmpleados = new JPanel();
		panelEmpleados.setBackground(new Color(237, 240, 245));
		panelBody.add(panelEmpleados, "name_161410589258100");
		panelEmpleados.setLayout(null);
		
		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setBounds(10, 25, 100, 17);
		lblEmpleados.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelEmpleados.add(lblEmpleados);
		
		JLabel lbllinea = new JLabel("");
		lbllinea.setBounds(10, 42, 764, 8);
		lbllinea.setOpaque(true);
		lbllinea.setBackground(Color.CYAN);
		panelEmpleados.add(lbllinea);
		
		scroll = new JScrollPane();
		scroll.setAutoscrolls(true);
		
		scroll.setBounds(10, 72, 764, 226);
		panelEmpleados.add(scroll);
		
		tabla = new JTable();
		tabla.setSelectionBackground(Color.CYAN);
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int getRegistro = tabla.getSelectedRow();
				idEmpleado.setText(tabla.getValueAt(getRegistro, 0).toString());
				txtNombre.setText(tabla.getValueAt(getRegistro, 1).toString());
				txtApellido.setText(tabla.getValueAt(getRegistro, 2).toString());
				txtDireccion.setText(tabla.getValueAt(getRegistro, 3).toString());
				txtTelefono.setText(tabla.getValueAt(getRegistro, 4).toString());
				txtDni.setText(tabla.getValueAt(getRegistro, 5).toString());
				txtOngCif.setText(tabla.getValueAt(getRegistro, 6).toString());
				
			}
		});
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scroll.setViewportView(tabla);
		
		lbletiqueta = new JLabel("Numero:");
		lbletiqueta.setBounds(10, 322, 125, 14);
		panelEmpleados.add(lbletiqueta);
		
		lbletiqueta_1 = new JLabel("Nombre:");
		lbletiqueta_1.setBounds(160, 322, 75, 14);
		panelEmpleados.add(lbletiqueta_1);
		
		lbletiqueta_2 = new JLabel("Apellido:");
		lbletiqueta_2.setBounds(305, 322, 75, 11);
		panelEmpleados.add(lbletiqueta_2);
		
		lbletiqueta_3 = new JLabel("Direccion:");
		lbletiqueta_3.setBounds(450, 322, 118, 14);
		panelEmpleados.add(lbletiqueta_3);
		
		lbletiqueta_4 = new JLabel("Telefono:");
		lbletiqueta_4.setBounds(595, 322, 75, 14);
		panelEmpleados.add(lbletiqueta_4);
		
		lbletiqueta_5 = new JLabel("Dni:");
		lbletiqueta_5.setBounds(11, 367, 124, 14);
		panelEmpleados.add(lbletiqueta_5);
		
		lbletiqueta_6 = new JLabel("Ong Cif:");
		lbletiqueta_6.setBounds(160, 367, 125, 14);
		panelEmpleados.add(lbletiqueta_6);
		
		idEmpleado = new JTextField();
		idEmpleado.setEditable(false);
		idEmpleado.setBounds(10, 336, 125, 20);
		panelEmpleados.add(idEmpleado);
		idEmpleado.setColumns(10);

		// PANEL PROYECTOS

		txtNombre = new JTextField();
		txtNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNombre.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtNombre.setBackground(Color.WHITE);
			}
		});
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite =45;
				if(txtNombre.getText().length() == limite) 
				{
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite +" carácteres", "Límite de carácteres en el campo Nombre",JOptionPane.ERROR_MESSAGE , null);
					e.consume();				
				}
			}
		});
		txtNombre.setBounds(160, 335, 125, 20);
		panelEmpleados.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtApellido.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtApellido.setBackground(Color.WHITE);
			}
		});
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite =45;
				if(txtApellido.getText().length() == limite) 
				{
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite +" carácteres", "Límite de carácteres en el campo Apellido",JOptionPane.ERROR_MESSAGE , null);
					e.consume();				
				}
			}
		});
		txtApellido.setBounds(305, 335, 125, 20);
		panelEmpleados.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDireccion.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtDireccion.setBackground(Color.WHITE);
			}
		});
		txtDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite =45;
				if(txtDireccion.getText().length() == limite) 
				{
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite +" carácteres", "Límite de carácteres en el campo Direccion",JOptionPane.ERROR_MESSAGE , null);
					e.consume();				
				}
			}
		});
		txtDireccion.setBounds(450, 335, 125, 20);
		panelEmpleados.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTelefono.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtTelefono.setBackground(Color.WHITE);
			}
		});
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite =45;
				if(txtTelefono.getText().length() == limite) 
				{
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite +" carácteres", "Límite de carácteres en el campo Telefono",JOptionPane.ERROR_MESSAGE , null);
					e.consume();				
				}
			}
		});
		txtTelefono.setBounds(595, 335, 125, 20);
		panelEmpleados.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDni.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtDni.setBackground(Color.WHITE);
			}
		});
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite =45;
				if(txtDni.getText().length() == limite) 
				{
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite +" carácteres", "Límite de carácteres en el campo Dni",JOptionPane.ERROR_MESSAGE , null);
					e.consume();				
				}
			}
		});
		txtDni.setBounds(10, 380, 125, 20);
		panelEmpleados.add(txtDni);
		txtDni.setColumns(10);
		
		txtOngCif = new JTextField();
		txtOngCif.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtOngCif.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtOngCif.setBackground(Color.WHITE);
			}
		});
		txtOngCif.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite =45;
				if(txtOngCif.getText().length() == limite) 
				{
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite +" carácteres", "Límite de carácteres en el campo Ong Cif",JOptionPane.ERROR_MESSAGE , null);
					e.consume();				
				}
			}
		});
		txtOngCif.setBounds(160, 380, 125, 20);
		panelEmpleados.add(txtOngCif);
		txtOngCif.setColumns(10);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFocusPainted(false);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				idEmpleado.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtDireccion.setText("");
				txtTelefono.setText("");
				txtDni.setText("");
				txtOngCif.setText("");
								
			}
		});
		btnNuevo.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/nuevo.png")));
		btnNuevo.setBounds(160, 612, 89, 23);
		panelEmpleados.add(btnNuevo);
		
		btnInsert = new JButton("Insertar");
		btnInsert.setFocusPainted(false);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ar0) {
				

				try {
					
					if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtDni.getText().isEmpty() || txtOngCif.getText().isEmpty()) {
						//JOptionPane.showMessageDialog(null, "Las siguientes celdas no pueden estar vacias: " + "\n" + "Pais" + "\n" + "Fecha de inicio" + "\n" +"Fecha de fin" +"\n" + "Socio" + "\n" +"Financiación" + "\n" +"Personal" + "\n" +"Voluntariados" + "\n" +"CIF de la ong", "Registro", JOptionPane.ERROR_MESSAGE);
						//JOptionPane.showMessageDialog(null, "Las siguientes celdas no pueden estar vacias: " + "\n" + "Nombre" + "\n" + "Apellido" + "\n" +"Direccion" +"\n" + "Telefono" + "\n" +"Dni" + "\n" +"Ong Cif" + "Registro", JOptionPane.ERROR_MESSAGE);
					} else {
														
							Empleados empleados = new Empleados(txtNombre.getText(),txtApellido.getText(),txtDireccion.getText(),txtTelefono.getText(),txtDni.getText(),txtOngCif.getText());
							
							DAOFactory.getDAOFactory(4).jpaEmpleadosDAO().persist(empleados);
													
						}
						
										
					//JOptionPane.showMessageDialog(null, "Registro insertado correctamente", "Registro", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					//JOptionPane.showMessageDialog(null, "Registro erroneo", "Registro", JOptionPane.ERROR_MESSAGE);
					//tx.rollback();
					// TODO: handle exception
				}finally {
					cargarJtableEmpleados();
				}		
				
			}
		});
		btnInsert.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/insertar.png")));
		btnInsert.setBounds(259, 612, 100, 23);
		panelEmpleados.add(btnInsert);
		
		btnDelete = new JButton("Eliminar");
		btnDelete.setFocusPainted(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					

				try {
					
					if (idEmpleado.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Tiene que seleccionar un registro de la tabla para ser borrado", "Registro", JOptionPane.ERROR_MESSAGE);
					} else {
						DAOFactory.getDAOFactory(4).jpaEmpleadosDAO().eliminar(Integer.parseInt(idEmpleado.getText()));
					}
					
					
					
					//JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Registro", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					//JOptionPane.showMessageDialog(null, "Registro no borrado", "Registro", JOptionPane.ERROR_MESSAGE);
					//tx1.rollback();
				}finally {
					cargarJtableEmpleados();
				}
				
			}
		});
		btnDelete.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/eliminar.png")));
		btnDelete.setBounds(369, 612, 105, 23);
		panelEmpleados.add(btnDelete);
		
		btnUpdate = new JButton("Modificar");
		btnUpdate.setFocusPainted(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				try {
					
					if(idEmpleado.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Tiene que seleccionar un registro de la tabla para ser modificado", "Registro", JOptionPane.ERROR_MESSAGE);
					}else {
						if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtDni.getText().isEmpty() || txtOngCif.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Las siguientes celdas no pueden estar vacias: " + "\n" + "Nombre" + "\n" + "Apellido" + "\n" +"Fecha de fin" +"\n" + "Socio" + "\n" +"Financiación" + "\n" +"Personal" + "\n" +"Voluntariados" + "\n" +"CIF de la ong", "Registro", JOptionPane.ERROR_MESSAGE);
						}else {
								Empleados empleadosMod = DAOFactory.getDAOFactory(4).jpaEmpleadosDAO().leerId(Integer.parseInt(idEmpleado.getText()));
								
								empleadosMod.setNombre(txtNombre.getText());
								empleadosMod.setApellidos(txtApellido.getText());
								empleadosMod.setDireccion(txtDireccion.getText());
								empleadosMod.setTelefono(txtTelefono.getText());
								empleadosMod.setDNI(txtDni.getText());
								empleadosMod.setOngCif(txtOngCif.getText());
								
								DAOFactory.getDAOFactory(4).jpaEmpleadosDAO().actualizar(empleadosMod);	
						}
						
						
						}	
			
					//JOptionPane.showMessageDialog(null, "Registro modificado correctamente", "Registro", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					//JOptionPane.showMessageDialog(null, "Registro no modificado", "Registro", JOptionPane.ERROR_MESSAGE);
					//tx1.rollback();
				}finally {
					cargarJtableEmpleados();
				}
				
				
			}
		});
		btnUpdate.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/reload.png")));
		btnUpdate.setBounds(484, 612, 112, 23);
		panelEmpleados.add(btnUpdate);
		
		
		//PANEL PROYECTOS
		
		panelProyectos = new JPanel();
		panelProyectos.setBackground(new Color(237, 240, 245));
		panelBody.add(panelProyectos, "name_161445339611100");
		panelProyectos.setLayout(null);

		JLabel lblTituloProyectos = new JLabel("PROYECTOS");
		lblTituloProyectos.setBounds(10, 25, 100, 17);
		lblTituloProyectos.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelProyectos.add(lblTituloProyectos);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBounds(10, 42, 764, 8);
		lblNewLabel_11.setOpaque(true);
		lblNewLabel_11.setBackground(Color.ORANGE);
		panelProyectos.add(lblNewLabel_11);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setAutoscrolls(true);
		/*
		 * scrollPane_3.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) {
		 * 
		 * 
		 * } });
		 */
		scrollPane_3.setBounds(10, 72, 764, 226);
		panelProyectos.add(scrollPane_3);

		table = new JTable();
		table.setSelectionBackground(new Color(255, 204, 102));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int getRegistro = table.getSelectedRow();
				idProyecto.setText(table.getValueAt(getRegistro, 0).toString());
				txtPais.setText(table.getValueAt(getRegistro, 1).toString());
				txtLocalizacion.setText(table.getValueAt(getRegistro, 2).toString());
				textAreaLinea.setText(table.getValueAt(getRegistro, 3).toString());
				textAreaSublinea.setText(table.getValueAt(getRegistro, 4).toString());
				txtFinicio.setText(table.getValueAt(getRegistro, 5).toString());
				txtFfinal.setText(table.getValueAt(getRegistro, 6).toString());
				txtSocioLocal.setText(table.getValueAt(getRegistro, 7).toString());
				txtFinanciador.setText(table.getValueAt(getRegistro, 8).toString());
				txtFinanciacion.setText(table.getValueAt(getRegistro, 9).toString());
				textAreaAccion.setText(table.getValueAt(getRegistro, 10).toString());
				txtPersonal.setText(table.getValueAt(getRegistro, 11).toString());
				txtVoluntarios.setText(table.getValueAt(getRegistro, 12).toString());
				txtCifOng.setText(table.getValueAt(getRegistro, 13).toString());

			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane_3.setViewportView(table);

		lblNewLabel = new JLabel("Nº de proyecto:");
		lblNewLabel.setBounds(10, 322, 125, 14);
		panelProyectos.add(lblNewLabel);

		lblNewLabel_2 = new JLabel("Pais:");
		lblNewLabel_2.setBounds(160, 322, 46, 14);
		panelProyectos.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Localización:");
		lblNewLabel_3.setBounds(305, 322, 75, 11);
		panelProyectos.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Fecha de inicio:");
		lblNewLabel_4.setBounds(450, 322, 118, 14);
		panelProyectos.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Fecha final:");
		lblNewLabel_5.setBounds(595, 322, 75, 14);
		panelProyectos.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Socio local:");
		lblNewLabel_6.setBounds(11, 367, 124, 14);
		panelProyectos.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Financiador:");
		lblNewLabel_7.setBounds(160, 367, 125, 14);
		panelProyectos.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("Financiación:");
		lblNewLabel_8.setBounds(305, 367, 125, 14);
		panelProyectos.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("Personal:");
		lblNewLabel_9.setBounds(451, 367, 64, 14);
		panelProyectos.add(lblNewLabel_9);

		lblNewLabel_10 = new JLabel("Voluntarios asignados:");
		lblNewLabel_10.setBounds(595, 367, 135, 14);
		panelProyectos.add(lblNewLabel_10);

		lblNewLabel_11 = new JLabel("Cif Ong:");
		lblNewLabel_11.setBounds(10, 411, 64, 14);
		panelProyectos.add(lblNewLabel_11);

		idProyecto = new JTextField();
		idProyecto.setEditable(false);
		idProyecto.setBounds(10, 336, 125, 20);
		panelProyectos.add(idProyecto);
		idProyecto.setColumns(10);

		txtPais = new JTextField();
		txtPais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPais.setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtPais.setBackground(Color.WHITE);
			}
		});
		txtPais.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 45;
				if (txtPais.getText().length() == limite) {
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite + " carácteres",
							"Límite de carácteres en el campo Pais", JOptionPane.ERROR_MESSAGE, null);
					e.consume();
				}
			}
		});
		txtPais.setBounds(160, 335, 125, 20);
		panelProyectos.add(txtPais);
		txtPais.setColumns(10);

		txtLocalizacion = new JTextField();
		txtLocalizacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtLocalizacion.setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtLocalizacion.setBackground(Color.WHITE);
			}
		});
		txtLocalizacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 45;
				if (txtLocalizacion.getText().length() == limite) {
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite + " carácteres",
							"Límite de carácteres en el campo Localización", JOptionPane.ERROR_MESSAGE, null);
					e.consume();
				}
			}
		});
		txtLocalizacion.setBounds(305, 335, 125, 20);
		panelProyectos.add(txtLocalizacion);
		txtLocalizacion.setColumns(10);

		txtFinicio = new JTextField();
		txtFinicio.setToolTipText("Formato de fecha YYYY-MM-DD");
		txtFinicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtFinicio.setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtFinicio.setBackground(Color.WHITE);
			}
		});
		txtFinicio.setBounds(450, 335, 125, 20);
		panelProyectos.add(txtFinicio);
		txtFinicio.setColumns(10);

		txtFfinal = new JTextField();
		txtFfinal.setToolTipText("Formato de fecha YYYY-MM-DD");
		txtFfinal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtFfinal.setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtFfinal.setBackground(Color.WHITE);
			}
		});
		txtFfinal.setBounds(595, 335, 125, 20);
		panelProyectos.add(txtFfinal);
		txtFfinal.setColumns(10);

		txtSocioLocal = new JTextField();
		txtSocioLocal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSocioLocal.setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtSocioLocal.setBackground(Color.WHITE);
			}
		});
		txtSocioLocal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 45;
				if (txtSocioLocal.getText().length() == limite) {
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite + " carácteres",
							"Límite de carácteres en el campo Socio Local", JOptionPane.ERROR_MESSAGE, null);
					e.consume();
				}
			}
		});
		txtSocioLocal.setBounds(10, 380, 126, 20);
		panelProyectos.add(txtSocioLocal);
		txtSocioLocal.setColumns(10);

		txtFinanciador = new JTextField();
		txtFinanciador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtFinanciador.setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtFinanciador.setBackground(Color.WHITE);
			}
		});
		txtFinanciador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 45;
				if (txtFinanciador.getText().length() == limite) {
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite + " carácteres",
							"Límite de carácteres en el campo Financiador", JOptionPane.ERROR_MESSAGE, null);
					e.consume();
				}
			}
		});
		txtFinanciador.setBounds(160, 380, 125, 20);
		panelProyectos.add(txtFinanciador);
		txtFinanciador.setColumns(10);

		txtFinanciacion = new JTextField();
		txtFinanciacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtFinanciacion.setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtFinanciacion.setBackground(Color.WHITE);
			}
		});
		txtFinanciacion.setBounds(305, 380, 125, 20);
		panelProyectos.add(txtFinanciacion);
		txtFinanciacion.setColumns(10);

		txtPersonal = new JTextField();
		txtPersonal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPersonal.setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtPersonal.setBackground(Color.WHITE);
			}
		});
		txtPersonal.setBounds(450, 380, 125, 20);
		panelProyectos.add(txtPersonal);
		txtPersonal.setColumns(10);

		txtVoluntarios = new JTextField();
		txtVoluntarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtVoluntarios.setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtVoluntarios.setBackground(Color.WHITE);
			}
		});
		txtVoluntarios.setBounds(595, 380, 125, 20);
		panelProyectos.add(txtVoluntarios);
		txtVoluntarios.setColumns(10);

		txtCifOng = new JTextField();
		txtCifOng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCifOng.setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				txtCifOng.setBackground(Color.WHITE);
			}
		});
		txtCifOng.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 45;
				if (txtCifOng.getText().length() == limite) {
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite + " carácteres",
							"Límite de carácteres en el campo Cif de ong", JOptionPane.ERROR_MESSAGE, null);
					e.consume();
				}
			}
		});
		txtCifOng.setBounds(10, 424, 125, 20);
		panelProyectos.add(txtCifOng);
		txtCifOng.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Línea de acción:");
		lblNewLabel_12.setBounds(10, 452, 125, 14);
		panelProyectos.add(lblNewLabel_12);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 465, 214, 120);
		panelProyectos.add(scrollPane);

		textAreaLinea = new JTextArea();
		textAreaLinea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textAreaLinea.setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				textAreaLinea.setBackground(Color.WHITE);
			}
		});
		textAreaLinea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 100;
				if (textAreaLinea.getText().length() == limite) {
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite + " carácteres",
							"Límite de carácteres en el campo Línea de acción", JOptionPane.ERROR_MESSAGE, null);
					e.consume();
				}
			}
		});
		scrollPane.setViewportView(textAreaLinea);

		lblNewLabel_13 = new JLabel("Sublínea de acción:");
		lblNewLabel_13.setBounds(250, 452, 125, 14);
		panelProyectos.add(lblNewLabel_13);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(250, 465, 214, 120);
		panelProyectos.add(scrollPane_1);

		textAreaSublinea = new JTextArea();
		textAreaSublinea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textAreaSublinea.setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				textAreaSublinea.setBackground(Color.WHITE);
			}
		});
		textAreaSublinea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 100;
				if (textAreaSublinea.getText().length() == limite) {
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite + " carácteres",
							"Límite de carácteres en el campo Sublínea de acción", JOptionPane.ERROR_MESSAGE, null);
					e.consume();
				}
			}
		});
		scrollPane_1.setViewportView(textAreaSublinea);

		lblNewLabel_14 = new JLabel("Acción:");
		lblNewLabel_14.setBounds(488, 452, 46, 14);
		panelProyectos.add(lblNewLabel_14);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(488, 465, 214, 120);
		panelProyectos.add(scrollPane_2);

		textAreaAccion = new JTextArea();
		textAreaAccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				textAreaAccion.setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				textAreaAccion.setBackground(Color.WHITE);
			}
		});
		textAreaAccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 100;
				if (textAreaAccion.getText().length() == limite) {
					JOptionPane.showMessageDialog(null, "Se ha sobrepasado el límite de " + limite + " carácteres",
							"Límite de carácteres en el campo Acciones", JOptionPane.ERROR_MESSAGE, null);
					e.consume();
				}
			}
		});
		scrollPane_2.setViewportView(textAreaAccion);

		btnLimpiar = new JButton("Nuevo");
		btnLimpiar.setFocusPainted(false);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				idProyecto.setText("");
				txtPais.setText("");
				txtLocalizacion.setText("");
				textAreaLinea.setText("");
				textAreaSublinea.setText("");
				txtFinicio.setText("");
				txtFfinal.setText("");
				txtSocioLocal.setText("");
				txtFinanciador.setText("");
				txtFinanciacion.setText("");
				textAreaAccion.setText("");
				txtPersonal.setText("");
				txtVoluntarios.setText("");
				txtCifOng.setText("");

			}
		});
		btnLimpiar.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/nuevo.png")));
		btnLimpiar.setBounds(160, 612, 89, 23);
		panelProyectos.add(btnLimpiar);

		btnInsertar = new JButton("Insertar");
		btnInsertar.setFocusPainted(false);
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					if (txtPais.getText().isEmpty() || txtFinicio.getText().isEmpty() || txtFfinal.getText().isEmpty()
							|| txtSocioLocal.getText().isEmpty() || txtFinanciacion.getText().isEmpty()
							|| txtPersonal.getText().isEmpty() || txtVoluntarios.getText().isEmpty()
							|| txtCifOng.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Las siguientes celdas no pueden estar vacias: " + "\n"
								+ "Pais" + "\n" + "Fecha de inicio" + "\n" + "Fecha de fin" + "\n" + "Socio" + "\n"
								+ "Financiación" + "\n" + "Personal" + "\n" + "Voluntariados" + "\n" + "CIF de la ong",
								"Registro", JOptionPane.ERROR_MESSAGE);
					} else {

						Date sqlDate = Date.valueOf(txtFinicio.getText());
						LocalDate fInicio = sqlDate.toLocalDate();
						Date sqlDate2 = Date.valueOf(txtFfinal.getText());
						LocalDate fFinal = sqlDate2.toLocalDate();
						if (fFinal.isBefore(fInicio)) {
							JOptionPane.showMessageDialog(null,
									"La fecha de inicio no puede ser mayor a la fecha final", "Registro",
									JOptionPane.ERROR_MESSAGE);
						} else {

							String per1 = txtPersonal.getText();
							int personal = Integer.parseInt(per1);

							String vol = txtVoluntarios.getText();
							int voluntarios = Integer.parseInt(vol);

							String finan = txtFinanciacion.getText();
							double financiacion = Double.parseDouble(finan);

							Proyectos proyectos = new Proyectos(txtPais.getText(), txtLocalizacion.getText(),
									textAreaLinea.getText(), textAreaSublinea.getText(), fInicio, fFinal,
									txtSocioLocal.getText(), txtFinanciador.getText(), financiacion,
									textAreaAccion.getText(), personal, voluntarios, txtCifOng.getText());

							DAOFactory.getDAOFactory(4).jpaProyectosDAO().persist(proyectos);

						}

					}

					// JOptionPane.showMessageDialog(null, "Registro insertado correctamente",
					// "Registro", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					// JOptionPane.showMessageDialog(null, "Registro erroneo", "Registro",
					// JOptionPane.ERROR_MESSAGE);
					// tx.rollback();
					// TODO: handle exception
				} finally {
					cargarJtableProyectos();
				}

			}
		});
		btnInsertar.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/insertar.png")));
		btnInsertar.setBounds(259, 612, 100, 23);
		panelProyectos.add(btnInsertar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFocusPainted(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					if (idProyecto.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Tiene que seleccionar un registro de la tabla para ser borrado", "Registro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						DAOFactory.getDAOFactory(4).jpaProyectosDAO().eliminar(Integer.parseInt(idProyecto.getText()));
					}

					// JOptionPane.showMessageDialog(null, "Registro eliminado correctamente",
					// "Registro", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					// JOptionPane.showMessageDialog(null, "Registro no borrado", "Registro",
					// JOptionPane.ERROR_MESSAGE);
					// tx1.rollback();
				} finally {
					cargarJtableProyectos();
				}

			}
		});
		btnEliminar.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/eliminar.png")));
		btnEliminar.setBounds(369, 612, 105, 23);
		panelProyectos.add(btnEliminar);

		btnModificar = new JButton("Modificar");
		btnModificar.setFocusPainted(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					if (idProyecto.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Tiene que seleccionar un registro de la tabla para ser modificado", "Registro",
								JOptionPane.ERROR_MESSAGE);
					} else {
						if (txtPais.getText().isEmpty() || txtFinicio.getText().isEmpty()
								|| txtFfinal.getText().isEmpty() || txtSocioLocal.getText().isEmpty()
								|| txtFinanciacion.getText().isEmpty() || txtPersonal.getText().isEmpty()
								|| txtVoluntarios.getText().isEmpty() || txtCifOng.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null,
									"Las siguientes celdas no pueden estar vacias: " + "\n" + "Pais" + "\n"
											+ "Fecha de inicio" + "\n" + "Fecha de fin" + "\n" + "Socio" + "\n"
											+ "Financiación" + "\n" + "Personal" + "\n" + "Voluntariados" + "\n"
											+ "CIF de la ong",
									"Registro", JOptionPane.ERROR_MESSAGE);
						} else {
							Date sqlDate = Date.valueOf(txtFinicio.getText());
							LocalDate fInicio = sqlDate.toLocalDate();
							Date sqlDate2 = Date.valueOf(txtFfinal.getText());
							LocalDate fFinal = sqlDate2.toLocalDate();
							if (fFinal.isBefore(fInicio)) {
								JOptionPane.showMessageDialog(null,
										"La fecha de inicio no puede ser mayor a la fecha final", "Registro",
										JOptionPane.ERROR_MESSAGE);
							} else {
								Proyectos proyectosMod = DAOFactory.getDAOFactory(4).jpaProyectosDAO()
										.leerId(Integer.parseInt(idProyecto.getText()));

								String per1 = txtPersonal.getText();
								int personal = Integer.parseInt(per1);

								String vol = txtVoluntarios.getText();
								int voluntarios = Integer.parseInt(vol);

								String finan = txtFinanciacion.getText();
								double financiacion = Double.parseDouble(finan);

								proyectosMod.setPais(txtPais.getText());
								proyectosMod.setLocalizacion(txtLocalizacion.getText());
								proyectosMod.setLineaDeAccion(textAreaLinea.getText());
								proyectosMod.setSublineaDeAccion(textAreaSublinea.getText());
								proyectosMod.setFechaInicio(fInicio);
								proyectosMod.setFechaFinal(fFinal);
								proyectosMod.setSocioLocal(txtSocioLocal.getText());
								proyectosMod.setFinanciador(txtFinanciador.getText());
								proyectosMod.setFinanciacion(financiacion);
								proyectosMod.setAcciones(textAreaAccion.getText());
								proyectosMod.setPersonal(personal);
								proyectosMod.setVoluntariosAsignados(voluntarios);
								proyectosMod.setOngCif(txtCifOng.getText());

								DAOFactory.getDAOFactory(4).jpaProyectosDAO().actualizar(proyectosMod);
							}

						}
					}
					// JOptionPane.showMessageDialog(null, "Registro modificado correctamente",
					// "Registro", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					// JOptionPane.showMessageDialog(null, "Registro no modificado", "Registro",
					// JOptionPane.ERROR_MESSAGE);
					// tx1.rollback();
				} finally {
					cargarJtableProyectos();
				}

			}
		});
		btnModificar.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/reload.png")));
		btnModificar.setBounds(484, 612, 112, 23);
		panelProyectos.add(btnModificar);
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

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public JButton getBtnInsertar() {
		return btnInsertar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JTable getTable() {
		return table;
	}

	public static void cargarJtableProyectos() {
		RellenarJTable cargaDatos = new RellenarJTable();

		try {
			table.setModel(cargaDatos.rellenarJtable());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Error al cargar los proyectos", JOptionPane.ERROR_MESSAGE);
		}
	}

	public JTable getTable1() {
		return table_1;
	}

	public static void cargarJtableSocios() {
		FillOutJTable cargaDatos = new FillOutJTable();

		try {
			table_1.setModel(cargaDatos.fillOutJTable());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Error al cargar los socios", JOptionPane.ERROR_MESSAGE);
		}
	}

	public JTextField getTxtPersonal() {
		return txtPersonal;
	}

	public JTextField getTxtFfinal() {
		return txtFfinal;
	}

	public JTextField getIdProyecto() {
		return idProyecto;
	}

	public JTextField getTxtPais() {
		return txtPais;
	}

	public JTextField getTxtFinanciador() {
		return txtFinanciador;
	}

	public JTextField getTxtVoluntarios() {
		return txtVoluntarios;
	}

	public JTextField getTxtSocioLocal() {
		return txtSocioLocal;
	}

	public JTextField getTxtLocalizacion() {
		return txtLocalizacion;
	}

	public JTextField getTxtCifOng() {
		return txtCifOng;
	}

	public JTextField getTxtFinicio() {
		return txtFinicio;
	}

	public JTextField getTxtFinanciacion() {
		return txtFinanciacion;
	}

	public JTextArea getTextAreaAccion() {
		return textAreaAccion;
	}

	public JTextArea getTextAreaSublinea() {
		return textAreaSublinea;
	}

	public JTextArea getTextAreaLinea() {
		return textAreaLinea;
	}
	
	public static void cargarJtableEmpleados() {
		LlenarJTable cargaDatos = new LlenarJTable();
		
		try {
			tabla.setModel(cargaDatos.llenarJtable());
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e,"Error al cargar los empleados",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public JButton getBtnNuevo(){
		return btnNuevo;
	}
	
	public JButton getBtnInsert(){
		return btnInsert;
	}
	
	public JButton getBtnDelete(){
		return btnDelete;
	}
	
	public JButton getBtnUpdate(){
		return btnUpdate;
	}
	
	public JTable getTabla() {
		return tabla;
	}
	
	public JTextField getidEmpleado() {
		return idEmpleado;
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	
	public JTextField getTxtApellido() {
		return txtApellido;
	}
	
	public JTextField getTxtDireccion() {
		return txtDireccion;
	}
	
	public JTextField getTxtTelefono() {
		return txtTelefono;
	}
	
	public JTextField getTxtDni() {
		return txtDni;
	}
	
	public JTextField getTxtOngCif() {
		return txtOngCif;
	}
}
