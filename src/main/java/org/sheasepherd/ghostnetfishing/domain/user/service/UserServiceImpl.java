package org.sheasepherd.ghostnetfishing.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.sheasepherd.ghostnetfishing.domain.user.api.UserService;
import org.sheasepherd.ghostnetfishing.domain.user.model.User;
import org.sheasepherd.ghostnetfishing.domain.user.spi.UserPersistenceService;
import org.springframework.stereotype.Service;

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
