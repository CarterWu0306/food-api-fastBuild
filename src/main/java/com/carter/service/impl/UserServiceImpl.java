package com.carter.service.impl;

import com.carter.mapper.UserMapper;
import com.carter.pojo.User;
import com.carter.pojo.UserExample;
import com.carter.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selUser(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        return users.get(0);
    }

    @Override
    public int addUser(User user) {
        int index = userMapper.insertSelective(user);
        return index;
    }

    @Override
    public Map<String, Object> selUserInfoByName(String username) {
        Map<String, Object> userInfo = userMapper.selUserInfoByName(username);
        return userInfo;
    }
}
