package com.welcome.controller;

import com.welcome.Result.Result;
import com.welcome.Token.PassToken;
import com.welcome.domain.Info;
import com.welcome.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/signup")
@Scope("prototype")
public class ColletionController {
    @Autowired
    private CollectionService  service;
    @PostMapping
    public Result insertInfo(@RequestBody Info info){

        LocalDate date=LocalDate.now();
        info.setTime(date);
        return service.addInfo(info);
    }
}
