package Tienda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Videojuegos {
    private int id;
    private String titulo;
    private String descripcion;
    private String imagen;
    private String fecha;
    private String estudioAutor;
    private double precio;

}
