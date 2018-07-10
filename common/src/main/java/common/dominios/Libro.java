package common.dominios;

import common.abstractos.dominios.BaseResource;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Libro extends BaseResource {

    private String isbn;
    private String lomo;
    private String portada;
    private String contraportada;

}
