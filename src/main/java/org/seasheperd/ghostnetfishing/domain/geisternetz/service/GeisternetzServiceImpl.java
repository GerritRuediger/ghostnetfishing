package org.seasheperd.ghostnetfishing.domain.geisternetz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.seasheperd.ghostnetfishing.domain.geisternetz.api.GeisternetzService;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Geisternetz;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Groesse;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Standort;
import org.seasheperd.ghostnetfishing.domain.geisternetz.model.Status;
import org.seasheperd.ghostnetfishing.domain.geisternetz.spi.GeisternetzPersistenceService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeisternetzServiceImpl implements GeisternetzService {

  private final GeisternetzPersistenceService geisternetzPersistenceService;

  @Override
  public Geisternetz createGeisternetz(Standort standort, Groesse groesse) {
    return geisternetzPersistenceService.save(new Geisternetz(standort,groesse));
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

    return geisternetzPersistenceService.save(geisternetz);
  }

  @Override
  public List<Geisternetz> findAllGemeldetGeisternetze() {
    List<Geisternetz> geisternetze = geisternetzPersistenceService.findAll();

    return geisternetze.stream()
            .filter(geisternetz -> geisternetz.getStatus() == Status.GEMELDET)
            .toList();
  }
}
