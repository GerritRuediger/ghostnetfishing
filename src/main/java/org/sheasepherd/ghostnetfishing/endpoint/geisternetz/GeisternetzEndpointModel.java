package org.sheasepherd.ghostnetfishing.endpoint.geisternetz;

import lombok.Data;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Groesse;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Status;

@Data
public class GeisternetzEndpointModel {
    private long id;
    private StandortEndpointModel standort;
    private Groesse groesse;
    private Status status;
    private Long userId;

    public GeisternetzEndpointModel() {
        this.id = 0;
    }
}
