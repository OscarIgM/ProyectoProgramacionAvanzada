package datosjuegos;
import modelos.Cliente;
import modelos.Videojuego;

import java.io.IOException;
import java.util.List;

public interface BaseDeDatos {

    List<Cliente> obtenerClientesDesdeJSON(String nombreArchivo);

   // void actualizarCliente(Cliente cliente, CarritoDeCompras carritoDeCompras) throws IOException;

    /*@Override
    public void actualizarCliente(Cliente cliente, CarritoDeCompras carritoDeCompras) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File archivo = new File("DatosClientes");
        // Verificar si el archivo existe
        if (archivo.exists()) {
            // Leer el contenido del archivo y convertirlo en una lista de objetos
            List<Cliente> listaObjetos = objectMapper.readValue(archivo, new TypeReference<List<Cliente>>() {
            });

            // Buscar el cliente en la lista y actualizarlo
            for (int i = 0; i < listaObjetos.size(); i++) {
                if (listaObjetos.get(i).getNombreUsuario().equals(cliente.getNombreUsuario())) {
                    cliente.setCarritoDeCompras(carritoDeCompras);
                    listaObjetos.set(i, cliente);
                    System.out.println("El cliente se agregó exitosamente: " + cliente);
                    break;
                }
            }

            // Escribir la lista actualizada en el archivo solo si el cliente se ha actualizado
            objectMapper.writeValue(archivo, listaObjetos);
        }
    }*/

    /*@Override
    public void actualizarCliente(Cliente cliente, CarritoDeCompras carritoDeCompras) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File archivo = new File("DatosClientes");
        // Verificar si el archivo existe
        if (archivo.exists()) {
            // Leer el contenido del archivo y convertirlo en una lista de objetos
            List<Cliente> listaObjetos = objectMapper.readValue(archivo, new TypeReference<List<Cliente>>() {
            });

            // Buscar el cliente en la lista y actualizarlo
            for (int i = 0; i < listaObjetos.size(); i++) {
                if (listaObjetos.get(i).getNombreUsuario().equals(cliente.getNombreUsuario())) {
                    cliente.setCarritoDeCompras(carritoDeCompras);
                    listaObjetos.set(i, cliente);
                    System.out.println("El cliente se agregó exitosamente: " + cliente);
                    break;
                }
            }

            // Escribir la lista actualizada en el archivo solo si el cliente se ha actualizado
            objectMapper.writeValue(archivo, listaObjetos);
        }
    }*/

    void registrarCliente(String rutaArchivo, Cliente cliente) throws IOException;
    void crearArchivoJSON(String nombreArchivo);
    List<Cliente>leerJsonClientes(String rutaArchivo) throws IOException;

    List<Videojuego> leerJsonVideojuego(String rutaArchivo) throws IOException;
}
