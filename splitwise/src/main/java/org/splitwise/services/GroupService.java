package org.splitwise.services;

import java.util.ArrayList;
import java.util.List;


import org.splitwise.models.User;
import org.splitwise.models.Group;;

public class GroupService {

    List<Group> groups = new ArrayList<>();

    public Group createGroup(String id, String name, String createdBy) {
        Group group = new Group(id, name, createdBy);
        return group;
    }

    public void addUser(Group group, User user){
        group.addUser(user);
    }
}
