package org.splitwise.models;
import java.util.ArrayList;
import java.util.List;

public class Group {
    public String id;
    String name;
    public List<User> users;
    List<Expense> expenses;
    List<Balance> balances;
    String createdBy;

    public Group(String id, String name,  String createdBy){
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        this.users = new ArrayList<>();
        this.expenses = new ArrayList<>();
        this.balances = new ArrayList<>();
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void addExpense(Expense expense){
        this.expenses.add(expense);
    }

}