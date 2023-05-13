package Modelo;

import Tienda.CarritoDeCompras;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
@AllArgsConstructor
@Getter
public class Factura {
    private ArrayList<Videojuegos>compra=new ArrayList<>();
    private int totalCompra=0;
    public int calcularTotal(ArrayList<Videojuegos> compra) {
        for (int i = 0; i < compra.size(); i++) {
           totalCompra+= compra.get(i).getPrecio();

        }
        return totalCompra;
    }
    public void imprimirFactura(Cliente cliente, CarritoDeCompras carritoDeCompras){}




}
