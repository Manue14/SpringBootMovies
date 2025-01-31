package bad.pals.movies.service;

import bad.pals.movies.model.entities.Movie;
import bad.pals.movies.model.entities.User;
import bad.pals.movies.model.entities.Vote;
import bad.pals.movies.model.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService{
    private final VoteRepository voteRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public List<Vote> findAll() {
        ArrayList<Vote> votes = new ArrayList<>();
        voteRepository.findAll().forEach(votes::add);
        return votes;
    }

    public Vote findById(Long id) {
        return voteRepository.findById(id).orElse(null);
    }

    @Override
    public Vote findByUser(User user) {
        List<Vote> votes = findAll();;
        if (votes.isEmpty()) return null;
        for (Vote vote : votes) {
            System.out.println(vote.getUser());
            if (vote.getUser().equals(user)) {
                return vote;
            }
        }
        return null;
    }

    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }

    public Vote update(Vote vote) {
        return voteRepository.save(vote);
    }

    public void deleteById(Long id) {
        voteRepository.deleteById(id);
    }

    public void delete(Vote vote) {
        voteRepository.delete(vote);
    }
}
