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
    state ={userId:0}

   
    

    componentDidMount(){
      console.log("User Id",this.state.userId)

      this.props.startLoadingUserRec(this.state.userId)

    }
    
    render(){
        return (
            <div>
              <Header text="Movie">
                
              </Header>
              <Search userId={this.state.userId} {...this.props}></Search>

              <MovieWall {...this.props}></MovieWall>

              
              
            </div>
          );

    }
}

export default Main;
