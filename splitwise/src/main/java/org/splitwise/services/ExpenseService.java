package org.splitwise.services;

import org.splitwise.models.User;
import org.splitwise.models.split.ExpenseType;
import org.splitwise.models.Expense;
import org.splitwise.models.Split;


public class ExpenseService {
    public Expense createExpense(String title, int amount, String paidBy, String description, Split[] splits, ExpenseType expenseType, String groupId){
        Expense expense = new Expense(title, amount, paidBy, description, splits, expenseType, groupId);
        return expense;
    }
    
}
