package com.welcome.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@TableName("tbl_sign")
public class Info {
    private int id;
    @TableField("stu_num")
    private String  stuNum;
    private String name;
    @TableField("stu_class")
    private String stuClass;
    private String  tel;
    private String  email;
    @TableField("qq_num")
    private String qqNum;
    private String introduce;
    private LocalDate time;

}
