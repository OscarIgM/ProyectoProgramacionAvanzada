package servicio;
import modelos.Videojuego;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CarritoDeCompras {
    private List<Videojuego> listaVideojuegos=new ArrayList<>();
    private long precioTotal;
    public CarritoDeCompras(List<Videojuego> listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos;
    }
    public void agregar(Videojuego juego) {
        listaVideojuegos.add(juego);
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
}