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

public class Principal extends JFrame {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 538);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 237, 500);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPanelDerechoImagen = new JLabel("imagen");
		lblPanelDerechoImagen.setForeground(new Color(255, 255, 255));
		lblPanelDerechoImagen.setBounds(83, 44, 46, 14);
		panel.add(lblPanelDerechoImagen);
		
		JLabel lblPanelDerechoUsuario = new JLabel("Usuario:");
		lblPanelDerechoUsuario.setForeground(new Color(255, 255, 255));
		lblPanelDerechoUsuario.setBounds(38, 94, 59, 14);
		panel.add(lblPanelDerechoUsuario);
		
		JLabel lblPanelDerechoRol = new JLabel("Rol:");
		lblPanelDerechoRol.setForeground(new Color(255, 255, 255));
		lblPanelDerechoRol.setBounds(38, 114, 24, 14);
		panel.add(lblPanelDerechoRol);
		
		JLabel lblPanelDerechoSetUsuario = new JLabel("Tipo_usuario");
		lblPanelDerechoSetUsuario.setForeground(new Color(255, 255, 255));
		lblPanelDerechoSetUsuario.setBounds(94, 94, 96, 14);
		panel.add(lblPanelDerechoSetUsuario);
		
		JLabel lblPanelDerechoSetRol = new JLabel("Tipo_rol");
		lblPanelDerechoSetRol.setForeground(new Color(255, 255, 255));
		lblPanelDerechoSetRol.setBounds(94, 114, 46, 14);
		panel.add(lblPanelDerechoSetRol);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 255));
		panel_1.setBounds(0, 222, 237, 38);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		panel_1.add(btnNewButton, BorderLayout.CENTER);
	}

	
	
}
