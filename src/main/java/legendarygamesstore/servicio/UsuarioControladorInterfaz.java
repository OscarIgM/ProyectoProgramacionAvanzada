package legendarygamesstore.servicio;

import legendarygamesstore.modelos.Cliente;

public interface UsuarioControladorInterfaz {
    void registrarCliente(Cliente cliente);
    Cliente iniciarSesion(String nombreUsuario, String contrasena);


}
