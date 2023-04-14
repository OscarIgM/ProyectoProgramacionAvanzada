import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private String idCliente;
    private String nombreCliente;
    private double saldo;
    private String correoCliente;
    private String telefonoCliente;
    private String direccionCliente;
    private CarritoDeCompras carritoDeCompras;




    public void comprarVideojuegos(){



  }

    public void agregarCarritoDeCompras(Videojuegos juego, int cantidad){
carritoDeCompras.agregar(juego,cantidad);
        System.out.println("Se ha agregado el videojuego"+juego+"al carrito de compras");
    }
    public void eliminarCarritoDeCompras(Videojuegos videojuegos,int cantidad){
carritoDeCompras.remover(videojuegos,cantidad);
    }

    public void verHistorialDeCompras(Videojuegos videojuegos){

    }
    public void buscarVideojuegos(Videojuegos videojuegos){}
    public void actualizarInformacion(Videojuegos videojuegos){}

}
