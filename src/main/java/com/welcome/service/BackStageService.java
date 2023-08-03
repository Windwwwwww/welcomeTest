package com.welcome.service;

import com.welcome.Result.Result;
import com.welcome.domain.User;

import java.util.Date;

public interface BackStageService {
    public Result login(User user);

    public Result selectByClass(String stuClass);
    public Result likeSelectByName(String name);
    public Result selectByTime(String time);
}
