package legendarygamesstore.modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class Tienda {
    private Catalogo catalogo;
private Factura factura;

    public Tienda() {
        this.catalogo = new Catalogo();
    }

    public Factura getFactura() {
        if (factura == null) {
            factura = new Factura();
        }
        return factura;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }
}









