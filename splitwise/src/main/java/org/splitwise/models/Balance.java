package org.splitwise.models;

public class Balance {
    User user;
    int getsBack;
    int owes;

    public Balance(User user, int getsBack, int owes){
        this.user = user;
        this.getsBack = getsBack;
        this.owes = owes;
    }
}
