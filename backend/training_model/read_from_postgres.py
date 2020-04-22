import psycopg2
import pandas as pd


class Postgres:
    DATABASE = "movie"
    USER = "postgres"
    PASSWORD = "postgres"
    HOST = "127.0.0.1"
    PORT = "5432"

    def __init__(self):
        self.conn = psycopg2.connect(
            database=self.DATABASE,
            user=self.USER,
            password=self.PASSWORD,
            host=self.HOST,
            port=self.PORT
        )
        self.cursor = self.conn.cursor()
        print(self.conn.closed)
        print("Database connection opened successfully")

    def load_data(self, table_name, column_names=None, schema="public", limit=None):
        if column_names is None:
            if limit is None:
                sql_cmd = "SELECT * FROM {}.{};".format(schema, table_name)
            else:
                sql_cmd = "SELECT * FROM {}.{} limit {};".format(schema, table_name, str(limit))

            data = pd.read_sql(sql_cmd, self.conn)
            print(data.shape)

            return data
        elif column_names is not None:
            if limit is None:
                sql_cmd = "SELECT * FROM {}.{};".format(schema, table_name)
            else:
                sql_cmd = "SELECT * FROM {}.{} limit {};".format(schema, table_name, str(limit))

            data = pd.read_sql(sql_cmd, self.conn)
            print(data.shape)
            return data

        else:
            return None


if __name__ == '__main__':
    postgress = Postgres()
    df = postgress.load_data(table_name='movie')
    df.head(5)
