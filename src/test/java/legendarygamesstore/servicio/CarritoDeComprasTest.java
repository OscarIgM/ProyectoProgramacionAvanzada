package legendarygamesstore.servicio;

import legendarygamesstore.modelos.Cliente;
import legendarygamesstore.modelos.Videojuego;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarritoDeComprasTest {
   ControladorVideojuego controladorVideojuego;
Cliente cliente;
    @BeforeEach
    void setUp() throws Exception {
        controladorVideojuego = new ControladorVideojuego();
    cliente=new Cliente();
    }
    @DisplayName("Test para verificar que se agrega el juego al carrito")
    @ParameterizedTest
    @ValueSource(strings = {"God of War"})
    void agregar(String titulo) {
        Videojuego juego = controladorVideojuego.buscarVideojuego(titulo);
        cliente.getCarritoDeCompras().getListaVideojuegos().add(juego);
        Assertions.assertTrue(cliente.getCarritoDeCompras().contiene(juego));
    }
}