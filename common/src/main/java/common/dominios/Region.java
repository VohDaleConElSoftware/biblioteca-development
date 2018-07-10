package common.dominios;

import lombok.Data;

@Data
public class Region {

    private int id;
    private String nombre;
    private Zona zona;

}
