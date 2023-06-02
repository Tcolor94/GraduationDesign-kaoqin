package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.mapper.RequestLeaveMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.mapper.TeacherMapper;
import com.example.demo.pojo.Admin;
import com.example.demo.pojo.RequestLeave;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.Teacher;
import com.example.demo.service.AdminService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@SuppressWarnings("all")
@CrossOrigin(origins = {"*", "null"})
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RequestLeaveMapper requestLeaveMapper;
    @Autowired
    private AdminService adminService;


    @RequestMapping("/addUser")
    public String addUser(@RequestParam("type") String utype,
                          @RequestParam("id") String uid,
                          @RequestParam("name") String name) {
        if (StringUtils.isNotBlank(utype)) {
            if (utype.equals("student")) {
                Student student = new Student();
                student.setSid(uid);
                student.setName(name);
                student.setPwd("123456");
                studentMapper.insert(student);
            } else if (utype.equals("teacher")) {
                Teacher teacher = new Teacher();
                teacher.setTid(uid);
                teacher.setName(name);
                teacher.setPwd("123456");
                teacherMapper.insert(teacher);
            } else if (utype.equals("admin")) {
                Admin admin = new Admin();
                admin.setAid(uid);
                admin.setPwd("123456");
                adminMapper.insert(admin);
            } else {
                return "0";
            }
            return "1";
        }
        return "0";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("type") String utype, @RequestParam("id") String uid) {
        int result = 0;
        if (StringUtils.isNotBlank(utype)) {
            Map<String, Object> columnMap = new HashMap<>();
            if (utype.equals("student")) {
                columnMap.put("sid", uid);
                result = studentMapper.deleteByMap(columnMap);
            } else if (utype.equals("teacher")) {
                columnMap.put("tid", uid);
                result = teacherMapper.deleteByMap(columnMap);
            } else if (utype.equals("admin")) {
                columnMap.put("aid", uid);
                result = adminMapper.deleteByMap(columnMap);
            }
        }
        return Integer.toString(result);
    }

//	还需要一个"/request"，返回的是list<requestleave>，无参数接收，要使用gson在本地序列化list再发送
//	// 假设 students 是一个 List<Student> 类型的对象
//val gson = Gson()
//val jsonString = gson.toJson(students)
//
//	还要一个requestDeal，处理批准或者否决请假申请
//	接收的是"1"和“0”，不返回，详见RequestAdapter

// 将 jsonString 发送到客户端，客户端进行解析

    @RequestMapping("/request")
    public String request() {
        //查询并返回全部的请假申请
        List<RequestLeave> requestLeaves = requestLeaveMapper.selectList(null);
        Gson gson = new Gson();
        return gson.toJson(requestLeaves);
    }

    @RequestMapping("/requestDeal")
    public void requestDeal(@RequestParam("flag") String flag,
                            @RequestParam("sid") String sid,
                            @RequestParam("rid") String rid) {
        if (flag.equals("1")) {
            QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("sid", sid);
            Student student = studentMapper.selectOne(queryWrapper);
            student.setStatus("请假");
        }

        // 删除该申请
        QueryWrapper<RequestLeave> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("rid", rid);
        requestLeaveMapper.delete(queryWrapper);
    }

    //所有都要加一个返回用户对象的接口getEntity
    @RequestMapping("/getEntity")
    public String getEntity(String aid){
        Gson gson = new Gson();
        Admin entity = adminService.getEntity(aid);
        return gson.toJson(entity);
    }
}
