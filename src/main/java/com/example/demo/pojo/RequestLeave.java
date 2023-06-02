package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("tb_request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestLeave {
    private Integer id;
    private String rid;
    @TableField("student_id")
    private String sid;
    private String startTime;
    private String endTime;
    private String reason;
}
