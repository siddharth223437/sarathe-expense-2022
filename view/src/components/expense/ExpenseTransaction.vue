<template>
  <div class="">
    <div class="py-10 px-4 bg-cyan-50">
      <form @submit.prevent="showTransaction">
        <base-select :options="optionsMonthArr"
                     :option-key="'month'"
                     v-model="selectedMonth"
                     label-text="Choose Month"
                     class="mb-10">
        </base-select>
        <base-select :options="optionsYearArr"
                     v-model="selectedYear"
                     label-text="Choose Year"
                     class="mb-10">
        </base-select>
        <button type="submit" class="btn btn-info">Search</button>
      </form>
    </div>
    <div class="bg-cyan-50 md:bg-violet-50 md:py-4 md:my-8 md:px-2">
      <expense-transaction-table @refreshTransaction="showTransaction" class="md:my-6"></expense-transaction-table>
    </div>
  </div>
</template>

<script setup>
import BaseSelect from "../forms/BaseSelect.vue";
import {ref, onMounted, computed} from 'vue'
import ExpenseTransactionTable from "./ExpenseTransactionTable.vue";
import DateUtilService from "../../service/DateUtilService";
import ExpenseService from "../../service/ExpenseService";
import {useStore} from 'vuex';

const store = useStore();
const optionsMonthArr = DateUtilService.getAllMonths();
const optionsYearArr = [2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025, 2026]
const selectedMonth = ref(DateUtilService.getCurrentMonthAsString())
const selectedYear = ref(DateUtilService.getCurrentYear())
const emit = defineEmits(['selectedYear', 'selectedMonth','date'])

const showTransaction = () => {
  /*for reference, how to use vue store*/

  const sourceDate = DateUtilService.format(selectedYear.value+DateUtilService.getMonthAsNumber(selectedMonth.value)+'01');
  const targetDate = DateUtilService.format(selectedYear.value+DateUtilService.getMonthAsNumber(selectedMonth.value)+DateUtilService.getLastDayOfMonth(sourceDate));
  console.log(targetDate)

  ExpenseService.findExpenseWithDates(sourceDate,targetDate).then(resp => {
    const toEmitObj = {
      selectedYear: selectedYear.value,
      selectedMonth: selectedMonth.value,
      sourceDate: sourceDate,
      targetDate: targetDate
    };
    emit('date',toEmitObj)

    store.commit('SAVE_EXPENSE_TRANSACTION',resp.data)
  })
}



onMounted(() => {
  showTransaction();
})

</script>

<style>

</style>