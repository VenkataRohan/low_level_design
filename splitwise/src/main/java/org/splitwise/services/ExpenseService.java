package org.splitwise.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.splitwise.models.split.ExpenseSplit;
import org.splitwise.models.split.ExpenseType;
import org.splitwise.models.split.SplitFactory;
import org.splitwise.models.Expense;
import org.splitwise.models.ExpensePaidFor;
import org.splitwise.models.Split;
import java.util.Map;

public class ExpenseService {
    // SELECT * FROM expense WHERE group_id = 'group_id'
    Map<String, List<Expense>> groupExpense;

    public ExpenseService(){
        groupExpense = new HashMap<>();
    }

    public Expense createExpense(String id,String title, int amount, String paidBy, String description, List<ExpensePaidFor> expensePaidFor, ExpenseType expenseType, String groupId){

        ExpenseSplit expenseSplit = SplitFactory.createSplit(expenseType, expensePaidFor, amount);
        List<Split> splits= expenseSplit.calculateSplit();

        Expense expense = new Expense(id, title, amount, paidBy, description, splits, expenseType, groupId);

        groupExpense.putIfAbsent(groupId, new ArrayList<>());
        groupExpense.get(groupId).add(expense);

        return expense;
    }

    public List<Expense> getAllGroupExpneses(String groupId){
        return groupExpense.get(groupId);
    }

}
