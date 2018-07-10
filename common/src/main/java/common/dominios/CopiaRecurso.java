package common.dominios;

import common.dominios.enums.EstadoCopia;
import lombok.Data;

@Data
public class CopiaRecurso {

    private int id;
    private Recurso recurso;
    private EstadoCopia estadoCopia;

}
