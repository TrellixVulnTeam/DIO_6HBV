import { Request, Response, NextFunction } from "express";
import DatabaseError from "../model/errors/database.error.model";
import ForbiddenError from "../model/errors/forbbiden.error.model";

function errorHandler(error: any, req: Request, res: Response, next: NextFunction){
    if (error instanceof DatabaseError) {
        res.sendStatus(404);
     } else if(error instanceof ForbiddenError)   {
       res.sendStatus(403);     
     } else {
        res.sendStatus(500);
    }

}

export default errorHandler;