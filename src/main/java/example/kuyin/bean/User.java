package example.kuyin.bean;

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
public class User {
    // 定义id
    private Integer id;
    // 定义用户名称
    private String userName;
    // 定义用户账号
    private String loginAccount;
    // 定义用户密码
    private String password;
    // 定义用户邮件
    private String email;
    // 定义创建用户的日期
    private Date createtime;

}
