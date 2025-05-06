package org.splitwise.models.split;

import org.splitwise.models.ExpensePaidFor;
import java.util.List;

public class SplitFactory {
    public static ExpenseSplit createSplit(ExpenseType expenseType, List<ExpensePaidFor> expensePaidFor, int amount){
        switch (expenseType) {
            case EQUAL:
                return new EqualSplit(expensePaidFor, amount);
            case UNEQUAL:
                return new UnEqualSplit(expensePaidFor, amount);
            case PERCENT:
             return new PercentSplit(expensePaidFor, amount);
            default:
                throw new IllegalArgumentException("Invalid Expense Type");
        }
    }
}
