import { Request, Response, NextFunction } from "express";
import ForbiddenError from "../model/errors/forbbiden.error.model";
import userRepository from "../repository/user-repository";

async function basicAthenticationMiddleware(req: Request, res: Response, next: NextFunction){
   try {
    const authorizationHeader = req.headers['authorization'];
    if (!authorizationHeader) {
       throw new ForbiddenError('Credenciais não informada');
    }

    const [authenticationType, token] = authorizationHeader.split(' ');
    if (authenticationType !== 'Basic' || !token ) {
        throw new ForbiddenError('Tipo de autenticação inválida');
    }

    const tokenContent = Buffer.from(token, 'base64').toString('utf-8');
    const [username, password] = tokenContent.split(':');

    if (!username || !password) {
        throw new ForbiddenError('Credenciais não preenchida');
    }

    const user = await userRepository.findByUsernameAndPassword(username, password);

    if(!user) {
       throw new ForbiddenError('Usuário inválido');
    }

   req.user = user;
   next();

   } catch (error) {
       next(error)
   }


}


export default basicAthenticationMiddleware