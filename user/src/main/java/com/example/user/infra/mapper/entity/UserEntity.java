package com.example.user.infra.mapper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("user")
@Data
public class UserEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String age;
    private String email;
}
