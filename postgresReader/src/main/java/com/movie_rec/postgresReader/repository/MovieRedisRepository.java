package com.movie_rec.postgresReader.repository;

import com.movie_rec.postgresReader.model.Movie;

import java.util.List;

public interface MovieRedisRepository {

    List<String> getMovieListId(String Id);

}
