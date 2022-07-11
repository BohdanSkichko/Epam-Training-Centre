package chapter12.videolibrary.DAO;

import chapter12.videolibrary.models.Director;

import java.sql.*;
import java.util.List;

public class DirectorDAO extends DAO<Director> {
    private final static String SQL_INSERT_DIRECTOR =
            "INSERT INTO directors(name, surname, birthday) VALUES(?,?,?)";
    private final static String SQL_CHECK_DIRECTOR_ID = "SELECT id FROM directors " +
            "WHERE name = ? and surname = ? and birthday = ?";

    @Override
    public List<Director> findAll() throws SQLException {
        return null;
    }

    @Override
    public Director findEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(Director entity) {
        return false;
    }

    @Override
    public void insert(Director director) throws SQLException {
        Connection connection = DBConnector.getConnection();
        try (connection;
             PreparedStatement psCheckDirector = connection.prepareStatement(SQL_CHECK_DIRECTOR_ID);
             PreparedStatement psInsertActor = connection.prepareStatement(SQL_INSERT_DIRECTOR, Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            psCheckDirector.setString(1, director.getName());
            psCheckDirector.setString(2, director.getSurname());
            psCheckDirector.setDate(3, director.getBirthday());
            ResultSet rsActor = psCheckDirector.executeQuery();
            if (rsActor.next()) {
                director.setId(rsActor.getInt(1));
                System.out.println("Video library contains this director");
            } else {
                psInsertActor.setString(1, director.getName());
                psInsertActor.setString(2, director.getSurname());
                psInsertActor.setDate(3, director.getBirthday());
                psInsertActor.executeUpdate();
                try (ResultSet generatedKeys = psInsertActor.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        director.setId((int) generatedKeys.getLong(1));
                    } else {
                        throw new SQLException("Creating director failed, no ID obtained.");
                    }
                }
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }

    }


    @Override
    public Director update(Director entity) {
        return null;
    }
}
