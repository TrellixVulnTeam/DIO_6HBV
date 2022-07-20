import { Request, Response } from "express";
import UserService from "../services/userService";
import { v4 as uuid } from "uuid";

class UserController {
  
    async handle(req: Request, res: Response) {
        
        const nome = req.body.nome;
        const email = req.body.email;
        const userService = new UserService();
        const id = uuid();

        const user = {
            id: id,
            nome: nome,
            email: email
        }

        const rstUser =  await userService.addUsuario(user);

        return res.status(201).json(rstUser);
    }


}

export default UserController;