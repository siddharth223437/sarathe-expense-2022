import {createRouter, createWebHistory} from "vue-router";
import Home from './components/Home.vue'
import Person from './components/Person.vue'
import Login from './components/Login.vue'
import AddOrUpdateExpense from './components/expense/AddorUpdateExpense.vue'
import Modal from'./components/forms/Modal.vue'

const routes = [
    { path: '/', component: Login },
    { path: '/login', component: Login },
    { path: '/home', component: Home },
    { path: '/add', component: AddOrUpdateExpense },
    { path: '/modal', component: Modal },
]

const router = createRouter({
    history: createWebHistory('/expense'),
    routes
})

export default router;
