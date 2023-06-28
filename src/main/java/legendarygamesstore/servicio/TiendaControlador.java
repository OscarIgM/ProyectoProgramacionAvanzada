package legendarygamesstore.servicio;
import legendarygamesstore.modelos.Cliente;
import legendarygamesstore.modelos.Factura;
import legendarygamesstore.modelos.Tienda;
import legendarygamesstore.datosjuegos.ArchivoTexto;
import legendarygamesstore.modelos.Videojuego;
import lombok.Getter;

import java.util.List;
import java.util.logging.Logger;
@Getter
public class TiendaControlador {
    private Tienda tienda;
    private static final Logger logger=Logger.getLogger(TiendaControlador.class.getName());

    public TiendaControlador() {
        this.tienda=new Tienda();
    }

    public void realizarVenta(Cliente cliente, Tienda tienda){
        List<Videojuego>juegoComprados=cliente.getCarritoDeCompras().getListaVideojuegos();
       logger.info("El total de la compra es de "+tienda.getFactura().calcularTotal(juegoComprados));
       logger.info("Listado de juegos = \n"+cliente.getCarritoDeCompras().getListaVideojuegos());
       enviarFactura(cliente);
    }
    public void mostrarCatalogo(){
        tienda.getCatalogo().mostrarInventario();
    }
    public void enviarFactura(Cliente cliente){
        Factura factura= new Factura();
        factura=factura.imprimirFactura(cliente);
        cliente.getFacturas().add(factura);
    }
}
