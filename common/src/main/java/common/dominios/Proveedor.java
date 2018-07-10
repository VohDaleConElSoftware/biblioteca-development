package common.dominios;

import lombok.Data;

@Data
public class Proveedor {

    private int id;
    private String nombre;
    private Comuna comuna;
    private String direccionCalle;
    private int direccionNumero;

}
