package org.sheasepherd.ghostnetfishing.endpoint.user;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.sheasepherd.ghostnetfishing.domain.user.model.User;

import static org.assertj.core.api.Assertions.assertThat;

class UserEndpointMapperTest {

    UserEndpointMapper mapper = Mappers.getMapper(UserEndpointMapper.class);

    @Test
    void toUser() {
        UserEndpointModel userEndpointModel = UserEndpointModel.builder()
                .id(123L)
                .vorname("Hans")
                .nachname("Mustermann")
                .telefonnr("0123456789")
                .password("<PASSWORD>")
                .build();

        User user = mapper.toUser(userEndpointModel);

        assertThat(user.getId()).isEqualTo(userEndpointModel.getId());
        assertThat(user.getVorname()).isEqualTo(userEndpointModel.getVorname());
        assertThat(user.getNachname()).isEqualTo(userEndpointModel.getNachname());
        assertThat(user.getTelefonnr()).isEqualTo(userEndpointModel.getTelefonnr());
        assertThat(user.getPassword()).isEqualTo(userEndpointModel.getPassword());
    }
}