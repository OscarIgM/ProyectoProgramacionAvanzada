package Tienda;
import Modelo.Videojuegos;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.Map;
@Getter
@Setter
public class CarritoDeCompras {
    private Map<Videojuegos, Integer> juegos;
    private long precioTotal;
    public CarritoDeCompras() {
        this.juegos = new HashMap<>();
    }
    public void agregar(Videojuegos juego, int codigo) {
        juegos.put(juego, codigo);
    }
    public void remover(Videojuegos juego, int cantidad) {
        int cantidadNueva = Math.max(juegos.getOrDefault(juego,0) - cantidad, 0);
        if (cantidadNueva == 0) {
            juegos.remove(juego);
        } else {
            juegos.put(juego, cantidadNueva);
        }
    }
    public void limpiarCarrito() {
        juegos.clear();
    }

    public double getPrecioTotal() {
        this.precioTotal = 0;
        for (Videojuegos juego : juegos.keySet()) {
            int cantidad = juegos.get(juego);
            precioTotal += juego.getPrecio() * cantidad;
        }
        return precioTotal;
    }

    public int getCantidad(Videojuegos juego) {
        return juegos.getOrDefault(juego, 0);
    }

    public Map<Videojuegos, Integer> getJuegos() {
        return juegos;
    }
}