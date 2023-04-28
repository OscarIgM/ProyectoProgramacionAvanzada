import Tienda.Tienda;
import Tienda.Usuario;
import Tienda.Cliente;
import lombok.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
@Getter
@Setter
@ToString
public class Controlador {
private Tienda tienda;
    private Scanner scanner;
private Cliente usuario;
private ArrayList<Cliente>clienteRegistrados=new ArrayList<Cliente>();
private Utils utils;

    public void registrarNuevoUsuario(Cliente cliente) {
     clienteRegistrados.add(cliente);
        System.out.println(clienteRegistrados.get(0));
        //CLiente.registrarUsuarioEnBaseDeDatos(); // Llamada al método de la clase Usuario
    }

    public void menuInicioSesion() {
String opcion;
        Utils utils = new Utils();
        System.out.println("Escriba 'iniciar sesion' para iniciar sesión");
        System.out.println("Escriba 'registrarse' para registrarse");
        System.out.println("Escriba 'salir' para salir");
do {
    opcion = utils.ingresarOpcion();
    try {
              manejarOpcion(opcion);
            } catch (IllegalArgumentException e) {
                System.out.println("Opción inválida, intente de nuevo.");

menuInicioSesion();    } catch (Exception e) {
                System.out.println("Ocurrió un error, intente de nuevo.");
menuInicioSesion();
            }}
while (opcion!="salir");
    }
    private void manejarOpcion(String opcion) {
        switch (opcion){
            case "iniciar_sesion":
                // iniciarSesion();
                break;
            case "registrarse":
                Utils utils = new Utils();
                Cliente cliente=utils.pedirDatosUsuario();
                registrarNuevoUsuario(cliente);
                break;
            case "salir":
                System.out.println("Saliendo del programa...");
                System.exit(0);
                break;
            default:
                System.out.println("Opción inválida, intente de nuevo.");
                break;
        }
    }

    public void menuTienda(){
        String opcion;
        Utils util = new Utils();
        opcion= util.ingresarOpcion();
            System.out.println("==== Menú de Opciones ====");
            System.out.println("1. Comprar videojuego");
            System.out.println("2. Ver carrito de compras");
            System.out.println("3. Ver biblioteca de juegos");
            System.out.println("4. Salir");
            System.out.print("Ingrese el número de opción: ");



    }
          /*  switch (opcion) {
                case 1:
                    // Lógica para comprar videojuego
                    break;
                case 2:
                    // Lógica para ver carrito de compras
                    break;
                case 3:
                    // Lógica para ver biblioteca de juegos
                    break;
                case 4:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción inválida, intente nuevamente.");
                    break;
            }*/
        }
