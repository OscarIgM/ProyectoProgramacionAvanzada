package legendarygamesstore.modelos;
import legendarygamesstore.servicio.CarritoDeCompras;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
public class Cliente extends Usuario {
    @JsonIgnore
    private CarritoDeCompras carritoDeCompras;
    @JsonProperty("saldo")
    private long saldo;
    @JsonProperty("biblioteca")
private Biblioteca biblioteca;
    @JsonProperty("facturas")
private ArrayList<Factura> facturas;
    public Cliente(String nombreUsuario, String contrasena, String correoCliente, String telefonoCliente, String direccionCliente,long saldo,Biblioteca biblioteca,ArrayList<Factura>facturas) {
        super(nombreUsuario, contrasena, correoCliente, telefonoCliente, direccionCliente);
        this.saldo=saldo;
        this.biblioteca=biblioteca;
        this.facturas=facturas;
    }
    public long getSaldo() {
        return saldo;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public Biblioteca getBiblioteca() {
        if (biblioteca==null) {
            return new Biblioteca();
        }
    return biblioteca;
    }
    public CarritoDeCompras getCarritoDeCompras() {
        if (carritoDeCompras == null) {
            carritoDeCompras = new CarritoDeCompras();
        }
        return carritoDeCompras;
    }
    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    public void setCarritoDeCompras(CarritoDeCompras carritoDeCompras) {
        this.carritoDeCompras = carritoDeCompras;
    }
    public void actualizarSaldo(long nuevoSaldo) {
this.saldo+=nuevoSaldo;
    }
}


