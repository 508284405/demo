package com.example.user.service;

import com.example.user.cmd.UserInfoCmd;
import com.example.user.vo.UserInfoVo;

import java.util.List;

public interface UserService {
    List<UserInfoVo> list();

    int add(UserInfoCmd cmd);

    UserInfoVo get(Long id);
}
