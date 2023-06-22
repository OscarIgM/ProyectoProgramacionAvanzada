package servicio;

import datosjuegos.ArchivoTexto;
import datosjuegos.BaseDeDatos;
import modelos.Videojuego;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.IOException;
import java.util.List;
@NoArgsConstructor

@AllArgsConstructor
public class ControladorVidejuego {

    private List<Videojuego> listaVideojuegos;
    public Videojuego buscarVideojuego(String nombre){
        BaseDeDatos juegos=new ArchivoTexto();
        try {
           listaVideojuegos= juegos.leerJsonVideojuego("DatosJuegos");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Videojuego juego : listaVideojuegos) {
            if (juego.getTitulo().equalsIgnoreCase(nombre)){
                return juego;
            }
        }return null;
    }




}
