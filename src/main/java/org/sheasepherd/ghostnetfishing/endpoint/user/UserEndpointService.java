package org.sheasepherd.ghostnetfishing.endpoint.user;

import lombok.RequiredArgsConstructor;
import org.sheasepherd.ghostnetfishing.domain.user.api.UserService;
import org.sheasepherd.ghostnetfishing.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEndpointService {
    private final UserService userService;
    private final UserEndpointMapper mapper;

    public void registerUser(UserEndpointModel endpointModel) {
        userService.createUser(mapper.toUser(endpointModel));
    }

    public Long verifyLogin(String telefonnr, String password) {
        User user = userService.verifyLogin(telefonnr, password);
        return user != null ? user.getId() : null;
    }
}
