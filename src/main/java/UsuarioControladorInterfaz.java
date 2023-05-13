import Modelo.Cliente;

public interface UsuarioControladorInterfaz {
void registrarCliente(Cliente cliente);
boolean iniciarSesion(String nombreUsuario,String contrasena);

}
