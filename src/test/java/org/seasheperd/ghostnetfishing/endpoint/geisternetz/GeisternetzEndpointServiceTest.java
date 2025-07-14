package org.seasheperd.ghostnetfishing.endpoint.geisternetz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.seasheperd.ghostnetfishing.domain.geisternetz.api.GeisternetzService;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Geisternetz;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Groesse;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Status;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GeisternetzEndpointServiceTest {

    @Mock
    GeisternetzEndpointMapper mapper;

    @Mock
    GeisternetzService geisternetzService;

    @InjectMocks
    GeisternetzEndpointService endpointService;

    @Test
    void submitNewGeisternetz() {
        StandortEndpointModel standort = new StandortEndpointModel();
        Groesse groesse = Groesse.MITTEL;

        endpointService.submitNewGeisternetz(standort, groesse);

        verify(geisternetzService, times(1)).createGeisternetz(mapper.toStandort(standort), groesse);
    }

    @Test
    void updateGeisternetzStatus() {
        long id = 12;
        Status status = Status.BERGUNG_BEVORSTEHEND;

        endpointService.updateGeisternetzStatus(id, status);

        verify(geisternetzService, times(1)).updateStatus(id, status);
    }

    @Test
    void updateGeisternetzUserId() {
        long id = 12;
        long userId = 13;

        endpointService.updateGeisternetzUserId(id, userId);

        verify(geisternetzService, times(1)).updateUserId(id, userId);
    }

    @Test
    void findAllZuBergendeGeisternetze() {
        Geisternetz geisternetz = new Geisternetz();
        when(geisternetzService.findAllGemeldetGeisternetze()).thenReturn(List.of(geisternetz));
        GeisternetzEndpointModel endpointModel = new GeisternetzEndpointModel();
        when(mapper.toGeisternetzEndpointModel(geisternetz)).thenReturn(endpointModel);

        assertThat(endpointService.findAllZuBergendeGeisternetze()).isEqualTo(List.of(endpointModel));

        verify(geisternetzService, times(1)).findAllGemeldetGeisternetze();
        verify(mapper, times(1)).toGeisternetzEndpointModel(geisternetz);
    }

    @Test
    void findById() {
        long id = 12;
        Geisternetz geisternetz = new Geisternetz();
        when(geisternetzService.findById(id)).thenReturn(Optional.of(geisternetz));

        endpointService.findById(id);

        verify(geisternetzService, times(1)).findById(id);
        verify(mapper, times(1)).toGeisternetzEndpointModel(geisternetz);
    }

    @Test
    void findByIdButNotFound() {
        long id = 12;
        when(geisternetzService.findById(id)).thenReturn(Optional.empty());

        assertThat(endpointService.findById(id)).isNull();

        verify(geisternetzService, times(1)).findById(id);
    }

    @Test
    void findAllGeisternetzeByUserId() {
        long userId = 12;
        Geisternetz geisternetz = new Geisternetz();
        when(geisternetzService.findAllGeisternetzeByUserId(12)).thenReturn(List.of(geisternetz));
        GeisternetzEndpointModel endpointModel = new GeisternetzEndpointModel();
        when(mapper.toGeisternetzEndpointModel(geisternetz)).thenReturn(endpointModel);

        assertThat(endpointService.findAllGeisternetzeByUserId(userId)).isEqualTo(List.of(endpointModel));

        verify(geisternetzService, times(1)).findAllGeisternetzeByUserId(userId);
    }
}