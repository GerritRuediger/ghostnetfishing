package org.sheasepherd.ghostnetfishing.endpoint.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sheasepherd.ghostnetfishing.domain.user.api.UserService;
import org.sheasepherd.ghostnetfishing.domain.user.model.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserEndpointServiceTest {

    @Mock
    UserEndpointMapper mapper;
    @Mock
    UserService userService;
    @InjectMocks
    UserEndpointService endpointService;

    @Test
    void registerUser() {
        User user = new User();
        when(mapper.toUser(any())).thenReturn(user);
        UserEndpointModel userEndpointModel = new UserEndpointModel();

        endpointService.registerUser(userEndpointModel);

        verify(mapper, times(1)).toUser(userEndpointModel);
        verify(userService, times(1)).createUser(user);

    }

    @Test
    void verifyLoginSuccessfull() {
        String telefonnr = "123456789";
        String password = "<PASSWORD>";
        User user = new User();
        when(userService.verifyLogin(telefonnr, password)).thenReturn(user);

        assertThat(endpointService.verifyLogin(telefonnr, password)).isEqualTo(user.getId());
        verify(userService, times(1)).verifyLogin(telefonnr, password);
    }

    @Test
    void verifyLogin() {
        String telefonnr = "123456789";
        String password = "<PASSWORD>";
        when(userService.verifyLogin(telefonnr, password)).thenReturn(null);

        assertThat(endpointService.verifyLogin(telefonnr, password)).isNull();
        verify(userService, times(1)).verifyLogin(telefonnr, password);
    }
}