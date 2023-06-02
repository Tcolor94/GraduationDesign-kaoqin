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
@RequestMapping("/common")
public class CommmonController {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private AdminMapper adminMapper;


    @RequestMapping("/changePwd")
    public String changePwd(@RequestParam("type") String type,
                            @RequestParam("id") String id,
                            @RequestParam("oldPwd") String oldPwd,
                            @RequestParam("newPwd") String newPwd
                            ){

        if (type.equals("admin")){
            QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("aid",id).eq("pwd",oldPwd);
            Admin admin = adminMapper.selectOne(queryWrapper);
            if(null != admin){
                admin.setPwd(newPwd);
                adminMapper.updateById(admin);
                return "1";
            }
            return "0";
        }else if (type.equals("teacher")){
            QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("tid",id).eq("pwd",oldPwd);
            Teacher teacher = teacherMapper.selectOne(queryWrapper);
            if(null != teacher){
                teacher.setPwd(newPwd);
                teacherMapper.updateById(teacher);
                return "1";
            }
            return "0";
        }else {
            QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("sid",id).eq("pwd",oldPwd);
            Student student = studentMapper.selectOne(queryWrapper);
            if(null != student){
                student.setPwd(newPwd);
                studentMapper.updateById(student);
                return "1";
            }
            return "0";
        }

    }
}
