package org.splitwise.models.split;
import org.splitwise.models.Split;
import org.splitwise.models.User;

public class UnEqualSplit extends Split {
    public UnEqualSplit(User user, double amount) {
        super(user, amount);
    }
}