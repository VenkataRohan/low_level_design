package org.splitwise.models;

import org.splitwise.models.split.ExpenseType;

public class Expense {
    public int id;
    public String title;
    public int amount;
    public String paidBy;
    public String description;
    public Split[] splits;
    public ExpenseType expenseType;
    public String groupId;

    public Expense(String title, int amount, String paidBy, String description, Split[] splits, ExpenseType expenseType, String groupId){
        this.title = title;
        this.amount = amount;
        this.paidBy = paidBy;
        this.description = description;
        this.splits =  splits;
        this.expenseType = expenseType;
        this.groupId = groupId;
    }

}