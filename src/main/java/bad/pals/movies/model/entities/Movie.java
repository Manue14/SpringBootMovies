package bad.pals.movies.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String imgUrl;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
