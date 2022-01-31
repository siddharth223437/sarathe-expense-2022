import http from './http-common'

class AuthService {
    // getUsername() {
    //     return http.get('/user/username')
    // };

    performAuth(token){
        return http.get("/user/username",{
            headers: {
                'Authorization': `Basic ${token}`
            }
        })
    }

    isUserLoggedIn(){
        return sessionStorage.getItem('_username');
    }

    getUsername() {
        return sessionStorage.getItem('_username')
    }

    performLogout() {
        sessionStorage.removeItem("_username");
        sessionStorage.removeItem("_token");
        window.location.href = '/expense/logout'

    }

}

export default new AuthService();

