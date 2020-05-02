import React, {Component} from 'react'

class Search extends Component{

    constructor(){
        super();
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleUserRec = this.handleUserRec.bind(this);
        
    }
    handleSubmit(event){

        
        

    }
    handleUserRec(event){
        event.preventDefault();
        const userId = event.target.elements.userId.value
        console.log("User ID in rec:", userId)
        this.setState({userId: userId}, ()=>{
            console.log("User Id after set state:", this.state.userId);
            this.props.startLoadingUserRec(this.state.userId);

        });


    }
    render(){
        return (
            <div>
                
                <form onSubmit={this.handleUserRec} className="search">
                    <input type="text" placeholder="user Id" name="userId"></input>
                    <button type="submit">Get User Recommendation</button>
                </form>
            </div>
            

        );
    }
}

export default Search