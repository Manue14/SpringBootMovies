package bad.pals.movies.service;

import bad.pals.movies.model.entities.Movie;
import bad.pals.movies.model.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll() {
        ArrayList<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        return movies;
    }

    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie findByTitle(String title) {
        List<Movie> movies = findAll();
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        return null;
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie update(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }
}
