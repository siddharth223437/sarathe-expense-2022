import http from './http-common'

class LoginService {
    getUsername() {
        return http.get('/user/username')
    };

    performAuth(){
        return http.get("/user/username");
    }
}

export default new LoginService();

