package org.splitwise.models;

public class User {
    public int id; 
    private String name;
    private String email;
    
    public User( int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
