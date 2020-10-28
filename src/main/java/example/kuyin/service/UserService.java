package example.kuyin.service;

import example.kuyin.bean.User;

import java.util.List;

public interface UserService {
    public User getUserById(Integer id);
    public List<User> getUserLikeName(User user);
    public void save(User user);
    public void update(User user);
    public User getById(Integer id);
    public void updateBySelected(User user);
    public User getByUser(User user);
}
