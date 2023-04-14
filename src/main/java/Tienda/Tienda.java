package Tienda;

import lombok.Getter;
@Getter
public class Tienda {
private final Inventario inventario= new Inventario();

    public Tienda(){
mostrarInventario();
    }
public void mostrarInventario(){
    for (int i = 0; i < inventario.getInventario().size(); i++) {
        System.out.println(inventario.getInventario().get(i).getTitulo());
    }




    }



}







