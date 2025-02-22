package org.splitwise.models;

public class Split {
    User user;
    double amount;

    Split(User user, double amount){
        this.user = user;
        this.amount = amount;
    }
}
