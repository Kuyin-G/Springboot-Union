package example.kuyin.controller;


import example.kuyin.bean.ResultJson;
import example.kuyin.bean.User;
import example.kuyin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("user/get")
    public ResultJson<User> getUserById(@RequestParam("id") Integer id){
        if(id!=null){
            System.out.println(id);
            User user = userService.getUserById(id);
            if (user!=null){
                return ResultJson.success(user);
            }
        }
        return ResultJson.failure();

    }

    @RequestMapping("/user/getByUser")
    public ResultJson getUserByUser(User user){
        user = userService.getByUser(user);
        if(user==null){
            return  ResultJson.failure("查无此人");
        }else{
            return ResultJson.success(user);
        }

    }

    @RequestMapping("user/like")
    public ResultJson<List<User>> getUserslikeName(@RequestParam("name") String name){
        if (name!= null){
            System.out.println(name);

            User user = new User();
            String param = "%"+name+"%";
            user.setUserName(param);

            List<User> userLikeName = userService.getUserLikeName(user);
            if (userLikeName != null && userLikeName.size() > 0){
                return ResultJson.success(userLikeName);
            }
        }
        return ResultJson.failure();
    }


    @RequestMapping("user/insert")
    public ResultJson<User> insert(User user){
        user.setCreatetime(new Date(System.currentTimeMillis()));
        userService.save(user);
        return ResultJson.success(user);
    }

    @RequestMapping("user/update")
    public ResultJson<User> update(User user){
        userService.update(user);
        return ResultJson.success(user);
    }
    @RequestMapping("user/updateBySelect")
    public ResultJson<User> updateBySelected(User user){
        userService.updateBySelected(user);
        user = userService.getUserById(user.getId());
        return ResultJson.success(user);
    }
}
