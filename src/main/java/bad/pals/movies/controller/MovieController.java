package bad.pals.movies.controller;

import bad.pals.movies.model.entities.Movie;
import bad.pals.movies.model.entities.User;
import bad.pals.movies.model.entities.Vote;
import bad.pals.movies.model.entities.VoteForm;
import bad.pals.movies.service.MovieService;
import bad.pals.movies.service.UserService;
import bad.pals.movies.service.VoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {
    private final MovieService movieService;
    private final VoteService voteService;
    private final UserService userService;

    @Autowired
    public MovieController(MovieService movieService, VoteService voteService, UserService userService) {
        this.movieService = movieService;
        this.voteService = voteService;
        this.userService = userService;
    }

    @GetMapping("/movie/list")
    public String list(Model model) {
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("voteForm", new VoteForm());
        return "movieList";
    }

    @PostMapping("/movie/vote")
    public String vote(@ModelAttribute("voteForm") @Valid VoteForm voteForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "movieList";
        }
        User user = userService.findByEmail(voteForm.getUserEmail());
        if (voteService.findByUser(user) != null) {
            //bindingResult.rejectValue("userEmail", "user.exists");
            System.out.println("User already voted");
            return "redirect:/movie/list";
        }
        Movie movie = movieService.findById(voteForm.getMovieId());
        if (user != null) {
            Vote vote = new Vote(movie, user);
            voteService.save(vote);
        } else {
            System.out.println("User not found");
        }
        return "redirect:/movie/list";
    }
}
