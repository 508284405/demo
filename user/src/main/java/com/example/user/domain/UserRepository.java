package com.example.user.domain;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.user.infra.mapper.entity.UserEntity;
import com.example.user.infra.model.UserModel;
import com.example.user.vo.UserInfoVo;

import java.util.List;

public interface UserRepository{

    List<UserModel> list();

    int add(UserModel model);

    UserModel get(Long id);
}
