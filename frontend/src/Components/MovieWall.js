import React, {Component} from 'react'
import Movie from './Movie'

function MovieWall(props){
    return <div>
        <div>
            {props.movies.sort(function(x,y){
                return y.Id - x. Id
            }).map(
                (movie, index) => <Movie key={index} movie={movie} {...props}></Movie>
            )}>
        </div>
    </div>
}

export default MovieWall