package org.seasheperd.ghostnetfishing.persistence.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.seasheperd.ghostnetfishing.domain.user.model.User;
import org.seasheperd.ghostnetfishing.domain.user.spi.UserPersistenceService;
import org.seasheperd.ghostnetfishing.persistence.user.model.UserDataModel;

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
