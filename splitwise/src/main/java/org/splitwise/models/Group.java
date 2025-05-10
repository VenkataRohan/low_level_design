package org.splitwise.models;
import java.util.ArrayList;
import java.util.List;

public class Group {
    public String id;
    String name;
    List<String> users;
    List<Expense> expenses;
    List<Balance> balances;
    String createdBy;

    public Group(String id, String name, List<String> users, String createdBy){
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        this.users = users;
        this.expenses = new ArrayList<>();
        this.balances = new ArrayList<>();
    }

    public void addUser(String userId){
        this.users.add(userId);
    }

    public List<String> getAllUsers(){
        return users;
    }

    public void addExpense(Expense expense){
        this.expenses.add(expense);
    }

}