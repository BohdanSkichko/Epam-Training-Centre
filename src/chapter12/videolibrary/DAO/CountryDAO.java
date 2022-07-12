package chapter12.videolibrary.DAO;

import chapter12.videolibrary.models.Country;
import chapter12.videolibrary.models.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO extends DAO<Country> {
    private final static String SQL_FIND_ALL_IN_MOVIE = "SELECT name FROM countries c " +
            "JOIN country_movie_link cml ON c.id = cml.country_id WHERE movie_id = ";
    private final static String SQL_INSERT_COUNTRY = "INSERT INTO countries(name) VALUES(?)";
    private final static String SQL_CHECK_COUNTRY_ID = "SELECT id FROM countries WHERE name = ?";


    public List<Country> findAllInMovie(Movie movie) throws SQLException {
        List<Country> countries = new ArrayList<>();
        MovieDao movieDao = new MovieDao();
        int id = movieDao.getId(movie);
        Connection connection = DBConnector.getConnection();
        assert connection != null;
        Statement statement = connection.createStatement();
        ResultSet rsCountry = statement.executeQuery(SQL_FIND_ALL_IN_MOVIE + id);
        try (connection;
             statement;
             rsCountry) {
            while (rsCountry.next()) {
                Country country = new Country();
                country.setName(rsCountry.getString(1));
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public List<Country> findAll() throws SQLException {
        return null;
    }

    @Override
    public Country findEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(Country country) {
        return false;
    }

    @Override
    public void insert(Country country) throws SQLException {
        Connection connection = DBConnector.getConnection();
        try (connection) {
            assert connection != null;
            try (
                 PreparedStatement psCheckCountry = connection.prepareStatement(SQL_CHECK_COUNTRY_ID);
                 PreparedStatement psInsertActor = connection.prepareStatement(SQL_INSERT_COUNTRY, Statement.RETURN_GENERATED_KEYS)) {
                connection.setAutoCommit(false);
                psCheckCountry.setString(1, country.getName());
                ResultSet rsActor = psCheckCountry.executeQuery();
                if (rsActor.next()) {
                    country.setId(rsActor.getInt(1));
                    System.out.println("Video library contains this country");
                } else {
                    psInsertActor.setString(1, country.getName());
                    psInsertActor.executeUpdate();
                    try (ResultSet generatedKeys = psInsertActor.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            country.setId((int) generatedKeys.getLong(1));
                        } else {
                            throw new SQLException("Creating country failed, no ID obtained.");
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
    public Country update(Country entity) {
        return null;
    }
}
