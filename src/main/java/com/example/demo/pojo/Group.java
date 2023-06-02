package com.example.demo.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@TableName("tb_group")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Group {
    private Integer id;
    private String gid;
}