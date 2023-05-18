package com.example.user.service.impl;

import com.example.user.cmd.UserInfoCmd;
import com.example.user.domain.UserRepository;
import com.example.user.service.UserService;
import com.example.user.service.translat.UserTanslator;
import com.example.user.vo.UserInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserTanslator userTanslator;

    @Cacheable(sync = true,cacheNames = "user",key = "'list'")
    public List<UserInfoVo> list() {
        return userTanslator.toUserInfoVos(userRepository.list());
    }

    @Override
    public int add(UserInfoCmd cmd) {
        return userRepository.add(userTanslator.toUserModel(cmd));
    }

    @Override
    @Cacheable(sync = true,cacheNames = "user")
    public UserInfoVo get(Long id) {
        return userTanslator.toUserInfoVo(userRepository.get(id));
    }
}
