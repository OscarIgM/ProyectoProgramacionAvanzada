package Modelo;
import DatosJuegos.ArchivoTexto;
import DatosJuegos.BaseDeDatos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
public abstract class Usuario {
    @JsonProperty("nombreUsuario")
    private String nombreUsuario;
    @JsonProperty("contrasena")
    private String contrasena;
    @JsonProperty("correoCliente")
    private String correoCliente;
    @JsonProperty("telefonoCliente")
    private String telefonoCliente;
    @JsonProperty("direccionCliente")
    private String direccionCliente;
   // private ArrayList<Videojuegos> biblioteca;
    public Usuario(String nombreUsuario, String contrasena, String correoCliente, String telefonoCliente, String direccionCliente) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correoCliente = correoCliente;
        this.telefonoCliente = telefonoCliente;
        this.direccionCliente = direccionCliente;
    }

    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena=contrasena;
    }



   /* public Usuario(ArrayList<Videojuegos> biblioteca) {
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
    }*/
}
