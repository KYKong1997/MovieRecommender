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
                <h2>{movie.title}</h2>
                <div class="container">
                <div>
                    <img
                    width="100"
                    height="100px"
                    alt={`The movie titled:${movie.title}`}
                    src={movie.movie_poster}
                    >

                    </img>
                    <p>{movie.Year}</p>
                </div>
                </div>
                
            </div>

        );
    }
}

export default Movie