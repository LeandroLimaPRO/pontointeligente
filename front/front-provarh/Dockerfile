# Imagem de Origem
FROM node:latest
# Diretório de trabalho(é onde a aplicação ficará dentro do container).
WORKDIR /app
# Adicionando `/app/node_modules/.bin` para o $PATH
ENV PATH /node_modules/.bin:$PATH
# Instalando dependências da aplicação e armazenando em cache.
COPY package.json /app/package.json
RUN npm install --silent
RUN npm audit fix
RUN npm install react-scripts@3.3.1 -g --silent
RUN npm install materialize-css@next
RUN npm install react-materialize
RUN npm install axios
EXPOSE 3000:3000
# start app
CMD ["npm", "start"]