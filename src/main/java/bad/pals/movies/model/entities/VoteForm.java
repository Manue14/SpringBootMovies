package bad.pals.movies.model.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VoteForm {
    @NotBlank(message = "An user email must be introduced")
    private String userEmail;

    @NotNull(message = "A movie must be selected")
    private Long movieId;

    public VoteForm() {}

    public String getUserEmail() {
        return userEmail;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
