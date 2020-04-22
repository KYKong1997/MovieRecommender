# Use official Python Runtime as parent image
FROM python:3.6

# Adding backend directory to make it consistent across devices
RUN mkdir -p /app/Movie_Recommender/backend
WORKDIR /app/Movie_Recommender/backend

# Install Python dependencies
COPY requirements.txt /app/Movie_Recommender/backend
RUN pip3 install --upgrade pip -r requirements.txt

COPY . /app/Movie_Recommender/backend

ENTRYPOINT ["python3.6"]
CMD ["app.py"]
