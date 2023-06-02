package com.example.demo.controller;

import com.example.demo.pojo.Course;
import com.example.demo.pojo.Teacher;
import com.example.demo.service.CourseService;
import com.example.demo.service.SignInRecordService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
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
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SignInRecordService signInRecordService;



    @RequestMapping("/startSignIn")
    public String startSignIn(@RequestParam("tid") String tid,
                              @RequestParam("cid") String cid,
                              @RequestParam("time") String time
                              ){
        Teacher teacher = teacherService.getEntity(tid);
        Course course = courseService.searchByCidCourse(cid);
        int i = Integer.parseInt(time);

        String code = teacherService.startSignIn(teacher,course,servletContext,i);
        return code;

    }
	
//	还要添加一个"/modify",
//	传入sid、cid、status（是signInRecord内的status）,返回“1”表示成功修改学生记录，“0”表示失败（找不到学生记录之类的）
    @RequestMapping("/modify")
    public String modify(@RequestParam("sid") String sid,
                         @RequestParam("cid") String cid,
                         @RequestParam("status") String status){
        return signInRecordService.modifyRecord(sid, cid, status);
    }


//所有都要加一个返回用户对象的接口getEntity

    @RequestMapping("/getEntity")
    public String getEntity(@RequestParam("tid") String tid){
        Gson gson = new Gson();
        Teacher entity = teacherService.getEntity(tid);
        return gson.toJson(entity);
    }
}
