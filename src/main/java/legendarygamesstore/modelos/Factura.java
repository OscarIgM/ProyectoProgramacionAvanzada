package legendarygamesstore.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.logging.Logger;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Factura {
    private List<Videojuego> compra;
    private long totalCompra;
    private static final Logger logger=Logger.getLogger(Factura.class.getName());

    public Factura(List<Videojuego> compra) {
        this.compra = compra;
    }
    public long calcularTotal(List<Videojuego> compra) {
        totalCompra=0;
        for (Videojuego juego:compra
             ) {
            totalCompra+=juego.getPrecio();
        }
        return totalCompra;
    }
    public void imprimirFactura(Cliente cliente){
logger.info("Facturas del cliente"+cliente.getFacturas());
    }




}
