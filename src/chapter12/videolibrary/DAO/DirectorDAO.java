package chapter12.videolibrary.DAO;

import chapter12.videolibrary.models.Director;
import chapter12.videolibrary.models.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DirectorDAO extends DAO<Director> {
    private final static String SQL_FIND_ALL_IN_MOVIE = "SELECT * FROM directors d " +
            "JOIN movie_direction md ON md.director_id = d.id WHERE movie_id = ?";
    private final static String SQL_INSERT_DIRECTOR = "INSERT INTO directors(name, surname, birthday) VALUES(?,?,?)";
    private final static String SQL_CHECK_DIRECTOR_ID = "SELECT id FROM directors " +
            "WHERE name = ? and surname = ? and birthday = ?";


    public List<Director> findAllInMovie(Movie movie) throws SQLException {
        MovieDao movieDao = new MovieDao();
        int id = movieDao.getId(movie);
        List<Director> directors = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_IN_MOVIE);
        try (connection;
             statement;
             preparedStatement) {
            connection.setAutoCommit(false);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Director director = mapDirector(rs);
                directors.add(director);
            }
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
            throw e;
        }
        return directors;
    }

    private Director mapDirector(ResultSet rs) throws SQLException {
        Director director = new Director();
        director.setId(rs.getLong("id"));
        director.setName(rs.getString("name"));
        director.setSurname(rs.getString("surname"));
        director.setBirthday(rs.getDate("birthday"));
        return director;
    }

    @Override
    public List<Director> findAll() {
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
            throw new SQLException("can't insert director");
        }

    }


    @Override
    public Director update(Director entity) {
        return null;
    }
}
