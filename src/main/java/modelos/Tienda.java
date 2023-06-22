package modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class Tienda {
    private Catalogo catalogo;
private Factura factura;

    public Factura getFactura() {
        if (factura == null) {
            factura = new Factura();
        }
        return factura;
    }

    }









