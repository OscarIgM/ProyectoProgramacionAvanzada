package datosjuegos;
import modelos.Cliente;
import modelos.Videojuego;

import java.io.IOException;
import java.util.List;

public interface BaseDeDatos {

    List<Cliente> obtenerClientesDesdeJSON(String nombreArchivo);
    void registrarCliente(String rutaArchivo, Cliente cliente) throws IOException;
    void crearArchivoJSON(String nombreArchivo);
    List<Cliente>leerJsonClientes(String rutaArchivo) throws IOException;

    List<Videojuego> leerJsonVideojuego(String rutaArchivo) throws IOException;
}
