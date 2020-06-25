package example.kuyin.service.impl;

import example.kuyin.bean.User;
import example.kuyin.mapper.UserMapper;
import example.kuyin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

}
