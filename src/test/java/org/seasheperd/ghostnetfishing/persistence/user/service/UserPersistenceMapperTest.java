package org.seasheperd.ghostnetfishing.persistence.user.service;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.seasheperd.ghostnetfishing.domain.user.model.User;
import org.seasheperd.ghostnetfishing.persistence.user.model.UserDataModel;

import static org.assertj.core.api.Assertions.assertThat;

public class UserPersistenceMapperTest {

    UserPersistenceMapper mapper = Mappers.getMapper(UserPersistenceMapper.class);

    @Test
    void toUser() {
        UserDataModel userDataModel = new UserDataModel(1, "V", "B", "1", "qwe");

        User user = mapper.toUser(userDataModel);

        assertThat(user.getId()).isEqualTo(userDataModel.getId());
        assertThat(user.getVorname()).isEqualTo(userDataModel.getVorname());
        assertThat(user.getNachname()).isEqualTo(userDataModel.getNachname());
        assertThat(user.getTelefonnr()).isEqualTo(userDataModel.getTelefonnr());
        assertThat(user.getPassword()).isEqualTo(userDataModel.getPassword());
    }

    @Test
    void toUserDataModel() {
        User user = new User(1, "V", "B", "1", "qwe");

        UserDataModel userDataModel = mapper.toUserDataModel(user);

        assertThat(user.getId()).isEqualTo(userDataModel.getId());
        assertThat(user.getVorname()).isEqualTo(userDataModel.getVorname());
        assertThat(user.getNachname()).isEqualTo(userDataModel.getNachname());
        assertThat(user.getTelefonnr()).isEqualTo(userDataModel.getTelefonnr());
        assertThat(user.getPassword()).isEqualTo(userDataModel.getPassword());
    }
}