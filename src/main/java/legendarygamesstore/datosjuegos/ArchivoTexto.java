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

public class ArchivoTexto  {
    static final String datosClientes="DatosClientes";
    static final String datosJuegos="DatosJuegos";

    public void registrarCliente(Cliente cliente) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File archivo = new File(datosClientes);
        if (archivo.exists()) {
            List<Cliente> listaObjetos = objectMapper.readValue(archivo, new TypeReference<List<Cliente>>() {
            });
            listaObjetos.add(cliente);
            objectMapper.writeValue(archivo, listaObjetos);
            System.out.println("Cliente agregado a la base de datos.");
        } else {
            System.out.println("El archivo JSON no existe.");
        }}

    public List<Cliente> obtenerClientesDesdeJSON() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(datosClientes), objectMapper.getTypeFactory().constructCollectionType(List.class, Cliente.class));
        } catch (JsonParseException | JsonMappingException e) {
            System.out.println("Ocurrió un error al parsear el JSON: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ocurrió un error de entrada/salida: " + e.getMessage());
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
                System.out.println("El archivo JSON no existe.");
                return null;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
            return null;
        }
    }

}



