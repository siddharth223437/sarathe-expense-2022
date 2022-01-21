<template>
  <div class="relative">
    <div>
      <label class="absolute top-[-12px] left-[27px] z-10">{{labelText}}</label>
      <select class="py-1.5 w-full focus:outline-none bg-white border border-solid border-gray-300 shadow px-3
                  rounded appearance-none block text-base text-gray-700 bg-clip-padding bg-no-repeat
                  focus:text-gray-700 focus:bg-white focus:border-blue-600 z-0" :value="modelValue" @input="updateInput" v-bind="$attrs">

        <option v-for="option in options" v-if="optionKey">
          {{ option[optionKey] }}
        </option>
        <option v-for="option in options" v-else>
          {{ option }}
        </option>
      </select>
      <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 text-gray-700 absolute top-2 right-2" fill="none"
           viewBox="0 0 24 24" stroke="currentColor">
        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 9l-7 7-7-7"/>
      </svg>
    </div>
  </div>
</template>

<script setup>
defineProps({
  options: {
    type: Array
  },
  optionKey: {

  },
  labelText: {
    default: ''
  },
  modelValue:{
    default: ''
  }
})
const emit = defineEmits(['onInput'])
const updateInput = (e) => {
  emit('update:modelValue', e.target.value)
}
</script>

<style scoped>
label:after {
  content: " ";
  background-color: #fff;
  width: 100%;
  height: 13px;
  position: absolute;
  left: 0;
  bottom: 0;
  z-index: -1;
}
</style>