package org.splitwise;

import java.util.List;

import org.splitwise.models.User;
import org.splitwise.models.split.ExpenseType;
import org.splitwise.models.Expense;
import org.splitwise.models.Group;
import org.splitwise.models.Split;
import org.splitwise.services.*;;

public class Splitwise {

    GroupService groupService;
    ExpenseService expenseService;

    Splitwise() {
        groupService = new GroupService();
        expenseService = new ExpenseService();
    }

    public void demo() {
        User user1 = new User("U101", "user1", "user1@gmail.com");
        User user2 = new User("U102", "user2", "user2@gmail.com");
        User user3 = new User("U103", "user3", "user3@gmail.com");
        User user4 = new User("U104", "user4", "user4@gmail.com");
        // expenseService.createExpense()
        System.out.println(user1.id);
        Group group1 = new Group("G101", "group1", user1.id);
        System.out.println(group1.users);
        
        Split split1 = new Split(user4, 0);
        Split split2 = new Split(user3, 0);
        Expense expense1 = new Expense("Ex101", 90, user1.id, "test", List.of(split1, split2), ExpenseType.EQUAL, group1.id);
        System.out.println(expense1.title);
        // Group group2 = new Group("G102", "group2", List.of(user1, user2), null, null);

    }
}
