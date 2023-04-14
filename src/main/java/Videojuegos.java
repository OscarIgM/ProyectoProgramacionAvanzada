import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Videojuegos {
    private String titulo;
    private String descripcion;
    private String imagen;
    private String url;
    private String categoria;
    private String fecha;
    private String autor;
    private double precio;

    public Videojuegos(String titulo, String descripcion, String imagen, String url, String categoria, String fecha, String autor) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.url = url;
        this.categoria = categoria;
        this.fecha = fecha;
        this.autor = autor;
    }



    @Override
    public String toString() {
        return "Videojuegos{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", url='" + url + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fecha='" + fecha + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
