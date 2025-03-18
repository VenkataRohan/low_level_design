package org.splitwise.models.split;
import org.splitwise.models.Split;

public class PercentSplit extends Split {
    private double percent;

    public PercentSplit(String userId, double percent) {
        super(userId, 0); // Amount will be set later
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }
}