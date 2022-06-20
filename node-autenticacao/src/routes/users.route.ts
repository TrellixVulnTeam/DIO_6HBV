import { Router, Request, Response, NextFunction } from "express";
import userRepository from "../repository/user-repository";

const usersRoute = Router();

usersRoute.get('/users', async (req: Request, res: Response, next: NextFunction) =>{
   const users = await userRepository.findAllUsers();
   res.status(200).json(users);
});

usersRoute.get('/users/:uuid', async (req: Request, res: Response, next: NextFunction) =>{
    const uuid = req.params.uuid
    const user = await userRepository.findById(uuid);
    res.status(200).send(user);
 });


usersRoute.post('/users', async (req: Request, res: Response, next: NextFunction) =>{
   let newUser = req.body;
   const uuid = await userRepository.addUser(newUser);
   res.status(201).json(uuid);
});

usersRoute.put('/users/:uuid', async (req: Request<{uuid: string}>, res: Response, next: NextFunction) =>{
    let updateUser = req.body;
    let uuid = req.params.uuid;
    updateUser.uuid = uuid;
    await userRepository.update(updateUser);
    res.status(200).json();
 });
 
 usersRoute.delete('/users/:uuid', async (req: Request<{uuid: string}>, res: Response, next: NextFunction) =>{
    let uuid = req.params.uuid;
    await userRepository.remove(uuid);
    res.status(200).send();
 });
 

export default usersRoute;