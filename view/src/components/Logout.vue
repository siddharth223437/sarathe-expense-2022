<template>

</template>

<script setup>
import {ref, onMounted} from 'vue';
import AuthService from "../service/AuthService";

onMounted(() => {
  AuthService.performLogout();

})

</script>

<style scoped>

</style>