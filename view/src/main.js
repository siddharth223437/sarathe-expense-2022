import { createApp } from 'vue'
import App from './App.vue'
import './assets/css/tailwind.css'
import router from "./routes";
import '@fortawesome/fontawesome-free/js/brands.min.js';
import '@fortawesome/fontawesome-free/js/solid.min.js';
import '@fortawesome/fontawesome-free/js/fontawesome.min.js';

const app = createApp(App);
app.use(router)
app.mount('#app')

