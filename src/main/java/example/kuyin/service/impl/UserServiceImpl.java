package example.kuyin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import example.kuyin.bean.User;
import example.kuyin.mapper.UserMapper;
import example.kuyin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


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

    @Override
    public void update(User user) {
        if(user.getId() !=null){
            userMapper.updateById(user);
        }

    }

    @Override
    public void deleteById(Integer userId) {
        userMapper.deleteById(userId);
    }

    /**
     * 通过Id批量查询
     * @param ids:userId的集合
     * */
    public List<User> getBatchByIds(List<Long> ids){
        if(ids!=null && ids.size() > 0 ){
            List<User> users = userMapper.selectBatchIds(ids);
            return users;
        }
        return null;
    }

    /**
     * 通过map封装条件查询
     * @param propertiesMap ,key是数据库的column（列名）的名称，value是需要查一下值
     * @return List<User>,User的list集合
     * */
    public List<User> getUsersByMap(Map<String,Object> propertiesMap){
        if(propertiesMap!=null && propertiesMap.size() >0){
            List<User> users = userMapper.selectByMap(propertiesMap);
            return users;
        }
        return null;
    }
    /**
     * 通过map封装条件查询
     * @param propertiesMap ,key是数据库的column（列名）的名称，value是需要查一下值
     * @return Integer,返回删除的数量来
     * */
    public Integer  deleteByMap(Map<String,Object> propertiesMap){
        if(propertiesMap!=null && propertiesMap.size() >0){
            int i = userMapper.deleteByMap(propertiesMap);
            return i;
        }
        return 0;
    }

    /**
     * 通过map封装条件查询
     * @param propertiesMap ：key是数据库的column（列名）的名称，value是需要查一下值
     * @return List<User>：返回删除的User的集合
     * */
    public List<User>  deleteByMapAndReturn(Map<String,Object> propertiesMap){
        List<User> userList = this.getUsersByMap(propertiesMap);
        if(userList!=null && userList.size() >0){
            userMapper.deleteByMap(propertiesMap);
            return userList;
        }
        return null;
    }

    /**
     * @param ids :  userId的的List集合
     * @return  Integer: 返回删除的行数
     * */
    public Integer deleteBatchByIds(List<Long> ids){
        if(ids!=null && ids.size() > 0 ){
            int i = userMapper.deleteBatchIds(ids);
            return i;
        }
        return 0;
    }

    /**
     * @param ids :  userId的的List集合
     * @return  Integer: 返回删除的行数
     * */
    public List<User> deleteBatchByIdsAndReturn(List<Long> ids){
        List<User> userList = this.getBatchByIds(ids);
        if(userList !=null && userList.size() >0){
            userMapper.deleteBatchIds(ids);
            return userList;
        }
        return null;
    }

    /**
     * 根据用户名进行获取User的集合
     * @param userName : 用户名
     * @return 根据用户名进行获取User的集合
     * */
    public List<User> getUserByUserName(String userName){

        List<User> userList = userMapper.selectList(new QueryWrapper<User>().eq("user_name",userName));
        return userList;
    }

    /**
     * 根据用账号的密码判断用户是否存在
     * @param user :传入含有userAccount 和 password属性的user
     * */
    public User getUserByLogin(User user){
        // 创建查询条件
        QueryWrapper<User> queryWrapper =new QueryWrapper<User>()
                .eq("login_account",user.getLoginAccount())
                .eq("password",user.getPassword());

        User dbUser = userMapper.selectOne(queryWrapper);
        return dbUser;
    }








}
