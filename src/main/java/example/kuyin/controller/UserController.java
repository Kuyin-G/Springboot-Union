package example.kuyin.controller;


import example.kuyin.bean.ResultJson;
import example.kuyin.bean.User;
import example.kuyin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
}