package org.seasheperd.ghostnetfishing.persistence.geisternetz.service;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Service;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Geisternetz;
import org.seasheperd.ghostnetfishing.persistence.geisternetz.model.GeisternetzDataModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GeisternetzPersistenceMapper {
  Geisternetz toGeisternetz(GeisternetzDataModel dataModel);

  GeisternetzDataModel toGeisternetzDataModel(Geisternetz geisternetz);

}
