<template>
  <div class=" min-h-screen text-center">
    <div class="mt-20 px-10 lg:px-52 xl:px-72">
      <form @submit.prevent="doLogin">
      <div class="shadow-lg px-4 py-14 border border-solid border-cyan-200  rounded w-full">
        <h1 class="mb-10">Login Form</h1>
        <base-input type="text" label-text="Username" class="" v-model="username"></base-input>
        <base-input type="password" label-text="Password" class="my-6" v-model="password"></base-input>
        <button type="submit" class="btn btn-success w-full px-4">Login</button>
        <router-link class="text-blue-600 underline pb-10" to="/" style="float: right">Login as admin</router-link>
      </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import BaseInput from "./forms/BaseInput.vue";
import { ref,onMounted } from 'vue'
import router from "../routes.js";
import AuthService from '../service/AuthService.js';
const username = ref('siddharth');
const password = ref('sid');

const myArr = ref([]);
onMounted(() => {
  for(let i =1 ; i<= 20000; i++){
    myArr.value.push('siddharth- ' + i)
  }
})

let displayArray = ref([])

function getComputedResult(e) {
  displayArray.value = e
}

const doLogin = () => {
  const base64 = btoa(username.value+':'+password.value);
  console.log(base64)
  AuthService.performAuth(base64).then(resp => {
    if(resp) {
      sessionStorage.setItem('_token', base64);
      sessionStorage.setItem('_username', username.value);
      router.push('/home')
    }
  });
}

onMounted(() => {
  if(AuthService.isUserLoggedIn()) {
    router.push('/home')
  }
})


</script>

<style scoped>

</style>