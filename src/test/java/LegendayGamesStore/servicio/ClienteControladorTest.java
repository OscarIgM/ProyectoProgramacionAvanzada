package LegendayGamesStore.servicio;

import LegendayGamesStore.modelos.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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