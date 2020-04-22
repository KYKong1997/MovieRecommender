from collections import defaultdict

import pandas as pd
import redis
from surprise import Reader, Dataset

from training_model.read_from_postgres import Postgres
from training_model.training import Training


def get_top_n(predictions, n=10):
    '''Return the top-N recommendation for each user from a set of predictions.

    Args:
        predictions(list of Prediction objects): The list of predictions, as
            returned by the test method of an algorithm.
        n(int): The number of recommendation to output for each user. Default
            is 10.

    Returns:
    A dict where keys are user (raw) ids and values are lists of tuples:
        [(raw item id, rating estimation), ...] of size n.
    '''

    # First map the predictions to each user.
    top_n = defaultdict(list)
    for uid, iid, true_r, est, _ in predictions:
        top_n[uid].append((iid, est))

    # Then sort the predictions for each user and retrieve the k highest ones.
    for uid, user_ratings in top_n.items():
        user_ratings.sort(key=lambda x: x[1], reverse=True)
        top_n[uid] = user_ratings[:n]

    return top_n


class Prediction:
    def __init__(self, postgres=None):
        if postgres is None:
            self.postgres = Postgres()
        else:
            self.postgres = postgres
        self.trainer = Training(self.postgres)
        self.redis_client = redis.Redis(host='localhost', port=6379)

    def get_user_data(self) -> pd.DataFrame:
        data = self.postgres.load_data('users')
        return data

    def get_movie_data(self) -> pd.DataFrame:
        data = self.postgres.load_data('movie')
        return data[['movieid']]

    def get_rating_data(self, limit=None) -> pd.DataFrame:
        dataset = self.postgres.load_data('ratings', limit=limit)

        return dataset

    @staticmethod
    def cross_join(users, movies) -> pd.DataFrame:
        new_df = users.assign(foo=1).merge(movies.assign(foo=1)).drop('foo', 1)
        return new_df

    def batch_prediction(self) -> pd.DataFrame:
        pipe = self.redis_client.pipeline()
        print('Data Generating..........')



        ratings = self.get_rating_data()

        print('Data generated')
        model = self.trainer.transform(ratings)

        reader = Reader(rating_scale=(1, 5))
        data = Dataset.load_from_df(ratings[['userid', 'movieid', 'rating']], reader)
        data = data.build_full_trainset()
        data = data.build_testset()
        predictions = model.test(testset=data)

        top_n = get_top_n(predictions, 10)
        a = 0
        # Print the recommended items for each user
        for uid, user_ratings in top_n.items():
            print(uid, [iid for (iid, _) in user_ratings])
            pipe.rpush(int(uid), *[iid for (iid, _) in user_ratings])
            a = a+1
        results = pipe.execute()
        print(a)
        print(ratings['userid'].value_counts())


    def write_to_redis(self, df):
        pipe = self.redis_client.pipeline()
        for i in range(len(df['userid'])):
            pipe.zadd(df['userid'][i], df['movieid'][i])
        results = pipe.execute()
        print(results)


if __name__ == '__main__':
    predictor = Prediction()
    predictor.batch_prediction()

