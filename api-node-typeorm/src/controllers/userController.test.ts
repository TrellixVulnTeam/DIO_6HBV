import { Request } from 'express';
import { makeMockResponse } from '../utils/mocks/MockResponse';
import UserController from "./userController"


describe('userController', () => {
   it('Deve retornar o id do usuário criado', async() => {
    const userController = new UserController();

    const request = {
        body: {
            nome: 'usuario',
            email: 'usuario@gmail.com'
        }
    } as Request

    const response = makeMockResponse()

    const result = await userController.handle(request, response);

})

});