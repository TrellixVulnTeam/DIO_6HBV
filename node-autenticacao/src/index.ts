import express, { Request, Response, NextFunction } from 'express';
import statusRoute from './routes/status.route';
import usersRoute from './routes/users.route';

const app = express();
app.use(express.json());
app.use(express.urlencoded({ extended: true}));
app.use(usersRoute, statusRoute);

app.listen(5000, () => {
    console.log('Aplicação executando na parta 5000');
})