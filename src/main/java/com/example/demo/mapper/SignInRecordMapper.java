package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.common.SignInStatus;
import com.example.demo.pojo.Course;
import com.example.demo.pojo.SignInRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SignInRecordMapper extends BaseMapper<SignInRecord> {
    /**
     * @return 0->表示插入失败,1->表示插入成功
     */
    @Insert("insert into tb_record values (null,#{signInRecord.status},#{signInRecord.studentId},#{signInRecord.groupId},#{signInRecord.teacherId},#{signInRecord.courseId})")
    @Options(keyProperty="signInRecord.id",useGeneratedKeys=true)
    Integer addRecord(SignInRecord signInRecord);
}
