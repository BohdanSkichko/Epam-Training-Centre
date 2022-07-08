package chapter12.videolibrary.DAO;

import chapter12.videolibrary.models.Actor;
import chapter12.videolibrary.models.Country;
import chapter12.videolibrary.models.Director;
import chapter12.videolibrary.models.Movie;

import java.sql.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieDao extends DAO<Movie> {
    private final static String SQL_SELECT_ACTORS = "SELECT * FROM actors";
    private final static String SQL_SELECT_DIRECTORS = "SELECT * FROM directors";
    private final static String SQL_SELECT_COUNTRIES = "SELECT * FROM countries";
    private final static String SQL_INSERT_ACTOR =
            "INSERT INTO actors(name, surname, birthday) VALUES(?,?,?)";
    private final static String SQL_INSERT_MOVIE =
            "INSERT INTO movies(title, release_data) VALUES(?,?)";
    private final static String SQL_INSERT_DIRECTOR =
            "INSERT INTO directors(name, surname, birthday) VALUES(?,?,?)";
    private final static String SQL_INSERT_COUNTRY =
            "INSERT INTO countries(name) VALUES(?)";
    public static final String SQL_SELECT_ALL_MOVIE = "SELECT * FROM movies";
    public static final String SQL_SELECT_ALL_YEAR = "SELECT * FROM movies where release_data between ";


    public List<Movie> findMoviesBetweenYears(LocalDate afterYear, LocalDate thisYear) throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            ResultSet resultSet = DBConnector.getConnection().createStatement().executeQuery(SQL_SELECT_ALL_YEAR
                    + "'" + afterYear + "'" + " and " + "'" + thisYear + "'");
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setReleaseDate(resultSet.getDate("release_data"));
                movies.add(movie);
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        }
        return movies;
    }

    @Override
    public List<Movie> findAll() throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
        try (Connection connection = DBConnector.getConnection()) {
            assert connection != null;
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_MOVIE)) {
                while (resultSet.next()) {
                    Movie movie = new Movie();
                    movie.setId(resultSet.getInt("id"));
                    movie.setTitle(resultSet.getString("title"));
                    movie.setReleaseDate(resultSet.getDate("release_data"));
                    movies.add(movie);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        }
        return movies;
    }

    @Override
    public Movie findEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(Movie entity) {
        return false;
    }

    @Override
    public boolean insert(Movie entity) throws SQLException {
        List<Actor> actors = entity.getActors();
        List<Country> countries = entity.getCountry();
        List<Director> directors = entity.getDirectors();
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement statementActor = connection.prepareStatement(SQL_INSERT_ACTOR,
                     Statement.RETURN_GENERATED_KEYS);
             PreparedStatement statementDirector = connection.prepareStatement(SQL_INSERT_DIRECTOR,
                     Statement.RETURN_GENERATED_KEYS);
             PreparedStatement statementCountry = connection.prepareStatement(SQL_INSERT_COUNTRY,
                     Statement.RETURN_GENERATED_KEYS);
             PreparedStatement statementMovie = connection.prepareStatement(SQL_INSERT_MOVIE,
                     Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            for (Actor actor : actors) {
                statementActor.setString(1, actor.getName());
                statementActor.setString(2, actor.getSurname());
                statementActor.setDate(3, Date.valueOf(actor.getBirthday()));
                int affectedRowsActor = statementActor.executeUpdate();
                if (affectedRowsActor == 0) {
                    connection.rollback();
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                try (ResultSet generatedKeys = statementActor.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        actor.setId((int) generatedKeys.getLong(1));
                    } else {
                        connection.rollback();
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            for (Director director : directors) {
                statementDirector.setString(1, director.getName());
                statementDirector.setString(2, director.getSurname());
                statementDirector.setDate(3, Date.valueOf(director.getBirthday()));
                int affectedRowsDirector = statementDirector.executeUpdate();
                if (affectedRowsDirector == 0) {
                    connection.rollback();
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                try (ResultSet generatedKeys = statementDirector.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        director.setId((int) generatedKeys.getLong(1));
                    } else {
                        connection.rollback();
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            for (Country country : countries) {
                statementCountry.setString(1, country.getName());
                int affectedRowsCountry = statementCountry.executeUpdate();
                if (affectedRowsCountry == 0) {
                    connection.rollback();
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                try (ResultSet generatedKeys = statementCountry.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        country.setId((int) generatedKeys.getLong(1));
                    } else {
                        connection.rollback();
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            statementMovie.setString(1, entity.getTitle());
            statementMovie.setDate(2, Date.valueOf(entity.getReleaseDate()));

            int affectedRowsMovie = statementMovie.executeUpdate();

            if (affectedRowsMovie == 0) {
                connection.rollback();
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statementMovie.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setId((int) generatedKeys.getLong(1));
                } else {
                    connection.rollback();
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            connection.commit();

        }
        return false;
    }

    @Override
    public Movie update(Movie entity) {
        return null;
    }

}
