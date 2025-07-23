package org.sheasepherd.ghostnetfishing.domain.user.api;

import org.sheasepherd.ghostnetfishing.domain.user.model.User;

public interface UserService {
    boolean createUser(User user);

    User verifyLogin(String telefonnr, String password);
}
