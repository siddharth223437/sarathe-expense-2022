<template>
  <div>
    <div class="sm:flex sm:justify-between md:grid md:grid-cols-2 md:gap-28 lg:gap-56 md:my-8 xl:gap-96">
      <ShowExpenseCard :amount="currentMonthExpense" :label-text="selectedMonth" icon-class="fas fa-dollar-sign" icon-color-class="text-green-400" class=""/>
      <ShowExpenseCard :amount="purpleBoxYearAmount" :label-text="selectedYear + ' Expense'" card-background-color-class="bg-violet-100" icon-color-class="text-yellow-500" class=""/>
    </div>
    <expense-transaction @date="handleDate"/>
  </div>
</template>

<script setup>

import ShowExpenseCard from "./expense/ShowExpenseCard.vue";
import ExpenseTransaction from "./expense/ExpenseTransaction.vue";
import DateUtilService from "../service/DateUtilService";
import {ref, computed, onMounted} from 'vue';
import ExpenseService from "../service/ExpenseService";

const currentMonthExpense = ref(0);
const currentYearExpense = ref(0);
const selectedMonth = ref('');
const selectedYear = ref('');
const sourceDate = ref(null);
const targetDate = ref(null);
const purpleBoxYearAmount = ref(0)
// const computeCurrentMonth = computed(() => {
//   return DateUtilService.getCurrentMonthAsString() + ' Expense'
// })

// const computeCurrentYear = computed(() => {
//   return DateUtilService.getCurrentYear() + ' Expense'
// })

const computeExpenseAmount = (resp) => {
  let expenseAmount = 0
  resp.data.forEach(e => {
    expenseAmount = expenseAmount + e.amount
  })
  return expenseAmount;
}

const getCurrentMonthExpense = () => {
  if (sourceDate.value === null || targetDate.value === null) {
    ExpenseService.findExpenseWithDates(DateUtilService.getStartDateOfMonth(), DateUtilService.getLastDateOfMonth()).then(resp => {
      currentMonthExpense.value = computeExpenseAmount(resp);
    });
  } else {
    ExpenseService.findExpenseWithDates(sourceDate.value, targetDate.value).then(resp => {
      currentMonthExpense.value = computeExpenseAmount(resp);
    });
  }
}

const getCurrentYearExpense = () => {

  if(sourceDate.value === null || targetDate.value === null) {
    // console.log('if in')
    ExpenseService.findExpenseWithDates(DateUtilService.getFirstDateOfYear(), DateUtilService.getLastDateOfYear()).then(resp => {
      currentYearExpense.value = computeExpenseAmount(resp);
      purpleBoxYearAmount.value = computeExpenseAmount(resp);
    })
  }else{
    // console.log('in else')
    // console.log(sourceDate.value)
    // console.log(targetDate.value)
    ExpenseService.findExpenseWithDates(sourceDate.value, targetDate.value).then(resp => {
      currentYearExpense.value = computeExpenseAmount(resp);
    })

    //  getPurpleBoxYearAmount
    const tg = DateUtilService.getLastDateOfYearFromSourceDate(sourceDate.value) + '-12-31';
    ExpenseService.findExpenseWithDates(sourceDate.value, tg).then(resp => {
      purpleBoxYearAmount.value = computeExpenseAmount(resp);
    })

  }
}


function handleDate(e) {
  purpleBoxYearAmount.value = 0
  selectedMonth.value = e.selectedMonth;
  selectedYear.value = e.selectedYear;
  sourceDate.value = e.sourceDate;
  targetDate.value = e.targetDate;
  getCurrentMonthExpense();
  getCurrentYearExpense();
  //compute only total year expense, purple box amount



}



onMounted(() => {
  getCurrentMonthExpense();
  getCurrentYearExpense();
})

</script>

<style>

</style>