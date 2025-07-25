package org.sheasepherd.ghostnetfishing.domain.geisternetz.spi;

import org.sheasepherd.ghostnetfishing.domain.geisternetz.model.Geisternetz;

import java.util.List;
import java.util.Optional;

public interface GeisternetzPersistenceService {
    Geisternetz save(Geisternetz geisternetz);

    Geisternetz getGeisternetzById(long id);

    List<Geisternetz> findAll();

    Optional<Geisternetz> findById(long id);
}
