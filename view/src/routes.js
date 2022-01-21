import {createRouter, createWebHistory} from "vue-router";
import Home from './components/Home.vue'
import Person from './components/Person.vue'
import Login from './components/Login.vue'

const routes = [
    { path: '/', component: Login },
    { path: '/login', component: Login },
    { path: '/home', component: Home },
    { path: '/person', component: Person },
]

const router = createRouter({
    history: createWebHistory('/expense'),
    routes
})

export default router;
