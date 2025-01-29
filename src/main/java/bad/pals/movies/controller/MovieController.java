package bad.pals.movies.controller;

import bad.pals.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movie/list")
    public String list(Model model) {
        model.addAttribute("movies", movieService.findAll());
        return "movieList";
    }
}
