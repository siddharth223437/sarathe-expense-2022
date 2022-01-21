<template>
  <div class=" min-h-screen text-center">
    <div class="mt-20 px-10">
      <div class="shadow-lg px-4 py-14 border border-solid border-cyan-200  rounded w-full">
        <h1 class="mb-10">Login Form</h1>
<!--        <input type="text" class="w-full mb-2 rounded focus:outline-none">-->
        <base-input type="text" label-text="Username" class=""></base-input>
        <base-input type="password" label-text="Password" class="my-6"></base-input>
        <button type="button" class="btn btn-success w-full px-4">Login</button>
        <a class="text-blue-600 underline pb-10" style="float: right" href="#">Login as admin</a>
      </div>
    </div>

  </div>
</template>

<script setup>

import BaseInput from "./forms/BaseInput.vue";
</script>

<style scoped>

</style>