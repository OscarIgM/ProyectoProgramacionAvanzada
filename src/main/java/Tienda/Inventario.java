package Tienda;

import Scraping.Videojuegos;
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
public void añadirInventario(Videojuegos videojuego){
    inventario.add(videojuego);
}
public void eliminarInventario(Videojuegos videojuego){
    this.inventario.remove(videojuego);
}
}
