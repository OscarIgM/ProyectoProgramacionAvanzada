import DatosJuegos.ArchivoTexto;
import DatosJuegos.BaseDeDatos;
import Modelo.Cliente;

import java.io.IOException;
import java.util.ArrayList;
public class ClienteControlador implements UsuarioControladorInterfaz{
    BaseDeDatos clientesRegistrados=new ArchivoTexto();
    @Override
    public void registrarCliente(Cliente cliente) {

        // clientesRegistrados.registrarUsuario(direccionDatos,cliente);
        //clientesRegistrados.;
        //clientesRegistrados.leerArchivo("C:\\Users\\oscar\\IdeaProjects\\ProyectoProgramacionAvanzada\\target\\generated-sources\\DatosClientes.txt");
    }
    @Override
    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
        Cliente cliente=new Cliente(nombreUsuario,contrasena);
        System.out.println("Comprobrando datos que coincidan con la base de datos");
        System.out.println("_--------------------------------");


        return true;
    }
}
