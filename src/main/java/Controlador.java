import Tienda.Cliente;
import Tienda.Usuario;

public class Controlador {
    private Cliente usuario;

    public Controlador() {
        //usuario = new Cliente("usuario" "contrasena");
    }
    public boolean verificarUsuario(String nombre, String contrasena) {
        return usuario.verificarUsuario(nombre, contrasena);
    }
}