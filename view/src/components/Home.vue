<template>
  <div>
    <ShowExpenseCard :amount="460" label-text="January Expense" icon-class="fas fa-dollar-sign" icon-color-class="text-green-400"/>
    <ShowExpenseCard :amount="460" label-text="2022 Expense" card-background-color-class="bg-violet-100" icon-color-class="text-yellow-500"/>

    <expense-transaction/>
  </div>
</template>

<script setup>

import ShowExpenseCard from "./expense/ShowExpenseCard.vue";
import ExpenseTransaction from "./expense/ExpenseTransaction.vue";
</script>

<style >

</style>