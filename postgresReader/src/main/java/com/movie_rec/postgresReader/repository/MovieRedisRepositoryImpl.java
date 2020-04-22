package com.movie_rec.postgresReader.repository;

import com.movie_rec.postgresReader.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieRedisRepositoryImpl implements MovieRedisRepository{
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    @Qualifier("listOperations")
    private ListOperations<String, String> ListOps;


    @Override
    public List<String> getMovieListId(String Id) {
        System.out.println(redisTemplate.opsForList().range(Id,0,-1));
        return ListOps.range(Id, 0, -1);
    }
}
