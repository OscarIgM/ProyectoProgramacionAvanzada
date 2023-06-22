package modelos;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Videojuego>clienteVideojuegos;
    public Biblioteca() {
        this.clienteVideojuegos = new ArrayList<>();
    }
    public List<Videojuego> getClienteVideojuegos() {
        return clienteVideojuegos;
    }
    public void setClienteVideojuegos(List<Videojuego> clienteVideojuegos) {
        this.clienteVideojuegos = clienteVideojuegos;
    }
    public void agregarVideojuego(Videojuego videojuego){
        if (clienteVideojuegos==null){
        clienteVideojuegos=new ArrayList<>();
    }
        clienteVideojuegos.add(videojuego);
    }

}
