import DatosJuegos.ArchivoTexto;
import DatosJuegos.BaseDeDatos;
import Modelo.Tienda;
import Modelo.Cliente;
import lombok.*;
import java.util.ArrayList;
import java.util.Scanner;

@Getter
@Setter
@ToString
public class Controlador {

   /* public void registrarNuevoUsuario(Cliente cliente) {
        clienteRegistrados.add(cliente);
        System.out.println(clienteRegistrados.get(0));
        //CLiente.registrarUsuarioEnBaseDeDatos(); // Llamada al método de la clase Usuario
    }*/

    public void primerMenu() {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        while (!salir) {
            System.out.println("Bienvenido a la tienda de videojuegos");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Salir");
            System.out.println("4.Listar Datos");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1://iniciar sesion
                    UsuarioControladorInterfaz cliente=new ClienteControlador();
                    System.out.print("Ingrese su nombre de usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    String contrasena = scanner.nextLine();
                   boolean inicioSesionExitoso = cliente.iniciarSesion(nombreUsuario, contrasena);

                /*    if (inicioSesionExitoso) {
                        System.out.println("Inicio de sesión exitoso");
                        // Aquí puedes agregar la lógica para mostrar el menú del cliente
                    } else {
                        System.out.println("Inicio de sesión fallido. Verifique sus credenciales.");
                    }*/
                    break;

                case 2://registro
                    System.out.print("Ingrese su nombre de usuario: ");
                    nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    contrasena = scanner.nextLine();
                    Cliente cliente2=new Cliente(nombreUsuario,contrasena);
                    UsuarioControladorInterfaz clienteControlador=new ClienteControlador();
                    clienteControlador.registrarCliente(cliente2);
                    System.out.println("Registro exitoso. Ahora puede iniciar sesión.");
                    break;

                case 3://salir
                    salir = true;
                    System.out.println("Gracias por utilizar la tienda de videojuegos");
                    break;

                case 4://Datos
                    BaseDeDatos datos=new ArchivoTexto();
                    datos.crearArchivoJSON("DatosJsonClientes");
                   // datos.verBase("C:\\Users\\oscar\\IdeaProjects\\ProyectoProgramacionAvanzada\\target\\generated-sources\\DatosClientes.txt");
break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    public void segundoMenu() {
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
