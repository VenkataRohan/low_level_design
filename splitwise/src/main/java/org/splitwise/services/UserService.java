package org.splitwise.services;

import java.util.HashMap;
import java.util.Map;

import org.splitwise.models.User;

public class UserService {

    Map<String, User> users;

    public UserService(){
        users = new HashMap<>();
    }

    public void createUser(String id, String name, String email){
        users.put(id, new User(id, name, email));   
    }
}
