package chapter12.videolibrary.DAO;

import chapter12.videolibrary.models.Country;

import java.sql.*;
import java.util.List;

public class CountryDAO extends DAO<Country> {
    private final static String SQL_INSERT_COUNTRY = "INSERT INTO countries(name) VALUES(?)";
    private final static String SQL_CHECK_COUNTRY_ID = "SELECT id FROM countries WHERE name = ?";

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
        try (connection;
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
                int Id = psInsertActor.executeUpdate();
                try (ResultSet generatedKeys = psInsertActor.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        country.setId((int) generatedKeys.getLong(1));
                    } else {
                        throw new SQLException("Creating country failed, no ID obtained.");
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
    public Country update(Country entity) {
        return null;
    }
}
