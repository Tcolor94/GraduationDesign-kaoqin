package com.example.demo.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_course")
public class Course {
    private Integer id;
    private String cid;
    private String name;
    @TableField("teacher_id")
    private String teacherId;
}