package legendarygamesstore.servicio;

import legendarygamesstore.modelos.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteControladorTest {
    private ControladorVideojuego controladorJuego=new ControladorVideojuego();
    private Cliente cliente;
    @BeforeEach
    public void setUp()  {
        controladorJuego=new ControladorVideojuego();
        cliente=new Cliente();
    }

    @Test
    void buscarVideojuego() {
    }
}