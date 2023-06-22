package servicio;

import modelos.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ClienteControladorTest {
private ControladorVidejuego controlador;
private Cliente cliente;
@BeforeEach
public void setup() throws Exception {
    controlador=new ControladorVidejuego();
    cliente=new Cliente();
}


}