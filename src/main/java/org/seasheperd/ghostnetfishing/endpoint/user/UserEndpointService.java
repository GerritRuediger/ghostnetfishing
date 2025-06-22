package org.seasheperd.ghostnetfishing.endpoint.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.seasheperd.ghostnetfishing.domain.user.api.UserService;

@Service
@RequiredArgsConstructor
public class UserEndpointService {
  private final UserService userService;
  private final UserEndpointMapper mapper;

  public void registerUser(UserEndpointModel endpointModel) {
    userService.createUser(mapper.toUser(endpointModel));
  }

  public void verifyLogin(String telefonnr, String password) {
    userService.verifyLogin(telefonnr, password);
  }
}
