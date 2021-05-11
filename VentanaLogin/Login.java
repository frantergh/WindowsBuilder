
public class Login {
	public Login() {

	}

	String usuario1 = "";
	String pass1 = "";

	public int PruebaPass() {
		usuario1 = Ventana.usuario.getText();
		pass1 = Ventana.pass.getText();
		if (usuario1.equals("Fran") && pass1.equals("1234")) {

			return 1;

		} else {

			return 0;
		}

	}
}
