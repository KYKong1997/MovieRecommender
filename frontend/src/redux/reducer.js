import _movies from './actions'
import {combineReducers} from 'redux'

function movies(state = _movies, action){
    console.log("Action Type:", action.type)
    
    switch(action.type){
        case 'LOAD_MOVIE': return action.movies
        case 'LOAD_USER_REC': return action.movies
        default: return state
    }
}

const rootReducer = combineReducers({movies})

export default rootReducer