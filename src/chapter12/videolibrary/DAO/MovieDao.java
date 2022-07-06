package chapter12.videolibrary.DAO;

import chapter12.videolibrary.models.Entity;
import chapter12.videolibrary.models.Movie;

import java.util.List;

public class MovieDao extends DAO<Integer, Movie>{

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public Movie findEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
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
