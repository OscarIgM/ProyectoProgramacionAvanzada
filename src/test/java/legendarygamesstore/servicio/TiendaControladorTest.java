package legendarygamesstore.servicio;

import legendarygamesstore.datosjuegos.ArchivoTexto;
import legendarygamesstore.modelos.Videojuego;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TiendaControladorTest {
    private List<Videojuego>listadoJuegos;
    private TiendaControlador tiendaControlador;

    @BeforeEach
void setUp() throws Exception{
    ArchivoTexto archivoTexto=new ArchivoTexto();
   listadoJuegos=archivoTexto.leerJsonVideojuego();
   tiendaControlador = new TiendaControlador();
}
    @DisplayName("Prueba para validar la existencia de los juegos del catalogo")
@ParameterizedTest
@ValueSource(strings = {"God of War","Berserk","fifitas"})
    void mostrarCatalogo(String nombreJuego) {
        boolean juegoEncontrado = false;
        for (Videojuego videojuego : listadoJuegos) {
            if (videojuego.getTitulo().equalsIgnoreCase(nombreJuego)) {
                juegoEncontrado = true;
                break;
            }
        }
        Assertions.assertTrue(juegoEncontrado);
    }
@DisplayName("Prueba para ver si el catalogo de la tienda corresponde al del json")
@Test
void buscarVideojuego() {
    for (Videojuego juego : listadoJuegos) {
        boolean juegoEncontrado = false;
        for (Videojuego juegoCatalogo : tiendaControlador.getTienda().getCatalogo().getInventarioJuegos()) {
            if (juego.getTitulo().equalsIgnoreCase(juegoCatalogo.getTitulo())) {
                juegoEncontrado = true;
                break;
            }
        }
        Assertions.assertTrue(juegoEncontrado);
    }

    }
    @DisplayName("Prueba para buscar un juego")
    @ParameterizedTest
    @ValueSource(strings = {"God of War"})
    void buscarVideojuego2(String titulo) {
        boolean juegoEncontrado = false;
        for (Videojuego juegoCatalogo : tiendaControlador.getTienda().getCatalogo().getInventarioJuegos()) {
            if (juegoCatalogo.getTitulo().equalsIgnoreCase(titulo)) {
                juegoEncontrado = true;
                break;
            }
        }
        Assertions.assertTrue(juegoEncontrado);
    }
}