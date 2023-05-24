package Modelo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class Cliente extends Usuario {

    public Cliente(String nombreUsuario, String contrasena, String correoCliente, String telefonoCliente, String direccionCliente) {
        super(nombreUsuario, contrasena, correoCliente, telefonoCliente, direccionCliente);
    }
    public Cliente(String nombreUsuario,String contrasena){
        super(nombreUsuario, contrasena);
    }

    public Cliente(Cliente cliente) {
        String nombreUsuario = cliente.getNombreUsuario();
        String contrasena = cliente.getContrasena();
        String correoCliente = cliente.getCorreoCliente();
        String telefonoCliente = cliente.getTelefonoCliente();
        String direccionCliente = cliente.getDireccionCliente();
    }
   /* private double saldo;
    private CarritoDeCompras carritoDeCompras;
private Factura factura;
*/

/*
    public void comprarVideojuego(Videojuegos juego) {//recordar asignar codigo a los videojuegos
        int codigo= juego.getId();
        carritoDeCompras.agregar(juego,codigo);
        System.out.println("Videojuego " + juego.getTitulo() + " agregado al carrito de compras.");
    }


    public void agregarCarritoDeCompras(Videojuegos juego, int cantidad){
        carritoDeCompras.agregar(juego,cantidad);
        System.out.println("Se ha agregado el videojuego"+juego+"al carrito de compras");
    }
    public void eliminarCarritoDeCompras(Videojuegos videojuegos, int cantidad){
        carritoDeCompras.remover(videojuegos,cantidad);
    }

    public void verHistorialDeCompras(Cliente cliente){
        System.out.println(cliente.getFactura());

    }
    public void buscarVideojuegos(Videojuegos videojuego){
    }
    public void modificarInformacion(Videojuegos videojuegos){}*/
}
