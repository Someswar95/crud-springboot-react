import { myAxios } from "./Helper";

export const signUp=(user)=>{

    return myAxios
        .post("/api/crud/save",user)
        .then((response)=> response.data)
}