import React, {Component} from 'react'

class Header extends Component{
    render(){
        return (
            <header className="App-header">{this.props.text}</header>
        )
    }
}

export default Header;
