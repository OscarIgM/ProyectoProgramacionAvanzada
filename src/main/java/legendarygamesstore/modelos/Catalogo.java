package legendarygamesstore.modelos;

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
public class Catalogo {
    private List<Videojuego> Catalogo = new ArrayList<>();
    public void mostrarInventario() {
        for (int i = 0; i < getCatalogo().size(); i++) {
            System.out.println(this.getCatalogo().get(i).getTitulo());
        }
    }
public void añadirInventario(Videojuego videojuego){
    this.Catalogo.add(videojuego);
}
public void eliminarInventario(Videojuego videojuego){
    this.Catalogo.remove(videojuego);
}
}
