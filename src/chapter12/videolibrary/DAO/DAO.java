package chapter12.videolibrary.DAO;

import chapter12.videolibrary.models.Entity;

import java.util.List;

public abstract class DAO<K, T extends Entity> {
        public abstract List<T> findAll();
        public abstract T findEntityById(K id);
        public abstract boolean delete(K id);
        public abstract boolean delete(T entity);
        public abstract boolean create(T entity);
        public abstract T update(T entity);
    }

