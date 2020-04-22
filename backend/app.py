from flask import Flask
from flask_restful import Resource, Api, reqparse
from predict import *


class Recommendation:
    def __init__(self):
        self.movies = pd.read_csv('data/movies.csv')
        self.matrix = MatrixFactorization()




    def get_user_recommendation(self, userId, n):
        result = self.matrix.predict(userId,self.movies,n)
        return result

class UserBasis(Resource):
    def parsing_args(self):
        self.parser = reqparse.RequestParser()
        self.parser.add_argument('users',required=False, help='movie title')
        self.parser.add_argument(
            'limit', required=False, help='N in top N films'
        )
        return self.parser.parse_args()

    def get(self, userId):
        args = self.parsing_args()

        if args['limit'] is None:
            n = 10

        else:
            n = int(args['limit'])



        output = ex.get_user_recommendation(int(userId), int(n))
        return output

app = Flask(__name__)
api = Api(app)

api.add_resource(UserBasis, '/users/<userId>')

if __name__ == '__main__':
    ex = Recommendation()

    app.run(debug=True, host='0.0.0.0' ,port=8081)
