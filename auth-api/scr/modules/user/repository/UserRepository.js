import User from "../model/User";

class UserRepository {

    async findById(id) {
        try {
            return await User.findOnde({ where: { id } });
        } catch (error) {
            console.log(error.message);
            return null;
        }
    }

    async findByEmail(email) {
        try {
            return await User.findOnde({ where: { email } });
        } catch (error) {
            console.log(error.message);
            return null;
        }
    }

}

export default new UserRepository();