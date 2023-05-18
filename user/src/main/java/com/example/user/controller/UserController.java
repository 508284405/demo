package com.example.user.controller;

import com.alibaba.nacos.api.model.v2.Result;
import com.example.user.cmd.UserInfoCmd;
import com.example.user.service.UserService;
import com.example.user.vo.UserInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/listAll")
    public Result<List<UserInfoVo>> listALl() {
        return Result.success(userService.list());
    }

    @PostMapping("/add")
    public Result<Integer> add(@RequestBody UserInfoCmd cmd) {
        return Result.success(userService.add(cmd));
    }

    @GetMapping("/get")
    public Result<UserInfoVo> get(@RequestParam("id") Long id) {
        return Result.success(userService.get(id));
    }
}
