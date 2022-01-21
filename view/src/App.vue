<script setup>
import Header from "./components/navigation/Header.vue";
import { ref } from 'vue'
const menuValue = ref(false);
const handleSmallScreenMenu = (e) => {
  menuValue.value = e;
}

const menuArr = ['Add New Expense','Logout']

</script>

<template>
  <div class="flex flex-col h-screen justify-between">
    <Header @onSmallScreenMenuClick="handleSmallScreenMenu"/>
<!--for small screen-->
    <nav v-if="menuValue">
      <div class="min-h-screen bg-gray-200">
        <div class="pt-4 text-lg underline pl-8 pb-8 shadow-lg">
          Welcome Siddharth
        </div>
        <div v-for="item in menuArr" class="py-4 pl-8">
          <label class="font-semibold ">{{item}}</label>
        </div>
      </div>
    </nav>

    <main class="mb-auto spacing-container flex-grow max:mt-6 max:mx-auto max:w-ui-max" :class="{'opacity-0':menuValue}">
      <router-view></router-view>
    </main>
    <footer class="bg-slate-50">
      <small class="px-16 top-0 bottom-0">&copy; Copyright 2022, Sarathe Expense</small>
    </footer>
  </div>
</template>




