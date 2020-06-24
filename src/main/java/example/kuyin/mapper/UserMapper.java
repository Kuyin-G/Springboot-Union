package example.kuyin.mapper;

import example.kuyin.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from tbl_user where id =#{id}")
    public User getUserById(@Param("id") Integer id);

    public List<User> getUsersLikeName(String  userName);
}
