package org.splitwise.models.split;
import org.splitwise.models.User;
import org.splitwise.models.Split;

public class PercentSplit extends Split {
    private double percent;

    public PercentSplit(User user, double percent) {
        super(user, 0); // Amount will be set later
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }
}