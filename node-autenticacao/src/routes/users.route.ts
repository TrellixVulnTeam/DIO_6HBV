import { Router, Request, Response, NextFunction } from "express";

const usersRoute = Router();

usersRoute.get('/users', (req: Request, res: Response, next: NextFunction) =>{
   const users = [
       {userName: "Lima"},
       {userName: "Will"}
   ];
   res.status(200).json(users);
});

usersRoute.get('/users/:uuid', (req: Request, res: Response, next: NextFunction) =>{
    const uuid = req.params.uuid
    res.status(200).send(uuid);
 });


usersRoute.post('/users', (req: Request, res: Response, next: NextFunction) =>{
   let newUser = req.body;
   res.status(201).json(newUser);
});

usersRoute.put('/users/:uuid', (req: Request<{uuid: string}>, res: Response, next: NextFunction) =>{
    let updateUser = req.body;
    let uuid = req.params.uuid;
    console.log(uuid);
    res.status(200).json(updateUser);
 });
 
 usersRoute.delete('/users/:uuid', (req: Request<{uuid: string}>, res: Response, next: NextFunction) =>{
    res.status(200);
 });
 

export default usersRoute;