package bad.pals.movies.service;

import bad.pals.movies.model.entities.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(Long id);
    Movie findByTitle(String title);
    Movie save(Movie movie);
    Movie update(Movie movie);
    void deleteById(Long id);
    void delete(Movie movie);
}
