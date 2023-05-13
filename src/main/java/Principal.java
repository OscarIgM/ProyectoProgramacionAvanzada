
import DatosJuegos.ArchivoTexto;
import DatosJuegos.BaseDeDatos;
import Modelo.Cliente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal {
    public static void agregarObjetoAJson(String rutaArchivo, Object objeto) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File archivo = new File(rutaArchivo);

        // Verificar si el archivo existe
        if (archivo.exists()) {
            // Leer el contenido del archivo y convertirlo en una lista de objetos
            List<Object> listaObjetos = objectMapper.readValue(archivo, new TypeReference<List<Object>>() {
            });

            // Agregar el nuevo objeto a la lista
            listaObjetos.add(objeto);

            // Escribir la lista actualizada en el archivo
            objectMapper.writeValue(archivo, listaObjetos);
            System.out.println("Objeto agregado exitosamente al archivo JSON.");
        } else {
            System.out.println("El archivo JSON no existe.");
        }
    }
        public static void main(String[] args) throws IOException {
            BaseDeDatos datos=new ArchivoTexto();
            datos.crearArchivoJSON("DatosClientes");
            Cliente cliente1=new Cliente("a","a","a","a","a");
            Cliente cliente2=new Cliente("b","b","b","b","b");
            agregarObjetoAJson("DatosClientes",cliente1);
            agregarObjetoAJson("DatosClientes",cliente2);


            Controlador conf = new Controlador();

        }
    }

