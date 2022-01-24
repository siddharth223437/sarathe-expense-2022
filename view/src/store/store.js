import { createStore } from 'vuex'

export const store = createStore({
    state: {
        expenseTransactionArr: [],
        isModalOpen: false,
        expenseObj: null
    },
    getters: {
        getExpenseTransactionArr(state) {
            return state.expenseTransactionArr;
        },
        getModalOpen(state) {
            return state.isModalOpen;
        },
        getExpenseObh(state) {
            return state.expenseObj
        },

    },
    mutations: {
        SAVE_EXPENSE_TRANSACTION(state,expenseTransactionArr) {
            state.expenseTransactionArr = expenseTransactionArr
        },
        SET_MODAL_OPEN_VALUE(state, isModalOpenValue) {
            state.isModalOpen = isModalOpenValue
        },
        SET_EXPENSE_OBJ(state, payload) {
            state.expenseObj = payload
        }
    },
    actions: {

    }
})