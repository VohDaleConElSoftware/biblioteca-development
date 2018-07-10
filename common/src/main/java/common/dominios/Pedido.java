package common.dominios;

import lombok.Data;

@Data
public class Pedido {

    private int id;
    private Recurso recurso;
    private int numero;

}
