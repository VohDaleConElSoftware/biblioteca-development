package common.abstractos.dominios;

import lombok.Data;

@Data
public abstract class BaseResource {

    private int id;
    private String titulo;
    private int totalPaginas;

}
