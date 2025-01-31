package bad.pals.movies.model.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String imgUrl;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "movie")
    private Set<Vote> votes = new HashSet<>();

    public Movie() {}

    public Movie(String title, String imgUrl) {
        this.title = title;
        this.imgUrl = imgUrl;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void addVote(Vote vote) {
        votes.add(vote);
    }
}
