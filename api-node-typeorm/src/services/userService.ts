import { getRepository } from "typeorm";
import { Usuario } from "../entities/Usuario";

interface IUsuario {
    id: string,
    nome: string,
    email?: string
}

class UserService {

   async addUsuario(user: IUsuario) {
       const usuario = await getRepository(Usuario)
          .createQueryBuilder("usuarios")
          .insert()
          .into(Usuario) 
          .values(
              [
                  {id: user.id,  nome: user.nome, email: user.email }
              ]
          )
          .execute();
        return usuario;  
   }

}

export default UserService;