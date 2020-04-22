package com.movie_rec.postgresReader.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie extends AuditModel{

    private long movieId;
    private String title;
    private String genres;
    private Set<Rating> rating;
    private String movie_poster;
    private String movie_url;



    public Movie(){

    }

    public Movie(long movieId, String title, String genres) {
        this.movieId = movieId;
        this.title = title;
        this.genres = genres;
    }

    @Id
    @GeneratedValue(generator = "movie_generator")
    @SequenceGenerator(
            name = "movie_generator",
            sequenceName = "movie_sequence",
            initialValue = 1
    )
    @Column(name = "movieid")
    public long getMovieId(){
        return movieId;
    }
    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    @NotBlank
    @Size(min = 3, max = 1000)
    @Column(name = "title")
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    @Column(name = "genres", nullable = false)
    public String getGenres(){
        return genres;
    }
    public void setGenres(String genres){
        this.genres = genres;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy="movie")
    public Set<Rating> getRating() {
        return rating;
    }
    public void setRating(Set<Rating> rating) {
        this.rating = rating;
    }

    @Column(name = "movie_poster", nullable = false)
    public String getMovie_poster() {
        return movie_poster;
    }

    public void setMovie_poster(String movie_poster) {
        this.movie_poster = movie_poster;
    }

    @Column(name = "movie_url", nullable = false)
    public String getMovie_url() {
        return movie_url;
    }

    public void setMovie_url(String movie_url) {
        this.movie_url = movie_url;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", genres='" + genres + '\'' +
                '}';
    }
}
