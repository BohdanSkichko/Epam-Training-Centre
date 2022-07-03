package chapter12;

import chapter12.videolibrary.Actor;
import chapter12.videolibrary.Film;
import chapter12.videolibrary.VideoLibraryHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Runner {
    public static void main(String[] args) {
        try {
            Statement statement = Objects.requireNonNull(ConnectorDB.getConnection()).createStatement();
            statement.executeUpdate("CREATE TABLE actor (Id serial primary key, Name VARCHAR(50)," +
                    "Surname VARCHAR(50), Birthday DATE)");
            statement.executeUpdate("CREATE TABLE director (Id serial primary key, Name VARCHAR(50)," +
                    "Surname VARCHAR(50), Birthday DATE)");
            statement.executeUpdate("CREATE TABLE film (Id serial primary key, Name VARCHAR(50), nameActor VARCHAR," +
                    "Release DATE, Country VARCHAR)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Actor> actors = new ArrayList<>();
        actors.add(new Actor("Ivan", "Ivanov", new Date(90, 11, 2)));
        actors.add(new Actor("Kola", "Kolyanov", new Date(84, 6, 23)));
        ArrayList<Film> films = new ArrayList<>();
        films.add(new Film("Film1", actors, new Date(100, 2, 23), "USA"));


        VideoLibraryHelper helper = null;
        PreparedStatement statement = null;
        try {
            helper = new VideoLibraryHelper();
            statement = helper.getPreparedStatementActor();
            for (Actor actor : actors) {
                helper.insertActor(statement, actor);
            }
            statement = helper.getPreparedStatementFilm();
            for (Film film : films) {
                helper.insertFilm(statement, film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert helper != null;
            helper.closeStatement(statement);
        }
    }
}