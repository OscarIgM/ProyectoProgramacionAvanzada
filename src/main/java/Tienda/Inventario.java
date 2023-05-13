package Tienda;

import Modelo.Videojuegos;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Inventario {
    private List<Videojuegos> inventario= new ArrayList<>();
    public void mostrarInventario() {
        for (int i = 0; i < getInventario().size(); i++) {
            System.out.println(this.getInventario().get(i).getTitulo());
        }
    }
public void añadirInventario(Videojuegos videojuego){
    this.inventario.add(videojuego);
}
public void eliminarInventario(Videojuegos videojuego){
    this.inventario.remove(videojuego);
}
}
