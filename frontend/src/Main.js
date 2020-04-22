import React, {Component} from 'react';
import logo from './logo.svg';
import Header from './Components/header'
import Search from './Components/Search'
import MovieWall from './Components/MovieWall'



const MOVIE_API_URL = "https://www.omdbapi.com/?s=man&apikey=4a3b711b"

class Main extends Component{
    constructor(){
        super()
    }

    componentDidMount(){

      this.props.startLoadingMovies()

    }
    render(){
        return (
            <div>
              <Header text="Movie">
                
              </Header>
              <Search>
        
              </Search>

              <MovieWall {...this.props}></MovieWall>

              
              
            </div>
          );

    }
}

export default Main;
