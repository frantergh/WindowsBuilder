import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	public static JTextField usuario;
	public static JPasswordField pass;
	private String url = "jdbc:mysql://localhost:3306/zoo";
	/**
	 * Launch the application.
	 */
	/**
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Ventana frame = new Ventana();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 **/

	/**
	 * Create the frame.
	 */
	/*Confirmacion de salida de la APP*/
	
	
	
	
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("User:");
		lblNewLabel.setBounds(56, 78, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(43, 126, 69, 17);
		contentPane.add(lblNewLabel_1);

		usuario = new JTextField();
		usuario.setBounds(124, 75, 86, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);

		pass = new JPasswordField();
		pass.setBounds(122, 125, 86, 17);
		contentPane.add(pass);
		final Login datos = new Login();
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (datos.PruebaPass() == 1) {
					JOptionPane.showMessageDialog(null, "Bienvenido Fran");
				} else {
					JOptionPane.showMessageDialog(null, "ERROR!!, Usuario o Contraseña incorrectos");
				}
			}
		});
		btnNewButton.setBounds(43, 209, 89, 23);
		contentPane.add(btnNewButton);

		JButton salir = new JButton("Exit");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		salir.setBounds(168, 209, 89, 23);
		contentPane.add(salir);
		
		
	}
}
