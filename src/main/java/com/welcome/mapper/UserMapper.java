package com.welcome.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.welcome.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from tbl_user where account=#{account} and password=#{password}")
    public User selectByPassAndAcc(@Param("account") String account, @Param("password") String password);
}
