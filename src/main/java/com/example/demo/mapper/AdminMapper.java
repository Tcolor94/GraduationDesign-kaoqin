package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    @Select("select * from tb_admin")
    List<Admin> showAllAdmins();


    @Select("select * from tb_admin where aid = #{aid}")
    Admin getEntity(String aid);
}
