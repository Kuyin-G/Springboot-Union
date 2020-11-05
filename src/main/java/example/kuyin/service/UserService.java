package example.kuyin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import example.kuyin.bean.User;

import java.util.List;

public interface UserService {

    // 插入一个用户
    /**
     * 根据User中不为空的值进行插入
     * */
    public void insert(User user);

    public User getUserById(Integer id );

    void update(User user);

    void deleteById(Integer id);

}
