package com.example.user.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.user.infra.mapper.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
