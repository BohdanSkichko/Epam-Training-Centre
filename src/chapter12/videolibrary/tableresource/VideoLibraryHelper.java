package chapter12.videolibrary.tableresource;

import chapter12.videolibrary.DAO.DBConnector;
import chapter12.videolibrary.models.Actor;
import chapter12.videolibrary.models.Country;
import chapter12.videolibrary.models.Director;
import chapter12.videolibrary.models.Movie;

import java.sql.*;


public class VideoLibraryHelper {
    private final static String SQL_INSERT_ACTOR =
            "INSERT INTO actors(name, surname, birthday) VALUES(?,?,?)";
    private final static String SQL_INSERT_MOVIE =
            "INSERT INTO movies(title, release_data) VALUES(?,?)";
    private final static String SQL_INSERT_DIRECTOR =
            "INSERT INTO directors(name, surname, birthday) VALUES(?,?,?)";
    private final static String SQL_INSERT_COUNTRY =
            "INSERT INTO countries(name) VALUES(?)";
    private final Connection connect;

    public VideoLibraryHelper() throws SQLException {
        connect = DBConnector.getConnection();
    }
    public PreparedStatement getPreparedStatementCountry() {
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(SQL_INSERT_COUNTRY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    public PreparedStatement getPreparedStatementActor() {
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(SQL_INSERT_ACTOR);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public PreparedStatement getPreparedStatementFilm() {
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(SQL_INSERT_MOVIE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    public PreparedStatement getPreparedStatementDirector() {
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(SQL_INSERT_DIRECTOR);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public boolean insertCountry(PreparedStatement ps, Country country) {
        boolean flag = false;
        try {
            ps.setString(1, country.getName());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insertActor(PreparedStatement ps, Actor actor) {
        boolean flag = false;
        try {
            ps.setString(1, actor.getName());
            ps.setString(2, actor.getSurname());
            ps.setDate(3, Date.valueOf(actor.getBirthday()));
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insertMovie(PreparedStatement ps, Movie movie) {
        boolean flag = false;
        try {
            ps.setString(1, movie.getTitle());
            ps.setDate(2, Date.valueOf(movie.getReleaseDate()));
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public boolean insertDirector(PreparedStatement ps, Director director) {
        boolean flag = false;
        try {
            ps.setString(1, director.getName());
            ps.setString(2, director.getSurname());
            ps.setDate(3, Date.valueOf(director.getBirthday()));
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public void closeStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

