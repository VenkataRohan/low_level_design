package org.splitwise.services;

import java.util.List;

import org.splitwise.models.Balance;
import org.splitwise.models.Expense;
import org.splitwise.models.User;
import org.splitwise.models.Group;;

public class GroupService {
    public Group createGroup(String id, String name, List<User> users, List<Expense> expenses, List<Balance> balances) {

        Group group = new Group(id, name, users, expenses, balances);
        
        return group;
    }
}
