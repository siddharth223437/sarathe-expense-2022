import http from './http-common'

class ExpenseService {
    findExpenseWithDates(sourceDate,targetDate){
        return http.get(`/expense/dates/${sourceDate}/${targetDate}`);
    }

    addOrUpdateExpense(expense) {
        return http.post('/expense/add',expense);
    }

    deleteExpense(id){
        return http.delete(`/expense/${id}`);
    }
}

export default new ExpenseService();

