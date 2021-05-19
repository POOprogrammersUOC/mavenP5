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
