package example.kuyin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

// 使用下面的注解，自动生成setter和getter、无参数构造器、全参数构造器和toString方法（lombok工具包提供的注解）
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName(value = "tbl_user")
/*
*
 */
public class User {
    // 定义id
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    // 定义用户名称
    @TableField("user_name")
    private String userName;
    // 定义用户账号
    @TableField("login_account")
    private String loginAccount;
    // 定义用户密码
    @TableField("password")
    private String password;
    // 定义用户邮件
    @TableField("email")
    private String email;
    // 定义创建用户的日期
    @TableField(value = "create_time")
    private Date createTime;

}
