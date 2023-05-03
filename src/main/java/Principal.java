import Tienda.Videojuegos;
import java.util.ArrayList;

import static DatosJuegos.ArchivoTexto.crearArchivo;

public class Principal {
        public static void main(String[] args) {
            //abrir conexion base de datos
            //hardcodeo para la base de datos ignorar en version final
            Videojuegos juego = new Videojuegos(1,"","","","","",1000);
            Videojuegos juego2 = new Videojuegos(2,"","","","","",2000);
            ArrayList<Videojuegos>juegos=new ArrayList<>();
            juegos.add(juego);
            juegos.add(juego2);
            ArrayList<Videojuegos>juegos2=new ArrayList<>();
            crearArchivo(juegos.toString(),"C:\\Users\\oscar\\IdeaProjects\\ProyectoProgramacionAvanzada\\target\\generated-sources\\DatosJuegos.txt");
            juegos2.addAll(juegos);
            System.out.println(juegos2.get(1).getTitulo());
            System.out.println(juegos2);//iniciar controlador para muestra de codigo via terminal
            /*Controlador conf=new Controlador();
conf.menuInicioSesion();*/

    }
}
