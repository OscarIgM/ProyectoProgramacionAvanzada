package legendarygamesstore.servicio;

import legendarygamesstore.modelos.Cliente;
import legendarygamesstore.modelos.Videojuego;
import legendarygamesstore.datosjuegos.ArchivoTexto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.*;

@NoArgsConstructor
@Getter
public class ClienteControlador implements UsuarioControladorInterfaz {
    private final ArchivoTexto clientesRegistrados=new ArchivoTexto();
     Scanner scanner=new Scanner(System.in);
    private static final Logger logger=Logger.getLogger(ClienteControlador.class.getName());
   private Cliente cliente;
   private final ControladorVideojuego videojuego=new ControladorVideojuego();


    public void verCarrito(Cliente cliente){
        for (Videojuego juego : cliente.getCarritoDeCompras().getListaVideojuegos()) {
            System.out.println(juego.getTitulo());        }
    }


public void realizarCompra(Cliente cliente){
    System.out.println("Desea realizar la compra de los videojuegos del carrito?");
    String respuesta2= scanner.nextLine();
    List<Videojuego>carrito;
    if (respuesta2.equalsIgnoreCase("s")){
        if (cliente.getSaldo()>cliente.getCarritoDeCompras().getPrecioTotal()){
            System.out.println("Realizando transaccion");
        for (Videojuego juego:cliente.getCarritoDeCompras().getListaVideojuegos()
             ) {
            cliente.getBiblioteca().agregarVideojuego(juego);
        }}else {
            System.out.println("Saldo insuficiente la transaccion no se realizo");
        }

    }
}
public void verBiblioteca(Cliente cliente){
    for ( Videojuego videojuego : cliente.getBiblioteca().getClienteVideojuegos()) {
        System.out.println(videojuego.getTitulo());
    }
}

    public void registrarCliente(Cliente cliente)  {
    clientesRegistrados.registrarCliente(cliente);
    }
    @Override
    public Cliente iniciarSesion(String nombreUsuario, String contrasena) {
        cliente = verificarUsuario(nombreUsuario, contrasena);
        return cliente;
    }
    public Cliente verificarUsuario(String nombreUsuario, String contrasena) {
        System.out.println("Comprobrando datos que coincidan con la base de datos");
        System.out.println("_--------------------------------");
        ArrayList<Cliente> listadoClientes = (ArrayList<Cliente>) clientesRegistrados.obtenerClientesDesdeJSON();
        for (int i = 0; i < listadoClientes.size(); i++) {
            if (Objects.equals(listadoClientes.get(i).getNombreUsuario(), nombreUsuario) && Objects.equals(listadoClientes.get(i).getContrasena(), contrasena)) {
                System.out.println("Inico de sesion exitoso");
                return new Cliente(listadoClientes.get(i).getNombreUsuario()
                        , listadoClientes.get(i).getContrasena()
                        , listadoClientes.get(i).getCorreoCliente()
                        , listadoClientes.get(i).getTelefonoCliente()
                        , listadoClientes.get(i).getDireccionCliente(),
                listadoClientes.get(i).getSaldo()
                ,listadoClientes.get(i).getBiblioteca()
                ,listadoClientes.get(i).getFacturas());
            }
        }return null;
    }


    static {
        // Crear un formateador personalizado que incluya la fecha y hora
        SimpleFormatter formatter = new SimpleFormatter() {
            private final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

            @Override
            public synchronized String format(LogRecord lr) {
                return String.format(format,
                        new java.util.Date(lr.getMillis()),
                        lr.getLevel().getLocalizedName(),
                        lr.getMessage()
                );
            }
        };

        // Obtener el manejador predeterminado y establecer el formateador
        Handler defaultHandler = Logger.getLogger("").getHandlers()[0];
        defaultHandler.setFormatter(formatter);
    }

    public void listadoClientes(){
        List <Cliente> listadoClientes=clientesRegistrados.obtenerClientesDesdeJSON();
logger.info("Listado Completo de clientes "+listadoClientes+"\n");
    }

    public void recargarSaldo(Cliente cliente) {
        System.out.println("Su saldo actual es "+cliente.getSaldo());
        System.out.println("Desea realizar una recarga?");
        String respuesta = scanner.nextLine();
        long nuevoSaldo;
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingrese el monto a recargar");
nuevoSaldo= scanner.nextLong();
cliente.actualizarSaldo(nuevoSaldo);
        } else {
            System.out.println("El juego no fue agregado al carrito.");
        }
    }

    public void verDatos(Cliente cliente) {
        System.out.println("Estimado cliente aqui un informe de sus datos");
        System.out.println("NombreUsuario: " + cliente.getNombreUsuario());
        System.out.println("Saldo es de "+cliente.getSaldo());

    }

}
