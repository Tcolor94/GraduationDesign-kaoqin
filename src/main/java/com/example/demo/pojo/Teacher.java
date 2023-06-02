package com.example.demo.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_teacher")
public class Teacher {
    private Integer id;
    private String tid;
    private String name;
    @TableField(select = false)
    private String pwd;

}