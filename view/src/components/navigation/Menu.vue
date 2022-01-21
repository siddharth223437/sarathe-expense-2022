<template>
    <Menu as="div" class="relative inline-block text-left">
      <MenuButton>
        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16" />
        </svg>
      </MenuButton>
      <transition
          enter-active-class="transition duration-100 ease-out"
          enter-from-class="transform scale-95 opacity-0"
          enter-to-class="transform scale-100 opacity-100"
          leave-active-class="transition duration-75 ease-in"
          leave-from-class="transform scale-100 opacity-100"
          leave-to-class="transform scale-95 opacity-0"
      >
      <MenuItems as="ul" class="absolute right-0 w-36 mt-2 origin-top-right bg-white divide-y divide-gray-100 rounded-md shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none">
        <div class="px-1 py-1">
        <MenuItem as="li"  v-slot="{ active }" v-for="item in items">
          <button @click="emitMenuItem(item)" :class="[
                  active ? 'bg-slate-100 text-black' : 'text-gray-900',
                  'group flex rounded-md items-center w-full px-2 py-2 text-sm',
               ]"
          >{{item}}</button>
        </MenuItem>
        </div>
      </MenuItems>
      </transition>
    </Menu>
  </template>

  <script setup>
    import { Menu, MenuButton, MenuItems, MenuItem } from "@headlessui/vue";
    // import { defineProps,defineEmits, reactive } from "vue";

    const emit = defineEmits(['onItemClick']);

    const menuItems = defineProps({
      items: Array
    })

    const emitMenuItem = (item) => {
      emit('onItemClick',item)
    }
  </script>


<style scoped>

</style>