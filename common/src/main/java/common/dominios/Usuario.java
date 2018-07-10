package common.dominios;

import common.dominios.enums.Rol;
import lombok.Data;

import java.util.Set;

@Data
public class Usuario {

    private int id;
    private String nombre;
    private String apellido;
    private boolean activo;
    private Set<Rol> roles;

}
