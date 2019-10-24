package com.carter.service;

import com.carter.pojo.User;

import java.util.Map;

public interface UserService {
    User selUser(String username);

    int addUser(User user);

    Map<String, Object> selUserInfoByName(String username);
}
