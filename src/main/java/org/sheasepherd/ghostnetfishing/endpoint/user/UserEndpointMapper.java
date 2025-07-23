package org.sheasepherd.ghostnetfishing.endpoint.user;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.sheasepherd.ghostnetfishing.domain.user.model.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserEndpointMapper {
    User toUser(UserEndpointModel userEndpointModel);
}
