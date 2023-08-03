package com.welcome.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.welcome.domain.Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InfoMapper extends BaseMapper<Info> {
    @Select("select * from tbl_sign where stu_num=#{stuNum}")
    public Info selectByStuNum(String stuNum);
}
