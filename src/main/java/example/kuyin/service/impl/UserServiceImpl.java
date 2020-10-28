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
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getUserLikeName(User user) {
        return userMapper.getUsersLikeName(user.getUserName());
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public void update(User user) {
        if(user.getId()!=null){
            userMapper.update(user);
        }
    }

    @Override
    public User getById(Integer id) {
        User user = null;
        if(id>0){
            user = userMapper.getById(id);
        }
        return user;
    }

    @Override
    public void updateBySelected(User user) {
        if(user.getId() !=null && user.getId() > 0){
            userMapper.updateBySelected(user);
        }
    }

    @Override
    public User getByUser(User user) {
        if(user !=null){
            user = userMapper.getByUser(user);
        }else{
            user = null;
        }
        return user;
    }
}
