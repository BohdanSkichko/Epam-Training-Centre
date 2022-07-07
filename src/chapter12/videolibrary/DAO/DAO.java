package chapter12.videolibrary.DAO;

import chapter12.DBConnector;
import chapter12.videolibrary.models.Entity;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T extends Entity> {
    protected Connection connection;

    public DAO(Connection connection) {
        this.connection = DBConnector.getConnection();
    }

    public abstract List<T> findAll() throws SQLException;

    public abstract T findEntityById(int id);

    public abstract boolean delete(int id);

    public abstract boolean delete(T entity);

    public abstract boolean create(T entity);

    public abstract T update(T entity);

    public void close() {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            System.out.println("Error closing SQL connection!");
        }
    }

}