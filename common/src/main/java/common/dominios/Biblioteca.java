package common.dominios;

import lombok.Data;

@Data
public class Biblioteca {

    private int id;
    private String nombre;
    private boolean esCentral;
    private Comuna comuna;
    private Usuario funcionario;
    private String direccionCalle;
    private int direccionNumero;

}
