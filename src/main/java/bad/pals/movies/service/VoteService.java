package bad.pals.movies.service;

import bad.pals.movies.model.entities.User;
import bad.pals.movies.model.entities.Vote;

import java.util.List;

public interface VoteService {
    List<Vote> findAll();
    Vote findById(Long id);
    Vote findByUser(User user);
    Vote save(Vote vote);
    Vote update(Vote vote);
    void deleteById(Long id);
    void delete(Vote vote);
}
