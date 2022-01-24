<template>
      <div class="shadow-lg  py-4 px-10   rounded w-full">
        <h1 class="mb-10">{{computeLabelText}}</h1>
        <form @submit.prevent="saveOrUpdateExpense">
          <base-input type="number" label-text="Amount" v-model="expense.amount"></base-input>
          <base-input type="text" label-text="Category" class="my-6" v-model="expense.category"></base-input>
          <base-select label-text="Payment Type" :options="paymentTypeOptions" class="my-6" v-model="expense.paymentType"></base-select>
          <base-input type="date" label-text="Expense Date" class="my-6" v-model="expense.expenseDate"></base-input>
          <base-input type="text" label-text="Paid by" class="my-6" v-model="expense.expensePaidBy"></base-input>
          <base-input type="text" label-text="Notes" class="my-6" v-model="expense.notes"></base-input>
          <button type="submit" class="btn btn-success w-full   px-6" >{{computeButtonText}}</button>
          <button type="button" class="btn btn-danger w-full   px-6 my-6 " @click="cancel">Cancel</button>
        </form>
      </div>
</template>

<script setup>
import BaseInput from "../forms/BaseInput.vue";
import Modal from "../forms/Modal.vue";
import BaseSelect from "../forms/BaseSelect.vue";
import {computed, reactive, watch, onMounted} from 'vue';
import DateUtilService from "../../service/DateUtilService";
import {useStore} from "vuex";
import ExpenseService from "../../service/ExpenseService";
import {setAll} from "../../service/JSUtil";
import {useRouter} from "vue-router";

const paymentTypeOptions = ['AMEX','VISA','CASH','MASTER_CARD','ACH']
const store = useStore();
const router = useRouter()

const emit = defineEmits(['refreshTransactions'])

let expense = reactive({
  id: null,
  transactionId: null,
  amount: null,
  category: null,
  notes: null,
  expensePaidBy: null,
  paymentType: 'AMEX',
  expenseDate: DateUtilService.getCurrentDate()
});

const saveOrUpdateExpense = () => {
  ExpenseService.addOrUpdateExpense(expense).then(resp => {
    if(!store.getters.getModalOpen){
      router.push('/home')
    }
    store.commit('SET_MODAL_OPEN_VALUE',false)
    emit('refreshTransactions',true)
  })


}

function cancel() {
  if(!store.getters.getModalOpen){
    //route to home page
    router.push('/home')
  }
  store.commit('SET_MODAL_OPEN_VALUE',false)

}

watch(() => store.getters.getExpenseObh, () => {
  const exp = store.getters.getExpenseObh;
  if(store.getters.getModalOpen && exp !== null) {
    expense = {...exp}
  }
}, {immediate: true})

const computeLabelText = computed(() => {
  if(store.getters.getModalOpen) {
    return 'Update Expense'
  }else{
    return 'Add Expense'
  }
})

const computeButtonText = computed(() => {
  if(store.getters.getModalOpen) {
    return 'Update'
  }else{
    return 'Add'
  }
})

onMounted(() => {


})

</script>

<style scoped>

</style>