package com.leo.test;

import com.leo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void selectUserAllTest() {
        System.out.println(userService.selectUserAll());
    }
}
