<template>
  <div class="bg-cyan-50">
    <div class="py-10 px-4">
      <base-select :options="optionsMonthArr"
                   :option-key="'id'"
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

    </div>
    <expense-transaction-table></expense-transaction-table>

  </div>
</template>

<script setup>
import BaseSelect from "../forms/BaseSelect.vue";
import { ref } from 'vue'
import ExpenseTransactionTable from "./ExpenseTransactionTable.vue";
const optionsMonthArr = [{month:'January',id:1},{month: 'Feb', id:2}]
const optionsYearArr = [2021,2022]
const selectedMonth = ref(1)
const selectedYear = ref(2021)

const tableHeadArr = ['Date','Amount','Description', 'Type'];

const tableBodyArr = [
  {value: '2022-03-01', name:'2022-03-01'}
]

</script>

<style >

</style>