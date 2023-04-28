package Tienda;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
@Getter
@Setter
@ToString
public abstract class Usuario {
    private String nombreUsuario;
    private String contrasena;
    private String correoCliente;
    private String telefonoCliente;
    private String direccionCliente;
    private ArrayList<Videojuegos> biblioteca;
    public Usuario(String nombreUsuario, String contrasena, String correoCliente, String telefonoCliente, String direccionCliente) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correoCliente = correoCliente;
        this.telefonoCliente = telefonoCliente;
        this.direccionCliente = direccionCliente;
    }

    public Usuario(ArrayList<Videojuegos> biblioteca) {
        this.biblioteca = biblioteca;
    }
    public Usuario() {
        this.biblioteca = new ArrayList<>();
    }

    public boolean verificarUsuario(String nombre, String contrasena) {
        return this.nombreUsuario.equals(nombre) && this.contrasena.equals(contrasena);
    }

    public ArrayList<Videojuegos> getBiblioteca() {
        return biblioteca;
    }
    public void setBiblioteca(ArrayList<Videojuegos> biblioteca) {
        this.biblioteca = biblioteca;
    }
}
