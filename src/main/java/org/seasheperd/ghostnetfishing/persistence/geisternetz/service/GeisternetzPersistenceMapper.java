package org.seasheperd.ghostnetfishing.persistence.geisternetz.service;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Geisternetz;
import org.seasheperd.ghostnetfishing.persistence.geisternetz.model.GeisternetzDataModel;

@Mapper(componentModel = "spring")
public interface GeisternetzPersistenceMapper {
  Geisternetz toGeisternetz(GeisternetzDataModel dataModel);

  GeisternetzDataModel toGeisternetzDataModel(Geisternetz geisternetz);

}
