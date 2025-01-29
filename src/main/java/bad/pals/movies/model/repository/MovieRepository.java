package bad.pals.movies.model.repository;

import bad.pals.movies.model.entities.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
