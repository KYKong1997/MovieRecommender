import React, { Component } from 'react';
import logo from './logo.svg';
import Header from './Components/header'
import Search from './Components/Search'
import { withRouter } from 'react-router'
import { bindActionCreators } from 'redux'
import Main from './Main'
import * as actions from './redux/actions'
import { connect } from 'react-redux';


function mapStateToProps(state){
  return {
    movies:state.movies
  }
}

function mapDispatchToProps(dispatch){
  return bindActionCreators(actions, dispatch)
}

const App = withRouter(connect(mapStateToProps, mapDispatchToProps)(Main))

export default App;
