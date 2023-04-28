import Tienda.Tienda;
import Tienda.Cliente;
import lombok.*;
import java.util.ArrayList;

@Getter
@Setter
@ToString
public class Controlador {
    private Tienda tienda;
    private Cliente usuario;
    private ArrayList<Cliente> clienteRegistrados = new ArrayList<>();
    private Utils utils;

    public void registrarNuevoUsuario(Cliente cliente) {
        clienteRegistrados.add(cliente);
        System.out.println(clienteRegistrados.get(0));
        //CLiente.registrarUsuarioEnBaseDeDatos(); // Llamada al método de la clase Usuario
    }

    public void menuInicioSesion() {
        String opcion;
        utils = new Utils();
        System.out.println("Escriba 'iniciar sesion' para iniciar sesión");
        System.out.println("Escriba 'registrarse' para registrarse");
        System.out.println("Escriba 'salir' para salir");
        do {
            opcion = utils.ingresarOpcion();
            try {
                manejarOpcion(opcion);
            } catch (IllegalArgumentException e) {
                System.out.println("Opción inválida, intente de nuevo.");

                menuInicioSesion();
            } catch (Exception e) {
                System.out.println("Ocurrió un error, intente de nuevo.");
                menuInicioSesion();
            }
        }
        while (opcion.equalsIgnoreCase("salir"));
    }
    private void manejarOpcion(String opcion) {

        switch (opcion) {
            case "iniciar_sesion" -> {
                System.out.println("Inicio sesion:");
Cliente cliente=utils.pedirDatosInicioSesion();
//verificar datos
menuTienda();
            }
            case "registrarse" -> {
                Utils utils = new Utils();
                Cliente cliente = utils.pedirDatosUsuario();
                registrarNuevoUsuario(cliente);
            }
            case "Salir" -> {
                System.out.println("Saliendo de la sesion");
                System.exit(0);
            }
            default -> System.out.println("Opción inválida, intente de nuevo.");
        }
    }

    public void menuTienda() {
        System.out.println("Menu de tienda");
        int opcion;
        Utils util = new Utils();
        System.out.println("==== Menú de Opciones ====");
        System.out.println("1. Buscar videojuego");
        System.out.println("2. Ver carrito de compras");
        System.out.println("3. Ver biblioteca de juegos");
        System.out.println("4. Cerrar Sesion");
        System.out.print("digite el numero de opcion");
        opcion = Integer.parseInt(util.ingresarOpcion());
        tiendaOpcion(opcion);
    }
    public void tiendaOpcion(int opcion) {
        switch (opcion) {
            case 1://Comprar videojuego
//basededatos mostrar videojuegos

                break;
            case 2:
                // ver carrito de compras
                break;
            case 3:
                // ver biblioteca de juegos
                break;
            case 4:
                System.out.println("Cerrando Sesion");
                break;
            default:
                System.out.println("Opción inválida, intente nuevamente.");
                break;
        }

    }
}
