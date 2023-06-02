package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.RequestLeave;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface RequestLeaveMapper extends BaseMapper<RequestLeave> {
    @Insert("insert into tb_request values (null,#{sid},#{startTime},#{endTime},#{reason},id)")
    @Options(keyProperty="id",useGeneratedKeys=true)
    Integer addRequest(String sid, String startTime, String endTime, String reason);
}
