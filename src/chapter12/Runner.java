package chapter12;

import chapter12.videolibrary.DAO.ActorDAO;
import chapter12.videolibrary.DAO.CountryDAO;
import chapter12.videolibrary.DAO.DirectorDAO;
import chapter12.videolibrary.DAO.MovieDao;
import chapter12.videolibrary.initializer.TestMovie;
import chapter12.videolibrary.models.Movie;
import chapter12.videolibrary.tableresource.VideoLibraryInitializer;

import java.sql.SQLException;


public class Runner {
    public static void main(String[] args) throws SQLException {

//        try {
//            VideoLibraryInitializer videoLibraryInitializer = new VideoLibraryInitializer();
//            videoLibraryInitializer.createTablesAndForeignKeys();
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        Movie movie = TestMovie.getTestMovie();
        MovieDao movieDao = new MovieDao();
//        movieDao.insert(movie);
        CountryDAO countryDAO = new CountryDAO();
        System.out.println(countryDAO.findAllInMovie(movie));
        movieDao.deleteIfReleaseMoreYearsAgo(7);
        ActorDAO actorDAO = new ActorDAO();
        DirectorDAO directorDAO = new DirectorDAO();
        System.out.println(directorDAO.findAllInMovie(movie));
        System.out.println(actorDAO.findAllInMovie(movie));
//        movieDao.deleteIfReleaseMoreYearsAgo(5);
        System.out.println(actorDAO.findAllIfMovieQuantityOver(0));
        System.out.println(actorDAO.findAllIfDirector());
//        movieDao.delete(movie);
        System.out.println(movieDao.findMoviesReleaseLastYearAndNow());
    }
}

