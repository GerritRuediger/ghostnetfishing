package org.seasheperd.ghostnetfishing.endpoint.geisternetz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Geisternetz;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Groesse;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Standort;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Status;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class GeisternetzEndpointMapperTest {

    GeisternetzEndpointMapper mapper = Mappers.getMapper(GeisternetzEndpointMapper.class);


    @Test
    void toGeisternetzEndpointModel() {
        Geisternetz geisternetz = Geisternetz.builder()
                .id(12)
                .groesse(Groesse.MITTEL)
                .status(Status.BERGUNG_BEVORSTEHEND)
                .userId(145L)
                .build();

        GeisternetzEndpointModel endpointModel = mapper.toGeisternetzEndpointModel(geisternetz);

        assertThat(endpointModel.getId()).isEqualTo(geisternetz.getId());
        assertThat(endpointModel.getGroesse()).isEqualTo(geisternetz.getGroesse());
        assertThat(endpointModel.getStatus()).isEqualTo(geisternetz.getStatus());
        assertThat(endpointModel.getUserId()).isEqualTo(geisternetz.getUserId());
    }

    @Test
    void toStandort() {
        StandortEndpointModel standortEndpointModel = StandortEndpointModel.builder()
                .id(123L)
                .laengengrad(12.3)
                .breitengrad(13.4)
                .build();

        Standort standort = mapper.toStandort(standortEndpointModel);

        assertThat(standort.getId()).isEqualTo(standortEndpointModel.getId());
        assertThat(standort.getLaengengrad()).isEqualTo(standortEndpointModel.getLaengengrad());
        assertThat(standort.getBreitengrad()).isEqualTo(standortEndpointModel.getBreitengrad());
    }
}