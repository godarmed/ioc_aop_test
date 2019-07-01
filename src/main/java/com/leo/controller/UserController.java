package com.leo.controller;


import com.leo.entity.User;
import com.leo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService ;

    @RequestMapping("/selectUserAll")
    public String selectUserAll(Model model){
        List<User> userList=userService.selectUserAll();
        model.addAttribute("userList",userList);
        return "user/list";
    }
}
