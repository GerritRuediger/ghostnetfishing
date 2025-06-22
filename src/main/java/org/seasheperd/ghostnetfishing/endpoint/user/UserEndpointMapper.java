package org.seasheperd.ghostnetfishing.endpoint.user;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Service;
import org.seasheperd.ghostnetfishing.domain.user.model.User;

@Service
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserEndpointMapper {
  UserEndpointModel toUserEndpointModel(User user);

  User toUser(UserEndpointModel userEndpointModel);
}
