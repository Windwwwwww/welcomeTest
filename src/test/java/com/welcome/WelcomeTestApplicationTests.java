package com.welcome;

import com.welcome.controller.BackStageController;
import com.welcome.controller.ColletionController;
import com.welcome.domain.Info;
import com.welcome.domain.User;
import com.welcome.service.BackStageService;
import com.welcome.service.CollectionService;
import com.welcome.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WelcomeTestApplicationTests {

    @Autowired
    private CollectionService service;
    @Autowired
    private ColletionController controller;
    @Test
    void contextLoads() {
        Info info=new Info();
        info.setStuNum("202028");
        info.setName("absjabb");
        info.setQqNum("1605903732");
        info.setEmail("1605903732@qq.com");
        info.setTel("17836132972");
        info.setStuClass("计师一班");
        info.setQqNum("1605903732");
        controller.insertInfo(info);



    }
    @Autowired
    SendMailService mail;
    @Test
    void mailTest(){
        mail.sendMail("1605903732@qq.com","nihao","nihao");

    }
    @Autowired
    private BackStageService Bservice;

    @Test
    void login(){
        User user=new User();
        user.setAccount("admin");
        user.setPassword("123456");
        Bservice.login(user);
    }

    @Test
    void selectByClass(){
        Bservice.selectByClass("计师一班");
    }

    @Test
    void  likeSelectByName(){
        Bservice.likeSelectByName("b");
    }

}
