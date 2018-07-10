package common.dominios;

import common.dominios.enums.TipoFactura;
import lombok.Data;

@Data
public class Factura {

    private int id;
    private Biblioteca bibliotecaOrigen;
    private Biblioteca bibliotecaDestino;
    private Proveedor proveedor;
    private TipoFactura tipoFactura;

}
