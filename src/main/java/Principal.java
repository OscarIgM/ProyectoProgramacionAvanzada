
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
        public static void main(String[] args) throws IOException {
            BaseDeDatos datos=new ArchivoTexto();
            //datos.crearArchivoJSON("DatosClientes");
            BaseDeDatos juegoDatos=new ArchivoTexto();
           // juegoDatos.crearArchivoJSON("DatosJuegos");
            //System.out.println(leerJsonClientes("DatosClientes"));
          Menu menu1=new Menu();
          menu1.primerMenu();


        }
    }

