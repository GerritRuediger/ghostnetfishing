package org.seasheperd.ghostnetfishing.endpoint.geisternetz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class StandortEndpointModel {
    long id;
    double breitengrad;
    double laengengrad;

    StandortEndpointModel() {
        this.id = 0;
    }
}
