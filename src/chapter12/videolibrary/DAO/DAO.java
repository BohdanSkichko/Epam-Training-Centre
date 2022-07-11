package chapter12.videolibrary.DAO;

import chapter12.videolibrary.models.Entity;

import java.sql.SQLException;
import java.util.List;



public abstract class DAO<T extends Entity> {

    public abstract List<T> findAll() throws SQLException;

    public abstract T findEntityById(int id);

    public abstract boolean delete(int id) throws SQLException;

    public abstract boolean delete(T entity);

    public abstract void insert(T entity) throws SQLException;

    private final static String SQL_CHECK_ACTOR_ID = "SELECT id FROM actors " +
            "WHERE name = ? and surname = ? and birthday = ?";

    public abstract T update(T entity);


}