package chapter12;

import chapter12.videolibrary.Actors;
import chapter12.videolibrary.VideoLibraryHelper;
import chapter12.videolibrary.models.Actor;
import chapter12.videolibrary.models.Movie;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Runner {
    public static void main(String[] args) {
//        try {
//            Statement statement = Objects.requireNonNull(ConnectorDB.getConnection()).createStatement();
//            statement.execute("CREATE TABLE actor (Id serial primary key, Name VARCHAR(50)," +
//                    "Surname VARCHAR(50), Birthday DATE)");
//            statement.execute("CREATE TABLE director (Id serial primary key, Name VARCHAR(50)," +
//                    "Surname VARCHAR(50), Birthday DATE)");
//            statement.execute("CREATE TABLE film (Id serial primary key, Name VARCHAR(50), NameActor VARCHAR," +
//                    "Release_data DATE, Country VARCHAR)");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        ArrayList<Actor> actors = new ArrayList<>();
//        actors.add(new Actor("Ivan", "Ivanov", LocalDate.of(1990, 11, 2)));
//        actors.add(new Actor("Kola", "Kolyanov", LocalDate.of (1984, 6, 23)));
//        ArrayList<Movie> movies = new ArrayList<>();
//        movies.add(new Movie("Film1",  LocalDate.of(2_000, 2, 23), "USA"));
//
//
//        VideoLibraryHelper helper = null;
//        PreparedStatement statement = null;
//        try {
//            helper = new VideoLibraryHelper();
//            statement = helper.getPreparedStatementActor();
//            for (Actor actor : actors) {
//                helper.insertActor(statement, actor);
//            }
//            statement = helper.getPreparedStatementFilm();
//            for (Movie movie : movies) {
//                helper.insertFilm(statement, movie);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            assert helper != null;
//            helper.closeStatement(statement);
//        }
        try {
            ConnectorDB.getConnection();
            VideoLibrary videoLibrary = new VideoLibrary();
            videoLibrary.createTablesAndForeignKeys();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}