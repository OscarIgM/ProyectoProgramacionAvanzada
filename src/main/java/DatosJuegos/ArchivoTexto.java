package DatosJuegos;

import Tienda.Cliente;

import java.io.*;

public class ArchivoTexto {
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
    public static void crearArchivo(String contenido, String rutaArchivo) {
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
    public static void agregarCliente(String nombreArchivo, Cliente cliente) {
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
    }
}
