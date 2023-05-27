package datosjuegos;
import modelos.Cliente;
import modelos.Videojuego;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoTexto implements BaseDeDatos {


    @Override
    public void registrarCliente(String rutaArchivo, Cliente cliente) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File archivo = new File(rutaArchivo);
        // Verificar si el archivo existe
        if (archivo.exists()) {
            // Leer el contenido del archivo y convertirlo en una lista de objetos
            List<Cliente> listaObjetos = objectMapper.readValue(archivo, new TypeReference<List<Cliente>>() {
            });
            // Agregar el nuevo objeto a la lista
            listaObjetos.add(cliente);
            // Escribir la lista actualizada en el archivo
            objectMapper.writeValue(archivo, listaObjetos);
            System.out.println("Cliente agregado a la base de datos.");
        } else {
            System.out.println("El archivo JSON no existe.");
        }
    }

    @Override
    public List<Cliente> obtenerClientesDesdeJSON(String nombreArchivo) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(nombreArchivo), objectMapper.getTypeFactory().constructCollectionType(List.class, Cliente.class));
        } catch (JsonParseException | JsonMappingException e) {
            System.out.println("Ocurrió un error al parsear el JSON: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ocurrió un error de entrada/salida: " + e.getMessage());
        }
        return new ArrayList<>(); // Retorna una lista vacía en caso de error
    }


    @Override
    public void crearArchivoJSON(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                System.out.println("Archivo JSON creado correctamente.");
            } catch (IOException e) {
                System.out.println("Ocurrió un error al crear el archivo JSON: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo JSON ya existe.");
        }
    }

    @Override
    public List<Cliente> leerJsonClientes(String rutaArchivo) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File archivo = new File(rutaArchivo);
        // Verificar si el archivo existe
        if (archivo.exists()) {
            // Leer el contenido del archivo y convertirlo en una lista de objetos Cliente
            return objectMapper.readValue(archivo, new TypeReference<List<Cliente>>() {
            });
        } else {
            System.out.println("El archivo JSON no existe.");
            return null;
        }
    }

    @Override
    public List<Videojuego> leerJsonVideojuego(String rutaArchivo) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            return objectMapper.readValue(archivo, new TypeReference<List<Videojuego>>() {
            });
        } else {
            System.out.println("El archivo JSON no existe.");
            return null;
        }
    }
}



