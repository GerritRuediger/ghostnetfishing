package org.sheasepherd.ghostnetfishing.domain.geisternetz.service;

import lombok.RequiredArgsConstructor;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.api.GeisternetzService;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Geisternetz;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Groesse;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Standort;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Status;
import org.sheasepherd.ghostnetfishing.domain.geisternetz.spi.GeisternetzPersistenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeisternetzServiceImpl implements GeisternetzService {

    private final GeisternetzPersistenceService geisternetzPersistenceService;

    @Override
    public Geisternetz createGeisternetz(Standort standort, Groesse groesse) {
        return geisternetzPersistenceService.save(new Geisternetz(standort, groesse));
    }

    @Override
    public Geisternetz updateStatus(long id, Status newStatus) {
        Geisternetz geisternetz = geisternetzPersistenceService.getGeisternetzById(id);
        geisternetz.setStatus(newStatus);

        return geisternetzPersistenceService.save(geisternetz);
    }

    @Override
    public Geisternetz updateUserId(long id, long newUserId) {
        Geisternetz geisternetz = geisternetzPersistenceService.getGeisternetzById(id);
        geisternetz.setUserId(newUserId);
        geisternetz.setStatus(Status.BERGUNG_BEVORSTEHEND);

        return geisternetzPersistenceService.save(geisternetz);
    }

    @Override
    public List<Geisternetz> findAllGemeldetGeisternetze() {
        List<Geisternetz> geisternetze = geisternetzPersistenceService.findAll();

        return geisternetze.stream()
                .filter(geisternetz -> geisternetz.getStatus() == Status.GEMELDET)
                .toList();
    }

    @Override
    public Optional<Geisternetz> findById(long id) {
        return geisternetzPersistenceService.findById(id);
    }

    @Override
    public List<Geisternetz> findAllGeisternetzeByUserId(long userId) {
        return geisternetzPersistenceService.findAll().stream()
                .filter(geisternetz -> geisternetz.getUserId() != null && geisternetz.getUserId() == userId)
                .toList();
    }
}
