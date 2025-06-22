package org.seasheperd.ghostnetfishing.endpoint.geisternetz;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Geisternetz;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Standort;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GeisternetzEndpointMapper {
    GeisternetzEndpointModel toGeisternetzEndpointModel(Geisternetz geisternetz);

    Geisternetz toGeisternetz(GeisternetzEndpointModel geisternetzEndpointModel);

    Standort toStandort(StandortEndpointModel standortEndpointModel);
}
