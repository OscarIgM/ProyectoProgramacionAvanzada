package legendarygamesstore.modelos;

import legendarygamesstore.datosjuegos.ArchivoTexto;
import legendarygamesstore.servicio.ClienteControlador;
import legendarygamesstore.servicio.ControladorVideojuego;
import legendarygamesstore.servicio.TiendaControlador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.*;

public class Menu {
    ArchivoTexto archivoTexto;
    private Cliente cliente;
    private ClienteControlador clienteControlador;
    private Scanner scanner;
    private final ControladorVideojuego controladorVideojuego=new ControladorVideojuego();
    private static final Logger logger=Logger.getLogger(Menu.class.getName());
    private final TiendaControlador tiendaControlador;
    private final Tienda tienda=new Tienda();

    public Menu() {
        this.clienteControlador = new ClienteControlador();
        this.tiendaControlador=new TiendaControlador();
        this.scanner = new Scanner(System.in);
        this.archivoTexto=new ArchivoTexto();
    }


    public void mostrarMenuPrincipal() {
logger.info("Digite una opcion");
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {
            logger.info("1.Iniciar sesion");
           logger.info("2.Registrarse");
           logger.info("3.Salir");
           logger.info("magia");
            try {
logger.info("Escriba Una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        iniciarSesion();
                        break;
                    case 2:
                        registrarse();
                        break;
                    case 3:
                        salir = true;
                        break;
                    case 4:
                        clienteControlador.listadoClientes();
                        break;
                    default:
logger.info("SOLO NUMEROS ENTRE 1 y 4");
                }
            } catch (InputMismatchException e) {
                logger.info("DEBES INSERTAR UN NUMERO");
                sn.next();
            }
        }
    }
    private void iniciarSesion() {
        logger.info("==== Iniciar Sesión ====");
        logger.info("Ingrese el nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
       logger.info("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();
        this.cliente = clienteControlador.iniciarSesion(nombreUsuario, contrasena);
        if (cliente!=null) {
            mostrarMenuCliente();
        }
    }

    private void registrarse() {
        logger.info("==== Registrarse ====");
       logger.info("Nombre: ");
        String nombreUsuario= scanner.next();
        logger.info("Contraseña: ");
        String contrasena= scanner.next();
       logger.info("Correo: ");
        String correo= scanner.next();
        logger.info("Telefono: ");
        String telefono= scanner.next();
        logger.info("Direccion: ");
        String direccion= scanner.next();
        Cliente nuevoCliente = new Cliente(nombreUsuario, contrasena,correo,telefono,direccion,0,new Biblioteca(),new ArrayList<>());
        clienteControlador.registrarCliente(nuevoCliente);
        logger.info("Registro exitoso. ¡Bienvenido, " + nuevoCliente.getNombreUsuario() + "!");
    }
   boolean mostrarMenuFinal(int opcionNum) {
        switch (opcionNum) {
            case 1:
                tiendaControlador.mostrarCatalogo();
                logger.info("Ingrese Videojuego a buscar");
                String nombreJuego = scanner.nextLine();
                Videojuego videojuego = controladorVideojuego.buscarVideojuego(nombreJuego);
                if (videojuego==null){
                    logger.info("El videojuego no existe");
                    break;
                }
                cliente.getCarritoDeCompras().agregar(videojuego);
                archivoTexto.actualizarCliente(cliente);
                break;
            case 2:
                clienteControlador.verCarrito(cliente);
                break;
            case 3:
               boolean realizarCompra= clienteControlador.realizarCompra(cliente);
               if (realizarCompra){
                   tiendaControlador.realizarVenta(cliente, tienda);
                   cliente.getCarritoDeCompras().limpiarCarrito();
               }
                archivoTexto.actualizarCliente(cliente);
                break;
            case 4:
                clienteControlador.verBiblioteca(cliente);
                break;
            case 5:
                clienteControlador.recargarSaldo(cliente);
                archivoTexto.actualizarCliente(cliente);
                break;
            case 6:
                clienteControlador.verDatos(cliente);
                break;
                case 7:
                    cliente.getCarritoDeCompras().limpiarCarrito();
                    break;
            case 8:
                archivoTexto.actualizarCliente(cliente);
                logger.info("Cerrando sesión. ¡Hasta luego, " + cliente.getNombreUsuario() + "!");
                return true;

            default:
                logger.info("Opción inválida. Ingrese un número de opción válido.");
        }
        return false;
    }
    int pedirOpcion() {
        String opcion = scanner.nextLine();
        return Integer.parseInt(opcion);
    }
    private void mostrarMenuCliente() {
        boolean salir = false;
        while (!salir) {
            mostrarTexto();
            try {
                int opcionNum = pedirOpcion();
                salir = mostrarMenuFinal(opcionNum);
            } catch (NumberFormatException e) {
                logger.info("Opción inválida. Ingrese un número de opción válido.");
            }
        }
    }
    void mostrarTexto(){
        logger.info("==== Menú de Cliente ====");
       logger.info("1. Buscar videojuego");
       logger.info("2. Ver carrito de compras");
        logger.info("3.Realizar compra");
        logger.info("4. Ver Biblioteca");
        logger.info("5. Añadir Saldo");
        logger.info("6. Configuracion de la informacion");
        logger.info("7. Limpiar Carrtio");

        logger.info("8. Cerrar Sesión");
        logger.info("Ingrese el número de opción: ");
    }
}