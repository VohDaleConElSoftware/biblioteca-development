package common.dao;

import common.dominios.Recurso;
import common.dominios.enums.TipoRecurso;
import common.dominios.enums.TipoTexto;
import common.interfaces.dao.RecursoDAO;

import java.util.List;
import java.util.Set;

/**
 * Esta clase implementa la interfaz RecursoDAO y sus métodos para mantener la entidad Recurso
 */
public class RecursoDAOImpl implements RecursoDAO {

    @Override
    public Set<Recurso> findByTipoRecurso(TipoRecurso tipoRecurso) {
        return null;
    }

    @Override
    public Set<Recurso> findByTipoTexto(TipoTexto tipoTexto) {
        return null;
    }

    @Override
    public Recurso find(int id) {
        return null;
    }

    @Override
    public List<Recurso> findAll() {
        return null;
    }

    @Override
    public void save(Recurso entity) {

    }

    @Override
    public void update(Recurso entity) {

    }

    @Override
    public void remove(int id) {

    }
}
