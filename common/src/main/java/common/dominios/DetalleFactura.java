package common.dominios;

import lombok.Data;

import java.util.Set;

@Data
public class DetalleFactura {

    private int id;
    private Factura factura;
    private Set<Pedido> pedidos;
    private int total;

}
