package org.sheasepherd.ghostnetfishing.endpoint.geisternetz;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Geisternetz;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Standort;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GeisternetzEndpointMapper {
    GeisternetzEndpointModel toGeisternetzEndpointModel(Geisternetz geisternetz);

    Standort toStandort(StandortEndpointModel standortEndpointModel);
}
