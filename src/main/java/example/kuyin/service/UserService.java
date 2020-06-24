package example.kuyin.service;

import example.kuyin.bean.User;

import java.util.List;

public interface UserService {
    public User getUserById(Integer id);
    public List<User> getUserLikeName(User user);
}
