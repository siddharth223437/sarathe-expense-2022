<template>
  <table>
    <thead>
    <tr>
      <th>Date</th>
      <th>Amount</th>
      <th>Type</th>
      <th>Category</th>
      <th v-if="isSmallOrGreater">Notes</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="transaction in computeTransactionArr">
      <td>{{ transaction.expenseDate }}</td>
      <td>${{ transaction.amount }}</td>
      <td>{{ transaction.paymentType }}</td>
      <td>{{ transaction.category }}</td>
      <td v-if="isSmallOrGreater">{{ transaction.notes }}</td>
      <td>
        <svg @click="editExpense(transaction.id)" xmlns="http://www.w3.org/2000/svg" class="h-4 w-4 lg:h-6 lg:w-6 stroke-green-500 cursor-pointer" fill="none"
             viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z"/>
        </svg>
      </td>
      <td>
        <svg @click="deleteExpense(transaction.id)" xmlns="http://www.w3.org/2000/svg" class="h-4 w-4 lg:h-6 lg:w-6 fill-rose-500" viewBox="0 0 20 20" fill="currentColor">
          <path fill-rule="evenodd"
                d="M9 2a1 1 0 00-.894.553L7.382 4H4a1 1 0 000 2v10a2 2 0 002 2h8a2 2 0 002-2V6a1 1 0 100-2h-3.382l-.724-1.447A1 1 0 0011 2H9zM7 8a1 1 0 012 0v6a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v6a1 1 0 102 0V8a1 1 0 00-1-1z"
                clip-rule="evenodd"/>
        </svg>
      </td>
    </tr>
    </tbody>
    <Modal>
      <AddorUpdateExpense @refreshTransactions="handleRefreshTransaction"/>
    </Modal>
  </table>

</template>

<script setup>
import {computed, ref, onMounted} from "vue";
import {useStore} from "vuex";
import {useMediaQuery} from '@vueuse/core'
import Modal from "../forms/Modal.vue";
import AddorUpdateExpense from "../expense/AddorUpdateExpense.vue";
import ExpenseService from "../../service/ExpenseService";


const store = useStore();
const emit = defineEmits(['toggleModal','refreshTransaction'])
const isSmallOrGreater = useMediaQuery('(min-width: 640px)')
let expTransactionArr = [];

const editExpense = (id) => {
  expTransactionArr.forEach(f => {
    if(f.id === id) {
      store.commit("SET_EXPENSE_OBJ", f)
      store.commit("SET_MODAL_OPEN_VALUE", true)
    }
  })


}

function handleRefreshTransaction(e) {
  emit('refreshTransaction',e)
}

const computeTransactionArr = computed(() => {
  expTransactionArr =  store.getters.getExpenseTransactionArr
   return store.getters.getExpenseTransactionArr;

})

function deleteExpense(id) {
  ExpenseService.deleteExpense(id).then(resp => {
    console.log(resp)
    emit('refreshTransaction',true)
  })
}

onMounted(()=>{
  store.commit("SET_MODAL_OPEN_VALUE", false)
})

</script>

<style scoped>

</style>