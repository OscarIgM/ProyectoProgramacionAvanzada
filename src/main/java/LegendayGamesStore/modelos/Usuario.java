package LegendayGamesStore.modelos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

}
