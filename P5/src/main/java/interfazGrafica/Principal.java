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
import com.proogramers.uoc.P5.Proyectos;

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
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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
	private JTable table;
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

	static Logger log = LogManager.getRootLogger();
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
		panelSocios.setBackground(Color.YELLOW);
		panelBody.add(panelSocios, "name_161214080585300");
		
		panelEmpleados = new JPanel();
		panelEmpleados.setBackground(Color.CYAN);
		panelBody.add(panelEmpleados, "name_161410589258100");
		
		panelProyectos = new JPanel();
		panelProyectos.setBackground(new Color(237, 240, 245));
		panelBody.add(panelProyectos, "name_161445339611100");
		panelProyectos.setLayout(null);
		
		JLabel lblTituloProyectos = new JLabel("PROYECTOS");
		lblTituloProyectos.setBounds(10, 25, 100, 17);
		lblTituloProyectos.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelProyectos.add(lblTituloProyectos);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 42, 764, 8);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.ORANGE);
		panelProyectos.add(lblNewLabel_1);
		
		table = new JTable();
		table.setBounds(10, 72, 764, 226);
		panelProyectos.add(table);
		
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
		idProyecto.setBounds(10, 336, 125, 20);
		panelProyectos.add(idProyecto);
		idProyecto.setColumns(10);
		
		txtPais = new JTextField();
		txtPais.setBounds(160, 335, 125, 20);
		panelProyectos.add(txtPais);
		txtPais.setColumns(10);
		
		txtLocalizacion = new JTextField();
		txtLocalizacion.setBounds(305, 335, 125, 20);
		panelProyectos.add(txtLocalizacion);
		txtLocalizacion.setColumns(10);
		
		txtFinicio = new JTextField();
		txtFinicio.setBounds(450, 335, 125, 20);
		panelProyectos.add(txtFinicio);
		txtFinicio.setColumns(10);
		
		txtFfinal = new JTextField();
		txtFfinal.setBounds(595, 335, 125, 20);
		panelProyectos.add(txtFfinal);
		txtFfinal.setColumns(10);
		
		txtSocioLocal = new JTextField();
		txtSocioLocal.setBounds(10, 380, 126, 20);
		panelProyectos.add(txtSocioLocal);
		txtSocioLocal.setColumns(10);
		
		txtFinanciador = new JTextField();
		txtFinanciador.setBounds(160, 380, 125, 20);
		panelProyectos.add(txtFinanciador);
		txtFinanciador.setColumns(10);
		
		txtFinanciacion = new JTextField();
		txtFinanciacion.setBounds(305, 380, 125, 20);
		panelProyectos.add(txtFinanciacion);
		txtFinanciacion.setColumns(10);
		
		txtPersonal = new JTextField();
		txtPersonal.setBounds(450, 380, 125, 20);
		panelProyectos.add(txtPersonal);
		txtPersonal.setColumns(10);
		
		txtVoluntarios = new JTextField();
		txtVoluntarios.setBounds(595, 380, 125, 20);
		panelProyectos.add(txtVoluntarios);
		txtVoluntarios.setColumns(10);
		
		txtCifOng = new JTextField();
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
		scrollPane.setViewportView(textAreaLinea);
		
		lblNewLabel_13 = new JLabel("Sublínea de acción:");
		lblNewLabel_13.setBounds(250, 452, 125, 14);
		panelProyectos.add(lblNewLabel_13);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(250, 465, 214, 120);
		panelProyectos.add(scrollPane_1);
		
		textAreaSublinea = new JTextArea();
		scrollPane_1.setViewportView(textAreaSublinea);
		
		lblNewLabel_14 = new JLabel("Acción:");
		lblNewLabel_14.setBounds(488, 452, 46, 14);
		panelProyectos.add(lblNewLabel_14);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(488, 465, 214, 120);
		panelProyectos.add(scrollPane_2);
		
		textAreaAccion = new JTextArea();
		scrollPane_2.setViewportView(textAreaAccion);
		
		btnLimpiar = new JButton("Nuevo");
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
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
				EntityManager em = emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				
				tx.begin();
				
				Date sqlDate = Date.valueOf(txtFinicio.getText());
				LocalDate fInicio = sqlDate.toLocalDate();
				Date sqlDate2 = Date.valueOf(txtFfinal.getText());
				LocalDate fFinal = sqlDate2.toLocalDate();
				
				String per1 = txtPersonal.getText();
				int personal = Integer.parseInt(per1);
				
				String vol = txtVoluntarios.getText();
				int voluntarios = Integer.parseInt(vol);
				
				String finan = txtFinanciacion.getText();
				double financiacion = Double.parseDouble(finan);
				
				Proyectos proyectos = new Proyectos(txtPais.getText(),txtLocalizacion.getText(),textAreaLinea.getText(),textAreaSublinea.getText(),fInicio,fFinal,txtSocioLocal.getText(),txtFinanciador.getText(),financiacion,textAreaAccion.getText(),personal,voluntarios,txtCifOng.getText());
				log.debug("Objeto no tratado: " + proyectos);
				
				em.persist(proyectos);
				
				tx.commit();
				
				log.debug("Objeto tratado: " + proyectos);
				em.close();
			}
		});
		btnInsertar.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/insertar.png")));
		btnInsertar.setBounds(259, 612, 100, 23);
		panelProyectos.add(btnInsertar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
				EntityManager em = emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				
				tx.begin();
				
				Proyectos proyectosRemove = em.find(Proyectos.class, Integer.parseInt(idProyecto.getText()));
				
				tx.commit();
				
				EntityTransaction tx1 = em.getTransaction();	
				tx1.begin();
				
				em.remove(proyectosRemove);
				
				tx1.commit();
				
				log.debug("Objeto eliminado: " + proyectosRemove);
				
				em.close();
			}
		});
		btnEliminar.setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/eliminar.png")));
		btnEliminar.setBounds(369, 612, 105, 23);
		panelProyectos.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
				EntityManager em = emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				
				tx.begin();
				
				Proyectos proyectosMod = em.find(Proyectos.class, Integer.parseInt(idProyecto.getText()));
				
				tx.commit();
				
				log.debug("Objeto Recuperado: " + proyectosMod);
				
				
				Date sqlDate = Date.valueOf(txtFinicio.getText());
				LocalDate fInicio = sqlDate.toLocalDate();
				Date sqlDate2 = Date.valueOf(txtFfinal.getText());
				LocalDate fFinal = sqlDate2.toLocalDate();
				
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
				
				EntityTransaction tx1 = em.getTransaction();	
				tx1.begin();
				
				em.merge(proyectosMod);
				
				tx1.commit();
				
				log.debug("Objeto Modificado: " + proyectosMod);
				em.close();
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
}
