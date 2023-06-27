package legendarygamesstore.servicio;
import legendarygamesstore.modelos.Cliente;
import legendarygamesstore.modelos.Tienda;
import legendarygamesstore.datosjuegos.ArchivoTexto;
import legendarygamesstore.modelos.Videojuego;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TiendaControlador {
    private Tienda tienda;
private ArchivoTexto videojuegos=new ArchivoTexto();
    private static final Logger logger=Logger.getLogger(TiendaControlador.class.getName());

    public TiendaControlador() {
        this.tienda=new Tienda();
        List<Videojuego> listadoJuegos=videojuegos.leerJsonVideojuego();
        for (Videojuego videojuego : listadoJuegos ) {
        tienda.getCatalogo().agregarInventario(videojuego);
        }
    }

    public void realizarVenta(Cliente cliente, Tienda tienda){
        List<Videojuego>juegoComprados=cliente.getCarritoDeCompras().getListaVideojuegos();
       logger.info("El total de la compra es de "+tienda.getFactura().calcularTotal(juegoComprados));
    }
    public void mostrarCatalogo(){
        tienda.getCatalogo().mostrarInventario();
    }
}
