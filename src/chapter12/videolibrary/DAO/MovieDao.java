package chapter12.videolibrary.DAO;

import chapter12.videolibrary.models.Actor;
import chapter12.videolibrary.models.Country;
import chapter12.videolibrary.models.Director;
import chapter12.videolibrary.models.Movie;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class MovieDao extends DAO<Movie> {
    private final ActorDAO actorDAO = new ActorDAO();
    private final DirectorDAO directorDAO = new DirectorDAO();
    private final CountryDAO countryDAO = new CountryDAO();

    private final static String SQL_DELETE_MOVIE_ID = "DELETE FROM movies WHERE id = ?";
    private final static String SQL_DELETE_MOVIE_ACTOR_ID = "DELETE FROM movie_actors WHERE movie_id = ?";
    private final static String SQL_DELETE_MOVIE_DIRECTION_ID = "DELETE FROM movie_direction WHERE movie_id = ?";
    private final static String SQL_DELETE_MOVIE_COUNTRY_ID = "DELETE FROM country_movie_link WHERE movie_id = ?";

    private final static String SQL_DELETE_MOVIE_RELEASE_DATE = "SELECT id FROM movies WHERE " +
            "release_date < date_trunc('YEAR',NOW())-INTERVAL ";

    private final static String SQL_GET_MOVIE_ID = "SELECT id FROM movies WHERE title = ? and release_date = ?";

    private final static String SQL_INSERT_COUNTRY_MOVIE_LINK = "INSERT INTO country_movie_link(country_id, movie_id) VALUES(?,?)";
    private final static String SQL_INSERT_MOVIE_DIRECTION = "INSERT INTO movie_direction(director_id, movie_id) VALUES(?,?)";
    private final static String SQL_INSERT_MOVIE_ACTORS = "INSERT INTO movie_actors(actor_id, movie_id) VALUES(?,?)";
    private final static String SQL_INSERT_MOVIE = "INSERT INTO movies(title, release_date) VALUES(?,?)";

    private final static String SQL_CHECK_MOVIE_ID = "SELECT id FROM movies WHERE title = ? AND release_date = ?";

    private final static String ALL_MOVIES_RELEASE_LAST_YEAR_AND_NOW = "SELECT * FROM movies WHERE release_date > " +
            "date_trunc('YEAR',NOW()-INTERVAL '1 YEAR')";


    public List<Movie> findMoviesReleaseLastYearAndNow() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        Statement statement = connection.createStatement();
        try (connection;
             statement) {
            ResultSet resultSet = statement.executeQuery(ALL_MOVIES_RELEASE_LAST_YEAR_AND_NOW);
            connection.setAutoCommit(false);
            while (resultSet.next()) {
                Movie movie = mapMovie(resultSet);
                List<Director> directors = directorDAO.findAllInMovie(movie);
                for (Director director : directors) {
                    movie.addDirector(director);
                }
                List<Actor> actors = actorDAO.findAllInMovie(movie);
                for (Actor actor : actors) {
                    movie.addActor(actor);
                }
                List<Country> countries = countryDAO.findAllInMovie(movie);
                for (Country country : countries) {
                    movie.addCountry(country);
                }
                movies.add(movie);
            }
            connection.commit();
        } catch (SQLException e) {
            throw new SQLException("SQL exception (request or table failed): " + e);
        }
        return movies;
    }

    private Movie mapMovie(ResultSet resultSet) throws SQLException {
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("id"));
        movie.setTitle(resultSet.getString("title"));
        movie.setReleaseDate(resultSet.getDate("release_date"));
        return movie;
    }

    @Override
    public List<Movie> findAll() throws SQLException {
        return null;
    }

    @Override
    public Movie findEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        Connection connection = DBConnector.getConnection();
        try (connection) {
            connection.setAutoCommit(false);
            PreparedStatement psMovieActors = connection.prepareStatement(SQL_DELETE_MOVIE_ACTOR_ID);
            psMovieActors.setInt(1, id);
            psMovieActors.executeUpdate();
            PreparedStatement psMovieDirectors = connection.prepareStatement(SQL_DELETE_MOVIE_DIRECTION_ID);
            psMovieDirectors.setInt(1, id);
            psMovieDirectors.executeUpdate();
            PreparedStatement psMovieCountries = connection.prepareStatement(SQL_DELETE_MOVIE_COUNTRY_ID);
            psMovieCountries.setInt(1, id);
            psMovieCountries.executeUpdate();
            PreparedStatement psMovie = connection.prepareStatement(SQL_DELETE_MOVIE_ID);
            psMovie.setInt(1, id);
            psMovie.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public void deleteIfReleaseMoreYearsAgo(int quantityYears) throws SQLException {
        Connection connection = DBConnector.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_MOVIE_RELEASE_DATE +
                "'" + quantityYears + "YEARS'");
        try (connection;
             preparedStatement) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                delete(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("SQL exception (request or table failed): " + e);
        }
    }

    public int getId(Movie movie) {
        if (movie.getId() != 0) {
            return (int) movie.getId();
        } else {
            Connection connection = DBConnector.getConnection();
            try (connection) {
                PreparedStatement psGetMovieID = connection.prepareStatement(SQL_GET_MOVIE_ID);
                psGetMovieID.setString(1, movie.getTitle());
                psGetMovieID.setDate(2, Date.valueOf(movie.getReleaseDate()));
                ResultSet resultSet = psGetMovieID.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    @Override
    public boolean delete(Movie entity) {
        Connection connection = DBConnector.getConnection();
        try (connection) {
            delete(getId(entity));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void insert(Movie movie) throws SQLException {
        Connection connection = DBConnector.getConnection();
        List<Actor> actors = movie.getActors();
        List<Country> countries = movie.getCountry();
        List<Director> directors = movie.getDirectors();
        try (connection) {
            try (PreparedStatement checkMovie = connection.prepareStatement(SQL_CHECK_MOVIE_ID);
                 PreparedStatement statementMovie = connection.prepareStatement(SQL_INSERT_MOVIE,
                         Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement statementCountryMovie = connection.prepareStatement(SQL_INSERT_COUNTRY_MOVIE_LINK);
                 PreparedStatement statementMovieCountry = connection.prepareStatement(SQL_INSERT_MOVIE_DIRECTION);
                 PreparedStatement statementMovieActor = connection.prepareStatement(SQL_INSERT_MOVIE_ACTORS)) {
                connection.setAutoCommit(false);
                checkMovie.setString(1, movie.getTitle());
                checkMovie.setDate(2, Date.valueOf(movie.getReleaseDate()));
                ResultSet rsMovie = checkMovie.executeQuery();
                if (rsMovie.next()) {
                    throw new SQLException("Video library contains this movie");
                } else {
                    statementMovie.setString(1, movie.getTitle());
                    statementMovie.setDate(2, Date.valueOf(movie.getReleaseDate()));
                    statementMovie.executeUpdate();
                    try (ResultSet generatedKeys = statementMovie.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            movie.setId((int) generatedKeys.getLong(1));
                        } else {
                            throw new SQLException("Creating movie failed, no ID obtained.");
                        }
                    }
                }
                for (Actor actor : actors) {
                    actorDAO.insert(actor);
                }
                for (Director director : directors) {
                    directorDAO.insert(director);
                }
                for (Country country : countries) {
                    countryDAO.insert(country);
                }
                insertMovieCountriesLink(movie, countries, statementCountryMovie);
                insertMovieDirectorsLink(movie, directors, statementMovieCountry);
                insertMovieActorsLink(movie, actors, statementMovieActor);
                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("can't insert movie" + e);
        }
    }

    private void insertMovieCountriesLink(Movie movie, List<Country> countries, PreparedStatement statementCountryMovie)
            throws SQLException {
        for (Country country : countries) {
            statementCountryMovie.setInt(1, (int) country.getId());
            statementCountryMovie.setInt(2, (int) movie.getId());
            statementCountryMovie.executeUpdate();
        }
    }

    private void insertMovieDirectorsLink(Movie movie, List<Director> directors, PreparedStatement statementMovieCountry)
            throws SQLException {
        for (Director director : directors) {
            statementMovieCountry.setInt(1, (int) director.getId());
            statementMovieCountry.setInt(2, (int) movie.getId());
            statementMovieCountry.executeUpdate();
        }
    }

    private void insertMovieActorsLink(Movie movie, List<Actor> actors, PreparedStatement statementMovieActor)
            throws SQLException {
        for (Actor actor : actors) {
            statementMovieActor.setInt(1, (int) actor.getId());
            statementMovieActor.setInt(2, (int) movie.getId());
            statementMovieActor.executeUpdate();
        }
    }

    @Override
    public Movie update(Movie entity) {
        return null;
    }

}
