package com.movie_rec.postgresReader.Controller;

import com.movie_rec.postgresReader.model.Movie;
import com.movie_rec.postgresReader.repository.MovieRedisRepository;
import com.movie_rec.postgresReader.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieRedisRepository movieRedisRepository;

    @GetMapping("/movie")
    public Page<Movie> getMovies(Pageable pageable){
        return movieRepository.findAll(pageable);
    }

    @RequestMapping(value = "/movie/{Id}", method = RequestMethod.GET)
    public List<Movie> getMoviesUser(@PathVariable String Id){
        List<String> list_pred = movieRedisRepository.getMovieListId(Id);
        List<Long> list_pred_long = new ArrayList<>();
        for(String s : list_pred) list_pred_long.add(Long.parseLong(s));
        return movieRepository.findAllById(list_pred_long);

    }

}
