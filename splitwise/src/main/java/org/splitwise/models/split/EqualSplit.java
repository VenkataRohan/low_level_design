package org.splitwise.models.split;
import org.splitwise.models.User;
import org.splitwise.models.Split;

public class EqualSplit extends Split {
    public EqualSplit(User user) {
        super(user,0.0); // Amount will be set later
    }
}