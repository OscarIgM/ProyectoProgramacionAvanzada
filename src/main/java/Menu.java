import modelos.Cliente;
import modelos.Tienda;
import servicio.ClienteControlador;
import servicio.TiendaControlador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private ClienteControlador clienteControlador;
    private Scanner scanner;
    private TiendaControlador tiendaControlador;
    public Menu() {
        clienteControlador = new ClienteControlador();
        tiendaControlador=new TiendaControlador();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        System.out.println("Digite una opcion");

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("1. Iniciar sesion");
            System.out.println("2. registarse");
            System.out.println("3. Salir");
            System.out.println("4. magia");
            try {

                System.out.println("Escribe una de las opciones");
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
                        clienteControlador.obtenerCliente("wolo");
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    private void iniciarSesion() {
        System.out.println("==== Iniciar Sesión ====");
        System.out.print("Ingrese el nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();

        Cliente cliente = clienteControlador.iniciarSesion(nombreUsuario, contrasena);
        if (cliente!=null) {
            mostrarMenuCliente(cliente);
        }
    }

    private void registrarse() {
        System.out.println("==== Registrarse ====");
        System.out.println("Nombre: ");
        String nombreUsuario= scanner.next();
        System.out.println("Contraseña: ");
        String contrasena= scanner.next();
        System.out.println("Correo: ");
        String correo= scanner.next();
        System.out.println("Telefono: ");
        String telefono= scanner.next();
        System.out.println("Direccion: ");
        String direccion= scanner.next();
        Cliente nuevoCliente = new Cliente(nombreUsuario, contrasena);
        clienteControlador.registrarCliente(nuevoCliente);
        System.out.println("Registro exitoso. ¡Bienvenido, " + nuevoCliente.getNombreUsuario() + "!");
    }
    private void mostrarMenuCliente(Cliente cliente) {
        boolean salir = false;
        Tienda tienda=new Tienda();
        while (!salir) {
            System.out.println("==== Menú de Cliente ====");
            System.out.println("1. Comprar videojuego");
            System.out.println("2. Ver carrito de compras");
            System.out.println("3. Ver biblioteca de juegos");
            System.out.println("4. Añadir Saldo");
            System.out.println("5. Configuracion de la informacion");
            System.out.println("6. Cerrar Sesión");
            System.out.print("Ingrese el número de opción: ");
            String opcion = scanner.nextLine();
            int opcionNum;
            try {
                opcionNum = Integer.parseInt(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Ingrese un número de opción válido.");
                continue;
            }

            switch (opcionNum) {
                case 1:
                    tiendaControlador.mostrarCatalogo();
                    clienteControlador.buscarVideojuego(cliente);
                    tiendaControlador.realizarVenta(cliente,tienda);
                    clienteControlador.actualizarCliente(cliente);

                    break;
                case 2:
                    clienteControlador.verCarrito(cliente);
                    clienteControlador.realizarCompra(cliente);
                    clienteControlador.actualizarCliente(cliente);
                    break;
                case 3:
                    clienteControlador.verBiblioteca(cliente);
                    break;
                case 4:
                    clienteControlador.recargarSaldo(cliente);
                    clienteControlador.actualizarCliente(cliente);
                    break;
                case 5:
                    clienteControlador.verDatos(cliente);
                    break;
                case 6:
                    clienteControlador.actualizarCliente(cliente);
                    salir = true;
                    System.out.println("Cerrando sesión. ¡Hasta luego, " + cliente.getNombreUsuario() + "!");
                    break;
                default:
                    System.out.println("Opción inválida. Ingrese un número de opción válido.");
            }
        }
    }
}