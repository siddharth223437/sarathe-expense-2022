<template>
    <div class="shadow h-28  w-full" :class="cardBackgroundColorClass">
      <div class="pt-4 pl-8 flex items-center space-x-6">
        <div class="h-20 w-20  flex items-center justify-center">
          <i class="fa-4x" :class="[iconClass,iconColorClass]"></i>
        </div>
        <div>
          <div class="text-xl font-semibold md:text-base lg:text-xl">
            {{labelText}}
          </div>
          <div class="font-semibold text-lg text-black">
            $ {{amount}}
          </div>
        </div>
      </div>
    </div>
</template>

<script setup>
defineProps({
  labelText: {
    type: String,
    required: true
  },
  amount: {
    type: Number,
    required: true,
    default: 0
  },
  iconClass: {
    type: String,
    required: false,
    default: 'fas fa-money-bill'
  },
  iconColorClass: {
    type: String,
    required: false,
    default: 'text-green-600'
  },
  cardBackgroundColorClass: {
    type: String,
    required: false,
    default: 'bg-sky-100'
  }
})
</script>

<style >

</style>