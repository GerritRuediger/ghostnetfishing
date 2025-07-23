package org.sheasepherd.ghostnetfishing.persistence.user.service;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.sheasepherd.ghostnetfishing.domain.user.model.User;
import org.sheasepherd.ghostnetfishing.persistence.user.model.UserDataModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserPersistenceMapper {
    User toUser(UserDataModel dataModel);

    UserDataModel toUserDataModel(User user);
}
