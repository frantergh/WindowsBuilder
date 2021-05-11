import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Conexion extends JFrame {
	public static final String URL = "jdbc:mysql://localhost:3306/ventana";
	public static final String usuario = "root";
	public static final String contraseña = "";

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conexion frame = new Conexion();
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
	public Connection getConection() {

		Connection con = null;
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, usuario, contraseña);
			JOptionPane.showConfirmDialog(null, "Conexion Existosa!!");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	public Conexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = getConection();

					PreparedStatement ps;
					ResultSet res;

					ps = con.prepareStatement("SELECT * FROM persona");
					res = ps.executeQuery();

					if (res.next()) {

						JOptionPane.showConfirmDialog(null, res.getObject("usuario") + "" + res.getString("usuario"));

					} else {

						JOptionPane.showConfirmDialog(null, "No existen datos ");

					}
					con.close();

				} catch (Exception e) {
					System.out.println(e);

				}

			}


		});
		btnConectar.setBounds(163, 140, 89, 23);
		contentPane.add(btnConectar);
	}

}
