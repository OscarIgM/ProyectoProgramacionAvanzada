import Tienda.Cliente;
import Tienda.Usuario;

import java.util.Scanner;

public class Utils {
    private Scanner scanner;

    public Cliente pedirDatosUsuario(){
        scanner = new Scanner(System.in);
        System.out.println("Nombre: ");
String nombre= scanner.nextLine();
        System.out.println("Contraseña: ");
String contraseña= scanner.next();
        System.out.println("Correo: ");
String correo= scanner.next();
        System.out.println("Telefono: ");
String telefono= scanner.next();
        System.out.println("Direccion: ");
String direccion= scanner.next();
        Cliente cliente= new Cliente(nombre,contraseña,correo,telefono,direccion);
return cliente;
    }
    public Cliente pedirDatosInicioSesion(){
        scanner=new Scanner(System.in);
        System.out.println("Nombre: ");
        String nombre=scanner.nextLine();
        System.out.println("Contraseña: ");
        String contraseña= scanner.nextLine();
        return new Cliente(nombre,contraseña);
    }
    public String ingresarOpcion(){
        scanner=new Scanner(System.in);
        String opcion="";
        opcion=scanner.nextLine();
        return opcion;
    }







}
