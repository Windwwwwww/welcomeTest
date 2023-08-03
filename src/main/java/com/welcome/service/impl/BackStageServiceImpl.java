package com.welcome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.welcome.Result.Code;
import com.welcome.Result.Result;
import com.welcome.domain.Info;
import com.welcome.domain.User;
import com.welcome.exception.SystemException;
import com.welcome.mapper.InfoMapper;
import com.welcome.mapper.UserMapper;
import com.welcome.service.BackStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Scope("prototype")
public class BackStageServiceImpl implements BackStageService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    InfoMapper infoMapper;
    @Override
    public Result login(User user) {

        try{
            Map<String,Object> map=new HashMap<>();
            map.put("account",user.getAccount());
            map.put("password",user.getPassword());
            if(userMapper.selectByMap(map)==null){
                System.out.println("wrong");
                return new Result(Code.BACKSTAGE_SELECTERROR,"账号或密码错误");

            }
            System.out.println("success");
            return new Result(Code.BACKSTAGE_SUCCESS,"登陆成功",user);
            //记得写拦截器！！！
            //然后这里要设置重定向
        }catch (Exception e){
            e.printStackTrace();
            throw new SystemException("服务器异常",e,Code.BACKSTAGE_ERROR);
        }

    }


    @Override
    public Result selectByClass(String stuClass) {
        try{
            Map<String,Object> map=new HashMap<>();
            map.put("stu_class",stuClass);
            List<Info> infolist=infoMapper.selectByMap(map);
            infolist.forEach(info->System.out.println(info));
            return new Result(Code.BACKSTAGE_SUCCESS,infolist);
        }catch (Exception e){
            e.printStackTrace();
            throw new SystemException("服务器异常",e, Code.BACKSTAGE_ERROR);
        }


    }

    @Override
    public Result likeSelectByName(String name) {
        try{
            QueryWrapper<Info> wrapper=new QueryWrapper<>();
            wrapper.like("name",name);
            List<Info> infolist=infoMapper.selectList(wrapper);
            infolist.forEach(info->System.out.println(info));
            return new Result(Code.BACKSTAGE_SUCCESS,infolist);
        }catch (Exception e){
            e.printStackTrace();
            throw new SystemException("服务器异常",e, Code.BACKSTAGE_ERROR);
        }
    }

    @Override
    public Result selectByTime(String time) {
        return null;
    }
}
