package legendarygamesstore.servicio;

import legendarygamesstore.modelos.Cliente;
import legendarygamesstore.modelos.Videojuego;
import legendarygamesstore.datosjuegos.ArchivoTexto;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
            logger.info(juego.getTitulo());        }
    }
    public boolean realizarCompra(Cliente cliente) {
        boolean realizar=false;
        logger.info("Desea realizar la compra de los videojuegos del carrito?");
        String respuesta2 = scanner.nextLine();
        if (respuesta2.equalsIgnoreCase("s")) {
            if (cliente.getSaldo() > cliente.getCarritoDeCompras().getPrecioTotal()) {
                logger.info("Realizando transaccion");
                for (Videojuego juego : cliente.getCarritoDeCompras().getListaVideojuegos()) {
                    cliente.getBiblioteca().agregarVideojuego(juego);
                    cliente.setSaldo(cliente.getSaldo() - juego.getPrecio());
                }
                realizar=true;
            } else {
                logger.info("Saldo insuficiente, la transaccion no se realizo");
            }
        }
        return realizar;
    }

public void verBiblioteca(Cliente cliente){
    for ( Videojuego videojuego : cliente.getBiblioteca().getClienteVideojuegos()) {
        logger.info(videojuego.getTitulo());
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
        logger.info("Comprobrando datos que coincidan con la base de datos");
       logger.info("_--------------------------------");
        ArrayList<Cliente> listadoClientes = (ArrayList<Cliente>) clientesRegistrados.obtenerClientesDesdeJSON();
        for (int i = 0; i < listadoClientes.size(); i++) {
            if (Objects.equals(listadoClientes.get(i).getNombreUsuario(), nombreUsuario) && Objects.equals(listadoClientes.get(i).getContrasena(), contrasena)) {
                logger.info("Inico de sesion exitoso");
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


    public void recargarSaldo(Cliente cliente) {
        logger.info("Su saldo actual es "+cliente.getSaldo());
        logger.info("Desea realizar una recarga?(s/n");
        String respuesta = scanner.nextLine();
        long nuevoSaldo;
        if (respuesta.equalsIgnoreCase("s")) {
           logger.info("Ingrese el monto a recargar");
nuevoSaldo= scanner.nextLong();
cliente.actualizarSaldo(nuevoSaldo);
        } else {
            logger.info("la recarga fallo.");
        }
    }
    public void verDatos(Cliente cliente) {
       logger.info("Estimado cliente aqui un informe de sus datos");
        logger.info("NombreUsuario: " + cliente.getNombreUsuario());
        logger.info("Saldo es de "+cliente.getSaldo());
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
}
