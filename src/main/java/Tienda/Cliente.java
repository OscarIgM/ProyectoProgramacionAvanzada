package Tienda;

import Scraping.Videojuegos;


public class Cliente extends Usuario {
    private double saldo;
    private CarritoDeCompras carritoDeCompras;

    public Cliente(String nombreUsuario, String contrasena, String correoCliente, String telefonoCliente, String direccionCliente) {
        super(nombreUsuario, contrasena, correoCliente, telefonoCliente, direccionCliente);
    }
    public void comprarVideojuegos(){



  }

    public void agregarCarritoDeCompras(Videojuegos juego, int cantidad){
carritoDeCompras.agregar(juego,cantidad);
        System.out.println("Se ha agregado el videojuego"+juego+"al carrito de compras");
    }
    public void eliminarCarritoDeCompras(Videojuegos videojuegos, int cantidad){
carritoDeCompras.remover(videojuegos,cantidad);
    }

    public void verHistorialDeCompras(Cliente cliente){
        cliente.verBiblioteca(cliente);

    }
    public void buscarVideojuegos(Videojuegos videojuego){

    }
    public void actualizarInformacion(Videojuegos videojuegos){}

}
