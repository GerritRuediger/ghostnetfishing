package org.seasheperd.ghostnetfishing.domain.user.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.seasheperd.ghostnetfishing.domain.user.model.User;
import org.seasheperd.ghostnetfishing.domain.user.spi.UserPersistenceService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserPersistenceService userPersistenceService;
    @InjectMocks
    UserServiceImpl userService;

    @Test
    void createUserSuccessfull() {
        User user = new User();
        when(userPersistenceService.createUser(user)).thenReturn(user);

        assertThat(userService.createUser(user)).isTrue();
    }

    @Test
    void createUserNotSuccessfull() {
        User user = new User();
        when(userPersistenceService.createUser(user)).thenReturn(null);

        assertThat(userService.createUser(user)).isFalse();
    }

    @Test
    void verifyLogin() {
        String telefonnr = "123456789";
        String password = "<PASSWORD>";

        userService.verifyLogin(telefonnr, password);

        verify(userPersistenceService, times(1)).verifyLogin(telefonnr, password);
    }
}