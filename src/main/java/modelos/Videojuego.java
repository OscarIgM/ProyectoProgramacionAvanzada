package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Videojuego {
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("imagen")
    private String imagen;
    @JsonProperty("fecha")
    private String fecha;
    @JsonProperty("estudioAutor")
    private String estudioAutor;
    @JsonProperty("precio")
    private double precio;

}
