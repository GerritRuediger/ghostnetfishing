package org.seasheperd.ghostnetfishing.persistence.user.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.seasheperd.ghostnetfishing.persistence.user.model.UserDataModel;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDataModel, Long> {
  Optional<UserDataModel> findByTelefonnrAndPassword(String telefonnr, String password);
}
