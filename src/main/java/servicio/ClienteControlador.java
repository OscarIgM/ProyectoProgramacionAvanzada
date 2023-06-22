package servicio;

import datosjuegos.ArchivoTexto;
import datosjuegos.BaseDeDatos;
import modelos.Cliente;
import modelos.Videojuego;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.*;

@NoArgsConstructor
@Getter
public class ClienteControlador implements UsuarioControladorInterfaz {
    BaseDeDatos clientesRegistrados=new ArchivoTexto();
    private Cliente cliente;
    Scanner scanner=new Scanner(System.in);
    private static final Logger logger=Logger.getLogger(ClienteControlador.class.getName());

    public ClienteControlador(Cliente cliente) {
        this.cliente = cliente;
    }
    public void verCarrito(Cliente cliente){
        for (Videojuego juego : cliente.getCarritoDeCompras().getListaVideojuegos()) {
            System.out.println(juego.getTitulo());        }
    }

public void buscarVideojuego(Cliente cliente){
    System.out.println("Ingrese el nombre del videojuego: ");
    String nombreJuego = scanner.nextLine();
    ControladorVidejuego juego = new ControladorVidejuego();
    Videojuego videojuego = juego.buscarVideojuego(nombreJuego);
    if (videojuego != null) {
        System.out.println("¿Desea agregar " + videojuego.getTitulo() + " al carrito? (s/n)");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Agregando al carrito");
cliente.getCarritoDeCompras().getListaVideojuegos().add(videojuego);
            System.out.println("Juego agregado al carrito.");
        } else {
            System.out.println("El juego no fue agregado al carrito.");
        }
    } else {
        System.out.println("No se encontró el videojuego.");
    }
    System.out.println("Desea realizar la compra de inmediato?");
String respuesta2= scanner.nextLine();
if (respuesta2.equalsIgnoreCase("s")){
realizarCompra(cliente);
}else {
    System.out.println("El videojuego quedo en el carrito");
}
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
    @Override
    public void registrarCliente(Cliente cliente)  {
        try {
            clientesRegistrados.registrarCliente("DatosClientes",cliente);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Cliente iniciarSesion(String nombreUsuario, String contrasena) {
        Cliente cliente = verificarUsuario(nombreUsuario, contrasena);
        return cliente;
    }
    public Cliente verificarUsuario(String nombreUsuario, String contrasena) {
        BaseDeDatos clientesRegistrados = new ArchivoTexto();
        System.out.println("Comprobrando datos que coincidan con la base de datos");
        System.out.println("_--------------------------------");
        ArrayList<Cliente> listadoClientes = (ArrayList<Cliente>) clientesRegistrados.obtenerClientesDesdeJSON("DatosClientes");
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
    public Cliente obtenerClientePorNombre(String nombreUsuario) {
        ObjectMapper objectMapper = new ObjectMapper();
        File archivo = new File("DatosClientes");
        try {
            List<Cliente> listaClientes = objectMapper.readValue(archivo, new TypeReference<List<Cliente>>() {});
            for (Cliente cliente : listaClientes) {
                if (cliente.getNombreUsuario().equals(nombreUsuario)) {
                    return cliente;
                }
            }
            System.out.println("No se encontró un cliente con el nombre de usuario: " + nombreUsuario);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de clientes.");
            e.printStackTrace();
        }
        return null;
    }
    static {
        // Configurar el nivel de registro
        logger.setLevel(Level.ALL);

        // Crear un manejador para la consola y establecer su nivel de registro
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);

        // Asociar el manejador a logger
        logger.addHandler(consoleHandler);
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

    public Cliente obtenerCliente(String nombreUsuario){
        List <Cliente> listadoClientes=clientesRegistrados.obtenerClientesDesdeJSON("DatosClientes");
logger.info("El clientes corresponde a "+listadoClientes);

        return listadoClientes.get(0);
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
    public void actualizarCliente(Cliente cliente) {
        ObjectMapper objectMapper = new ObjectMapper();
        File archivo = new File("DatosClientes");
        try {
            if (archivo.exists()) {
                List<Cliente> listaObjetos = objectMapper.readValue(archivo, new TypeReference<List<Cliente>>() {});
                // Buscar el cliente en la lista y actualizarlo
                for (int i = 0; i < listaObjetos.size(); i++) {
                    if (listaObjetos.get(i).getNombreUsuario().equals(cliente.getNombreUsuario())) {
                        listaObjetos.set(i, cliente);
                        break;
                    }
                }
                objectMapper.writeValue(archivo, listaObjetos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
