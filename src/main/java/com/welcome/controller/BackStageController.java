package com.welcome.controller;

import com.welcome.Result.Code;
import com.welcome.Result.Result;
import com.welcome.Token.PassToken;
import com.welcome.domain.User;
import com.welcome.service.BackStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Scope("prototype")
@RestController
@RequestMapping("/backstage")
public class BackStageController {
    @Autowired
    BackStageService service;
    @PassToken
    @PostMapping ("/login")
    public Result login(@RequestBody User user) {
        return service.login(user);

    }


    @GetMapping("/selectbyclass/{stuClass}")
    public Result selectByClass(@PathVariable String stuClass){
        return service.selectByClass(stuClass);


    }
    @GetMapping("/likeselectbyName/{name}")
    public Result likeSelectByName(@PathVariable String name){
        return service.likeSelectByName(name);


    }

    @GetMapping("/selectbytime/{time}")
    public Result selectByTime(@PathVariable String time){

        return null;
    }
}
