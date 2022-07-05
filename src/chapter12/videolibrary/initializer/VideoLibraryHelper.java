package chapter12.videolibrary;

import chapter12.ConnectorDB;
import chapter12.videolibrary.models.Actor;
import chapter12.videolibrary.models.Movie;

import java.sql.*;


public class VideoLibraryHelper {
    private final static String SQL_INSERT_ACTOR =
            "INSERT INTO actor(name, surname, birthday) VALUES(?,?,?)";
    private final static String SQL_INSERT_FILM =
            "INSERT INTO film(name, array, releaseDate, country) VALUES(?,?,?,?)";
    private final Connection connect;

    public VideoLibraryHelper() throws SQLException {
        connect = ConnectorDB.getConnection();
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
            ps = connect.prepareStatement(SQL_INSERT_FILM);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
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

    public boolean insertFilm(PreparedStatement ps, Movie movie) {
        boolean flag = false;
        try {
            ps.setString(1, movie.getName());
//            ps.setArray(2, (Array) film.getActors());
            ps.setDate(3, Date.valueOf(movie.getReleaseDate()));
            ps.setString(4, movie.getCountry());
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

