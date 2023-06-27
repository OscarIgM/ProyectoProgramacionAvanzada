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
@BeforeEach
void setUp() throws Exception{
    ArchivoTexto archivoTexto=new ArchivoTexto();
   listadoJuegos=archivoTexto.leerJsonVideojuego();
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
}