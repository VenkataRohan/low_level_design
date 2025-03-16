package org.splitwise.services;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.splitwise.models.User;
import org.splitwise.models.Group;;

public class GroupService {

    //SELECT * FROM group where id = 'groupId'
    Map<String, Group> groups;

    public GroupService(){
        groups = new HashMap<>();
    }

    public Group createGroup(String id, String name, List<User> users ,String createdBy) {
        Group group = new Group(id, name, users, createdBy);
        return group;
    }

    public void addUser(Group group, User user){
        group.addUser(user);
    }
}
