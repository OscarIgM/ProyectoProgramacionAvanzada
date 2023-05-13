package DatosJuegos;
import Modelo.Cliente;

import java.io.IOException;
import java.util.List;

public interface BaseDeDatos {

    List<Cliente> obtenerClientesDesdeJSON(String nombreArchivo);


    void crearArchivoJSON(String nombreArchivo);



}
