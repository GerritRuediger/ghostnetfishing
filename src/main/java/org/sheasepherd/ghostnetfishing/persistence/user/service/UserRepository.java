package org.sheasepherd.ghostnetfishing.persistence.user.service;

import org.sheasepherd.ghostnetfishing.persistence.user.model.UserDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDataModel, Long> {
    Optional<UserDataModel> findByTelefonnrAndPassword(String telefonnr, String password);
}
