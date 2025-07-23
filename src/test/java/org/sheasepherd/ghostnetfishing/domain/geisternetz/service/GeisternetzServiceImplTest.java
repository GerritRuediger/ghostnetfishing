package org.sheasepherd.ghostnetfishing.domain.geisternetz.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Geisternetz;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Groesse;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Standort;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Status;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.spi.GeisternetzPersistenceService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GeisternetzServiceImplTest {

    @Mock
    GeisternetzPersistenceService persistenceService;
    @InjectMocks
    GeisternetzServiceImpl geisternetzService;

    @Test
    void createGeisternetz() {
        Standort standort = new Standort(1, 2, 3);
        Groesse groesse = Groesse.MITTEL;
        geisternetzService.createGeisternetz(standort, groesse);

        verify(persistenceService).save(new Geisternetz(standort, groesse));
    }

    @Test
    void updateStatus() {
        long id = 1L;
        Status newStatus = Status.BERGUNG_BEVORSTEHEND;

        Geisternetz geisternetz = Geisternetz.builder()
                .id(id)
                .status(Status.GEMELDET)
                .build();

        when(persistenceService.getGeisternetzById(id)).thenReturn(geisternetz);
        when(persistenceService.save(any(Geisternetz.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Geisternetz updatedGeisternetz = geisternetzService.updateStatus(id, newStatus);

        assertThat(updatedGeisternetz.getStatus()).isEqualTo(newStatus);
        verify(persistenceService).getGeisternetzById(id);
        verify(persistenceService).save(geisternetz);
    }

    @Test
    void updateUserId() {
        long id = 1L;
        long userId = 2L;

        Geisternetz geisternetz = Geisternetz.builder()
                .id(id)
                .status(Status.GEMELDET)
                .build();

        when(persistenceService.getGeisternetzById(id)).thenReturn(geisternetz);
        when(persistenceService.save(any(Geisternetz.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Geisternetz updatedGeisternetz = geisternetzService.updateUserId(id, userId);

        assertThat(updatedGeisternetz.getUserId()).isEqualTo(userId);
        verify(persistenceService).getGeisternetzById(id);
        verify(persistenceService).save(geisternetz);
    }

    @Test
    void findAllGemeldetGeisternetze() {
        Geisternetz gemeldetNetz1 = Geisternetz.builder().id(1L).status(Status.GEMELDET).build();
        Geisternetz gemeldetNetz2 = Geisternetz.builder().id(2L).status(Status.GEMELDET).build();
        Geisternetz anderesNetz = Geisternetz.builder().id(3L).status(Status.BERGUNG_BEVORSTEHEND).build();

        when(persistenceService.findAll()).thenReturn(List.of(gemeldetNetz1, gemeldetNetz2, anderesNetz));

        List<Geisternetz> result = geisternetzService.findAllGemeldetGeisternetze();

        assertThat(result).containsExactly(gemeldetNetz1, gemeldetNetz2);
        verify(persistenceService).findAll();
    }

    @Test
    void findById() {
        long id = 1L;
        geisternetzService.findById(id);

        verify(persistenceService).findById(id);
    }

    @Test
    void findAllGeisternetzeByUserId() {
        long userId = 2L;

        Geisternetz user1Netz = Geisternetz.builder().id(1L).userId(1L).status(Status.GEMELDET).build();
        Geisternetz user2Netz1 = Geisternetz.builder().id(2L).userId(userId).status(Status.BERGUNG_BEVORSTEHEND).build();
        Geisternetz user2Netz2 = Geisternetz.builder().id(3L).userId(userId).status(Status.GEMELDET).build();

        when(persistenceService.findAll()).thenReturn(List.of(user1Netz, user2Netz1, user2Netz2));

        List<Geisternetz> result = geisternetzService.findAllGeisternetzeByUserId(userId);

        assertThat(result).containsExactly(user2Netz1, user2Netz2);
        verify(persistenceService).findAll();
    }
}