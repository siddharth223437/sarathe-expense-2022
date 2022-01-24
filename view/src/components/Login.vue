<template>
  <div class=" min-h-screen text-center">
    <div class="mt-20 px-10 lg:px-52 xl:px-72">
      <form @submit.prevent="doLogin">
      <div class="shadow-lg px-4 py-14 border border-solid border-cyan-200  rounded w-full">
        <h1 class="mb-10">Login Form</h1>
        <base-input type="text" label-text="Username" class="" v-model="username"></base-input>
        <base-input type="password" label-text="Password" class="my-6" v-model="password"></base-input>
        <button type="submit" class="btn btn-success w-full px-4">Login</button>
        <router-link class="text-blue-600 underline pb-10" to="/home" style="float: right">Login as admin</router-link>
      </div>
      </form>
    </div>
  </div>
</template>

<script setup>

import BaseInput from "./forms/BaseInput.vue";
import { ref } from 'vue'
import router from "../routes.js";
import LoginService from '../service/LoginService.js';
const username = ref('siddharth');
const password = ref('sid');

const doLogin = () => {
  if(username.value === 'siddharth' && password.value === 'sid'){
    router.push('/home')
  }
}

// const base64 = btoa('basic ' + username+":"+password);


</script>

<style scoped>

</style>