package Modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import Tienda.Inventario;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class Tienda {
    private Inventario inventario;

public List<Videojuegos> buscarVideojuego(String nombre){
    return inventario.getInventario();
}



    }








