package org.splitwise.models.split;
import org.splitwise.models.ExpensePaidFor;
import org.splitwise.models.Split;

import java.util.ArrayList;
import java.util.List;


public class PercentSplit implements ExpenseSplit {
    List<ExpensePaidFor> expensePaidFor;
    int totalAmount;

    public PercentSplit(List<ExpensePaidFor> expensePaidFor, int totalAmount) {
        this.expensePaidFor = expensePaidFor;
        this.totalAmount = totalAmount;
    }

    @Override
    public List<Split> calculateSplit(){
//1000
//20, 30, 50
        if(!validate()) throw new Error("Invaid share Split");

        List<Split> splits = new ArrayList<>();

        for(ExpensePaidFor exp : expensePaidFor){
            splits.add(new Split(exp.userId, (totalAmount/100) * exp.shares));
        }
        return splits;
    }

    @Override
    public boolean validate(){
        if(expensePaidFor == null || expensePaidFor.size() == 0){
            return false;
        }
        
        int shares = 0;

        for(ExpensePaidFor expense : expensePaidFor){
            shares += expense.shares;
        }

       

        return  shares == 100;
    }
}