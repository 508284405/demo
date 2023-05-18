package com.example.user.service.translat;

import com.example.user.cmd.UserInfoCmd;
import com.example.user.infra.model.UserModel;
import com.example.user.vo.UserInfoVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserTanslator {

    UserInfoVo toUserInfoVo(UserModel model);
    List<UserInfoVo> toUserInfoVos(List<UserModel> list);

    UserModel toUserModel(UserInfoCmd cmd);
}
