package org.splitwise.models.split;

import org.splitwise.models.Split;
import org.splitwise.models.User;

public class SplitFactory {
    public static Split createSplit(ExpenseType expenseType, User user, double amount){
        switch (expenseType) {
            case EQUAL:
                return new EqualSplit(user);
            case UNEQUAL:
                return new UnEqualSplit(user, amount);
            case PERCENT:
             return new PercentSplit(user, amount);
            default:
                throw new IllegalArgumentException("Invalid Expense Type");
        }
    }
}
