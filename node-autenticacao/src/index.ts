import express, { Request, Response, NextFunction } from 'express';
import basicAthenticationMiddleware from './middlewares/basic.authentication.middleware';
import bearerAuthenticationMiddleware from './middlewares/bearer.authentication.middleware';
import errorHandler from './middlewares/erro.handler.middleware';
import authorizationRoute from './routes/authorization.route';
import statusRoute from './routes/status.route';
import usersRoute from './routes/users.route';

const app = express();

//Configuração da aplicação
app.use(express.json());
app.use(express.urlencoded({ extended: true}));


//Configuração de rotas
app.use(statusRoute);
app.use(authorizationRoute);
app.use(bearerAuthenticationMiddleware, usersRoute);


//Configuração dos hundler de erro
app.use(errorHandler);

app.listen(5000, () => {
    console.log('Aplicação executando na parta 5000');
})