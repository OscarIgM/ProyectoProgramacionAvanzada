package legendarygamesstore.modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Tienda {
    private final Catalogo catalogo=new Catalogo();
private Factura factura;

    public Factura getFactura() {
        if (factura == null) {
            factura = new Factura();
        }
        return factura;
    }

    }









