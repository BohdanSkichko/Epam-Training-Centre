package chapter12.videolibrary.DAO;

import chapter12.videolibrary.models.Entity;

import java.sql.SQLException;
import java.util.List;



public abstract class DAO<T extends Entity> {

    public abstract List<T> findAll() throws SQLException;

    public abstract T findEntityById(int id);

    public abstract boolean delete(int id);

    public abstract boolean delete(T entity);

    public abstract boolean insert(T entity) throws SQLException;

    public abstract T update(T entity);


}