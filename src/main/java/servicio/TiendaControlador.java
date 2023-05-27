package servicio;

import datosjuegos.ArchivoTexto;
import datosjuegos.BaseDeDatos;
import modelos.Cliente;
import modelos.Tienda;
import modelos.Videojuego;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
public class TiendaControlador {
    private Tienda tienda;
BaseDeDatos videojuegos=new ArchivoTexto();
    public TiendaControlador(Tienda tienda) {
this.tienda=tienda;
    }

    public void realizarVenta(Cliente cliente,Tienda tienda){
        List<Videojuego>juegoComprados=cliente.getCarritoDeCompras().getListaVideojuegos();
        System.out.println("El total de la compra es de "+tienda.getFactura().calcularTotal(juegoComprados));
    }
    public void mostrarCatalogo(){
        List<Videojuego>listadoJuegos=new ArrayList<>();
        try {
          listadoJuegos=videojuegos.leerJsonVideojuego("datosjuegos");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Videojuego juegos:listadoJuegos) {
            System.out.println("Increible oferton\n" + juegos.getTitulo()+"\nA solo!!!! "+juegos.getPrecio());
        }
    }
}
