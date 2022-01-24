<template>
  <TransitionRoot appear :show="computeIsOpen" as="template">
    <Dialog as="div" @close="computeIsOpen">
      <div class="fixed inset-0 z-10 overflow-y-auto">
        <div class="min-h-screen px-4 text-center">
          <TransitionChild
              as="template"
              enter="duration-300 ease-out"
              enter-from="opacity-0"
              enter-to="opacity-100"
              leave="duration-200 ease-in"
              leave-from="opacity-100"
              leave-to="opacity-0"
          >
            <DialogOverlay class="fixed inset-0 bg-black opacity-80" />
          </TransitionChild>

          <span class="inline-block h-screen align-middle" aria-hidden="true">
            &#8203;
          </span>

          <TransitionChild
              as="template"
              enter="duration-300 ease-out"
              enter-from="opacity-0 scale-95"
              enter-to="opacity-100 scale-100"
              leave="duration-200 ease-in"
              leave-from="opacity-100 scale-100"
              leave-to="opacity-0 scale-95"
          >
            <div
                class="inline-block w-full max-w-md p-6 my-8 overflow-hidden text-left align-middle transition-all transform bg-white shadow-xl rounded-2xl"
            >
              <DialogTitle>
              </DialogTitle>
              <slot/>
            </div>
          </TransitionChild>
        </div>
      </div>
    </Dialog>
  </TransitionRoot>
</template>

<script setup>
import { ref, computed } from 'vue'
import {TransitionRoot, TransitionChild, Dialog, DialogOverlay, DialogTitle} from '@headlessui/vue'
import {useStore} from "vuex";
const store = useStore();

const props = defineProps({
  openDialog: {
    type: Boolean,
    default: false
  }
})

const isOpen = ref(store.getters.getModalOpen);

const computeIsOpen = computed(() => {
  return store.getters.getModalOpen
})

function closeModal() {
  store.commit('SET_MODAL_OPEN_VALUE',false)
}


</script>
