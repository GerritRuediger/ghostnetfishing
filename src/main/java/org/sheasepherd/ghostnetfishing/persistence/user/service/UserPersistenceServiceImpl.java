package org.sheasepherd.ghostnetfishing.persistence.user.service;

import lombok.RequiredArgsConstructor;
import org.sheasepherd.ghostnetfishing.domain.user.model.User;
import org.sheasepherd.ghostnetfishing.domain.user.spi.UserPersistenceService;
import org.sheasepherd.ghostnetfishing.persistence.user.model.UserDataModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPersistenceServiceImpl implements UserPersistenceService {

    private final UserRepository userRepository;
    private final UserPersistenceMapper userPersistenceMapper;

    @Override
    public User createUser(User user) {
        UserDataModel dataModel = userPersistenceMapper.toUserDataModel(user);

        UserDataModel saved = userRepository.save(dataModel);

        return userPersistenceMapper.toUser(saved);
    }

    @Override
    public User verifyLogin(String telefonnr, String password) {
        return userRepository.findByTelefonnrAndPassword(telefonnr, password).map(userPersistenceMapper::toUser).orElse(null);
    }
}
