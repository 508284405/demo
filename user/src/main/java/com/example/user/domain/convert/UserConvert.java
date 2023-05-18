package com.example.user.domain.convert;

import com.example.user.infra.mapper.entity.UserEntity;
import com.example.user.infra.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserConvert extends BaseConvert<UserModel, UserEntity> {
}
