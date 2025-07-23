package org.sheasepherd.ghostnetfishing.persistence.geisternetz.service;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Geisternetz;
import org.sheasepherd.ghostnetfishing.persistence.geisternetz.model.GeisternetzDataModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GeisternetzPersistenceMapper {
    Geisternetz toGeisternetz(GeisternetzDataModel dataModel);

    GeisternetzDataModel toGeisternetzDataModel(Geisternetz geisternetz);

}
