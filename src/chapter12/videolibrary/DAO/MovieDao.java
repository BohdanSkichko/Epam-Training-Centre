package chapter12.videolibrary.DAO;

import chapter12.DBConnector;
import chapter12.videolibrary.models.Movie;
import org.postgresql.shaded.com.ongres.scram.client.ScramSession;

import java.beans.Statement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieDao extends DAO<Movie> {
    protected Connection connection;
    public static final String SQL_SELECT_ALL_MOVIE = "SELECT * FROM movies";
    public static final String SQL_SELECT_ALL_YEAR = "SELECT * FROM movies where release_data between ";

    public MovieDao(Connection connection) {
        super(connection);
    }

    public List<Movie> findMoviesBetweenYears(Date afterYear, Date thisYear) throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(SQL_SELECT_ALL_YEAR
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
        } finally {
            connection.close();
        }
        return movies;
    }

    @Override
    public List<Movie> findAll() throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(SQL_SELECT_ALL_MOVIE);
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setReleaseDate(resultSet.getDate("release_data"));
                movies.add(movie);
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            connection.close();
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
    public boolean create(Movie entity) {
        return false;
    }

    @Override
    public Movie update(Movie entity) {
        return null;
    }

}
