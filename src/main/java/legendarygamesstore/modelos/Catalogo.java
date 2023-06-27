package legendarygamesstore.modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Catalogo {
    private List<Videojuego> inventarioJuegos = new ArrayList<>();
    private static final Logger logger=Logger.getLogger(Catalogo.class.getName());

    public void mostrarInventario() {
        for (int i = 0; i < getInventarioJuegos().size(); i++) {
            logger.info(this.getInventarioJuegos().get(i).getTitulo());
        }
    }
public void agregarInventario(Videojuego videojuego){
    this.inventarioJuegos.add(videojuego);
}
public void eliminarInventario(Videojuego videojuego){
    this.inventarioJuegos.remove(videojuego);
}
}
