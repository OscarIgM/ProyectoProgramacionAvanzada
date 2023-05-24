package DatosJuegos;
import Modelo.Cliente;
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
            System.out.println("Objeto agregado exitosamente al archivo JSON.");
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
            return objectMapper.readValue(archivo, new TypeReference<List<Cliente>>() {});
        } else {
            System.out.println("El archivo JSON no existe.");
            return null;
        }
    }
    }

    /*
       @Override
    public void registrarCliente(String nombreArchivo, Cliente cliente) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(nombreArchivo), cliente);
            System.out.println("Usuario guardado en el archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar el usuario en el archivo: " + e.getMessage());
        }
    }
    @Override
    public void leerArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    @Override
    public String retornarClientes() {
        try (BufferedReader br = new BufferedReader(new FileReader(direccionDatos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
return linea;}
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
return null;
    }

    @Override
    public void crearArchivo(String contenido, String rutaArchivo) {
        try {
            FileWriter archivo = new FileWriter(rutaArchivo);
            archivo.write(contenido);
            archivo.close();
            System.out.println("Archivo creado exitosamente.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el archivo.");
            e.printStackTrace();
        }
    }
    @Override
    public void registrarUsuario(String nombreArchivo, Cliente cliente) {
        try {
            File archivo = new File(nombreArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            fr.close();
            br.close();
            // Agregar el nuevo usuario al contenido del archivo
            contenido.append(cliente.toString()).append("\n");
            FileWriter fw = new FileWriter(archivo);
            fw.write(contenido.toString());
            fw.close();
            System.out.println("Usuario " + cliente.getNombreUsuario() + " agregado exitosamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al agregar el usuario: " + e.getMessage());
        }
    }*/

