package org.splitwise.models;
import java.util.List;
import org.splitwise.models.split.ExpenseType;

public class Expense {
    private String id;
    public String title;
    public int amount;
    public String paidBy;
    public String description;
    public List<Split> splits;
    public ExpenseType expenseType;
    public String groupId;

    public Expense(String id, String title, int amount, String paidBy, String description, List<Split> splits, ExpenseType expenseType, String groupId){
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.paidBy = paidBy;
        this.description = description;
        this.splits =  splits;
        this.expenseType = expenseType;
        this.groupId = groupId;
    }

}

