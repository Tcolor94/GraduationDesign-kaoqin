package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.mapper.TeacherMapper;
import com.example.demo.pojo.Admin;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@SuppressWarnings("all")
@CrossOrigin(origins = {"*", "null"})
@RequestMapping("/login")
public class HelloController {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private AdminMapper adminMapper;



    @RequestMapping("/student")
    public String loginStudent(@RequestParam("id") String stuId, @RequestParam("pwd") String stuPwd){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid",stuId).eq("pwd",stuPwd);
        if(queryWrapper == null){
            //该用户不存在或密码输入错误
            return "0";
        }
        //登录成功
        return "1";
    }
    @RequestMapping("/teacher")
    public String loginTeacher(@RequestParam("id") String tchId, @RequestParam("pwd") String tchPwd){
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tid",tchId).eq("pwd",tchPwd);
        if(queryWrapper == null){
            //该用户不存在或密码输入错误
            return "0";
        }
        //登录成功
        return "1";
    }

    @RequestMapping("/admin")
    public String loginAdmin(@RequestParam("id") String adminId, @RequestParam("pwd") String adminPwd){
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("aid",adminId).eq("pwd",adminPwd);
        if(queryWrapper == null){
            //该用户不存在或密码输入错误
            return "0";
        }
        //登录成功
        return "1";
    }
}
