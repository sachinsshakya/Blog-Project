import { myAxios } from "./helper";

export const signUp = (user) => {
    return myAxios.post('/user', user).then((response) => response.data);
}