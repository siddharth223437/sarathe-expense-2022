import axios from "axios";
import AuthService from "./AuthService";

const instance =  axios.create({
    baseURL: "/expense/api/v1/admin/",
    headers: {
        "Content-type": "application/json"
    }
});

instance.interceptors.request.use((config) => {
    if(AuthService.isUserLoggedIn()) {
        config.headers.authorization = `Basic ${sessionStorage.getItem('_token')}`
    }
    return config;
})

export default instance