package org.seasheperd.ghostnetfishing.persistence.geisternetz.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Geisternetz;
import org.seasheperd.ghostnetfishing.persistence.geisternetz.model.GeisternetzDataModel;
import org.seasheperd.ghostnetfishing.persistence.geisternetz.model.StandortDataModel;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GeisternetzPersistenceServiceImplTest {

    @Mock
    private GeisternetzRepository geisternetzRepository;

    @Mock
    private StandortRepository standortRepository;

    @Mock
    private GeisternetzPersistenceMapper geisternetzPersistenceMapper;

    @InjectMocks
    private GeisternetzPersistenceServiceImpl service;

    @Test
    void saveSuccessfull() {
        Geisternetz geisternetz = new Geisternetz();
        GeisternetzDataModel mappedGeisternetz = new GeisternetzDataModel();
        mappedGeisternetz.setStandort(new StandortDataModel(1, 2, 3));
        GeisternetzDataModel savedDataModel = new GeisternetzDataModel();

        when(geisternetzPersistenceMapper.toGeisternetzDataModel(any(Geisternetz.class))).thenReturn(mappedGeisternetz);
        when(geisternetzRepository.save(mappedGeisternetz)).thenReturn(savedDataModel);
        when(geisternetzPersistenceMapper.toGeisternetz(any(GeisternetzDataModel.class))).thenReturn(geisternetz);

        service.save(geisternetz);


        verify(geisternetzRepository, times(1)).save(mappedGeisternetz);
        verify(geisternetzPersistenceMapper, times(1)).toGeisternetz(savedDataModel);
    }

    @Test
    void saveSuccessfullOverwriteStandort() {
        Geisternetz geisternetz = new Geisternetz();
        GeisternetzDataModel mappedGeisternetz = new GeisternetzDataModel();
        mappedGeisternetz.setStandort(new StandortDataModel(0, 2, 3));
        GeisternetzDataModel savedDataModel = new GeisternetzDataModel();
        StandortDataModel savedStandort = new StandortDataModel(1, 2, 3);

        when(standortRepository.findByBreitengradAndLaengengrad(anyDouble(), anyDouble())).thenReturn(Optional.of(savedStandort));
        when(geisternetzPersistenceMapper.toGeisternetzDataModel(any(Geisternetz.class))).thenReturn(mappedGeisternetz);
        when(geisternetzRepository.save(mappedGeisternetz)).thenReturn(savedDataModel);
        when(geisternetzPersistenceMapper.toGeisternetz(any(GeisternetzDataModel.class))).thenReturn(geisternetz);

        service.save(geisternetz);


        verify(geisternetzRepository, times(1)).save(mappedGeisternetz);
        verify(geisternetzPersistenceMapper, times(1)).toGeisternetz(savedDataModel);
    }

    @Test()
    void getById() {
        long id = 123;
        GeisternetzDataModel dataModel = new GeisternetzDataModel();
        when(geisternetzRepository.findById(id)).thenReturn(Optional.of(dataModel));
        when(geisternetzPersistenceMapper.toGeisternetz(any(GeisternetzDataModel.class))).thenReturn(new Geisternetz());

        service.getGeisternetzById(id);

        verify(geisternetzRepository, times(1)).findById(id);
        verify(geisternetzPersistenceMapper, times(1)).toGeisternetz(dataModel);
    }

    @Test()
    void findById() {
        long id = 123;
        GeisternetzDataModel dataModel = new GeisternetzDataModel();
        when(geisternetzRepository.findById(id)).thenReturn(Optional.of(dataModel));

        service.findById(id);

        verify(geisternetzRepository, times(1)).findById(id);
        verify(geisternetzPersistenceMapper, times(1)).toGeisternetz(dataModel);
    }

    @Test()
    void findAll() {
        GeisternetzDataModel dataModel = new GeisternetzDataModel();
        when(geisternetzRepository.findAll()).thenReturn(List.of(dataModel));

        service.findAll();

        verify(geisternetzRepository, times(1)).findAll();
        verify(geisternetzPersistenceMapper, times(1)).toGeisternetz(dataModel);
    }
}