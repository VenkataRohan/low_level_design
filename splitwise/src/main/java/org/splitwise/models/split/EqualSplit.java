package org.splitwise.models.split;
import org.splitwise.models.Split;

public class EqualSplit extends Split {
    public EqualSplit(String userId) {
        super(userId,0); // Amount will be set later
    }
}