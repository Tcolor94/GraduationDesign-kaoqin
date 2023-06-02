package com.example.demo.common;

import com.example.demo.mapper.CourseMapper;
import com.example.demo.pojo.Course;
import com.example.demo.pojo.SignInRecord;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.Teacher;
import jakarta.servlet.ServletContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInStatus {
    private Integer time;
    private Long startTime;
    private String code;
    private String sid;

    public String startSignIn(Course course,
                              Teacher teacher,
                              ServletContext servletContext,
                              CourseMapper courseMapper,
                              Integer time) {
        Random random = new Random();
        String yzm = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 5; ++i) {
            int a = random.nextInt(36);
            code.append(yzm.charAt(a));
        }
//        根据课程名称添加签到任务
        List<SignInStatus> taskList = (List<SignInStatus>) servletContext.getAttribute(course.getName());
        List<Student> students = courseMapper.findStudentsByCourseId(course.getCid());
        for (Student student:students){
            if("1".equals(student.getStatus())){
                SignInRecord signInRecord = new SignInRecord();
                //lambda优化
                signInRecord.setStatus("请假");
                signInRecord.setStudentId(student.getSid());
                signInRecord.setGroupId(student.getGroupId());
                signInRecord.setTeacherId(teacher.getTid());
                signInRecord.setCourseId(course.getCid());
                continue;
            }
            SignInStatus signInStatus = new SignInStatus();
            signInStatus.setTime(time);
            signInStatus.setStartTime(System.currentTimeMillis());
            signInStatus.setCode(code.toString());
            signInStatus.setSid(student.getSid());
            taskList.add(signInStatus);
        }
        servletContext.setAttribute(course.getName(),taskList);
        return code.toString();
    }

//    public String startSign(
//            Teacher teacher,
//            Course course,
//            ServletContext servletContext,
//            StudentMapper studentMapper,
//            SignInRecordMapper signInRecordMapper,
//            CourseMapper courseMapper,
//            GroupMapper groupMapper) {
//        List<SignInStatus> taskList = (List<SignInStatus>) servletContext.getAttribute("taskList");
//        if(taskList==null){
//            taskList = new ArrayList<>(1);
//        }
////        List<Group> groupList = groupMapper.findGroupByTeacherListAndCourseList(teacher,course);
//        List<Student> students = courseMapper.findStudentsByCourseId(course.getCid());
//        Random random = new Random();
//        String code = "";
//        for(Student stu:students) {
//            SignInStatus signinStatus = new SignInStatus();
//            signinStatus.setId(groupDao.findGroupBygId(Integer.parseInt(gro)).getgId());
//            signinStatus.setCourse(course);
//            signinStatus.setStartId(teacher);
//            if(code.equals("")) {
//                for (int i = 0; i < 4; i++) {
//                    code += random.nextInt(10);
//                }
//            }
//            signinStatus.setCode(code);
//            signinStatus.setStartTime(System.currentTimeMillis());
//            List<Student> students = studentDao.findStudentsByGroup(groupDao.findGroupBygId(Integer.parseInt(gro)));
//            //检查该班级有无学生请假
//            for(int i = 0;i<students.size();i++){
//                if(students.get(i).getStatus().equals("请假")){
//                    System.out.println(students.get(i).getStatus());
//                    SignInRecord signinRecord = new SignInRecord();
//                    signinRecord.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//                    signinRecord.setStudentId(students.get(i).getStudentId());
//                    signinRecord.setGroupId(groupDao.findGroupBygId(Integer.parseInt(gro)).getgId());
//                    signinRecord.setStatus("请假");
//                    signinRecordDao.save(signinRecord);
//                    students.remove(i);
//                }
//            }
//            signinStatus.setStudentList(students);
//            taskList.add(signinStatus);
//            servletContext.setAttribute("taskList",taskList);
//        }
//        return code;
//    }
}
