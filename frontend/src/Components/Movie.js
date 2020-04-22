import React, {Component}  from 'react'

const LOADING_ERROR_IMAGE = "https://pbs.twimg.com/media/DrgxjM8W4AEdZdV.jpg";

class Movie extends Component{
    constructor(){
        super()
        
    }

    render(){
        const movie = this.props.movie
        return (
            <div>
                <h2>{Movie.title}</h2>
                <div>
                    <img
                    width="200"
                    alt={`The movie titled:${movie.title}`}
                    src={movie.Poster}
                    >

                    </img>
                </div>
                <p>{movie.Year}</p>
            </div>

        );
    }
}

export default Movie