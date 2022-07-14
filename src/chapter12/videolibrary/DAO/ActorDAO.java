package chapter12.videolibrary.DAO;

import chapter12.videolibrary.models.Actor;
import chapter12.videolibrary.models.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO extends DAO<Actor> {
    private final static String SQL_SELECT_ALL_ACTOR_MOVIE = "SELECT * FROM actors a " +
            "JOIN movie_actors ma ON a.id = ma.actor_id WHERE movie_id = ?";
    private final static String SQL_SELECT_ALL_ACTOR_QUANTITY_MOVIE = "SELECT a.* FROM actors a " +
            "JOIN movie_actors ma ON a.id = ma.actor_id GROUP BY a.id HAVING count(movie_id) > ?";
    private final static String SQL_INSERT_ACTOR = "INSERT INTO actors(name, surname, birthday) VALUES(?,?,?)";
    private final static String SQL_CHECK_ACTOR_ID = "SELECT id FROM actors WHERE name = ? and surname = ? and birthday = ?";
    private final static String SQL_GET_DIRECTORS = " SELECT a.* FROM actors a " +
            "JOIN directors d ON d.name = a.name and d.surname = a.surname and d.birthday = a.birthday";


    @Override
    public List<Actor> findAll() throws SQLException {
        return null;
    }

    public List<Actor> findAllInMovie(Movie movie) throws SQLException {
        List<Actor> actors = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        MovieDao movieDao = new MovieDao();
        int id = movieDao.getId(movie);
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_ACTOR_MOVIE);
        try (connection;
             preparedStatement) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Actor actor = mapActor(resultSet);
                actors.add(actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("SQL exception (request or table failed): " + e);
        }
        return actors;
    }


    public List<Actor> findAllIfDirector() throws SQLException {
        List<Actor> actors = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(SQL_GET_DIRECTORS);
        try (connection;
             statement;
             rs) {
            while (rs.next()) {
                Actor actor = mapActor(rs);
                actors.add(actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    private Actor mapActor(ResultSet rs) throws SQLException {
        Actor actor = new Actor();
        actor.setId(rs.getLong("id"));
        actor.setName(rs.getString("name"));
        actor.setSurname(rs.getString("surname"));
        actor.setBirthday(rs.getDate("birthday"));
        return actor;
    }

    public List<Actor> findAllIfMovieQuantityOver(int quantity) throws SQLException {
        List<Actor> actors = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_ACTOR_QUANTITY_MOVIE);
        try (connection;
             statement;
             preparedStatement) {
            preparedStatement.setInt(1, quantity);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Actor actor = mapActor(resultSet);
                actors.add(actor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("can't find actors" + e);
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
        try (connection;
             PreparedStatement psCheckActor = connection.prepareStatement(SQL_CHECK_ACTOR_ID);
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
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }

    }

    @Override
    public Actor update(Actor actor) {
        return null;
    }
}
