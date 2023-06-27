package LegendayGamesStore.servicio;
import LegendayGamesStore.modelos.Videojuego;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@Getter
@Setter
@NoArgsConstructor
public class CarritoDeCompras {
    private List<Videojuego> listaVideojuegos=new ArrayList<>();
    private long precioTotal;
    Scanner scanner=new Scanner(System.in);
    Logger logger=Logger.getLogger(CarritoDeCompras.class.getName());

    public CarritoDeCompras(List<Videojuego> listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos;
    }
    public void agregar(Videojuego juego) {
       if (printConfirmacion(juego)){
           listaVideojuegos.add(juego);
           logger.info("El juego fue agregado exitosamente al carrito");
       }else {logger.info("El juego no fue agregado al carrito.");
       }
    }
    public void remover(Videojuego juego) {
        listaVideojuegos.remove(juego);
    }
    public List<Videojuego>getListaVideojuegos() {
        return listaVideojuegos;
    }
    public void limpiarCarrito() {
        listaVideojuegos.clear();
    }
    public void agregarCarrito(Videojuego videojuego){


    }
    boolean printConfirmacion(Videojuego juego){
        logger.info("Desea agregar "+juego.getTitulo()+"al carrito? (s/n)");
        String respuesta=scanner.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            logger.info("Agregando al carrito");
            return true;
        } else {
           return false;
        }

    }
}