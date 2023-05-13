package DatosJuegos;
import Modelo.Cliente;
public interface BaseDeDatos {
    String direccionDatos="C:\\Users\\oscar\\IdeaProjects\\ProyectoProgramacionAvanzada\\target\\generated-sources\\DatosClientes.txt";

    void registrarCliente(String nombreArchivo, Cliente cliente);

    Cliente verBase(String nombreArchivo);

    void crearArchivoJSON(String nombreArchivo);

    //public void leerArchivo(String rutaArchivo);
    //public String retornarClientes();
    //public void crearArchivo(String contenido, String rutaArchivo);

    //public void registrarUsuario(String nombre, Cliente cliente);


}
