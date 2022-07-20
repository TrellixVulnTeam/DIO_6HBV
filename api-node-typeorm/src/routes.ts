import { Router, Request, Response } from "express";
import UserController from "./controllers/userController";

const router = Router();
const userController = new UserController();


router.post('/usuarios', userController.handle)

export default router;