package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datosMysql.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	public JTextField textFieldUser;
	public JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/interfazGrafica/img/mundo.png")));
		
		setTitle("Control de acceso a ONG");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(0, 0, 252, 403);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/interfazGrafica/img/fotoOngLoginRetocada.jpg")));
		lblNewLabel_1.setBounds(251, 0, 419, 403);
		contentPane.add(lblNewLabel_1);
		
		JLabel logoLogin = new JLabel("");
		logoLogin.setIcon(new ImageIcon(Login.class.getResource("/interfazGrafica/img/login120.png")));
		logoLogin.setBounds(59, 11, 120, 120);
		contentPane.add(logoLogin);
		
		JLabel usuario = new JLabel("Usuario:");
		usuario.setBounds(20, 174, 68, 14);
		contentPane.add(usuario);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(20, 187, 192, 20);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña:");
		lblNewLabel_2.setBounds(20, 232, 99, 14);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(20, 247, 192, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFocusPainted(false);
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/interfazGrafica/img/login16.png")));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textFieldUser.getText();  
				String passw = passwordField.getText();
				String select="select username,password,privilegio from usuarios where username='"+user+"'";
				//select username,password,privilegio from usuarios where privilegio='administrador';
				
				try {
					
					
					Connection conn = Conexion.getConection();
					PreparedStatement pstat = conn.prepareStatement(select);
					ResultSet rs = pstat.executeQuery();
					
					if(rs.next()) {
						String getUser = rs.getString("username");
						String getPassw = rs.getString("password");
						String getPrivilegio = rs.getString("privilegio");
						if(passw.equals(getPassw)) {
							if(getPrivilegio.equals("administrador")) {
								Principal principal = new Principal();
								principal.setVisible(true);
								principal.getLblPanelDerechoSetUsuario().setText("Administrador");
								principal.getLblPanelDerechoSetRol().setText("Total");
								principal.getLblImageSetUsuario().setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/mini_administrador.png")));
								principal.cargarJtableProyectos();
								principal.cargarJtableEmpleados();
								principal.setLocationRelativeTo(null);
								dispose();
							}else if(getPrivilegio.equals("usuario")) {
								Principal principal = new Principal();
								principal.setVisible(true);
								principal.getLblPanelDerechoSetUsuario().setText("Usuario");
								principal.getLblPanelDerechoSetRol().setText("Restringido");
								//principal.getLblAdmin().setVisible(false); //hay que hacer publico todo lo que se quiere ocultar
								principal.getLblImageSetUsuario().setIcon(new ImageIcon(Principal.class.getResource("/interfazGrafica/img/mini_usuario.png")));
								principal.getBtnInsertar().setEnabled(false);
								principal.getBtnEliminar().setEnabled(false);
								principal.getBtnModificar().setEnabled(false);
								principal.getBtnLimpiar().setEnabled(false);
								principal.getBtnInsert().setEnabled(false);
								principal.getBtnDelete().setEnabled(false);
								principal.getBtnUpdate().setEnabled(false);
								principal.getBtnNuevo().setEnabled(false);
								principal.cargarJtableProyectos();
								principal.cargarJtableEmpleados();
								principal.setLocationRelativeTo(null);
								dispose();
							}
						}else {
							JOptionPane.showMessageDialog(null,"CONTRASEÑA INCORECTA");
						}
						
					}else {
						JOptionPane.showMessageDialog(null,"EL USUARIO NO EXITE");
					}
				} catch (SQLException e1) {
					// TODO Bloque catch generado automáticamente
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(74, 307, 89, 23);
		contentPane.add(btnLogin);
	}
}
