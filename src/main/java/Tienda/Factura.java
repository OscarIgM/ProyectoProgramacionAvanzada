package Tienda;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
@AllArgsConstructor
@Getter
public class Factura {
    private ArrayList<Videojuegos>compra=new ArrayList<>();
    private int totalCompra;
    public void calcularTotal(ArrayList<Videojuegos> compra) {
        for (int i = 0; i < compra.size(); i++) {
            compra.get(i).getPrecio();

        }


    }
    public void imprimirFactura(){}




}
