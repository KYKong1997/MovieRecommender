package com.movie_rec.postgresReader.Controller;

import com.movie_rec.postgresReader.model.Movie;
import com.movie_rec.postgresReader.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movie")
    public Page<Movie> getMovies(Pageable pageable){
        return movieRepository.findAll(pageable);
    }

}
