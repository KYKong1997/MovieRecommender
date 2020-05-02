import axios from 'axios';



const _movies = [
    {
        Id:0,
        Title: 'Iron Man',
        Year:2008,
        Poster:"https://m.media-amazon.com/images/M/MV5BMTczNTI2ODUwOF5BMl5BanBnXkFtZTcwMTU0NTIzMw@@._V1_SX300.jpg"


    },
    {
        Id:1,
        Title:"Man of Steel",
        Year: 2020,
        Poster: "https://m.media-amazon.com/images/M/MV5BMTk5ODk1NDkxMF5BMl5BanBnXkFtZTcwNTA5OTY0OQ@@._V1_SX300.jpg"

    }

]
export default _movies

export function startLoadingMovies(){

    return (dispatch) =>{
        return axios.get('movie/3').then((data) =>{
            console.log('Data:', data.data)
            dispatch(loadMovies(data.data))
        }).catch((error)=>{
            console.log(error)
        })
        
    }

    

}

export function startLoadingUserRec(userId){
    console.log("User Id in fuinc:",userId)
    return (dispatch) =>{
        return axios.get(`movie/${userId}`).then((data) =>{
            console.log('Data:', data.data)
            dispatch(loadUserRec(data.data))
            
        }).catch((error)=>{
            console.log(error)
        })
        
    }

    

}


export function loadMovies(movies){
    return {
        type:'LOAD_MOVIE',
        movies
    }
}

export function loadUserRec(movies){
    return {
        type:'LOAD_USER_REC',
        movies
    }
}