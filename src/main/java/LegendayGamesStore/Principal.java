package LegendayGamesStore;

import LegendayGamesStore.datosjuegos.ArchivoTexto;
import LegendayGamesStore.modelos.Menu;

import java.io.IOException;

public class Principal {
        public static void main(String[] args) {
            ArchivoTexto datos=new ArchivoTexto();
            //datos.crearArchivoJSON("DatosClientes");
            ArchivoTexto juegoDatos=new ArchivoTexto();
           // juegoDatos.crearArchivoJSON("DatosJuegos");
            //System.out.println(leerJsonClientes("DatosClientes"));
          Menu menu1=new Menu();
          menu1.mostrarMenuPrincipal();


        }
    }

