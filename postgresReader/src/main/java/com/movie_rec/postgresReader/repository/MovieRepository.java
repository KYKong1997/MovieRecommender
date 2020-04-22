package com.movie_rec.postgresReader.repository;

import com.movie_rec.postgresReader.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
