package LegendayGamesStore.modelos;

import LegendayGamesStore.datosjuegos.ArchivoTexto;
import LegendayGamesStore.servicio.ClienteControlador;
import LegendayGamesStore.servicio.ControladorVideojuego;
import LegendayGamesStore.servicio.TiendaControlador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.*;

public class Menu {
    ArchivoTexto archivoTexto;
    private Cliente cliente;
    private final ClienteControlador clienteControlador;
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
        Cliente nuevoCliente = new Cliente(nombreUsuario, contrasena,correo,telefono,direccion,0,new Biblioteca(),new ArrayList<Factura>());
        clienteControlador.registrarCliente(nuevoCliente);
        logger.info("Registro exitoso. ¡Bienvenido, " + nuevoCliente.getNombreUsuario() + "!");
    }
    boolean mostrarMenuFinal(int opcionNum){
        switch (opcionNum) {
            case 1://Buscar VideoJuego
                tiendaControlador.mostrarCatalogo();
                Videojuego videojuego= controladorVideojuego.buscarVideojuego();
                cliente.getCarritoDeCompras().agregar(videojuego);
                archivoTexto.actualizarCliente(cliente);
                break;
            case 2://ver carrito de compras
                clienteControlador.verCarrito(cliente);

                break;
            case 3://Realizar compra
                clienteControlador.realizarCompra(cliente);
                tiendaControlador.realizarVenta(cliente,tienda);
                archivoTexto.actualizarCliente(cliente);
            case 4://ver biblioteca
                clienteControlador.verBiblioteca(cliente);
                break;
            case 5://recargar Saldo
                clienteControlador.recargarSaldo(cliente);
                archivoTexto.actualizarCliente(cliente);
                break;
            case 6://ver Datos
                clienteControlador.verDatos(cliente);
                break;

            case 7://salir
                    archivoTexto.actualizarCliente(cliente);
                    logger.info("Cerrando sesión. ¡Hasta luego, " + cliente.getNombreUsuario() + "!");
                    return true;

            default:
                logger.warning("Opción inválida. Ingrese un número de opción válido.");
        }
        return true;
    }
    int pedirOpcion() {
        String opcion = scanner.nextLine();
        int opcionNum;
        try {
            opcionNum = Integer.parseInt(opcion);
            return opcionNum;
        } catch (NumberFormatException e) {
            logger.info("Opción inválida. Ingrese un número de opción válido.");
            return pedirOpcion();
        }
    }
    private void mostrarMenuCliente() {
        boolean salir = false;
        while (!salir) {
            mostrarTexto();
            int opcionNum=pedirOpcion();
            salir=mostrarMenuFinal(opcionNum);
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

        logger.info("7. Cerrar Sesión");
        logger.info("Ingrese el número de opción: ");
    }
}