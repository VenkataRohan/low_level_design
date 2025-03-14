package org.splitwise.models;
import java.util.List;

public class Group {
    String id;
    String name;
    List<User> users;
    List<Expense> expenses;
    List<Balance> balances;

    public Group(String id, String name, List<User> users, List<Expense> expenses, List<Balance> balances){
        this.id = id;
        this.name = name;
        this.users = users;
        this.expenses = expenses;
        this.balances = balances;
    }
}