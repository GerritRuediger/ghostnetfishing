package org.sheasepherd.ghostnetfishing.persistence.geisternetz.service;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Geisternetz;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Groesse;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Standort;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Status;
import org.sheasepherd.ghostnetfishing.persistence.geisternetz.model.GeisternetzDataModel;
import org.sheasepherd.ghostnetfishing.persistence.geisternetz.model.StandortDataModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class GeisternetzPersistenceMapperTest {

    private final GeisternetzPersistenceMapper mapper = Mappers.getMapper(GeisternetzPersistenceMapper.class);

    @Test
    void shouldMapToGeisternetz() {
        StandortDataModel mockStandort = mock(StandortDataModel.class);
        GeisternetzDataModel dataModel = new GeisternetzDataModel();
        dataModel.setId(42L);
        dataModel.setStandort(mockStandort);
        dataModel.setGroesse(Groesse.MITTEL);
        dataModel.setStatus(Status.GEMELDET);

        Geisternetz geisternetz = mapper.toGeisternetz(dataModel);

        assertEquals(dataModel.getId(), geisternetz.getId());
        assertEquals(dataModel.getGroesse(), geisternetz.getGroesse());
        assertEquals(dataModel.getStatus(), geisternetz.getStatus());
    }

    @Test
    void shouldMapToGeisternetzDataModel() {
        Standort mockStandort = mock(Standort.class);
        Geisternetz geisternetz = Geisternetz.builder()
                .id(42L)
                .standort(mockStandort)
                .groesse(Groesse.KLEIN)
                .status(Status.BERGUNG_BEVORSTEHEND)
                .build();

        GeisternetzDataModel dataModel = mapper.toGeisternetzDataModel(geisternetz);

        assertEquals(geisternetz.getId(), dataModel.getId());
        assertEquals(geisternetz.getGroesse(), dataModel.getGroesse());
        assertEquals(geisternetz.getStatus(), dataModel.getStatus());
    }
}