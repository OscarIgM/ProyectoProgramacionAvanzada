package legendarygamesstore.servicio;
import legendarygamesstore.modelos.Cliente;
import legendarygamesstore.modelos.Tienda;
import legendarygamesstore.datosjuegos.ArchivoTexto;
import legendarygamesstore.modelos.Videojuego;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
public class TiendaControlador {
    private Tienda tienda;
ArchivoTexto videojuegos=new ArchivoTexto();
    public TiendaControlador(Tienda tienda) {
this.tienda=tienda;
    }

    public void realizarVenta(Cliente cliente, Tienda tienda){
        List<Videojuego>juegoComprados=cliente.getCarritoDeCompras().getListaVideojuegos();
        System.out.println("El total de la compra es de "+tienda.getFactura().calcularTotal(juegoComprados));
    }
    public void mostrarCatalogo(){
        List<Videojuego>listadoJuegos=new ArrayList<>();
        listadoJuegos=videojuegos.leerJsonVideojuego();
        for (Videojuego juegos:listadoJuegos) {
            System.out.println("Increible oferton\n" + juegos.getTitulo()+"\nA solo!!!! "+juegos.getPrecio());
        }
    }
}
