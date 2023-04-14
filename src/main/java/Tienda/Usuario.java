package Tienda;

public class Usuario {

    private String nommbreUsuario;
    private String contrasena;


    public Usuario(String nommbreUsuario, String contrasena) {
        this.nommbreUsuario = nommbreUsuario;
        this.contrasena = contrasena;
    }

    public String getNommbreUsuario() {
        return nommbreUsuario;
    }

    public void setNommbreUsuario(String nommbreUsuario) {
        this.nommbreUsuario = nommbreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public boolean verificar(String nombre, String contrasena) {
        return this.nommbreUsuario.equals(nombre) && this.contrasena.equals(contrasena);
    }
}
