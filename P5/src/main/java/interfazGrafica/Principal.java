package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import interfazGrafica.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import datosMysql.Conexion;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {
	private JLabel lblImageSetUsuario;
	private JLabel lblPanelDerechoSetUsuario;
	private JLabel lblPanelDerechoSetRol;
	private JPanel panelBody;
	private JPanel panelHome;
	private JPanel panelSocios;
	private JPanel panelEmpleados;
	private JPanel panelAnadir;
	private JPanel panelProyectos;
	private JButton btnHome;

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
		
		//PANEL EMPLEADOS
		
		panelEmpleados = new JPanel();
		panelEmpleados.setLayout(null);
		//panelEmpleados.setBackground(Color.CYAN);
		panelBody.add(panelEmpleados, "name_161410589258100");
		
		//MOSTRAR TABLA
		
		final DefaultTableModel model = new DefaultTableModel();
		final JTable table = new JTable(model);
		table.setBounds(200, 50, 500, 300);
		String[] columnas = {"id", "Nombre", "Apellido", "Direccion", "Telefono", "Dni", " Ong Cif"};
		JScrollPane desplazamiento = null;
		desplazamiento = new JScrollPane(table);
		/*int[] ancho = {50 , 100, 100, 200, 100, 100, 100};
		for (int x = 0; x <= 6; x++){
			table.getColumnModel().getColumn(x).setPreferredWidth(ancho[x]);
		}*/
		model.setColumnIdentifiers(columnas);
		
		String[] dato = new String[7];
		String sql = "select * from empleados";
		table.setModel(model);
		try {
			Connection conn = Conexion.getConection();
			Statement comando=conn.createStatement();
			ResultSet registro = comando.executeQuery(sql);
			while (registro.next()) {
				dato[0]=registro.getString(1);
				dato[1]=registro.getString(2);
				dato[2]=registro.getString(3);
				dato[3]=registro.getString(4);
				dato[4]=registro.getString(5);
				dato[5]=registro.getString(6);
				dato[6]=registro.getString(7);
				model.addRow(dato);	
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		panelEmpleados.add(table);
		
		JLabel etiqueta = new JLabel();
		etiqueta.setText("EMPLEADOS");
		etiqueta.setBounds(10, 50, 100, 50);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.CYAN);
		panelEmpleados.add(etiqueta);
		
		//AÑADIR EMPLEADOS
		
		final JTextField cajaNombre = new JTextField();
		cajaNombre.setBounds(80, 300, 100, 20);
		add(cajaNombre);
		
		final JLabel etiNombre = new JLabel();
		etiNombre.setText("Nombre: ");
		etiNombre.setBounds(10, 300, 70, 20);
		etiNombre.setOpaque(true);
		etiNombre.setBackground(Color.CYAN);
		
		final JTextField cajaApellido = new JTextField();
		cajaApellido.setBounds(80, 330, 100, 20);
		add(cajaApellido);
		
		final JLabel etiApellido = new JLabel();
		etiApellido.setText("Apellido: ");
		etiApellido.setBounds(10, 330, 70, 20);
		etiApellido.setOpaque(true);
		etiApellido.setBackground(Color.CYAN);
		
		final JTextField cajaDireccion = new JTextField();
		cajaDireccion.setBounds(80, 360, 100, 20);
		add(cajaDireccion);
		
		final JLabel etiDireccion = new JLabel();
		etiDireccion.setText("Direccion: ");
		etiDireccion.setBounds(10, 360, 70, 20);
		etiDireccion.setOpaque(true);
		etiDireccion.setBackground(Color.CYAN);
		
		final JTextField cajaTelefono = new JTextField();
		cajaTelefono.setBounds(80, 390, 100, 20);
		add(cajaTelefono);
		
		final JLabel etiTelefono = new JLabel();
		etiTelefono.setText("Telefono: ");
		etiTelefono.setBounds(10, 390, 70, 20);
		etiTelefono.setOpaque(true);
		etiTelefono.setBackground(Color.CYAN);
		
		final JTextField cajaDni = new JTextField();
		cajaDni.setBounds(80, 420, 100, 20);
		add(cajaDni);
		
		final JLabel etiDni = new JLabel();
		etiDni.setText("Dni: ");
		etiDni.setBounds(10, 420, 70, 20);
		etiDni.setOpaque(true);
		etiDni.setBackground(Color.CYAN);
		
		final JTextField cajaCif = new JTextField();
		cajaCif.setBounds(80, 450, 100, 20);
		add(cajaCif);
		
		final JLabel etiCif = new JLabel();
		etiCif.setText("Cif Ong: ");
		etiCif.setBounds(10, 450, 70, 20);
		etiCif.setOpaque(true);
		etiCif.setBackground(Color.CYAN);
		//Boton Añadir Empleados
		final JButton btnAnadir = new JButton("Añadir");
		
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  panelEmpleados.repaint();
			  try {
				  Connection conn = Conexion.getConection();
				  PreparedStatement comando= conn.prepareStatement("INSERT INTO empleados (Nombre, Apellido_1, Direccion, Telefono, Dni, Ong_CIF) VALUES (?, ?, ?, ?, ?, ?)");
				  	comando.setString(1, cajaNombre.getText());
				  	comando.setString(2, cajaApellido.getText());
				  	comando.setString(3, cajaDireccion.getText());
				  	comando.setString(4, cajaTelefono.getText());
				  	comando.setString(5, cajaDni.getText());
				  	comando.setString(6, cajaCif.getText());
				  	comando.execute();
				  	comando.close();
			  }catch(SQLException e1) {
				  setTitle(e1.toString());
			  }
				
				panelEmpleados.revalidate();
				panelEmpleados.add(etiNombre);
				panelEmpleados.add(cajaNombre);
				panelEmpleados.add(etiApellido);
				panelEmpleados.add(cajaApellido);
				panelEmpleados.add(etiDireccion);
				panelEmpleados.add(cajaDireccion);
				panelEmpleados.add(etiTelefono);
				panelEmpleados.add(cajaTelefono);
				panelEmpleados.add(etiDni);
				panelEmpleados.add(cajaDni);
				panelEmpleados.add(etiCif);
				panelEmpleados.add(cajaCif);
				panelEmpleados.revalidate();
				
			}
		});
		btnAnadir.setBounds(10, 150, 100, 40);
		panelEmpleados.add(btnAnadir);
		
		
		//BOTON ELIMINAR EMPLEADOS
		
		JButton btneliminar = new JButton();
		btneliminar.setBounds(10, 200, 100, 40);
		btneliminar.setText("Eliminar");
		panelEmpleados.add(btneliminar);
		btneliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				int a1=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				if (table.getSelectedRow()!= -1) {
					model.removeRow(table.getSelectedRow());
					try {
					  Connection conn = Conexion.getConection();
					  PreparedStatement comando= conn.prepareStatement("DELETE FROM mydb.empleados WHERE Numero ='"+a1+"'");
					  //comando.setInt(1, table.getSelectedRow());
					  comando.executeUpdate();
					  JOptionPane.showMessageDialog(null, "Se elimino correctamente");
					  } catch (SQLException e2) {  
					  }
			}else {
				JOptionPane.showMessageDialog(null, "No has seleccionado un empleado");
			}
		}
		});
		
		JButton btnmodificar = new JButton();
		btnmodificar.setBounds(10, 250, 100, 40);
		btnmodificar.setText("Modificar");
		panelEmpleados.add(btnmodificar);
		btnmodificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try {
				Connection conn = Conexion.getConection();
				String id= table.getValueAt(table.getSelectedRow(),0).toString();
				String nombre= table.getValueAt(table.getSelectedRow(),1).toString();
				String apellido= table.getValueAt(table.getSelectedRow(),2).toString();
				String direccion= table.getValueAt(table.getSelectedRow(),3).toString();
				String telefono= table.getValueAt(table.getSelectedRow(),4).toString();
				String dni= table.getValueAt(table.getSelectedRow(),5).toString();
				String cif= table.getValueAt(table.getSelectedRow(),6).toString();
				PreparedStatement comando= conn.prepareStatement("UPDATE mydb.empleados SET Nombre = '"+nombre+"', Apellido_1 = '"+apellido+"', Direccion = '"+direccion+"', Telefono = '"+telefono+"', Dni = '"+dni+"', Ong_CIF = '"+cif+"' WHERE Numero = '"+id+"'");
				System.out.println(comando);
				comando.executeUpdate();
				JOptionPane.showMessageDialog(null, "Modificado con exito");
				
				}catch(SQLException e3) {
					
				}
			}
		});
		
		
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
	
	public JPanel getpanelAnadir() {
		return panelAnadir;
	}
}
