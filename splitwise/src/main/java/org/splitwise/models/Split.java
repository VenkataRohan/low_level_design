package org.splitwise.models;

public class Split {
    String userId;
    int amount;

   public Split(String userId, int amount){
        this.userId = userId;
        this.amount = amount;
    }

    public String getUserId(){
        return this.userId;
    }

    public int getAmount(){
        return this.amount;
    }

}
