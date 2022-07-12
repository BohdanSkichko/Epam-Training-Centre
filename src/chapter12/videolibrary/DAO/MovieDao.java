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
    private final ActorDAO actorDAO = new ActorDAO();
    private final DirectorDAO directorDAO = new DirectorDAO();
    private final CountryDAO countryDAO = new CountryDAO();

    private final static String SQL_DELETE_MOVIE_ID = "DELETE FROM movies WHERE id = ?";
    private final static String SQL_DELETE_MOVIE_ACTOR_ID = "DELETE FROM movie_actors WHERE movie_id = ?";
    private final static String SQL_DELETE_MOVIE_DIRECTION_ID = "DELETE FROM movie_direction WHERE movie_id = ?";
    private final static String SQL_DELETE_MOVIE_COUNTRY_ID = "DELETE FROM country_movie_link WHERE movie_id = ?";
    private final static String SQL_DELETE_MOVIE_RELEASE_DATE = "DELETE FROM movies WHERE release_date >";

    private final static String SQL_GET_MOVIE_ID = "SELECT id FROM movies WHERE title = ? and release_date = ?";

    private final static String SQL_INSERT_COUNTRY_MOVIE_LINK = "INSERT INTO country_movie_link(country_id, movie_id) VALUES(?,?)";
    private final static String SQL_INSERT_MOVIE_DIRECTION = "INSERT INTO movie_direction(director_id, movie_id) VALUES(?,?)";
    private final static String SQL_INSERT_MOVIE_ACTORS = "INSERT INTO movie_actors(actor_id, movie_id) VALUES(?,?)";
    private final static String SQL_INSERT_MOVIE = "INSERT INTO movies(title, release_date) VALUES(?,?)";

    private final static String SQL_CHECK_MOVIE_ID = "SELECT id FROM movies WHERE title = ? AND release_date = ?";

    private final static String SQL_SELECT_ALL_MOVIE = "SELECT * FROM movies";
    private final static String SQL_SELECT_ALL_YEAR = "SELECT * FROM movies WHERE release_date BETWEEN ";


    public List<Movie> findMoviesBetweenYears(LocalDate afterYear, LocalDate thisYear) throws SQLException {
        List<Movie> movies = new ArrayList<>();
        List<Director> directors;
        List<Actor> actors;
        List<Country> countries;
        Connection connection = DBConnector.getConnection();
        assert connection != null;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_YEAR
                + "'" + afterYear + "'" + " and " + "'" + thisYear + "'");

        try (connection;
             statement;
             resultSet) {
            connection.setAutoCommit(false);
            while (resultSet.next()) {

                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setReleaseDate(resultSet.getDate("release_date"));

                directors = directorDAO.findAllInMovie(movie);
                for (Director director : directors) {
                    movie.addDirector(director);
                }

                actors = actorDAO.findAllInMovie(movie);
                for (Actor actor : actors) {
                    movie.addActor(actor);
                }

                countries = countryDAO.findAllInMovie(movie);
                for (Country country : countries) {
                    movie.addCountry(country);
                }
                movies.add(movie);
            }
            connection.commit();
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        }
        return movies;
    }

    @Override
    public List<Movie> findAll() throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        assert connection != null;
        Statement statement = connection.createStatement();
        List<Director> directors;
        List<Actor> actors;
        List<Country> countries;
        ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_MOVIE);
        try (connection;
             statement;
             resultSet) {
            connection.setAutoCommit(false);
            while (resultSet.next()) {

                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setReleaseDate(resultSet.getDate("release_date"));
                DirectorDAO directorDAO = new DirectorDAO();

                directors = directorDAO.findAllInMovie(movie);
                for (Director director : directors) {
                    movie.addDirector(director);
                }

                ActorDAO actorDAO = new ActorDAO();
                actors = actorDAO.findAllInMovie(movie);
                for (Actor actor : actors) {
                    movie.addActor(actor);
                }
                CountryDAO countryDAO = new CountryDAO();
                countries = countryDAO.findAllInMovie(movie);
                for (Country country : countries) {
                    movie.addCountry(country);
                }
                movies.add(movie);
            }
            connection.commit();
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
    public boolean delete(int id) throws SQLException {
        Connection connection = DBConnector.getConnection();
        try (connection) {
            assert connection != null;
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
        List<Movie> movies = findAll();
        for (Movie movie : movies) {
            if (LocalDate.now().getYear() - movie.getRelease().getYear() > quantityYears) {
                delete(getId(movie));
            }
        }
    }

    public int getId(Movie movie) {
        Connection connection = DBConnector.getConnection();
        try (connection) {
            assert connection != null;
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
            assert connection != null;
            try (PreparedStatement checkMovie = connection.prepareStatement(SQL_CHECK_MOVIE_ID);
                 PreparedStatement statementMovie = connection.prepareStatement(SQL_INSERT_MOVIE,
                         Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement statementCountryMovie = connection.prepareStatement(SQL_INSERT_COUNTRY_MOVIE_LINK);
                 PreparedStatement statementMovieCountry = connection.prepareStatement(SQL_INSERT_MOVIE_DIRECTION);
                 PreparedStatement statementMovieActor = connection.prepareStatement(SQL_INSERT_MOVIE_ACTORS)) {
                connection.setAutoCommit(false);
                for (Actor actor : actors) {
                    actorDAO.insert(actor);
                }
                for (Director director : directors) {
                    directorDAO.insert(director);
                }
                for (Country country : countries) {
                    countryDAO.insert(country);
                }
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
                for (Country country : countries) {
                    statementCountryMovie.setInt(1, country.getId());
                    statementCountryMovie.setInt(2, movie.getId());
                    statementCountryMovie.executeUpdate();
                }
                for (Director director : directors) {
                    statementMovieCountry.setInt(1, director.getId());
                    statementMovieCountry.setInt(2, movie.getId());
                    statementMovieCountry.executeUpdate();
                }
                for (Actor actor : actors) {
                    statementMovieActor.setInt(1, actor.getId());
                    statementMovieActor.setInt(2, movie.getId());
                    statementMovieActor.executeUpdate();
                }
                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Movie update(Movie entity) {
        return null;
    }

}
