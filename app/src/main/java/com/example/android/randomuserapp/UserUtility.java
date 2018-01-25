package com.example.android.randomuserapp;

import com.example.android.randomuserapp.model.User;

import java.util.HashMap;
import java.util.List;

/**
 * Created by amirahoxendine on 1/24/18.
 */

public class UserUtility {
    public HashMap<String, User> buildMap(List<User> userList){
        HashMap<String, User> userHashMap = new HashMap<>();
        for (User user: userList){
            userHashMap.put(user.getEmail(), user);
        }
        return userHashMap;
    }

    public User getModelFromMap(HashMap<String, User> modelMap, String email){
        return modelMap.get(email);
    }
}
