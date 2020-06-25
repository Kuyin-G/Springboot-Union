package example.kuyin.service;

import example.kuyin.bean.User;

import java.util.List;

public interface UserService {

    // 插入一个用户
    public void insert(User user);

    public User getUserById(Integer id );



}
