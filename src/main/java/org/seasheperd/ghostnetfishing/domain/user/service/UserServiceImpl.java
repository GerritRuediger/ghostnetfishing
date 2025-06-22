package org.seasheperd.ghostnetfishing.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.seasheperd.ghostnetfishing.domain.user.api.UserService;
import org.seasheperd.ghostnetfishing.domain.user.model.User;
import org.seasheperd.ghostnetfishing.domain.user.spi.UserPersistenceService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserPersistenceService userPersistenceService;


  @Override
  public boolean createUser(User user) {
    return userPersistenceService.createUser(user) != null;
  }

  @Override
  public User verifyLogin(String telefonnr, String password) {
    return userPersistenceService.verifyLogin(telefonnr, password);
  }
}
