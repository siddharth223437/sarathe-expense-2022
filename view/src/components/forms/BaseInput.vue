<template>
  <div class="relative">
    <label class="absolute top-[-7px] left-[27px] z-10 text-xs">{{labelText}}</label>
    <input :type="inputType" :value="modelValue" @input="updateInput" v-bind="$attrs">
  </div>
</template>

<script setup>
defineProps({
  inputType: {
    type: String,
    default: 'text'
  },
  labelText: {
    default: ''
  },
  modelValue:{
    default: ''
  }
})
const emit = defineEmits(['update:modelValue'])
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