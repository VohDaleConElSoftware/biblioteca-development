package common.dominios;

import lombok.Data;

@Data
public class Comuna {

    private int id;
    private String nombre;
    private Region region;

}
