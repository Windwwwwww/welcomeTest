package com.welcome.Vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDate;
@Data
public class InfoVO {
    @ExcelProperty("编号")
    @ColumnWidth(10)
    private int id;
    @ExcelProperty("学号")
    @ColumnWidth(40)
    private String  stuNum;
    @ExcelProperty("姓名")
    @ColumnWidth(20)
    private String name;
    @ExcelProperty("班级")
    @ColumnWidth(20)
    private String stuClass;
    @ExcelProperty("电话")
    @ColumnWidth(30)
    private String  tel;
    @ExcelProperty("邮箱")
    @ColumnWidth(40)
    private String  email;
    @ExcelProperty("QQ号")
    @ColumnWidth(40)
    private String qqNum;
}
