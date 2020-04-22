package com.movie_rec.postgresReader.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="rating")
public class Rating extends AuditModel implements Serializable {

    private long usermovieid;




    private Movie movie;


    private User user;


    @Id
    @GeneratedValue(generator = "usermovie_generator")
    @SequenceGenerator(
            name = "usermovie_generator",
            sequenceName = "usermovie_sequence",
            initialValue = 1
    )
    @Column(name = "usermovieid")
    public long getUsermovieid() {
        return usermovieid;
    }

    public void setUsermovieid(long usermovieid) {
        this.usermovieid = usermovieid;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movieid", nullable = false)
    @OnDelete(action =  OnDeleteAction.CASCADE)
    @JsonIgnore
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
