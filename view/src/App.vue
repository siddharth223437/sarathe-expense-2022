<script setup>
import Header from "./components/navigation/Header.vue";
import { ref } from 'vue'
const menuValue = ref(false);
const handleSmallScreenMenu = (e) => {
  menuValue.value = e;
  console.log(menuValue.value)
}

const menuArr = [
  {label: 'Add new expense', url: '/add'},
  {label: 'Logout', url: '/logout'},
]

</script>

<template>
  <div class="flex flex-col h-screen justify-between">
    <Header @onSmallScreenMenuClick="handleSmallScreenMenu" />
<!--for small screen-->
    <nav v-if="menuValue">
      <div class="min-h-screen bg-gray-200 animate__animated animate__fadeInRight">
        <div class="pt-4 text-lg underline pl-8 pb-8 shadow-lg">
          Welcome Siddharth
        </div>
        <div v-for="item in menuArr" class="py-1 pt-4 pl-8">
          <router-link class="text-blue-600 underline" :to="item.url" @click="menuValue=false">{{item.label}}</router-link>
        </div>
      </div>
    </nav>

    <main class="mb-auto spacing-container flex-grow max:mt-6 max:mx-auto max:w-ui-max sm:px-8 md:px-12 md:py-6  xl:px-96" :class="{'opacity-0':menuValue}">
      <router-view></router-view>
    </main>
    <footer class="bg-slate-50">
      <small class="px-16 top-0 bottom-0">&copy; Copyright 2022, Sarathe Expense</small>
    </footer>
  </div>
</template>




