package org.seasheperd.ghostnetfishing.domain.user.spi;

import org.seasheperd.ghostnetfishing.domain.user.model.User;

public interface UserPersistenceService {
  User createUser(User user);

  User verifyLogin(String telefonnr, String password);
}
