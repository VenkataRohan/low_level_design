package org.splitwise.models.split;

import java.util.List;

import org.splitwise.models.Split;

public interface ExpenseSplit {
    List<Split> calculateSplit();

    boolean validate();
}



