import JWT from "jsonwebtoken";
import { Request, Response, NextFunction } from "express";
import ForbiddenError from "../model/errors/forbbiden.error.model";
import userRepository from '../repository/user-repository';


async function bearerAuthenticationMiddleware(req: Request, res: Response, next: NextFunction){
    try {
       
      const authorizationHeader = req.headers['authorization'];
      if (!authorizationHeader) {
        throw new ForbiddenError('Credenciais não informada');
      }
 
     const [authenticationType, token] = authorizationHeader.split(' ');
     if (authenticationType !== 'Bearer' || !token ) {
         throw new ForbiddenError('Tipo de autenticação inválida');
     }

     try {
          const tokenPayload = JWT.verify(token, 'my_secret_key');

          if (typeof tokenPayload !== 'object' || !tokenPayload.sub) {
            throw new ForbiddenError('Token inválido');
          }

          const uuid =  tokenPayload.sub;
          const user = await userRepository.findById(uuid);

          req.user = user;
        } catch (error) {
          throw new ForbiddenError('Token inválido');    
        }
    next();  
    } catch (error) {
      next(error)
    }

}

export default bearerAuthenticationMiddleware;