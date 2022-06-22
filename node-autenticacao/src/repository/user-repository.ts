import db from "../db";
import DatabaseError from "../model/errors/database.error.model";
import User from "../model/user-model";



class UserRepository {

  async findAllUsers(): Promise<User[]> {
      const query = `SELECT uuid, username FROM USERS`;
      const { rows } = await db.query<User>(query);
      return rows || [];
  }

  async findById(uuid: string): Promise<User> {
    try {
    const query = `SELECT uuid, username FROM USERS WHERE uuid = $1`;
    const values = [uuid];
    const { rows } = await db.query<User>(query, values);
    return rows[0];
    } catch (error) {
       throw new DatabaseError('Erro na consulta por id: ', error);
    }
  }

  async findByUsernameAndPassword(username: string, password: string): Promise<User | null> {
    try {
    const query = `SELECT uuid, username, password FROM USERS WHERE username = $1 and password = crypt($2, 'my_salt')`;
    const values = [username, password];
    const { rows } = await db.query<User>(query, values);
    return rows[0];
    } catch (error) {
       throw new DatabaseError('Erro na consulta por username: ', error);
    }
  }

  async addUser(user: User): Promise<String> {
      const query = `INSERT INTO USERS (username, password) VALUES ($1, crypt($2, $3)) RETURNING uuid`;
      const values = [user.username, user.password, 'my_salt'];
      const { rows } = await db.query<{uuid: string}>(query, values);
      return rows[0].uuid;
  }

  async update(user: User): Promise<void> {
    const query = `UPDATE USERS SET username = $1, password = crypt($2, $3) WHERE uuid = $4`;
    const values = [user.username, user.password, 'my_salt', user.uuid];
    await db.query(query, values);
    
}

async remove(uuid: string): Promise<void> {
    const query = `DELETE FROM USERS WHERE uuid = $1`;
    const values = [uuid];
    await db.query(query, values);
}

}

export default new UserRepository();