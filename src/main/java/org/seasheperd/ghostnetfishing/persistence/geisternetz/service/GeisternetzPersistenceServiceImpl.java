package org.seasheperd.ghostnetfishing.persistence.geisternetz.service;

import lombok.RequiredArgsConstructor;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Geisternetz;
import org.seasheperd.ghostnetfishing.domain.geisternetz.spi.GeisternetzPersistenceService;
import org.seasheperd.ghostnetfishing.persistence.geisternetz.model.GeisternetzDataModel;
import org.seasheperd.ghostnetfishing.persistence.geisternetz.model.StandortDataModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeisternetzPersistenceServiceImpl implements GeisternetzPersistenceService {

    private final GeisternetzRepository geisternetzRepository;
    private final GeisternetzPersistenceMapper geisternetzPersistenceMapper;
    private final StandortRepository standortRepository;

    @Override
    public Geisternetz save(Geisternetz geisternetz) {
        GeisternetzDataModel dataModel = geisternetzPersistenceMapper.toGeisternetzDataModel(geisternetz);

        if (dataModel.getStandort().getId() == 0) {
            Optional<StandortDataModel> standort = standortRepository.findByBreitengradAndLaengengrad(dataModel.getStandort().getBreitengrad(), dataModel.getStandort().getLaengengrad());
            standort.ifPresent(dataModel::setStandort);
        }
        GeisternetzDataModel savedDataModel = geisternetzRepository.save(dataModel);

        return geisternetzPersistenceMapper.toGeisternetz(savedDataModel);
    }

    @Override
    public Geisternetz getGeisternetzById(long id) {
        return findById(id).orElseThrow();
    }

    @Override
    public List<Geisternetz> findAll() {
        return geisternetzRepository.findAll().stream().map(geisternetzPersistenceMapper::toGeisternetz).toList();
    }

    @Override
    public Optional<Geisternetz> findById(long id) {
        return geisternetzRepository.findById(id).map(geisternetzPersistenceMapper::toGeisternetz);
    }
}
