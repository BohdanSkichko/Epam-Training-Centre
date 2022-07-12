package chapter12.videolibrary.DAO;

import chapter12.videolibrary.models.Actor;
import chapter12.videolibrary.models.Director;
import chapter12.videolibrary.models.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO extends DAO<Actor> {
    private final static String SQL_SELECT_ALL_ACTOR_MOVIE = "SELECT * FROM actors a " +
            "JOIN movie_actors ma ON a.id = ma.actor_id WHERE movie_id = ";
    private final static String SQL_SELECT_ALL_ACTOR_QUANTITY_MOVIE = "SELECT name, surname, birthday from actors a " +
            "JOIN movie_actors ma ON a.id = ma.actor_id GROUP BY a.id HAVING count(movie_id) > ";
    private final static String SQL_INSERT_ACTOR = "INSERT INTO actors(name, surname, birthday) VALUES(?,?,?)";
    private final static String SQL_CHECK_ACTOR_ID = "SELECT id FROM actors WHERE name = ? and surname = ? and birthday = ?";
    private final static String SQL_GET_DIRECTORS = " SELECT a.name, a.surname, a.birthday FROM actors a " +
            "JOIN directors d ON d.name = a.name and d.surname = a.surname and d.birthday = a.birthday";


    @Override
    public List<Actor> findAll() throws SQLException {
        return null;
    }

    public List<Actor> findAllInMovie(Movie movie) {
        List<Actor> actors = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        MovieDao movieDao = new MovieDao();
        int id = movieDao.getId(movie);
        try (connection;
             ResultSet rs = connection.createStatement().executeQuery((SQL_SELECT_ALL_ACTOR_MOVIE + id))) {
            while (rs.next()) {
                Actor actor = new Actor();
                actor.setName(rs.getString("name"));
                actor.setSurname(rs.getString("surname"));
                actor.setBirthday(rs.getDate("birthday"));
                actors.add(actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL exception (request or table failed): " + e);
        }
        return actors;
    }

    public List<Director> findAllDirectors() throws SQLException {
        List<Director> directors = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        assert connection != null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(SQL_GET_DIRECTORS);
        try (connection;
             statement;
             rs) {
            while (rs.next()) {
                Director director = new Director();
                director.setName(rs.getString(1));
                director.setSurname(rs.getString(2));
                director.setBirthday(rs.getDate(3));
                directors.add(director);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return directors;
    }

    public List<Actor> findAllIfQuantityMovieOver(int quantity) throws SQLException {
        List<Actor> actors = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        assert connection != null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_ACTOR_QUANTITY_MOVIE + quantity);
        try (connection;
             statement;
             rs) {
            while (rs.next()) {
                Actor actor = new Actor();
                actor.setName(rs.getString(1));
                actor.setSurname(rs.getString(2));
                actor.setBirthday(rs.getDate(3));
                actors.add(actor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL exception (request or table failed): " + e);
        }
        return actors;
    }

    @Override
    public Actor findEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(Actor actor) {
        return false;
    }

    @Override
    public void insert(Actor actor) throws SQLException {
        Connection connection = DBConnector.getConnection();
        try (connection) {
            assert connection != null;
            try (PreparedStatement psCheckActor = connection.prepareStatement(SQL_CHECK_ACTOR_ID);
                 PreparedStatement psInsertActor = connection.prepareStatement(SQL_INSERT_ACTOR, Statement.RETURN_GENERATED_KEYS)) {
                connection.setAutoCommit(false);
                psCheckActor.setString(1, actor.getName());
                psCheckActor.setString(2, actor.getSurname());
                psCheckActor.setDate(3, actor.getBirthday());
                ResultSet rsActor = psCheckActor.executeQuery();
                if (rsActor.next()) {
                    actor.setId(rsActor.getInt(1));
                    System.out.println("Video library contains this actor");
                } else {
                    psInsertActor.setString(1, actor.getName());
                    psInsertActor.setString(2, actor.getSurname());
                    psInsertActor.setDate(3, actor.getBirthday());
                    psInsertActor.executeUpdate();
                    try (ResultSet generatedKeys = psInsertActor.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            actor.setId((int) generatedKeys.getLong(1));
                        } else {
                            throw new SQLException("Creating actor failed, no ID obtained.");
                        }
                    }
                }
                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public Actor update(Actor actor) {
        return null;
    }
}
