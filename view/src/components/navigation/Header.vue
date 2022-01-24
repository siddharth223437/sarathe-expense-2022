<template>
  <div class="py-4 bg-slate-50">
    <div class="flex items-center align-middle justify-between mx-8">
      <div>
        Expense
      </div>
      <div>
        <Menu :items="['Add new expense','Logout']" @onItemClick="handleMenuOnClick" class="hidden sm:block"/> <!--visible on medium and up screen-->

        <button @click="toggleSidebar" class="sm:hidden"><!--visible only on small screens-->
          <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16"/>
          </svg>
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import Menu from "./Menu.vue";
import { ref } from 'vue'
import {useRouter} from "vue-router";

const router = useRouter();

const handleMenuOnClick = (e) => {
  if(e === 'Add new expense') {
    router.push('/add')
  }
  console.log(e)
}
const emit = defineEmits(['onSmallScreenMenuClick']);
const showSidebar = ref(false);

const toggleSidebar=()=> {
  showSidebar.value = !showSidebar.value
  emit('onSmallScreenMenuClick', showSidebar.value);

}

</script>

<style scoped>

</style>