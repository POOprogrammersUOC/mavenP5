package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JLabel lblAdmin;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblAdmin = new JLabel("Administrador");
		lblAdmin.setBounds(91, 66, 116, 14);
		contentPane.add(lblAdmin);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setBounds(91, 104, 72, 14);
		contentPane.add(lblUser);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(124, 155, 89, 23);
		contentPane.add(btnNewButton);
	}

	
	public JLabel getLblAdmin() {
		return lblAdmin;
	}
}
