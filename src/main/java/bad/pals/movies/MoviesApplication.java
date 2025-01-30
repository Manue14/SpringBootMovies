package bad.pals.movies;

import bad.pals.movies.model.entities.Movie;
import bad.pals.movies.model.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(MovieRepository movieRepository) {
		return args -> {
			movieRepository.save(new Movie("Arrival", "/imgs/arrival.jpg"));
			movieRepository.save(new Movie("Blade Runner 2049", "/imgs/runner.jpg"));
			movieRepository.save(new Movie("The Big Lebowski", "/imgs/lebowski.jpg"));
		};
	}

}
