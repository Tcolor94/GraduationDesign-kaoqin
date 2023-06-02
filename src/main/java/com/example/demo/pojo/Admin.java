package com.example.demo.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_admin")
public class Admin {
    private Integer id;
    private String aid;
    @TableField(select = false)
    private String pwd;

}
