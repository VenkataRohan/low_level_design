package org.splitwise.models.split;

import org.splitwise.models.Split;


public class SplitFactory {
    public static Split createSplit(ExpenseType expenseType, String userId, int amount){
        switch (expenseType) {
            case EQUAL:
                return new EqualSplit(userId);
            case UNEQUAL:
                return new UnEqualSplit(userId, amount);
            case PERCENT:
             return new PercentSplit(userId, amount);
            default:
                throw new IllegalArgumentException("Invalid Expense Type");
        }
    }
}
