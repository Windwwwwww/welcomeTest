package com.welcome.service.impl;

import com.welcome.Result.Code;
import com.welcome.Result.Result;
import com.welcome.domain.Info;
import com.welcome.exception.SystemException;
import com.welcome.mapper.InfoMapper;
import com.welcome.service.CollectionService;
import com.welcome.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private InfoMapper infoMapper;
    @Autowired
    private SendMailService  mailService;
    public Result addInfo(Info info){
        try{
            if(infoMapper.selectByStuNum(info.getStuNum())!=null){
                System.out.println("你已经提交过报名信息");
                return new Result(Code.AGAIN,"你已经提交过报名信息");
            }
            infoMapper.insert(info);
            mailService.sendMail(info.getEmail(),"Homyit迎新","欢迎你报名参加宏奕工作室");

            return new Result(Code.SUCCESS,"报名成功",info);

        }catch(Exception e){
            e.printStackTrace();
            throw new SystemException("服务器异常",e,Code.ERROR);
        }
    }
}
