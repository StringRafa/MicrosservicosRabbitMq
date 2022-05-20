import { Router } from "express";
import UserController from "../controller/UserController.js";
import User from "../model/User.js";

const router = new Router();

router.get("/api/user/email/:email", UserController.findByEmail);

export default router;