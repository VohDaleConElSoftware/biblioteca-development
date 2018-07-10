package common.dominios;

import common.dominios.enums.EstadoPrestamo;
import lombok.Data;

@Data
public class DetallePrestamo {

    private int id;
    private Prestamo prestamo;
    private CopiaRecurso copiaRecurso;
    private EstadoPrestamo estadoPrestamo;
    private Biblioteca bibliotecaDevolucion;

}

