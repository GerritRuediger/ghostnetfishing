package org.sheasepherd.ghostnetfishing.endpoint.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserEndpointModel {
    private long id;
    private String vorname;
    private String nachname;
    private String telefonnr;
    private String password;

    public UserEndpointModel() {
        this.id = 0;
    }
}
