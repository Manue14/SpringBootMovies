package bad.pals.movies.model.repository;

import bad.pals.movies.model.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
