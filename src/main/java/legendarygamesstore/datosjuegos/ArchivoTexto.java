package legendarygamesstore.datosjuegos;

import legendarygamesstore.modelos.Cliente;
import legendarygamesstore.modelos.Videojuego;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ArchivoTexto  {
    static final String datosClientes="DatosClientes";
    static final String datosJuegos="DatosJuegos";
    private static final Logger logger=Logger.getLogger(ArchivoTexto.class.getName());

    public void registrarCliente(Cliente cliente) {
        ObjectMapper objectMapper = new ObjectMapper();
        File archivo = new File(datosClientes);
        try {
            if (archivo.exists()) {
                List<Cliente> listaObjetos = objectMapper.readValue(archivo, new TypeReference<List<Cliente>>() {});
                listaObjetos.add(cliente);
                objectMapper.writeValue(archivo, listaObjetos);
               logger.info("Cliente agregado a la base de datos.");
            } else {
                logger.info("El archivo JSON no existe.");
            }
        } catch (IOException e) {
            logger.info("Error al registrar el cliente: " + e.getMessage());
        }
    }
    public List<Cliente> obtenerClientesDesdeJSON() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(datosClientes), objectMapper.getTypeFactory().constructCollectionType(List.class, Cliente.class));
        } catch (JsonParseException | JsonMappingException e) {
           logger.info("Ocurrió un error al parsear el JSON: " + e.getMessage());
        } catch (IOException e) {
            logger.info("Ocurrió un error de entrada/salida: " + e.getMessage());
        }
        return new ArrayList<>(); // Retorna una lista vacía en caso de error
    }
    public void actualizarCliente(Cliente cliente) {
        ObjectMapper objectMapper = new ObjectMapper();
        File archivo = new File(datosClientes);
        try {
            if (archivo.exists()) {
                List<Cliente> listaObjetos = objectMapper.readValue(archivo, new TypeReference<List<Cliente>>() {});
                for (int i = 0; i < listaObjetos.size(); i++) {
                    if (listaObjetos.get(i).getNombreUsuario().equals(cliente.getNombreUsuario())) {
                        listaObjetos.set(i, cliente);
                        break;
                    }
                }
                objectMapper.writeValue(archivo, listaObjetos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Videojuego> leerJsonVideojuego() {
        ObjectMapper objectMapper = new ObjectMapper();
        File archivo = new File(datosJuegos);
        try {
            if (archivo.exists()) {
                return objectMapper.readValue(archivo, new TypeReference<List<Videojuego>>() {});
            } else {
               logger.info("El archivo JSON no existe.");
                return new ArrayList<>();
            }
        } catch (IOException e) {
            logger.info("Error al leer el archivo JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}



