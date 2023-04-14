package Scraping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Videojuegos {
    private String titulo;
    private String descripcion;
    private String imagen;
    private String fecha;
    private String estudioAutor;
    private double precio;

    public Videojuegos(String titulo, String descripcion, String imagen, String fecha, String estudioAutor,double precio) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fecha = fecha;
        this.estudioAutor = estudioAutor;
        this.precio = precio;
    }

}
