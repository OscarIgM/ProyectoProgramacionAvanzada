import Modelo.Cliente;

public interface UsuarioControladorInterfaz {
    String direccionDatos="C:\\Users\\oscar\\IdeaProjects\\ProyectoProgramacionAvanzada\\target\\generated-sources\\DatosClientes.txt";
void registrarCliente(Cliente cliente);
boolean iniciarSesion(String nombreUsuario,String contrasena);
}
