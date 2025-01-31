package bad.pals.movies.model.repository;

import bad.pals.movies.model.entities.Vote;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Long> {
}
