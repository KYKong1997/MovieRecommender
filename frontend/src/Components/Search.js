import React, {Component} from 'react'

class Search extends Component{

    constructor(){
        super();
        this.handleSubmit = this.handleSubmit.bind(this);
        
    }
    handleSubmit(event){
        
    }
    render(){
        return (
            <form onSubmit={this.handleSubmit} className="search">
                <input type="text" placeholder="Movie title" name="movie_title"></input>
                <button type="submit">Search</button>
            </form>

        );
    }
}

export default Search