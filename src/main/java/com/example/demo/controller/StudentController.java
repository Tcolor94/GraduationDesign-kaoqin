package com.example.demo.controller;

import com.example.demo.pojo.Student;
import com.example.demo.service.RequestLeaveService;
import com.example.demo.service.StudentService;
import com.google.gson.Gson;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("all")
@CrossOrigin(origins = {"*", "null"})
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private StudentService studentService;
    @Autowired
    private RequestLeaveService requestLeaveService;
//要改成sid和cid，然后在函数里面创建实体

    @RequestMapping("/toSignIn")
    public String toSignIn(@RequestParam("sid") String sid,
                           @RequestParam("cid") String cid) {
        return studentService.toSignIn(sid, cid, servletContext);

    }

    @RequestMapping("/signIn")
    public String signIn(@RequestParam("sid") String sid,
                         @RequestParam("cid") String cid,
                         @RequestParam("code") String code) {
        return studentService.signIn(sid, cid, code, servletContext);
    }

//	还要加一个"/requestLeave",接收sid、startTime、endTime、reason，全string，不返回
//	这个要保存在serveletcontext里面，是一个list内的元素，requestleave类

    @RequestMapping("/getEntity")
    public String getEntity(@RequestParam("sid") String sid) {
        Gson gson = new Gson();
        Student entity = studentService.getEntity(sid);
        return gson.toJson(entity);
    }

    @RequestMapping("/requestLeave")
    public void requestLeave(@RequestParam("sid") String sid,
                             @RequestParam("startTime") String startTime,
                             @RequestParam("endTime") String endTime,
                             @RequestParam("reason") String reason) {
        // flag == 1 表示创建申请成功； == 0 表示失败
        Integer flag = requestLeaveService.addRequest(sid, startTime, endTime, reason);

    }

}
