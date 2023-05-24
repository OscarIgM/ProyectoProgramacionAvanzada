import Modelo.Cliente;

import java.util.Scanner;

public class Menu {
    public void primerMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        Cliente cliente;
        UsuarioControladorInterfaz controlador= new ClienteControlador(); ;
        while (!salir) {
            System.out.println("Bienvenido a la tienda de videojuegos");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");

            String opcion = scanner.nextLine();

            try {
                int opcionNum = Integer.parseInt(opcion);
                switch (opcionNum) {
                    case 1:
                        // Opción para iniciar sesión
                        System.out.print("Ingrese su nombre de usuario: ");
                        String nombreUsuario = scanner.nextLine();
                        System.out.print("Ingrese su contraseña: ");
                        String contrasena = scanner.nextLine();
cliente=new Cliente(controlador.iniciarSesion(nombreUsuario,contrasena));
                        if (cliente != null) {
                            // Inicio de sesión exitoso, puedes manipular los datos del cliente
                            segundoMenu(cliente);
                            System.out.println("Inicio de sesión exitoso");
                        } else {
                            // Inicio de sesión fallido, mostrar mensaje de error
                            System.out.println("Inicio de sesión fallido. Verifica tus credenciales.");
                        }


                        break;
                    case 2:
                        //registrar cliente
                        System.out.println("Ingrse nombre de usuario");
                        System.out.println("");

                        break;
                    case 3:
                        // Opción para salir
                        salir = true;
                        System.out.println("Gracias por utilizar la tienda de videojuegos");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        }

        scanner.close();
    }
    public void segundoMenu(Cliente cliente) {
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
    }
}
