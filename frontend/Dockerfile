FROM node

WORKDIR /app/Movie_Recommender/frontend

COPY package.json ./

RUN npm install 

COPY . .

CMD ["npm","run","start"]
