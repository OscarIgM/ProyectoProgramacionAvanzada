package legendarygamesstore.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.logging.Logger;


@Getter
@NoArgsConstructor
public class Factura {
    @JsonIgnore
    private Cliente cliente;
    @JsonProperty("cliente")
    private String nombre;
    @JsonProperty("totalCompra")
    private long totalCompra;
    @JsonIgnore
    private static final Logger logger = Logger.getLogger(Factura.class.getName());
    @JsonProperty("compras")
    List<Videojuego> compras;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.nombre = cliente.getNombreUsuario();
        this.totalCompra = calcularTotal(cliente.getCarritoDeCompras().getListaVideojuegos());
        this.compras = cliente.getCarritoDeCompras().getListaVideojuegos();
    }

    public long calcularTotal(List<Videojuego> compra) {
        totalCompra = 0;
        for (Videojuego juego : compra) {
            totalCompra += juego.getPrecio();
        }
        return totalCompra;
    }

    public Factura imprimirFactura(Cliente cliente) {
        return new Factura(cliente);
    }
}


