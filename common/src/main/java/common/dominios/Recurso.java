package common.dominios;

import common.abstractos.dominios.BaseResource;
import common.dominios.enums.TipoRecurso;
import common.dominios.enums.TipoTexto;
import lombok.Data;

import java.util.Set;

@Data
public class Recurso<T extends BaseResource> {

    private int id;
    private T recurso;
    private TipoRecurso tipoRecurso;
    private Set<Autor> autores;
    private Editorial editorial;
    private TipoTexto tipoTexto;
    private Set<Topico> topicos;

}
