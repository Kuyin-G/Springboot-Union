package example.kuyin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import example.kuyin.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper接口
 * 基于Mybatis：在接口中编写CRUD的方法，提供Mapper接口对应的SQL映射文件，以及方法对应的sql语句
 *
 * 基于MP ：XxxMapper接口继承BaseMapper接口即可
 *  BaseMapper<T> : 泛型指定的当前接口的
 *
 * */

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
