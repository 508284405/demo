package com.example.user.infra;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.user.domain.UserRepository;
import com.example.user.domain.convert.UserConvert;
import com.example.user.infra.mapper.UserMapper;
import com.example.user.infra.mapper.entity.UserEntity;
import com.example.user.infra.model.UserModel;
//import com.example.user.util.IdUtils;
import com.example.user.util.IdUtils;
import com.example.user.vo.UserInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserMapper userMapper;
    private final UserConvert userConvert;

    public List<UserModel> list() {
        return userConvert.toDomains(userMapper.selectList(Wrappers.emptyWrapper()));
    }

    @Override
    public int add(UserModel model) {
        model.setId(IdUtils.nextId());
        return userMapper.insert(userConvert.toEntity(model));
    }

    @Override
    public UserModel get(Long id) {
        return userConvert.toDomain(userMapper.selectById(id));
    }
}
