public class Controlador {
    private Usuario usuario;

    public Controlador() {
        usuario = new Usuario("usuario", "contrasena");
    }

    public boolean verificarUsuario(String nombre, String contrasena) {
        return usuario.verificar(nombre, contrasena);
    }
}