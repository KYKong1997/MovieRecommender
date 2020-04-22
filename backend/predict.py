import pandas as pd
import joblib
import json
import sys

class MatrixFactorization(object):

    def __init__(self):
        self.algo = joblib.load('model/model.sav')

    @staticmethod
    def get_user_list():
        data = pd.read_csv('data/users.csv')
        return data['userId'].unique()

    

    def predict(self, userId, movies, n=10):
        movies['user_est'] = movies['movieId'].apply(lambda x: self.algo.predict(x, userId)[3])
        movies = movies.sort_values(by=['user_est'], ascending=False)
        return movies.head(n).to_dict(orient="records")
