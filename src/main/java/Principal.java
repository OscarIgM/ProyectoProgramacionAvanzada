
import datosjuegos.ArchivoTexto;
import datosjuegos.BaseDeDatos;

import java.io.IOException;

public class Principal {
        public static void main(String[] args) throws IOException {
            BaseDeDatos datos=new ArchivoTexto();
            //datos.crearArchivoJSON("DatosClientes");
            BaseDeDatos juegoDatos=new ArchivoTexto();
           // juegoDatos.crearArchivoJSON("DatosJuegos");
            //System.out.println(leerJsonClientes("DatosClientes"));
          Menu menu1=new Menu();
          menu1.mostrarMenuPrincipal();


        }
    }

