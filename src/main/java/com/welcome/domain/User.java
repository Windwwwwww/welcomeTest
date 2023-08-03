package com.welcome.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tbl_user")
public class User {
    private int id;
    private String account;
    private String password;
}
