import DatosJuegos.ArchivoTexto;
import DatosJuegos.BaseDeDatos;
import Modelo.Cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ClienteControlador implements UsuarioControladorInterfaz{
    BaseDeDatos clientesRegistrados=new ArchivoTexto();
    @Override
    public void registrarCliente(Cliente cliente)  {
        try {
            clientesRegistrados.registrarCliente("DatosClientes",cliente);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //clientesRegistrados.;
        //clientesRegistrados.leerArchivo("C:\\Users\\oscar\\IdeaProjects\\ProyectoProgramacionAvanzada\\target\\generated-sources\\DatosClientes.txt");
    }
    @Override
    public Cliente iniciarSesion(String nombreUsuario, String contrasena) {
        Cliente cliente = verificarUsuario(nombreUsuario, contrasena);
        return cliente;
    }
    public Cliente verificarUsuario(String nombreUsuario, String contrasena) {
        BaseDeDatos clientesRegistrados = new ArchivoTexto();
        System.out.println("Comprobrando datos que coincidan con la base de datos");
        System.out.println("_--------------------------------");
        ArrayList<Cliente> listadoClientes = (ArrayList<Cliente>) clientesRegistrados.obtenerClientesDesdeJSON("DatosClientes");
        for (int i = 0; i < listadoClientes.size(); i++) {
            if (Objects.equals(listadoClientes.get(i).getNombreUsuario(), nombreUsuario) && Objects.equals(listadoClientes.get(i).getContrasena(), contrasena)) {
                System.out.println("Inico de sesion exitoso");
                return new Cliente(listadoClientes.get(i).getNombreUsuario()
                        , listadoClientes.get(i).getContrasena()
                        , listadoClientes.get(i).getCorreoCliente()
                        , listadoClientes.get(i).getTelefonoCliente()
                        , listadoClientes.get(i).getDireccionCliente());
            }
        }return null;
    }
}
