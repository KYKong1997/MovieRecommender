from surprise import Dataset, Reader, SVD, accuracy
from surprise.model_selection import train_test_split, cross_validate
import pandas as pd
from training_model.read_from_postgres import Postgres
import pickle
import time

class Training:
    def __init__(self, postgres=None):
        if postgres is None:
            self.postgres = Postgres()
        else:
            self.postgres = postgres





    def save_model(self, model):
        print('Saving model')
        epoch = time.mktime(datetime.datetime.now().timetuple())
        filename = 'model_{}.pkl'.format(str(epoch))
        dir = '../model/'+filename
        with open(dir, 'wb+') as f:
            pickle.dump(model, f)
            print('Model Saved')


    def transform(self, dataset):


        reader = Reader(rating_scale=(1,5))
        data = Dataset.load_from_df(dataset[['userid','movieid','rating']], reader)
        train, test = train_test_split(data, test_size=0.3)

        algorithm = SVD()
        print('Training Model...........')
        algorithm.fit(train)

        y_test = algorithm.test(test)

        print("Test Accuracy:",accuracy.rmse(y_test))
        print('Model training finished.')
        # self.save_model(algorithm)
        return algorithm






if __name__ == '__main__':
    train_model = Training()
    train_model.transform()