package com.example.demo.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@TableName("tb_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInRecord {
    private Integer id;
    private String status;
    @TableField("student_id")
    private String studentId;
    @TableField("group_id")
    private String groupId;
    @TableField("teacher_id")
    private String teacherId;
    @TableField("course_id")
    private String courseId;

}