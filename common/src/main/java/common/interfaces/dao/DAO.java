package common.interfaces.dao;

import java.util.List;

/**
 * Esta interfaz generica contiene los metodos basicos de una operacion CRUD.
 *
 * @param <T> Tipo de entidad a implementar
 */

public interface DAO<T> {

    /**
     * Este método Busca una entidad en la base de datos a través de su clave primaria
     *
     * @param id clave primaria de la entidad
     * @return la entidad en cuestion
     */
    T find(int id);

    /**
     * Este método busca todas las entidades del tipo <T> en la base de datos y las devuelve en una lista
     *
     * @return lista de con todas las entidades en cuestion
     */
    List<T> findAll();

    /**
     * Este método guarda la entidad en cuestion en la base de datos
     *
     * @param entity entidad tipo <T>
     */
    void save(T entity);

    /**
     * Este método actualiza los datos de la entidad en cuestion en la base de datos
     *
     * @param entity entidad tipo <T>
     */
    void update(T entity);

    /**
     * Este método elimina la entidad en cuestion de la base de datos
     *
     * @param id clave primaria de la entidad
     */
    void remove(int id);

}
