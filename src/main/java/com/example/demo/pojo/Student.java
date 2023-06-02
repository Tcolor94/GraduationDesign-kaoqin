package com.example.demo.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * status:
 * 0-正常
 * 1-请假
 * 2后未定
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_student")
public class Student {
    private Integer id;
    private String sid;
    @TableField(select = false)
    private String pwd;
    private String name;
    private String status;
    @TableField(value = "group_id")
    private String groupId;

}