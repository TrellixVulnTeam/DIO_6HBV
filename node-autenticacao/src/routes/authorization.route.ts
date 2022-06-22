import { Router, Request, Response, NextFunction } from "express";
import ForbiddenError from "../model/errors/forbbiden.error.model";
import JWT from "jsonwebtoken";
import basicAthenticationMiddleware from "../middlewares/basic.authentication.middleware";
import bearerAuthenticationMiddleware from "../middlewares/bearer.authentication.middleware";

const authorizationRoute = Router();

authorizationRoute.post('/token', basicAthenticationMiddleware,  async (req: Request, res: Response, next: NextFunction) => {
    try {
       const user = req.user;

      if (!user) {
         throw new ForbiddenError('Usuário não informado');
      }

       const jwtPayload = { username: user?.username};
       const jwpOptions = { subject: user?.uuid};
       const jwtSecretKey = 'my_secret_key';

       const jwt = JWT.sign(jwtPayload, jwtSecretKey, jwpOptions);
       res.status(200).json({token: jwt});
       
    } catch(error) {
       next(error);
    } 

 });

authorizationRoute.post('/token/validate', bearerAuthenticationMiddleware, async (req: Request, res: Response, next: NextFunction) =>{
  res.sendStatus(200);  
});


export default authorizationRoute;