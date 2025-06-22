package org.seasheperd.ghostnetfishing.persistence.user.service;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import org.seasheperd.ghostnetfishing.domain.user.model.User;
import org.seasheperd.ghostnetfishing.persistence.user.model.UserDataModel;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {
  User toUser(UserDataModel dataModel);

  UserDataModel toUserDataModel(User user);
}
