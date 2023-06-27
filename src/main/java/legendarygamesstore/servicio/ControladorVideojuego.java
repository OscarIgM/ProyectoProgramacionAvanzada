package legendarygamesstore.servicio;

import legendarygamesstore.datosjuegos.ArchivoTexto;
import legendarygamesstore.modelos.Videojuego;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@NoArgsConstructor
@AllArgsConstructor
public class ControladorVideojuego {
private Videojuego videojuego=new Videojuego();
    private List<Videojuego> listaVideojuegos;
    private static final Logger logger=Logger.getLogger(ControladorVideojuego.class.getName());
    ArchivoTexto juegos=new ArchivoTexto();
    Scanner scanner=new Scanner(System.in);
    public Videojuego buscarVideojuego(){
        logger.info("Ingrese Videojuego a buscar");
        String nombreJuego = scanner.nextLine();
        listaVideojuegos= juegos.leerJsonVideojuego();
        for (Videojuego juego : listaVideojuegos) {
            if (juego.getTitulo().equalsIgnoreCase(nombreJuego)){
                return juego;
            }
        }return null;
    }

    public void printInformacion(Videojuego videojuego){
logger.info("Titulo: " + videojuego.getTitulo());
logger.info("Precio: "+videojuego.getPrecio());
logger.info("Descripcion: "+videojuego.getDescripcion());
    }




}
