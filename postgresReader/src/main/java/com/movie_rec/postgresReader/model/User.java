package com.movie_rec.postgresReader.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User extends AuditModel{
    private long userId;
    private ArrayList<Rating> rating;

    public User(long userId) {
        this.userId = userId;
    }
    @Id
    @GeneratedValue(generator = "user_generator")
    @SequenceGenerator(
            name="user_generator",
            sequenceName = "user_sequence",
            initialValue = 1
    )
    @Column(name = "userid")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy="user")
    public List<Rating> getRating() {
        return rating;
    }
    public void setRating(ArrayList<Rating> rating) {
        this.rating = rating;
    }
}
