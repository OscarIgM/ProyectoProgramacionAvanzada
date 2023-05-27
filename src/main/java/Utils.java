import modelos.Cliente;

import java.util.Scanner;

public class Utils {
    private Scanner scanner;

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
