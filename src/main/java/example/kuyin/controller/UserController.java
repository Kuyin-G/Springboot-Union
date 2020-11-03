package example.kuyin.controller;


import example.kuyin.bean.ResultJson;
import example.kuyin.bean.User;
import example.kuyin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("user/get")
    public ResultJson<User> getUserById(@RequestParam("id") Integer id){
        if(id!=null){
            User user = userService.getUserById(id);
            if (user!=null){
                return ResultJson.success(user);
            }
        }
        return ResultJson.failure();
    }

    @RequestMapping("/user/insert")
    public ResultJson<User> save(User user){
        if(user==null){
            return ResultJson.failure();
        }
        userService.insert(user);
        return ResultJson.success(user);

    }

    @RequestMapping("/user/update")
    public ResultJson<Map> update(User user){

        Map<String,User> dataMap = new HashMap<>();
        User oldUser = userService.getUserById(user.getId());
        dataMap.put("old",oldUser);
        userService.update(user);
        dataMap.put("new",user);
        return ResultJson.success(dataMap);
    }

    public ResultJson<Map> del(int id){
        Map<String,Object> dataMap = new HashMap<>();
        if (id<=0){
            return ResultJson.failure();
        }
        User delUser = userService.getUserById(id);

        if(delUser!=null){
            userService.deleteById(delUser.getId());
            dataMap.put("del",delUser);
        }else{
            dataMap.put("msg","不存在该用户");
        }

        return ResultJson.success(dataMap);
    }


}