package LegendayGamesStore.modelos;

import LegendayGamesStore.servicio.CarritoDeCompras;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Factura {
    private ArrayList<Videojuego>compra;
    private long totalCompra;
    public Factura(ArrayList<Videojuego> compra) {
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
    public void imprimirFactura(Cliente cliente, CarritoDeCompras carritoDeCompras){

    }




}
